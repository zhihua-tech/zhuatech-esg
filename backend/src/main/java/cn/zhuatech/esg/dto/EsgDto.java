/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.dto;
import jakarta.validation.constraints.*; import java.time.*; import java.util.List;
public final class EsgDto { private EsgDto(){}
    public record Metric(String label,String value,String hint,String tone){}
    public record DisclosureTaskView(Long id,String orderNo,String productCode,String productName,String reportingScope,String workshop,int plannedQty,int completedQty,int defectQty,LocalDate dueDate,String status,String batchNo,int progress){}
    public record MetricDefinitionView(String code,String name,String reportingScope,String status,int oee,LocalDateTime lastHeartbeat){}
    public record AssuranceFindingView(String assuranceFindingNo,String orderNo,String productName,String assuranceFindingType,int assuranceFindingQty,int defectQty,String result,String inspector){}
    public record Dashboard(List<Metric> metrics,List<DisclosureTaskView> disclosureTasks,List<MetricDefinitionView> metricDefinition,List<AssuranceFindingView> assuranceFindings){}
    public record ReportRequest(@NotBlank String operationName,@Positive int goodQty,@PositiveOrZero int defectQty,@Size(max=200) String remark){}
    public record ReportResult(String orderNo,int completedQty,int defectQty,int progress,String status){}
}
