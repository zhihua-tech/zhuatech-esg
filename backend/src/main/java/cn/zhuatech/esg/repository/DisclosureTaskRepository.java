/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.repository; import cn.zhuatech.esg.model.DisclosureTask; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface DisclosureTaskRepository extends JpaRepository<DisclosureTask,Long>{List<DisclosureTask> findAllByOrderByDueDateAsc();List<DisclosureTask> findByReportingScopeCodeOrderByDueDateAsc(String code);long countByStatus(DisclosureTask.Status status);}
