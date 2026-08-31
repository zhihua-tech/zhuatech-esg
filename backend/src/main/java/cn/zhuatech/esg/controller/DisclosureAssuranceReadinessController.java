/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.controller;
import cn.zhuatech.esg.common.ApiResponse;
import cn.zhuatech.esg.service.DisclosureAssuranceReadinessService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/enterprise/esg")
public class DisclosureAssuranceReadinessController {
    private final DisclosureAssuranceReadinessService service;
    public DisclosureAssuranceReadinessController(DisclosureAssuranceReadinessService service) { this.service = service; }
    @PostMapping("/assurance-readiness")
    public ApiResponse<DisclosureAssuranceReadinessService.Result> evaluate(@Valid @RequestBody DisclosureAssuranceReadinessService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
