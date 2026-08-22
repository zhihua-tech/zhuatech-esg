/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.esg;
import cn.zhuatech.esg.service.EvidenceReliabilityService;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class EvidenceReliabilityServiceTests {private final EvidenceReliabilityService service=new EvidenceReliabilityService();@Test void assuresStrongEvidenceSet(){var r=service.evaluate(new EvidenceReliabilityService.Request(100,100,90,0,0,false));assertEquals("ASSURED",r.status());}@Test void rejectsWeakEstimatedEvidence(){var r=service.evaluate(new EvidenceReliabilityService.Request(100,30,10,60,5,true));assertEquals("UNRELIABLE",r.status());}}
