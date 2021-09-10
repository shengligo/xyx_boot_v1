package com.shell.xyxv1.controller.user;

import com.shell.xyxv1.core.entity.vo.Result;
import com.shell.xyxv1.entity.request.EssayRequest;
import com.shell.xyxv1.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user/essay")
public class EssayUserController {

  @Autowired
  EssayService essayService;

  /**
   * 获取文章列表
   * @param request
   * @return
   */
  @GetMapping("getEssayList")
  public Result getEssayList(EssayRequest request){
    return Result.success(essayService.getEssay(request));
  }
}
