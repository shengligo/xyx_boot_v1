package com.shell.xyxv1.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.api.client.util.DateTime;
import com.shell.xyxv1.core.entity.vo.Result;
import com.shell.xyxv1.entity.Essay;
import com.shell.xyxv1.entity.request.EssayRequest;
import com.shell.xyxv1.entity.vo.EssayVo;
import com.shell.xyxv1.mapper.EssayMapper;
import com.shell.xyxv1.service.EssayService;
import com.shell.xyxv1.util.PageWrapper;
import java.util.Date;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 文章分享 服务实现类
 * </p>
 *
 * @author shell
 * @since 2021-08-31
 */
@Service
@Slf4j
public class EssayServiceImpl extends ServiceImpl<EssayMapper, Essay> implements EssayService {

  @Autowired
  EssayMapper essayMapper;

  @Override
  public Result updateOrInsertEssay(EssayRequest request) {
    try {
      Essay essay = new Essay();
      BeanUtils.copyProperties(request, essay);

      if (request.getType()== 0) {
        essay.setCreateTime(new Date());
        essayMapper.insert(essay);
      } else if (request.getType() == 1) {
        essay.setUpdateTime(new Date());
        essayMapper.updateById(essay);
      }
      return Result.success("成功");
    } catch (Exception e) {
      log.error("插入失败", e);
      return Result.fail("失败");
    }

  }

  @Override
  public PageWrapper<EssayVo> getEssay(EssayRequest request) {
    PageHelper.startPage(request.getPageNum(), request.getPageSize());
    List<EssayVo> essayList = essayMapper.getEssayList(request);
    PageWrapper<EssayVo> page = new PageWrapper();
    PageInfo<EssayVo> info = new PageInfo<>(essayList);
    page.setPageInfo(info);
    return page;
  }

  @Override
  public Result getEssayDetail(EssayRequest request) {
    try {
      if (request.getId() == null) {
        return Result.fail("查询失败");
      }
      EssayVo essayVo = essayMapper.getEssayById(request);
      return Result.success(essayVo);
    } catch (Exception e) {
      log.error("查询异常",e);
      return Result.fail("查询失败");
    }
  }
}
