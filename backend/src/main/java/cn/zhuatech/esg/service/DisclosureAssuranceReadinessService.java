/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.service;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service
public class DisclosureAssuranceReadinessService {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Result evaluate(Request request) {
        List<String> gaps = new ArrayList<>();
        int evidenceGap = Math.max(0, request.totalMetrics() - request.metricsWithEvidence());
        if (evidenceGap > 0) gaps.add("缺少证据的指标数量: " + evidenceGap);
        if (!request.methodologyApproved()) gaps.add("核算方法尚未批准");
        if (!request.scopeBoundaryApproved()) gaps.add("披露范围边界尚未批准");
        if (!request.ownerSignedOff()) gaps.add("指标责任人尚未签署确认");
        if (request.unresolvedFindings() > 0) gaps.add("存在未关闭鉴证发现: " + request.unresolvedFindings());
        if (request.independentAssuranceRequired() && !request.assuranceProviderAssigned()) gaps.add("尚未指定独立鉴证机构");
        int completeness = request.totalMetrics() == 0 ? 100 : request.metricsWithEvidence() * 100 / request.totalMetrics();
        String decision = gaps.isEmpty() ? "READY" : request.unresolvedFindings() > 0 ? "HOLD" : "REVIEW";
        return new Result(request.disclosureId(), decision, completeness, List.copyOf(gaps), gaps.isEmpty());
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Request(@NotBlank String disclosureId, @Min(0) int totalMetrics,
                          @Min(0) int metricsWithEvidence, boolean methodologyApproved,
                          boolean scopeBoundaryApproved, boolean ownerSignedOff,
                          @Min(0) int unresolvedFindings, boolean independentAssuranceRequired,
                          boolean assuranceProviderAssigned) {
        /**
         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
         */
        public Request {
            if (disclosureId == null || disclosureId.isBlank()) throw new IllegalArgumentException("disclosureId is required");
            if (totalMetrics < 0 || metricsWithEvidence < 0 || metricsWithEvidence > totalMetrics || unresolvedFindings < 0)
                throw new IllegalArgumentException("invalid metric or finding counts");
        }
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Result(String disclosureId, String decision, int evidenceCompletenessPercent,
                         List<String> gaps, boolean publicationAllowed) {}
}
