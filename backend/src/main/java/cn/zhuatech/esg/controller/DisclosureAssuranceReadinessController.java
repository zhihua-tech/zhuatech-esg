/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.controller;
import cn.zhuatech.esg.common.ApiResponse;
import cn.zhuatech.esg.service.DisclosureAssuranceReadinessService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/enterprise/esg")
public class DisclosureAssuranceReadinessController {
    private final DisclosureAssuranceReadinessService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public DisclosureAssuranceReadinessController(DisclosureAssuranceReadinessService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/assurance-readiness")
    public ApiResponse<DisclosureAssuranceReadinessService.Result> evaluate(@Valid @RequestBody DisclosureAssuranceReadinessService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
