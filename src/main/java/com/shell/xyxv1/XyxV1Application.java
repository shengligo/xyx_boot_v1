package com.shell.xyxv1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shell.xyxv1.mapper")
public class XyxV1Application {

  public static void main(String[] args) {
    SpringApplication.run(XyxV1Application.class, args);
  }

}
