package cn.gson.oasys.controller.bonus;


import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.bonus.Bonus;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.services.bonus.IBonusService;
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
 * 2019/3/4  13:12
 */
@Controller
@RequestMapping("/")
public class BonusController {
    @Autowired
    private IBonusService iBonusService;

    @Autowired
    private UserDao udao;


    @RequestMapping("bonusmanage")
    public String bonusManage(Model model) {
        List<Bonus> bonuses = iBonusService.findAll();
        model.addAttribute("bonuses", bonuses);
        return "bonus/bonusmanage";
    }

    @RequestMapping(value = "bonusview")
    public String bonusManage(@SessionAttribute("userId") Long userId, Model model) {
        User tu = udao.findOne(userId);
        Bonus bonus = new Bonus();
        model.addAttribute("bonus", bonus);
        return "bonus/bonusedit";
    }

    @RequestMapping(value = "bonusedit", method = RequestMethod.POST)
    public String addOrUpdateBonus(@Valid Bonus bonus, Model model) {
        Bonus bonus1 = new Bonus();
        bonus1.setBonusTime(DateUitl.dateToString());
        bonus1.setBonusContent(bonus.getBonusContent());
        int re = 0;
        System.out.println("id:" + bonus.getBonusId());
        if (bonus.getBonusId() == null) {
            re = iBonusService.add(bonus1);
            System.out.println("re1:" + re);
        } else {
            bonus1.setBonusId(bonus.getBonusId());
            re = iBonusService.update(bonus);
            System.out.println("re2:" + re);
        }
        System.out.println("re3:" + re);
        if (re != 0) {
            System.out.println("插入成功");
            List<Bonus> bonuses = iBonusService.findAll();
            model.addAttribute("bonuses", bonuses);
            return "bonus/bonusmanage";
        }
        System.out.println("插入失败");
        return "bonus/bonusedit";
    }

    @RequestMapping(value = "getbonus")
    public String getBonus(@RequestParam(value = "id", required = false) Integer id, Model model) {
        System.out.println("id:" + id);
        Bonus bonus = iBonusService.findOne(id);
        model.addAttribute("bonus", bonus);
        return "bonus/bonusedit";
    }

    @RequestMapping(value = "bonusremove")
    public String removeBonus(@RequestParam(value = "id", required = false) Integer id, Model model) {
        System.out.println("id:" + id);
        int remove = iBonusService.remove(id);
        List<Bonus> bonuses = iBonusService.findAll();
        model.addAttribute("bonuses", bonuses);
        return "bonus/bonusmanage";
    }


}
