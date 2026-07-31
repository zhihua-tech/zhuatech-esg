/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.esg.repository; import cn.zhuatech.esg.model.ReportingScope; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface ReportingScopeRepository extends JpaRepository<ReportingScope,Long>{Optional<ReportingScope> findByCode(String code);}
