package cn.gson.oasys.controller.department;



import cn.gson.oasys.model.entity.department.Department;
import cn.gson.oasys.services.department.IDepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by 万先生
 * 2019/2/25  13:14
 */
@Controller
@RequestMapping("/")
public class DepController {
    @Autowired
    private IDepService iDepService;

    /**
     * 第一次进入部门管理页面
     *
     * @return
     */
    @RequestMapping("depmanage")
    public String depManage(Model model) {
        List<Department> departments = iDepService.findAll();
        model.addAttribute("departments", departments);
        return "department/depmanage";
    }

    @RequestMapping(value = "depview")
    public String viewManage( Model model) {
        Department department = new Department();
        department.setDepartmentAddr("111");
        model.addAttribute("department", department);
        return "department/depedit";
    }

    @RequestMapping(value = "depedit", method = RequestMethod.POST)
    public String addLog(@Valid Department dep, Model model) {
        Department department = new Department();
        department.setDepartmentName(dep.getDepartmentName());
        department.setDepartmentTel(dep.getDepartmentTel());
        department.setDepartmentAddr(dep.getDepartmentAddr());
        int re = 0;
        System.out.println("id:"+dep.getDepartmentId());
        if (dep.getDepartmentId() == null) {
            re = iDepService.add(department);
            System.out.println("re1:"+re);
        } else {
            department.setDepartmentId(dep.getDepartmentId());
            re = iDepService.update(department);
            System.out.println("re2:"+re);
        }
        System.out.println("re3:"+re);
        if (re != 0) {
            System.out.println("插入成功");
            List<Department> departments = iDepService.findAll();
            model.addAttribute("departments", departments);
            return "department/depmanage";
        }
        System.out.println("插入失败");
        return "department/depedit";
    }

    @RequestMapping(value = "getdepartment")
    public String getDepartment(@RequestParam(value = "id", required = false) Integer id, Model model) {
        System.out.println("id:" + id);
        Department department = iDepService.findOne(id);
        model.addAttribute("department", department);
        return "department/depedit";
    }

    @RequestMapping(value = "depremove")
    public String removeDep(@RequestParam(value = "id", required = false) Integer id, Model model) {
        System.out.println("id:" + id);
        int re = iDepService.remove(id);
        List<Department> departments = iDepService.findAll();
        model.addAttribute("departments", departments);
        return "department/depmanage";
    }

}
