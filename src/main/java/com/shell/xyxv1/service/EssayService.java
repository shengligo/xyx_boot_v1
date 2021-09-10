package com.shell.xyxv1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shell.xyxv1.core.entity.vo.Result;
import com.shell.xyxv1.entity.Essay;
import com.shell.xyxv1.entity.request.EssayRequest;
import com.shell.xyxv1.entity.vo.EssayVo;
import com.shell.xyxv1.util.PageWrapper;

/**
 * <p>
 * 文章分享 服务类
 * </p>
 *
 * @author shell
 * @since 2021-08-31
 */
public interface EssayService extends IService<Essay> {

    Result updateOrInsertEssay(EssayRequest request);

    PageWrapper<EssayVo> getEssay(EssayRequest request);

  Result getEssayDetail(EssayRequest request);
}
