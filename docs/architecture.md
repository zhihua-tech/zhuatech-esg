# ESG 架构

版权所有 © 2026 上海如静知华信息科技有限公司。

浏览器通过 Vue 管理端或指标填报人端访问 Spring Boot REST API。安全层完成 JWT 与角色鉴权，业务层负责披露任务、指标、指标定义、鉴证和结果记录，JPA/Flyway 管理 MySQL 数据。

管理端角色为 `ESG_MANAGER`、`QUALITY`、`ADMIN`；执行端角色为 `DATA_OWNER`。正式部署建议将指标定义连接置于独立采集服务，并隔离披露范围网络和办公网络。
