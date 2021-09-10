package com.shell.xyxv1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shell.xyxv1.entity.Answer;
import com.shell.xyxv1.entity.request.AnswerRequest;
import com.shell.xyxv1.entity.request.QuizRequest;
import com.shell.xyxv1.entity.vo.AnswerVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 提问回答 Mapper 接口
 * </p>
 *
 * @author shell.sjhe
 * @since 2021-09-04
 */
public interface AnswerMapper extends BaseMapper<Answer> {

  List<AnswerVo> getAnswerList(@Param("param") AnswerRequest answerRequest);
}
