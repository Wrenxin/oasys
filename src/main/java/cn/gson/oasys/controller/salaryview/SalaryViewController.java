package cn.gson.oasys.controller.salaryview;


import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.services.salaryview.ISalaryService;
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
public class SalaryViewController {
    @Autowired
    private ISalaryService iSalaryService;

    /**
     * 第一次进入日志管理页面
     *
     * @return
     */
    @RequestMapping("salaryviewmanage")
    public String SalaryViewManage(Model model) {
        List<User> reports = iSalaryService.findAll();
        model.addAttribute("reports", reports);
        return "salaryview/salaryviewmanage";
    }


}
