/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.esg.controller;
import cn.zhuatech.esg.common.ApiResponse;
import cn.zhuatech.esg.service.CarbonPathService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/admin")
public class CarbonPathController {
    private final CarbonPathService service;
    public CarbonPathController(CarbonPathService service){this.service=service;}
    @PostMapping("/carbon-path") public ApiResponse<CarbonPathService.Result> evaluate(@Valid @RequestBody CarbonPathService.Request request){return ApiResponse.ok(service.evaluate(request));}
}

