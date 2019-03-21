package cn.gson.oasys.controller.log;


import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.log.Loges;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.services.log.IlogService;
import cn.gson.oasys.util.DateUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  13:14
 */
@Controller
@RequestMapping("/")
public class LogController {
    @Autowired
    private IlogService logService;

    @Autowired
    private UserDao udao;

    /**
     * 第一次进入日志管理页面
     *
     * @return
     */
    @RequestMapping("logmanage")
    public String logManage(@SessionAttribute("userId") Long userId,Model model) {
        User user = udao.findOne(userId);
        List<Loges> logses = logService.findAll(user.getRealName());
        model.addAttribute("loges", logses);
        return "log/logmanage";
    }

    @RequestMapping(value = "view")
    public String viewManage(@SessionAttribute("userId") Long userId, Model model) {
        User user = udao.findOne(userId);
        Loges loges = new Loges();
        loges.setUser(user.getRealName());
        model.addAttribute("loges", loges);
        return "log/logedit";
    }

    @RequestMapping(value = "logedit", method = RequestMethod.POST)
    public String addOrUpdateLog(@Valid Loges loges, Model model) {
        Loges log = new Loges();
        log.setUser(loges.getUser());
        log.setContent(loges.getContent());
        log.setTime(DateUitl.dateToString());
        int re = 0;
        System.out.println("id:"+loges.getId());
        if (loges.getId() == null) {
            re = logService.add(log);
            System.out.println("re1:"+re);
        } else {
            log.setId(loges.getId());
            re = logService.update(log);
            System.out.println("re2:"+re);
        }
        System.out.println("re3:"+re);
        if (re != 0) {
            System.out.println("插入成功");
            List<Loges> logses = logService.findAll(loges.getUser());
            model.addAttribute("loges", logses);
            return "log/logmanage";
        }
        System.out.println("插入失败");
        return "log/logedit";
    }

    @RequestMapping(value = "getlog")
    public String getLog(@RequestParam(value = "id", required = false) Integer id, Model model) {
        System.out.println("id:" + id);
        Loges loges = logService.findOne(id);
        model.addAttribute("loges", loges);
        return "log/logedit";
    }

    @RequestMapping(value = "remove")
    public String removeLog(@SessionAttribute("userId") Long userId,@RequestParam(value = "id", required = false) Integer id, Model model) {
        System.out.println("id:" + id);
        int loges = logService.remove(id);
        User user = udao.findOne(userId);
        List<Loges> logses = logService.findAll(user.getRealName());
        model.addAttribute("loges", logses);
        return "log/logmanage";
    }

}
