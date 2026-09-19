/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="esg_assurance_finding") public class AssuranceFinding extends BaseEntity {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Result { PENDING, PASSED, FAILED }
    @Column(nullable=false,unique=true,length=32) private String assuranceFindingNo; @ManyToOne(optional=false,fetch=FetchType.LAZY) private DisclosureTask disclosureTask;
    @Column(nullable=false,length=30) private String assuranceFindingType; @Column(nullable=false) private int assuranceFindingQty; @Column(nullable=false) private int defectQty; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Result result;
    @Column(length=50) private String inspector; @Column(nullable=false) private LocalDateTime createdAt;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected AssuranceFinding(){} /**
                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                    */
public AssuranceFinding(String assuranceFindingNo,DisclosureTask disclosureTask,String assuranceFindingType,int assuranceFindingQty,int defectQty,Result result,String inspector){this.assuranceFindingNo=assuranceFindingNo;this.disclosureTask=disclosureTask;this.assuranceFindingType=assuranceFindingType;this.assuranceFindingQty=assuranceFindingQty;this.defectQty=defectQty;this.result=result;this.inspector=inspector;this.createdAt=LocalDateTime.now();}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getAssuranceFindingNo(){return assuranceFindingNo;} /**
                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                       */
public DisclosureTask getDisclosureTask(){return disclosureTask;} /**
                                                                                                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                         */
public String getAssuranceFindingType(){return assuranceFindingType;} /**
                                                                                                                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                               */
public int getAssuranceFindingQty(){return assuranceFindingQty;} /**
                                                                                                                                                                                                                                                                                * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                */
public int getDefectQty(){return defectQty;} /**
                                                                                                                                                                                                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                             */
public Result getResult(){return result;} /**
                                                                                                                                                                                                                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                       */
public String getInspector(){return inspector;}
}
