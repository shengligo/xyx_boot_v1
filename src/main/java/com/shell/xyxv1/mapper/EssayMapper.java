package com.shell.xyxv1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shell.xyxv1.entity.Essay;
import com.shell.xyxv1.entity.request.EssayRequest;
import com.shell.xyxv1.entity.vo.EssayVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 文章分享 Mapper 接口
 * </p>
 *
 * @author shell
 * @since 2021-08-31
 */
public interface EssayMapper extends BaseMapper<Essay> {

    List<EssayVo> getEssayList(@Param("param") EssayRequest request);
    EssayVo getEssayById(@Param("param") EssayRequest request);
}
