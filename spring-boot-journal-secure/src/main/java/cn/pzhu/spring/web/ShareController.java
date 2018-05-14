package cn.pzhu.spring.web;

import cn.pzhu.spring.service.FileService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping(value = "share")
@RestController
public class ShareController {

    @Value("${file.share}")
    private String ROOT;
    private FileService fileService;

    @Autowired
    ShareController(FileService fileService) {
        this.fileService = fileService;
        fileService.setROOT(ROOT);
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
    public Object upload(@RequestParam("destination") String destination, HttpServletRequest httpServletRequest) {
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

