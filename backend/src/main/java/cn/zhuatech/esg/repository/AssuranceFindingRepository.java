/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.esg.repository; import cn.zhuatech.esg.model.AssuranceFinding; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface AssuranceFindingRepository extends JpaRepository<AssuranceFinding,Long>{List<AssuranceFinding> findTop10ByOrderByIdDesc();long countByResult(AssuranceFinding.Result result);}
