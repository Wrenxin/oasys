package cn.gson.oasys.controller.sign;

import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.sign.Sign;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.services.sign.ISignService;
import cn.gson.oasys.util.DateUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by 万先生
 * 2019/3/5  14:49
 */
@Controller
@RequestMapping("/")
public class SignController {
    @Autowired
    private ISignService iSignService;

    @Autowired
    private UserDao udao;

    @RequestMapping(value = "signUp")
    public String signUp(@SessionAttribute("userId") Long userId, Model model)throws UnknownHostException {
        User u = udao.findOne(userId);
        //首先获取ip
        InetAddress ia=null;
        ia=ia.getLocalHost();
        String ip=ia.getHostAddress();
        String time = u.getRealName()+"A"+ DateUitl.dateToString().substring(0,4)+ DateUitl.dateToString().substring(5,7)+ DateUitl.dateToString().substring(8,10);

        Sign sign = iSignService.find(time);
        if (sign!=null){
            System.out.println("已经上班打卡");
            model.addAttribute("error","1");
            return "systemcontrol/control";
        }

        Sign s = new Sign();
        s.setSignName(u.getRealName());
        String date = DateUitl.dateToString().substring(12,14);
        if(date.compareTo("08")>0){
            s.setSignType("迟到");
        }else {
            s.setSignType("正常");
        }
        s.setSignTime(DateUitl.dateToString());
        s.setSignIp(ip);
        s.setSignCheck(time);
        int re = iSignService.add(s);
        model.addAttribute("success","打卡成功");
        return "systemcontrol/control";
    }

    @RequestMapping(value = "signDown")
    public String signDown(@SessionAttribute("userId") Long userId, Model model)throws UnknownHostException {
        User u = udao.findOne(userId);
        //首先获取ip
        InetAddress ia=null;
        ia=ia.getLocalHost();
        String ip=ia.getHostAddress();
        String time = u.getRealName()+"P"+ DateUitl.dateToString().substring(0,4)+ DateUitl.dateToString().substring(5,7)+ DateUitl.dateToString().substring(8,10);

        Sign sign = iSignService.find(time);
        if (sign!=null){
            System.out.println("已经下班打卡");
            model.addAttribute("error","2");
            return "systemcontrol/control";
        }
        Sign s = new Sign();
        s.setSignName(u.getRealName());
        String date = DateUitl.dateToString().substring(12,14);
        if(date.compareTo("18")<0){
            s.setSignType("早退");
        }else {
            s.setSignType("正常");
        }
        s.setSignTime(DateUitl.dateToString());
        s.setSignIp(ip);
        s.setSignCheck(time);
        int re = iSignService.add(s);
        model.addAttribute("success","打卡成功");
        return "systemcontrol/control";
    }

    @RequestMapping(value = "signview")
    public String signView(@SessionAttribute("userId") Long userId, Model model){
        User u = udao.findOne(userId);
        List<Sign> signs = iSignService.findByName(u.getRealName());
        model.addAttribute("signs",signs);
        return "sign/sign";

    }
    @RequestMapping(value = "signallview")
    public String signAllView(Model model){
        List<Sign> signs = iSignService.findAll();
        model.addAttribute("signs",signs);
        return "sign/sign";

    }

}
