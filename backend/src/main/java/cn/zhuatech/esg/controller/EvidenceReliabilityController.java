/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.controller;
import cn.zhuatech.esg.common.ApiResponse;import cn.zhuatech.esg.service.EvidenceReliabilityService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/esg/insights/evidence-reliability") public class EvidenceReliabilityController {private final EvidenceReliabilityService service;public EvidenceReliabilityController(EvidenceReliabilityService service){this.service=service;}@PostMapping ApiResponse<EvidenceReliabilityService.Result> evaluate(@Valid @RequestBody EvidenceReliabilityService.Request request){return ApiResponse.ok(service.evaluate(request));}}
