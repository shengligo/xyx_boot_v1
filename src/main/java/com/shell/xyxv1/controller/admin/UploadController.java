package com.shell.xyxv1.controller.admin;


import com.shell.xyxv1.core.entity.vo.Result;
import com.shell.xyxv1.core.entity.vo.WangEditor;
import com.shell.xyxv1.minio.FileUploader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("admin/upload")
@Slf4j
public class UploadController {

  @Autowired
  private FileUploader fileUploader;

  @PostMapping("img")
  public Result uploadImg(MultipartFile[] file) {
    try {
      if (file != null) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < file.length; i++) {
          //图片大小，单位k
//                    long size = files[i].getSize();
//                    if (size > 1024 * 1024 * 2){
//                        return Result.fail("图片大小不能超过2M");
//                    }
          // 添加毫秒时间戳前缀
          String originalFilename = file[i].getOriginalFilename();
          originalFilename = System.currentTimeMillis() + "-" + originalFilename;
          String url = fileUploader.uploadImg(originalFilename, file[i].getInputStream());
          builder.append(url);
          // 最后一个不拼接逗号
          if (i < file.length - 1) {
            builder.append(",");
          }
        }

        return Result.success(builder.toString());
      }
    } catch (Exception e) {
      log.error("图片上传发生异常", e);
      return Result.fail("图片上传失败");
    }
    return Result.fail("请选择正确的图片");
  }

  @PostMapping("img/wangEditor")
  public WangEditor uploadImgWangEditor(@RequestParam("myfile") MultipartFile file,HttpServletRequest request) {
    WangEditor wangEditor = null;
    String url =null;
    try {
      if (file != null) {
        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < file.length; i++) {
          //图片大小，单位k
//                    long size = files[i].getSize();
//                    if (size > 1024 * 1024 * 2){
//                        return Result.fail("图片大小不能超过2M");
//                    }
          // 添加毫秒时间戳前缀
          String originalFilename = file.getOriginalFilename();
          originalFilename = System.currentTimeMillis() + "-" + originalFilename;
         url= fileUploader.uploadImg(originalFilename, file.getInputStream());
        }
        String[] str = { url };
        wangEditor = new WangEditor(str);
        return wangEditor;

  } catch (Exception e) {
      log.error("图片上传发生异常", e);
    }
    return wangEditor;
  }

  @PostMapping("file")
  public Result uploadFile(MultipartFile[] files) {
    try {
      if (files != null) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < files.length; i++) {
          // 添加毫秒时间戳前缀
          String originalFilename = files[i].getOriginalFilename();
          originalFilename = System.currentTimeMillis() + "-" + originalFilename;
          String url = null;
          if (originalFilename.contains("pdf")) {
            url = fileUploader.uploadFile(originalFilename, files[i].getInputStream());
          } else {
            url = fileUploader.uploadVdieo(originalFilename, files[i].getInputStream());

          }
          builder.append(url);
//          builder.append(",");
//          builder.append(originalFilename.split("-")[1]);
          // 最后一个不拼接逗号
          if (i < files.length - 1) {
            builder.append(",");
          }
        }

        return Result.success(builder.toString());
      }
    } catch (Exception e) {
      log.error("文件上传发生异常", e);
      return Result.fail("文件上传失败");
    }

    return Result.fail("请选择正确的文件");
  }

  /**
   * @param fileUrl
   * @param fileName
   * @param request
   * @param response
   * @return
   */
  @PostMapping("/file/download")
  public Result<String> download(String fileUrl, String fileName, HttpServletRequest request,
      HttpServletResponse response) {
    fileUploader.downloadFile(fileUrl, request, response, fileName);
    return null;
  }

}
