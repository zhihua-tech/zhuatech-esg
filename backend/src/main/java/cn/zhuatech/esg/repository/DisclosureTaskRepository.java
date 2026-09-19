/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.esg.repository; import cn.zhuatech.esg.model.DisclosureTask; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface DisclosureTaskRepository extends JpaRepository<DisclosureTask,Long>{/**
                                                                                      * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                      */
List<DisclosureTask> findAllByOrderByDueDateAsc();/**
                                                                                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                        */
List<DisclosureTask> findByReportingScopeCodeOrderByDueDateAsc(String code);/**
                                                                                                                                                                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                    */
long countByStatus(DisclosureTask.Status status);}
