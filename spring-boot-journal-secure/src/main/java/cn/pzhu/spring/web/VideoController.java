package cn.pzhu.spring.web;

import cn.pzhu.spring.domain.AccountEntity;
import cn.pzhu.spring.domain.VideoEntity;
import cn.pzhu.spring.domain.enumerate.RoleEnum;
import cn.pzhu.spring.repository.AccountEntityRepository;
import cn.pzhu.spring.repository.VideoRepository;
import cn.pzhu.spring.service.FileService;
import cn.pzhu.spring.utils.FileUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "video")
@RestController
public class VideoController {

    private static final String VIEW_VIDEO = "video";
    private static final String VIEW_PLAY = "playVideo";
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private AccountEntityRepository accountEntityRepository;
    @Autowired
    private Sort idASCSort;
    @Autowired
    private FileService fileService;
    @Value("${video.share}")
    private String ROOT;

    @RequestMapping("playlist")
    public ModelAndView video(ModelAndView modelAndView,
                              @RequestParam(value = "title", defaultValue = "") String title,
                              @RequestParam(value = "page", defaultValue = "0") Integer page,
                              @RequestParam(value = "size", defaultValue = "6") Integer size) {

        modelAndView.addObject("videos",
                videoRepository.findByNameContains(title, PageRequest.of(page, size, idASCSort)));

        // 获取当前用户
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        if ("anonymousUser".equals(name)) {
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }
        AccountEntity accountEntity = accountEntityRepository.findAccountEntitiesByAccountName(name);
        modelAndView.addObject("isAdmin",
                accountEntity.getUserRole() == RoleEnum.TEACHER);

        modelAndView.setViewName(VIEW_VIDEO);
        return modelAndView;
    }

    @RequestMapping("play")
    public ModelAndView play(ModelAndView modelAndView,
                              @RequestParam(value = "name", defaultValue = "1") String name) {
        modelAndView.setViewName(VIEW_PLAY);
        modelAndView.addObject("name", name);
        return modelAndView;
    }

    /**
     * 展示文件夹
     */
    @PostMapping(value = "list")
    public Object list(@RequestBody JSONObject json) {

        fileService.setROOT(ROOT);
        return fileService.list(json);
    }

    /**
     * 文件上传
     */
    @RequestMapping("upload")
    public Object upload(@RequestParam("destination") String destination,
                         HttpServletRequest httpServletRequest) throws IOException, ServletException {

        // 获取所有课件并保存
        Collection<Part> partCollection = httpServletRequest.getParts();
        List<VideoEntity> videoEntityList = new ArrayList<>();

        for (Part part : partCollection) {
            if (part.getContentType() != null) {  // 忽略路径字段,只处理文件类型
                String fileName = FileUtils.getFileName(
                        part.getHeader("content-disposition"));
                VideoEntity videoEntity = new VideoEntity();
                videoEntity.setName(fileName);
                videoEntityList.add(videoEntity);
            }
        }
        videoRepository.saveAll(videoEntityList);

        return fileService.upload(destination, httpServletRequest);
    }

    /**
     * 文件下载/预览
     */
    @RequestMapping("preview")
    public void preview(HttpServletResponse httpServletResponse, String path) throws IOException {
        fileService.preview(httpServletResponse, path);
    }

    /**
     * 创建目录
     */
    @RequestMapping("createFolder")
    public Object createFolder(@RequestBody JSONObject json) {
        return fileService.createFolder(json);
    }

    /**
     * 修改文件或目录权限
     */
    @RequestMapping("changePermissions")
    public Object changePermissions(@RequestBody JSONObject json) {
        return fileService.changePermissions(json);
    }

    /**
     * 复制文件或目录
     */
    @RequestMapping("copy")
    public Object copy(@RequestBody JSONObject json) {
        return fileService.copy(json);
    }

    /**
     * 移动文件或目录
     */
    @RequestMapping("move")
    public Object move(@RequestBody JSONObject json) {
        return fileService.move(json);
    }

    /**
     * 删除文件或目录
     */
    @RequestMapping("remove")
    public Object remove(@RequestBody JSONObject json) {
        return fileService.remove(json);
    }

    /**
     * 重命名文件或目录
     */
    @RequestMapping("rename")
    public Object rename(@RequestBody JSONObject json) {
        String path = json.getString("item")
                .replaceAll("/", "");
        String newPath = json.getString("newItemPath")
                .replaceAll("/", "");
        VideoEntity videoEntity = videoRepository.findFirstByName(path);
        if (videoEntity == null) {
            videoEntity = new VideoEntity();
        }
        videoEntity.setName(newPath);
        videoRepository.save(videoEntity);
        return fileService.rename(json);
    }

    /**
     * 查看文件内容,针对html、txt等可编辑文件
     */
    @RequestMapping("getContent")
    public Object getContent(@RequestBody JSONObject json) {
        return fileService.getContent(json);
    }

    /**
     * 修改文件内容,针对html、txt等可编辑文件
     */
    @RequestMapping("edit")
    public Object edit(@RequestBody JSONObject json) {
        return fileService.edit(json);
    }

    /**
     * 文件压缩
     */
    @RequestMapping("compress")
    public Object compress(@RequestBody JSONObject json) {
        return fileService.compress(json);
    }

    /**
     * 文件解压
     */
    @RequestMapping("extract")
    public Object extract(@RequestBody JSONObject json) {
        return fileService.extract(json);
    }
}
