/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.service;
import jakarta.validation.constraints.*;import org.springframework.stereotype.Service;import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service public class EvidenceReliabilityService {
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public Result evaluate(Request r){double integrated=r.sourceIntegratedMetrics()*100.0/r.totalMetrics();double verified=r.thirdPartyVerifiedMetrics()*100.0/r.totalMetrics();double estimated=r.estimatedMetrics()*100.0/r.totalMetrics();int score=(int)Math.round(Math.min(100,integrated*.55+verified*.35+Math.max(0,100-estimated)*.10-r.overdueOwners()*3-(r.restatementRequired()?15:0)));score=Math.max(0,score);String status=score>=85?"ASSURED":score>=60?"IMPROVE":"UNRELIABLE";List<String> actions=new ArrayList<>();if(integrated<80)actions.add("提升指标与源系统的自动采集覆盖");if(verified<50)actions.add("扩大关键指标第三方核验范围");if(estimated>20)actions.add("用实测数据替代高比例估算值");if(r.overdueOwners()>0)actions.add("督促逾期指标责任人提交证据");if(actions.isEmpty())actions.add("证据链完整，可进入披露复核");return new Result(score,Math.round(integrated*10)/10.0,Math.round(verified*10)/10.0,status,actions);}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record Request(@Min(1) int totalMetrics,@Min(0) int sourceIntegratedMetrics,@Min(0) int thirdPartyVerifiedMetrics,@Min(0) int estimatedMetrics,@Min(0) int overdueOwners,@NotNull Boolean restatementRequired){}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record Result(int reliabilityScore,double sourceIntegrationRate,double verificationRate,String status,List<String> actions){}
}
