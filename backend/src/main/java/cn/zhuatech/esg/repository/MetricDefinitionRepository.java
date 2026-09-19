/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.repository; import cn.zhuatech.esg.model.MetricDefinition; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface MetricDefinitionRepository extends JpaRepository<MetricDefinition,Long>{/**
                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                          */
List<MetricDefinition> findAllByOrderByCodeAsc();/**
                                                                                                                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                           */
long countByStatus(MetricDefinition.Status status);}
