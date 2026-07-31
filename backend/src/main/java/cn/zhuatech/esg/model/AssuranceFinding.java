/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.esg.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="esg_assurance_finding") public class AssuranceFinding extends BaseEntity {
    public enum Result { PENDING, PASSED, FAILED }
    @Column(nullable=false,unique=true,length=32) private String assuranceFindingNo; @ManyToOne(optional=false,fetch=FetchType.LAZY) private DisclosureTask disclosureTask;
    @Column(nullable=false,length=30) private String assuranceFindingType; @Column(nullable=false) private int assuranceFindingQty; @Column(nullable=false) private int defectQty; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Result result;
    @Column(length=50) private String inspector; @Column(nullable=false) private LocalDateTime createdAt;
    protected AssuranceFinding(){} public AssuranceFinding(String assuranceFindingNo,DisclosureTask disclosureTask,String assuranceFindingType,int assuranceFindingQty,int defectQty,Result result,String inspector){this.assuranceFindingNo=assuranceFindingNo;this.disclosureTask=disclosureTask;this.assuranceFindingType=assuranceFindingType;this.assuranceFindingQty=assuranceFindingQty;this.defectQty=defectQty;this.result=result;this.inspector=inspector;this.createdAt=LocalDateTime.now();}
    public String getAssuranceFindingNo(){return assuranceFindingNo;} public DisclosureTask getDisclosureTask(){return disclosureTask;} public String getAssuranceFindingType(){return assuranceFindingType;} public int getAssuranceFindingQty(){return assuranceFindingQty;} public int getDefectQty(){return defectQty;} public Result getResult(){return result;} public String getInspector(){return inspector;}
}
