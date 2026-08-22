/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="esg_metric_submission") public class MetricSubmission extends BaseEntity {
    @ManyToOne(optional=false,fetch=FetchType.LAZY) private DisclosureTask disclosureTask; @Column(nullable=false,length=50) private String operationName; @Column(nullable=false) private int goodQty; @Column(nullable=false) private int defectQty;
    @Column(nullable=false,length=50) private String operatorName; @Column(nullable=false) private LocalDateTime reportedAt; @Column(length=200) private String remark;
    protected MetricSubmission(){} public MetricSubmission(DisclosureTask disclosureTask,String operationName,int goodQty,int defectQty,String operatorName,String remark){this.disclosureTask=disclosureTask;this.operationName=operationName;this.goodQty=goodQty;this.defectQty=defectQty;this.operatorName=operatorName;this.reportedAt=LocalDateTime.now();this.remark=remark;}
    public DisclosureTask getDisclosureTask(){return disclosureTask;} public String getOperationName(){return operationName;} public int getGoodQty(){return goodQty;} public int getDefectQty(){return defectQty;} public String getOperatorName(){return operatorName;} public LocalDateTime getReportedAt(){return reportedAt;}
}
