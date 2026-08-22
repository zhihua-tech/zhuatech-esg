/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.repository; import cn.zhuatech.esg.model.MetricDefinition; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface MetricDefinitionRepository extends JpaRepository<MetricDefinition,Long>{List<MetricDefinition> findAllByOrderByCodeAsc();long countByStatus(MetricDefinition.Status status);}
