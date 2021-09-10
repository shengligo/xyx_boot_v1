package com.shell.xyxv1.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InitConfig implements InitializingBean  {


  @Value("${upload.url}")
  private String uploaderUrl;
  public static String UPLOAD_URL;
  @Value("${upload.access_key}")
  private String uploadAccessKey;
  public static String UPLOAD_ACCESS_KEY;
  @Value("${upload.secret_key}")
  private String uploadSecretKey;
  public static String UPLOAD_SECRET_KEY;

  @Override
  public void afterPropertiesSet() throws Exception {
    UPLOAD_URL = this.uploaderUrl;
    UPLOAD_ACCESS_KEY = this.uploadAccessKey;
    UPLOAD_SECRET_KEY = this.uploadSecretKey;
  }
}
