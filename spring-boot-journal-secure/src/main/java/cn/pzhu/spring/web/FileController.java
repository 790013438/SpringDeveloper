package cn.pzhu.spring.web;

import cn.pzhu.spring.domain.AccountEntity;
import cn.pzhu.spring.domain.enumerate.RoleEnum;
import cn.pzhu.spring.repository.AccountEntityRepository;
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
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipOutputStream;

@RestController
@RequestMapping(value = "fileManager")
public class FileController {

    @Value("${file.root}")
    private String ROOT;
    @Value("${file.share}")
    private String SHARE;
    // 个人存储文件夹
    private File dirFile;
    @Autowired
    private AccountEntityRepository accountEntityRepository;
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    /**
     * 展示文件夹
     */
    @PostMapping(value = "list")
    public Object list(@RequestBody JSONObject json) {

        try {
            // 需要显示的目录路径
            String path = json.getString("path");
            // 改变root/用户名
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String name = authentication.getName();
            AccountEntity accountEntity = accountEntityRepository.findAccountEntitiesByAccountName(name);
            if (RoleEnum.TEACHER == accountEntity.getUserRole()) {
                dirFile = new File(ROOT + File.separator
                        + accountEntity.getUserName());
                if (!dirFile.exists()) {
                    logger.info("创建用户（教师文件夹，管理课件）> " + dirFile.mkdirs());
                    logger.info("创建用户（教师文件夹，管理课件）路径> " + dirFile.getAbsolutePath());
                }
            } else {
                dirFile = new File(ROOT);
            }
            if (RoleEnum.STUDENT == accountEntity.getUserRole()) {
                dirFile = new File(ROOT + File.separator + "homework"
                +accountEntity.getUserName());
                if (!dirFile.exists()) {
                    logger.info("创建用户（学生作业文件夹，管理课件）> " + dirFile.mkdirs());
                    logger.info("创建用户（学生作业文件夹，管理课件）路径> " + dirFile.getAbsolutePath());
                }
            }

            // 返回的结果集
            List<JSONObject> fileItems = new ArrayList<>();

            // 根据用户名不同，用户个人存储路径不同
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(dirFile.getAbsolutePath(), path))) {

                String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
                for (Path pathObj : directoryStream) {
                    // 获取文件基本属性
                    BasicFileAttributes basicFileAttributes = Files.readAttributes(pathObj, BasicFileAttributes.class);

                    // 封装返回JSON数据
                    JSONObject fileItem = new JSONObject();
                    fileItem.put("name", pathObj.getFileName().toString());
                    fileItem.put("date", simpleDateFormat.format(new Date(basicFileAttributes.lastModifiedTime().toMillis())));
                    fileItem.put("size", basicFileAttributes.size());
                    fileItem.put("type", basicFileAttributes.isDirectory() ? "dir" : "file");
                    fileItems.add(fileItem);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("result", fileItems);
            return jsonObject;
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 文件上传
     */
    @RequestMapping("upload")
    public Object upload(@RequestParam("destination") String destination, HttpServletRequest httpServletRequest) {

        try {
            // Servlet3.0方式上传文件
            Collection<Part> parts = httpServletRequest.getParts();

            for (Part part : parts) {
                if (part.getContentType() != null) {  // 忽略路径字段,只处理文件类型
                    String path = dirFile + destination;

                    File f = new File(path, cn.pzhu.spring.utils.FileUtils.getFileName(part.getHeader("content-disposition")));
                    if (!cn.pzhu.spring.utils.FileUtils.write(part.getInputStream(), f)) {
                        throw new Exception("文件上传失败");
                    }
                }
            }
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    private JSONObject error(String msg) {

        // { "result": { "success": false, "error": "msg"} }
        JSONObject result = new JSONObject();
        result.put("success", false);
        result.put("error", msg);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject;
    }

    private JSONObject success() {
        // { "result": { "success": true, "error": null } }
        JSONObject result = new JSONObject();
        result.put("success", true);
        result.put("error", null);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        return jsonObject;
    }

    /**
     * 文件下载/预览
     */
    @RequestMapping("preview")
    public void preview(HttpServletResponse response, String path) throws IOException {

        File file = new File(dirFile, path);
        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource Not Found");
            return;
        }

        /*
         * 获取mimeType
         */
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        response.setContentType(mimeType);
        response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", URLEncoder.encode(file.getName(), "UTF-8")));
        response.setContentLength((int) file.length());

        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }
    }

    /**
     * 创建目录
     */
    @RequestMapping("createFolder")
    public Object createFolder(@RequestBody JSONObject json) {
        try {
            String newPath = json.getString("newPath");
            File newDir = new File(dirFile + newPath);
            if (!newDir.mkdir()) {
                throw new Exception("不能创建目录: " + newPath);
            }
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 修改文件或目录权限
     */
    @RequestMapping("changePermissions")
    public Object changePermissions(@RequestBody JSONObject json) {
        try {

            String perms = json.getString("perms"); // 权限
            boolean recursive = json.getBoolean("recursive"); // 子目录是否生效

            JSONArray items = json.getJSONArray("items");
            for (int i = 0; i < items.size(); i++) {
                String path = items.getString(i);
                File f = new File(dirFile, path);
                cn.pzhu.spring.utils.FileUtils.setPermissions(f, perms, recursive); // 设置权限
            }
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 复制文件或目录
     */
    @RequestMapping("copy")
    public Object copy(@RequestBody JSONObject json) {
        try {
            String newPath = json.getString("newPath");
            JSONArray items = json.getJSONArray("items");

            for (int i = 0; i < items.size(); i++) {
                String path = items.getString(i);

                File srcFile = new File(dirFile, path);
                File destinationFile = new File(dirFile + newPath, srcFile.getName());

                FileCopyUtils.copy(srcFile, destinationFile);
            }
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 移动文件或目录
     */
    @RequestMapping("move")
    public Object move(@RequestBody JSONObject json) {
        try {
            String newpath = json.getString("newPath");
            JSONArray items = json.getJSONArray("items");

            for (int i = 0; i < items.size(); i++) {
                String path = items.getString(i);

                File srcFile = new File(dirFile, path);
                File destFile = new File(dirFile + newpath, srcFile.getName());

                if (srcFile.isFile()) {
                    FileUtils.moveFile(srcFile, destFile);
                } else {
                    FileUtils.moveDirectory(srcFile, destFile);
                }
            }
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 删除文件或目录
     */
    @RequestMapping("remove")
    public Object remove(@RequestBody JSONObject json) {
        try {
            JSONArray items = json.getJSONArray("items");
            for (int i = 0; i < items.size(); i++) {
                String path = items.getString(i);
                File srcFile = new File(dirFile, path);
                if (!FileUtils.deleteQuietly(srcFile)) {
                    throw new Exception("删除失败: " + srcFile.getAbsolutePath());
                }
            }
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 重命名文件或目录
     */
    @RequestMapping("rename")
    public Object rename(@RequestBody JSONObject json) {
        try {
            String path = json.getString("item");
            String newPath = json.getString("newItemPath");

            File srcFile = new File(dirFile, path);
            File destFile = new File(dirFile, newPath);
            if (srcFile.isFile()) {
                FileUtils.moveFile(srcFile, destFile);
            } else {
                FileUtils.moveDirectory(srcFile, destFile);
            }
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 查看文件内容,针对html、txt等可编辑文件
     */
    @RequestMapping("getContent")
    public Object getContent(@RequestBody JSONObject json) {
        try {
            String path = json.getString("item");
            File srcFile = new File(dirFile, path);

            String content = FileUtils.readFileToString(srcFile);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("result", content);
            return jsonObject;
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 修改文件内容,针对html、txt等可编辑文件
     */
    @RequestMapping("edit")
    public Object edit(@RequestBody JSONObject json) {
        try {
            String path = json.getString("item");
            String content = json.getString("content");

            File srcFile = new File(dirFile, path);
            FileUtils.writeStringToFile(srcFile, content);

            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 文件压缩
     */
    @RequestMapping("compress")
    public Object compress(@RequestBody JSONObject json) {
        try {
            String destination = json.getString("destination");
            String compressedFilename = json.getString("compressedFilename");
            JSONArray items = json.getJSONArray("items");
            List<File> files = new ArrayList<>();
            for (int i = 0; i < items.size(); i++) {
                File f = new File(dirFile, items.getString(i));
                files.add(f);
            }

            File zip = new File(dirFile + destination, compressedFilename);

            try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zip))) {
                ZipUtils.zipFiles(out, "", files.toArray(new File[files.size()]));
            }
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 文件解压
     */
    @RequestMapping("extract")
    public Object extract(@RequestBody JSONObject json) {
        try {
            String destination = json.getString("destination");
            String zipName = json.getString("item");
            File file = new File(dirFile, zipName);

            String extension = cn.pzhu.spring.utils.FileUtils.getExtension(zipName);
            switch (extension) {
                case ".zip":
                    ZipUtils.unZipFiles(file, dirFile + destination);
                    break;
                case ".gz":
                    TargzUtils.unTargzFile(file, dirFile + destination);
                    break;
                case ".rar":
                    RarUtils.unRarFile(file, dirFile + destination);
            }
            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }
}
