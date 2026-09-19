/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.config;

import cn.zhuatech.esg.model.*;
import cn.zhuatech.esg.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Configuration
public class DataInitializer {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Bean
    CommandLineRunner seed(ReportingScopeRepository reportingScopes, DisclosureTaskRepository orders,
                           MetricDefinitionRepository metricDefinitions, AssuranceFindingRepository assuranceFindings,
                           UserRepository users, PasswordEncoder encoder) {
        return args -> {
            if (reportingScopes.count() > 0) return;
            ReportingScope chemistry = reportingScopes.save(new ReportingScope("SCP-CHEM", "环境披露范围", "可持续发展中心", 180));
            ReportingScope micro = reportingScopes.save(new ReportingScope("SCP-MICRO", "社会责任范围", "研发中心", 120));
            ReportingScope material = reportingScopes.save(new ReportingScope("SCP-MAT", "供应链范围", "工程中心", 96));

            DisclosureTask t1 = orders.save(new DisclosureTask("DSC-260801-018", "GB-T-228", "范围一温室气体排放", material, 24, 16, 1, LocalDate.now().plusDays(1), DisclosureTask.Status.RUNNING, "S260801-A"));
            DisclosureTask t2 = orders.save(new DisclosureTask("DSC-260801-021", "HPLC-042", "员工培训时数", chemistry, 18, 8, 0, LocalDate.now().plusDays(1), DisclosureTask.Status.RUNNING, "S260801-C"));
            DisclosureTask t3 = orders.save(new DisclosureTask("DSC-260802-006", "ISO-4833", "供应商 ESG 覆盖率", micro, 12, 0, 0, LocalDate.now().plusDays(3), DisclosureTask.Status.RELEASED, "S260802-B"));
            DisclosureTask t4 = orders.save(new DisclosureTask("DSC-260731-015", "ICP-017", "董事会独立性", chemistry, 20, 20, 1, LocalDate.now(), DisclosureTask.Status.COMPLETED, "S260731-D"));

            metricDefinitions.saveAll(List.of(
                new MetricDefinition("MET-HPLC-03", "碳排放指标定义 03", chemistry, MetricDefinition.Status.RUNNING, 88),
                new MetricDefinition("MET-ICP-02", "公司治理指标定义", chemistry, MetricDefinition.Status.IDLE, 76),
                new MetricDefinition("MET-UTM-05", "员工发展指标定义", material, MetricDefinition.Status.RUNNING, 91),
                new MetricDefinition("MET-INC-08", "供应链责任指标 08", micro, MetricDefinition.Status.ALARM, 62)
            ));
            assuranceFindings.saveAll(List.of(
                new AssuranceFinding("AF-260801-032", t1, "留样鉴证", 6, 0, AssuranceFinding.Result.PASSED, "周妍"),
                new AssuranceFinding("AF-260801-011", t2, "前处理鉴证", 3, 0, AssuranceFinding.Result.PASSED, "陆承"),
                new AssuranceFinding("AF-260801-018", t4, "结果鉴证", 5, 1, AssuranceFinding.Result.FAILED, "周妍"),
                new AssuranceFinding("AF-260802-003", t3, "收样确认", 4, 0, AssuranceFinding.Result.PENDING, "陆承")
            ));
            String demo = encoder.encode("Demo@2026");
            users.saveAll(List.of(
                new UserAccount("operator", demo, "陆承", UserAccount.Role.DATA_OWNER, "SCP-CHEM"),
                new UserAccount("planner", demo, "周妍", UserAccount.Role.ESG_MANAGER, null),
                new UserAccount("quality", demo, "顾清", UserAccount.Role.QUALITY, null),
                new UserAccount("admin", encoder.encode("ZhuaTech@2026"), "系统管理员", UserAccount.Role.ADMIN, null)
            ));
        };
    }
}
