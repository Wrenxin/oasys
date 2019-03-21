package cn.gson.oasys.controller.perInformation;


import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.services.perInformation.IPerInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  19:21
 */
@Controller
@RequestMapping("/")
public class PerInforController {
    @Autowired
    private IPerInforService perInforService;

    /**
     * 个人信息管理页面
     *
     * @return
     */
    @RequestMapping("perinformation")
    public String InforManage(@SessionAttribute("userId") Long userId, Model model) {
        System.out.print(userId);
        User user = perInforService.find(userId);
        System.out.print(user.toString());
        model.addAttribute("user", user);
        return "perInformation/perinformanage";
    }

    @RequestMapping(value = "personalupdatet",method = RequestMethod.POST)
    public String InforUpdate(User user, Model model) {
        int re = perInforService.update(user);
        System.out.print(user.toString());
        User infor = perInforService.find(user.getUserId());
        model.addAttribute("user", infor);
        return "perInformation/perinformanage";

    }
}
