package cn.gson.oasys.model.entity.workreport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 万先生
 * 2019/3/3  13:15
 */
@Entity
@Table(name = "w_report")
public class Report {
    @Id
    @Column(name = "report_id")
    private Integer reportId;

    @Column(name = "report_name")
    private String reportName;

    @Column(name = "report_content")
    private String reportContent;

    @Column(name = "report_time")
    private String reportTime;

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }
}
