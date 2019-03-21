package cn.gson.oasys.controller.reportview;



import cn.gson.oasys.model.entity.workreport.Report;
import cn.gson.oasys.services.reportview.IReportViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 万先生
 * 2019/3/3  14:14
 */
@Controller
@RequestMapping("/")
public class ReportViewController {
    @Autowired
    private IReportViewService iReportService;

    /**
     * 第一次进入日志管理页面
     *
     * @return
     */
    @RequestMapping("reportviewmanage")
    public String ReportViewManage(Model model) {
        List<Report> reports = iReportService.findAll();
        model.addAttribute("reports", reports);
        return "reportview/reportmanage";
    }


}
