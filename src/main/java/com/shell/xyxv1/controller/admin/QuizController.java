package com.shell.xyxv1.controller.admin;

import com.shell.xyxv1.core.entity.vo.Result;
import com.shell.xyxv1.entity.request.AnswerRequest;
import com.shell.xyxv1.entity.request.QuizRequest;
import com.shell.xyxv1.service.AnswerService;
import com.shell.xyxv1.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 提问 前端控制器
 * </p>
 *
 * @author shell.sjhe
 * @since 2021-09-04
 */
@RestController
@RequestMapping("/quiz")
public class QuizController {

  @Autowired
  AnswerService answerService;

  @Autowired
  QuizService quizService;


  /**
   * 去提问
   * @param quizRequest
   * @return
   */
  @PostMapping("addQuiz")
  public Result addQuiz(@RequestBody QuizRequest quizRequest){
    return  quizService.addQuiz(quizRequest);
  }

}
