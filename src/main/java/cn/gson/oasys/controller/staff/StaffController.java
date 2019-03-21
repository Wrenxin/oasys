package cn.gson.oasys.controller.staff;

import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.department.Department;
import cn.gson.oasys.model.entity.role.Role;
import cn.gson.oasys.model.entity.staff.Staff;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.services.department.IDepService;
import cn.gson.oasys.services.staff.IStaffService;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 万先生
 * 2019/2/27  14:47
 */
@Controller
@RequestMapping("/")
public class StaffController {
    @Autowired
    private UserDao udao;

    @Autowired
    private IStaffService iStaffService;

    @Autowired
    private IDepService iDepService;

    /**
     * 员工管理页面
     *
     * @return
     */
    @RequestMapping("staffmanage")
    public String staffView(Model model) {

        List<Staff> staffList = new ArrayList<>();
        List<User> users = iStaffService.findAll();
        for (User u : users) {
            Department department = iDepService.findOne(u.getDepartmentId());
            Staff staff = new Staff();
            staff.setId(u.getUserId());
            staff.setDepartmentName(department.getDepartmentName());
            staff.setUsername(u.getUserName());
            staff.setRealName(u.getRealName());
            staff.setTel(u.getUserTel());
            staff.setSalary(u.getSalary());
            staffList.add(staff);
        }
        model.addAttribute("staffList", staffList);
        return "staff/staffmanage";
    }

    @RequestMapping(value = "staffedit", method = RequestMethod.POST)
    public String addOrUpdateStaff(User user,Model model) {
        User u = new User();
        u.setDepartmentId(user.getDepartmentId());
        u.setUserName(user.getUserName());
        u.setRealName(user.getRealName());
        u.setUserTel(user.getUserTel());
        u.setSalary(user.getSalary());
        u.setEamil(user.getEamil());
        u.setAddress(user.getAddress());
        u.setUserEdu(user.getUserEdu());
        u.setSchool(user.getSchool());
        u.setIdCard(user.getIdCard());
        u.setBank(user.getBank());
        u.setSex(user.getSex());
        u.setSalary(user.getSalary());
        u.setHireTime(user.getHireTime());
        u.setPassword(user.getPassword());
        u.setRole(user.getRole());
        System.out.println("roke"+user.getRole());
        int re = 0;
        if (user.getUserId() == null) {
            re = iStaffService.add(u);
            System.out.println("re1:" + re);
        } else {
            u.setUserId(user.getUserId());
            re = iStaffService.update(u);
            System.out.println("re2:" + re);
        }
        System.out.println("re3:" + re);
        if (re != 0) {
            System.out.println("插入成功");
            return this.staffView(model);
        }
        System.out.println("插入失败");
        return "staff/staffedit";
    }

    @RequestMapping(value = "getstaff")
    public String getStaff(@RequestParam(value = "id", required = false) Long id, Model model) {
        System.out.println("id:" + id);
        User user = iStaffService.findOne(id);
        Department department = iDepService.findOne(user.getDepartmentId());
        List<Department> departments = iDepService.findAll();
        List<Role> roles = iStaffService.findRole();
        model.addAttribute("user", user);
        model.addAttribute("idCheck", id);
        model.addAttribute("roles", roles);
        model.addAttribute("departmentName", department.getDepartmentName());
        model.addAttribute("departments", departments);
        return "staff/staffedit";
    }

    @RequestMapping(value = "removestaff")
    public String removeStaff(@RequestParam(value = "id", required = false) Long id, Model model) {
        System.out.println("id:" + id);
        int u = iStaffService.remove(id);
        return this.staffView(model);
    }

    @RequestMapping(value = "staffview")
    public String view(Model model) {
        User user = new User();
        List<Department> departments = iDepService.findAll();
        List<Role> roles = iStaffService.findRole();
        int  id= user.getUserId()==null?0:1;
        model.addAttribute("idCheck", id);
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        model.addAttribute("departmentName", "请选择");
        model.addAttribute("departments", departments);
        return "staff/staffedit";
    }

    @RequestMapping("staffchaxun")
    public String chaXun(HttpServletRequest request, Model model) {
        String title = null;
        if (!StringUtil.isEmpty(request.getParameter("title"))) {
            title = request.getParameter("title").trim();
        }

        List<Staff> staffList = new ArrayList<>();
        List<User> users = null;
        if (title == null) {
            users = iStaffService.findAll();
        } else {
            users = iStaffService.findByRealName(title);
        }
        for (User u : users) {
            Department department = iDepService.findOne(u.getDepartmentId());
            Staff staff = new Staff();
            staff.setId(u.getUserId());
            staff.setDepartmentName(department.getDepartmentName());
            staff.setUsername(u.getUserName());
            staff.setRealName(u.getRealName());
            staff.setTel(u.getUserTel());
            staff.setSalary(u.getSalary());
            staffList.add(staff);
        }
        model.addAttribute("staffList", staffList);
        return "staff/staffmanage";
    }




}
