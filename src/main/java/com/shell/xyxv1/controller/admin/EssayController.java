package com.shell.xyxv1.controller.admin;


import com.shell.xyxv1.core.entity.vo.Result;
import com.shell.xyxv1.entity.request.EssayRequest;
import com.shell.xyxv1.service.EssayService;
import com.shell.xyxv1.service.EssaySortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 文章分享 前端控制器
 * </p>
 *
 * @author shell
 * @since 2021-08-31
 */
@RestController
@RequestMapping("essay")
public class EssayController {

  @Autowired
  EssayService essayService;

  @Autowired
  EssaySortService essaySortService;

  /**
   * 更新和新增文章
   * @param request
   * @return
   */
  @PostMapping("updateOrInsertEssay")
  public Result updateOrInsertEssay(@RequestBody EssayRequest request){
    return essayService.updateOrInsertEssay(request);
  }

  /**
   *获取文章列表
   * @param request
   * @return
   */
  @GetMapping("getEssayList")
  public Result getEssayList(EssayRequest request){
    return Result.success(essayService.getEssay(request));
  }

  /**
   * 获取文章分类列表
   * @return
   */
  @GetMapping("getEssaySort")
  public Result getEssaySort(){
    return  Result.success(essaySortService.getEssaySort());
  }

  @GetMapping("getEssayDetail")
  public Result getEssayDetail(EssayRequest request){
    return  essayService.getEssayDetail(request);
  }
}
