package com.shell.xyxv1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shell.xyxv1.core.entity.vo.Result;
import com.shell.xyxv1.entity.Answer;
import com.shell.xyxv1.entity.request.AnswerRequest;
import com.shell.xyxv1.entity.request.QuizRequest;
import com.shell.xyxv1.entity.vo.AnswerVo;

import com.shell.xyxv1.util.PageWrapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 提问回答 服务类
 * </p>
 *
 * @author shell.sjhe
 * @since 2021-09-04
 */
public interface AnswerService extends IService<Answer> {

  PageWrapper<AnswerVo> getAnswerList( AnswerRequest answerRequest);

  Result addAnswer(AnswerRequest answerRequest);
}
