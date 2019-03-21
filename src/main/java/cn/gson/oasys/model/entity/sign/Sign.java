package cn.gson.oasys.model.entity.sign;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 万先生
 * 2019/3/5  13:10
 */
@Entity
@Table(name = "w_sign")
public class Sign {
    @Id
    @Column(name = "sign_id")
    private Integer reportId;

    @Column(name = "sign_name")
    private String signName;

    @Column(name = "sign_time")
    private String signTime;

    @Column(name = "sign_ip")
    private String signIp;

    @Column(name = "sign_type")
    private String signType;

    @Column(name = "sign_check")
    private String signCheck;


    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getSignIp() {
        return signIp;
    }

    public void setSignIp(String signIp) {
        this.signIp = signIp;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSignCheck() {
        return signCheck;
    }

    public void setSignCheck(String signCheck) {
        this.signCheck = signCheck;
    }
}
