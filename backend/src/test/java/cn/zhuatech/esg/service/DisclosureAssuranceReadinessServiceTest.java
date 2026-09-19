/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.service;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class DisclosureAssuranceReadinessServiceTest {
    private final DisclosureAssuranceReadinessService service = new DisclosureAssuranceReadinessService();
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void marksEvidenceCompleteDisclosureReady() {
        var r = service.evaluate(new DisclosureAssuranceReadinessService.Request("ESG-001", 20, 20, true, true, true, 0, true, true));
        assertEquals("READY", r.decision()); assertEquals(100, r.evidenceCompletenessPercent()); assertTrue(r.publicationAllowed());
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void holdsDisclosureWithOpenFindings() {
        var r = service.evaluate(new DisclosureAssuranceReadinessService.Request("ESG-002", 20, 16, false, false, false, 2, true, false));
        assertEquals("HOLD", r.decision()); assertEquals(6, r.gaps().size()); assertFalse(r.publicationAllowed());
    }
}
