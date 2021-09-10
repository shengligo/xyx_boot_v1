package com.shell.xyxv1.minio;


import com.shell.xyxv1.config.InitConfig;
import io.minio.MinioClient;
import io.minio.errors.MinioException;
import io.minio.policy.PolicyType;
import java.io.InputStream;
import java.net.URLEncoder;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FileUploader {

  @Value("${upload.bucket}")
  private String publicBucket;


  public String uploadImg(String fileName, InputStream inputStream)
      throws Exception {
    try {
      String folder = "/img/";
      // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
      MinioClient minioClient = new MinioClient(InitConfig.UPLOAD_URL, InitConfig.UPLOAD_ACCESS_KEY,
          InitConfig.UPLOAD_SECRET_KEY);
      // 检查存储桶是否已经存在
      boolean isExist = minioClient.bucketExists(publicBucket);
      if (!isExist) {
        // 创建一个存储桶
        minioClient.makeBucket(publicBucket);
        minioClient.setBucketPolicy(publicBucket, "*", PolicyType.READ_ONLY);
      }
      // 使用putObject上传一个图片文件到存储桶中。
      minioClient.putObject(publicBucket, folder + fileName, inputStream,
          ContentType.IMAGE_JPEG.getMimeType());
      log.info(InitConfig.UPLOAD_URL + publicBucket + folder + fileName);

//      carImageMapper
      return InitConfig.UPLOAD_URL + publicBucket + folder + fileName;
    } catch (MinioException e) {
      log.error("上传错误", e);
    }
    return null;
  }


  public String uploadFile(String fileName, InputStream inputStream) throws Exception {
    try {
      String folder = "/files/";
      // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
      MinioClient minioClient = new MinioClient(InitConfig.UPLOAD_URL, InitConfig.UPLOAD_ACCESS_KEY,
          InitConfig.UPLOAD_SECRET_KEY);
      // 检查存储桶是否已经存在
      boolean isExist = minioClient.bucketExists(publicBucket);
      if (!isExist) {
        // 创建一个存储桶
        minioClient.makeBucket(publicBucket);
        minioClient.setBucketPolicy(publicBucket, "*", PolicyType.READ_ONLY);
      }
      // 使用putObject上传一个图片文件到存储桶中。
      minioClient.putObject(publicBucket, folder + fileName, inputStream, "application/pdf");
      log.info(InitConfig.UPLOAD_URL + publicBucket + folder + fileName);
      return InitConfig.UPLOAD_URL + publicBucket + folder + fileName;
    } catch (MinioException e) {
      log.error("错误", e);
    }
    return null;
  }

  public String uploadVdieo(String fileName, InputStream inputStream) throws Exception {
    try {
      String folder = "/files/";
      // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
      MinioClient minioClient = new MinioClient(InitConfig.UPLOAD_URL, InitConfig.UPLOAD_ACCESS_KEY,
          InitConfig.UPLOAD_SECRET_KEY);
      // 检查存储桶是否已经存在
      boolean isExist = minioClient.bucketExists(publicBucket);
      if (!isExist) {
        // 创建一个存储桶
        minioClient.makeBucket(publicBucket);
        minioClient.setBucketPolicy(publicBucket, "*", PolicyType.READ_ONLY);
      }
      // 使用putObject上传一个图片文件到存储桶中。
      minioClient.putObject(publicBucket, folder + fileName, inputStream, "video/mp4");
      log.info(InitConfig.UPLOAD_URL + publicBucket + folder + fileName);
      return InitConfig.UPLOAD_URL + publicBucket + folder + fileName;
    } catch (MinioException e) {
      log.error("错误", e);
    }
    return null;
  }

  public void downloadFile(String fileName, HttpServletRequest request,
      HttpServletResponse response, String name) {
    try (ServletOutputStream outputStream = response.getOutputStream()) {
//			fileName.replace(url+"files","");
      String agent = request.getHeader("User-Agent").toLowerCase();
      if (agent.contains("msie") || agent.contains("like gecko")) {
        // win10 ie edge 浏览器 和其他系统的ie
        name = URLEncoder.encode(name, "UTF-8");
      } else {
        // fe
        name = new String(name.getBytes("UTF-8"), "iso-8859-1");
      }
      response.setHeader("Content-Disposition", "attachment;fileName=" + name);
      fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
      response.setContentType("application/force-download");
      // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
      MinioClient minioClient = new MinioClient(InitConfig.UPLOAD_URL, InitConfig.UPLOAD_ACCESS_KEY,
          InitConfig.UPLOAD_SECRET_KEY);
      // 从minio上获取文件流
      InputStream inputStream = minioClient.getObject(publicBucket, "files/" + fileName);
      IOUtils.copy(inputStream, outputStream);
      outputStream.flush();
    } catch (Exception e) {
      log.error("文件下载失败", e);
    }
  }


}
