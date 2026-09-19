/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.controller;
import cn.zhuatech.esg.common.ApiResponse;
import cn.zhuatech.esg.service.CarbonPathService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/admin")
public class CarbonPathController {
    private final CarbonPathService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public CarbonPathController(CarbonPathService service){this.service=service;}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/carbon-path") public ApiResponse<CarbonPathService.Result> evaluate(@Valid @RequestBody CarbonPathService.Request request){return ApiResponse.ok(service.evaluate(request));}
}

