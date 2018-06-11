package cn.pzhu.spring.web;

import cn.pzhu.spring.domain.AccountEntity;
import cn.pzhu.spring.domain.enumerate.RoleEnum;
import cn.pzhu.spring.repository.AccountEntityRepository;
import cn.pzhu.spring.service.FileService;
import cn.pzhu.spring.utils.RarUtils;
import cn.pzhu.spring.utils.TargzUtils;
import cn.pzhu.spring.utils.ZipUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.zip.ZipOutputStream;

@RestController
@RequestMapping(value = "fileManager")
public class FileController {

    @Value("${file.root}")
    private String ROOT;
    // 个人存储文件夹
    private File dirFile;
    @Autowired
    private AccountEntityRepository accountEntityRepository;
    private FileService fileService;

    @Autowired
    FileController(FileService fileService) {
        this.fileService = fileService;
        fileService.setROOT(ROOT);
    }

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    /**
     * 展示文件夹
     */
    @PostMapping(value = "list")
    public Object list(@RequestBody JSONObject json) {

        try {
            // 改变root/用户名
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String name = authentication.getName();
            AccountEntity accountEntity = accountEntityRepository.findAccountEntitiesByAccountName(name);
            if (RoleEnum.TEACHER == accountEntity.getUserRole()) {
                dirFile = new File(ROOT + File.separator
                        + accountEntity.getPersonalDirectory());
                if (!dirFile.exists()) {
                    logger.info("创建用户（教师文件夹，管理课件）> " + dirFile.mkdirs());
                    logger.info("创建用户（教师文件夹，管理课件）路径> " + dirFile.getAbsolutePath());
                }
            } else {
                dirFile = new File(ROOT);
            }
            if (RoleEnum.STUDENT == accountEntity.getUserRole()) {
                if (accountEntity.getTeacherDirectory() == null) {
                    throw new IllegalStateException("学生没有选课");
                }
                dirFile = new File(ROOT + File.separator
                        + accountEntity.getTeacherDirectory()
                        + File.separator
                        + "学生作业"
                        + File.separator
                        + accountEntity.getPersonalDirectory());
                if (!dirFile.exists()) {
                    logger.info("创建用户（学生作业文件夹，管理课件）> " + dirFile.mkdirs());
                    logger.info("创建用户（学生作业文件夹，管理课件）路径> " + dirFile.getAbsolutePath());
                }
            }
        } catch (Exception e) {
            FileService.error(e.getMessage());
        }

        fileService.setROOT(dirFile.toString());
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
