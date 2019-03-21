package cn.gson.oasys.model.entity.department;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 万先生
 * 2019/2/26  15:28
 */
@Entity
@Table(name = "w_department")
public class Department {
    @Id
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_tel")
    private String departmentTel;

    @Column(name = "department_addr")
    private String departmentAddr;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentTel() {
        return departmentTel;
    }

    public void setDepartmentTel(String departmentTel) {
        this.departmentTel = departmentTel;
    }

    public String getDepartmentAddr() {
        return departmentAddr;
    }

    public void setDepartmentAddr(String departmentAddr) {
        this.departmentAddr = departmentAddr;
    }
}
