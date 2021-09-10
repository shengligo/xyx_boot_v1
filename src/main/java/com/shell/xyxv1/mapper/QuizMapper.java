package com.shell.xyxv1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shell.xyxv1.entity.Quiz;
import com.shell.xyxv1.entity.request.QuizRequest;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 提问 Mapper 接口
 * </p>
 *
 * @author shell.sjhe
 * @since 2021-09-04
 */
public interface QuizMapper extends BaseMapper<Quiz> {

  int insertQuiz(@Param("param") QuizRequest quizRequest);
}
