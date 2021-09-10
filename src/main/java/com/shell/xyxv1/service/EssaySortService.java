package com.shell.xyxv1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shell.xyxv1.entity.EssaySort;
import java.util.List;

/**
 * <p>
 * 文章分类 服务类
 * </p>
 *
 * @author shell
 * @since 2021-09-04
 */
public interface EssaySortService extends IService<EssaySort> {

  List<EssaySort> getEssaySort();
}
