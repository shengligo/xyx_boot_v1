package com.shell.xyxv1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shell.xyxv1.core.entity.vo.Result;
import com.shell.xyxv1.entity.Answer;
import com.shell.xyxv1.entity.request.AnswerRequest;
import com.shell.xyxv1.entity.request.QuizRequest;
import com.shell.xyxv1.entity.vo.AnswerVo;
import com.shell.xyxv1.mapper.AnswerMapper;
import com.shell.xyxv1.service.AnswerService;
import com.shell.xyxv1.util.PageWrapper;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 提问回答 服务实现类
 * </p>
 *
 * @author shell.sjhe
 * @since 2021-09-04
 */
@Service
@Slf4j
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements AnswerService {

  @Autowired AnswerMapper answerMapper;
  @Override
  public PageWrapper<AnswerVo> getAnswerList(AnswerRequest answerRequest) {
    PageHelper.startPage(answerRequest.getPageNum(), answerRequest.getPageSize());
    List<AnswerVo> answerVoList = answerMapper.getAnswerList(answerRequest);
    PageWrapper<AnswerVo> page = new PageWrapper();
    PageInfo<AnswerVo> info = new PageInfo<>(answerVoList);
    page.setPageInfo(info);
    return page;
  }

  @Override
  public Result addAnswer(AnswerRequest answerRequest) {
    Answer answer =new Answer();
    try{
      if (null ==answerRequest ){
        return Result.fail("添加失败");
      }
      BeanUtils.copyProperties(answerRequest,answer);
      answer.setCreateTime(new Date());
      answerMapper.insert(answer);
      return Result.success("插入成功");
    }catch (Exception e) {
      log.error("插入失败", e);
      return Result.fail("插入失败");
    }
  }

}
