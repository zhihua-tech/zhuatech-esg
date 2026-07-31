/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. */
package cn.zhuatech.esg.model;
import jakarta.persistence.*;
@Entity @Table(name="esg_user")
public class UserAccount extends BaseEntity {
    public enum Role { ADMIN, ESG_MANAGER, DATA_OWNER, QUALITY }
    @Column(nullable=false,unique=true,length=32) private String username; @Column(nullable=false) private String password;
    @Column(nullable=false,length=50) private String fullName; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Role role;
    @Column(name="reporting_scope_code",length=32) private String reportingScopeCode; @Column(nullable=false) private boolean enabled=true;
    protected UserAccount(){}
    public UserAccount(String username,String password,String fullName,Role role,String reportingScopeCode){this.username=username;this.password=password;this.fullName=fullName;this.role=role;this.reportingScopeCode=reportingScopeCode;}
    public String getUsername(){return username;} public String getPassword(){return password;} public String getFullName(){return fullName;} public Role getRole(){return role;} public String getReportingScopeCode(){return reportingScopeCode;} public boolean isEnabled(){return enabled;}
}
