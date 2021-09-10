package com.shell.xyxv1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shell.xyxv1.entity.EssaySort;
import java.util.List;

/**
 * <p>
 * 文章分类 Mapper 接口
 * </p>
 *
 * @author shell
 * @since 2021-09-04
 */
public interface EssaySortMapper extends BaseMapper<EssaySort> {

  List<EssaySort> getEssaySortList();
}
