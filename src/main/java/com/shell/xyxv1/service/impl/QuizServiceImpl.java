package com.shell.xyxv1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shell.xyxv1.core.entity.vo.Result;
import com.shell.xyxv1.entity.Quiz;
import com.shell.xyxv1.entity.QuizLabel;
import com.shell.xyxv1.entity.request.QuizRequest;
import com.shell.xyxv1.mapper.QuizLabelMapper;
import com.shell.xyxv1.mapper.QuizMapper;
import com.shell.xyxv1.service.QuizService;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 提问 服务实现类
 * </p>
 *
 * @author shell.sjhe
 * @since 2021-09-04
 */
@Service
@Slf4j
public class QuizServiceImpl extends ServiceImpl<QuizMapper, Quiz> implements QuizService {

  @Autowired
  QuizMapper quizMapper;

  @Autowired
  QuizLabelMapper quizLabelMapper;

  @Override
  public Result addQuiz(QuizRequest quizRequest) {
    try {
      if(null == quizRequest){
        return Result.fail("添加失败");
      }
      Quiz quiz = new Quiz();
      BeanUtils.copyProperties(quizRequest,quiz);
      quiz.setCreateTime(new Date());
      quizMapper.insert(quiz);
      return Result.success("插入成功");
  }catch (Exception e){
      log.error("插入失败",e);
      return Result.fail("插入失败");
    }
  }
}
