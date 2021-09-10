package com.shell.xyxv1.controller.admin;

import com.shell.xyxv1.core.entity.vo.Result;
import com.shell.xyxv1.entity.request.AnswerRequest;
import com.shell.xyxv1.service.AnswerService;
import com.shell.xyxv1.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 提问回答 前端控制器
 * </p>
 *
 * @author shell.sjhe
 * @since 2021-09-04
 */
@RestController
@RequestMapping("answer")
public class AnswerController {

  @Autowired
  AnswerService answerService;

  @Autowired
  QuizService quizService;

  /**
   * 获取回答列表
   * @param answerRequest
   * @return
   */
  @GetMapping("getAnswerList")
  public Result getAnswerList(AnswerRequest answerRequest){
    return Result.success(answerService.getAnswerList(answerRequest));
  }

  /**
   * 去回答
   * @param answerRequest
   * @return
   */
  @PostMapping("addAnswer")
  public Result addAnswer(AnswerRequest answerRequest){
    return answerService.addAnswer(answerRequest);
  }
}
