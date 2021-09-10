package com.shell.xyxv1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shell.xyxv1.core.entity.vo.Result;
import com.shell.xyxv1.entity.Quiz;
import com.shell.xyxv1.entity.request.QuizRequest;

/**
 * <p>
 * 提问 服务类
 * </p>
 *
 * @author shell.sjhe
 * @since 2021-09-04
 */
public interface QuizService extends IService<Quiz> {

  Result addQuiz(QuizRequest quizRequest);
}
