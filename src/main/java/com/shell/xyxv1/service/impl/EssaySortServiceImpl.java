package com.shell.xyxv1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shell.xyxv1.entity.EssaySort;
import com.shell.xyxv1.mapper.EssaySortMapper;
import com.shell.xyxv1.service.EssaySortService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章分类 服务实现类
 * </p>
 *
 * @author shell
 * @since 2021-09-04
 */
@Service
public class EssaySortServiceImpl extends ServiceImpl<EssaySortMapper, EssaySort> implements
    EssaySortService {

  @Autowired
  EssaySortMapper essaySortMapper;

  @Override
  public List<EssaySort> getEssaySort() {

    return essaySortMapper.getEssaySortList();
  }
}
