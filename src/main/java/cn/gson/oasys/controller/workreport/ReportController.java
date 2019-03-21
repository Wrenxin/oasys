package cn.gson.oasys.controller.workreport;


import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.entity.workreport.Report;
import cn.gson.oasys.services.workreport.IReportService;
import cn.gson.oasys.util.DateUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by 万先生
 * 2019/3/3  14:14
 */
@Controller
@RequestMapping("/")
public class ReportController {
    @Autowired
    private IReportService iReportService;

    @Autowired
    private UserDao udao;

    @RequestMapping("reportmanage")
    public String ReportManage(@SessionAttribute("userId") Long userId,Model model) {
        User tu = udao.findOne(userId);
        List<Report> reports = iReportService.findAll(tu.getUserName());
        model.addAttribute("reports", reports);
        return "workreport/reportmanage";
    }

    @RequestMapping(value = "reportview")
    public String viewManage(@SessionAttribute("userId") Long userId, Model model) {
        User tu = udao.findOne(userId);
        Report report = new Report();
        report.setReportName(tu.getUserName());
        model.addAttribute("report",report);
        return "workreport/reportedit";
    }

    @RequestMapping(value = "reportedit", method = RequestMethod.POST)
    public String addOrUpdateReport(@SessionAttribute("userId") Long userId, @Valid Report report, Model model) {
        Report rep = new Report();
        rep.setReportName(report.getReportName());
        rep.setReportContent(report.getReportContent());
        rep.setReportTime(DateUitl.dateToString());
        int re = 0;
        System.out.println("id:"+report.getReportId());
        if (report.getReportId() == null) {
            re = iReportService.add(rep);
            System.out.println("re1:"+re);
        } else {
            rep.setReportId(report.getReportId());
            re = iReportService.update(rep);
            System.out.println("re2:"+re);
        }
        System.out.println("re3:"+re);
        if (re != 0) {
            System.out.println("插入成功");
            User tu = udao.findOne(userId);
            List<Report> reports = iReportService.findAll(tu.getUserName());
            model.addAttribute("reports", reports);
            return "workreport/reportmanage";
        }
        System.out.println("插入失败");
        return "workreport/reportedit";
    }

    @RequestMapping(value = "getreport")
    public String getReport(@RequestParam(value = "id", required = false) Integer id, Model model) {
        System.out.println("id:" + id);
        Report report = iReportService.findOne(id);
        model.addAttribute("report", report);
        return "workreport/reportedit";
    }

    @RequestMapping(value = "reportremove")
    public String removeReport(@SessionAttribute("userId") Long userId,@RequestParam(value = "id", required = false) Integer id, Model model) {
        System.out.println("id:" + id);
        int re = iReportService.remove(id);
        User tu = udao.findOne(userId);
        List<Report> reports = iReportService.findAll(tu.getUserName());
        model.addAttribute("reports", reports);
        return "workreport/reportmanage";
    }

}
