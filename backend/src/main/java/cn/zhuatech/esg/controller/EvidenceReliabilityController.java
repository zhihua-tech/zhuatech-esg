/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.controller;
import cn.zhuatech.esg.common.ApiResponse;import cn.zhuatech.esg.service.EvidenceReliabilityService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/esg/insights/evidence-reliability") public class EvidenceReliabilityController {private final EvidenceReliabilityService service;/**
                                                                                                                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                        */
public EvidenceReliabilityController(EvidenceReliabilityService service){this.service=service;}/**
                                                                                                                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                       */
@PostMapping ApiResponse<EvidenceReliabilityService.Result> evaluate(@Valid @RequestBody EvidenceReliabilityService.Request request){return ApiResponse.ok(service.evaluate(request));}}
