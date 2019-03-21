package cn.gson.oasys.controller;

import cn.gson.oasys.mappers.NoticeMapper;
import cn.gson.oasys.model.dao.roledao.RolepowerlistDao;
import cn.gson.oasys.model.dao.system.StatusDao;
import cn.gson.oasys.model.dao.system.TypeDao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.role.Rolemenu;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.services.system.MenuSysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private MenuSysService menuService;
	@Autowired
	private NoticeMapper nm;
	@Autowired
	private StatusDao statusDao;
	@Autowired
	private TypeDao typeDao;
	@Autowired
	private UserDao uDao;


	@Autowired
	private RolepowerlistDao rdao;

	
	// 格式转化导入
	DefaultConversionService service = new DefaultConversionService();

	@RequestMapping("index")
	public String index(HttpServletRequest req,Model model) {
		HttpSession session = req.getSession();
		if(StringUtils.isEmpty(session.getAttribute("userId"))){
			return "login/login";
		}
		Long userId = Long.parseLong(session.getAttribute("userId") + "");
		User user=uDao.findOne(userId);
		menuService.findMenuSys(req,user);

		model.addAttribute("user", user);

		return "index/index";
	}
	/**
	 * 菜单查找
	 * @param
	 * @param req
	 * @return
	 */
	@RequestMapping("menucha")
	public String menucha(HttpSession session, Model model,HttpServletRequest req){
		Long userId = Long.parseLong(session.getAttribute("userId") + "");
		User user=uDao.findOne(userId);
		String val=null;
		if(!StringUtils.isEmpty(req.getParameter("val"))){
			val=req.getParameter("val");
		}
		if(!StringUtils.isEmpty(val)){
			List<Rolemenu> oneMenuAll=rdao.findname(0L, user.getRole().getRoleId(), true, true, val);//找父菜单
			List<Rolemenu> twoMenuAll=null;
			for (int i = 0; i < oneMenuAll.size(); i++) {
				twoMenuAll=rdao.findbyparentxianall(oneMenuAll.get(i).getMenuId(), user.getRole().getRoleId(), true, true);//找子菜单
			}
			req.setAttribute("oneMenuAll", oneMenuAll);
			req.setAttribute("twoMenuAll", twoMenuAll);
			req.setAttribute("user",user);
		}else{
			menuService.findMenuSys(req,user);
		}
	
		return "common/leftlists";
		
	}



	/**
	 * 控制面板主页
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("test2")
	public String test2(HttpSession session, Model model, HttpServletRequest request) {
		Long userId = Long.parseLong(session.getAttribute("userId") + "");
		User user=uDao.findOne(userId);
		Long roleId = user.getRole().getRoleId();
		model.addAttribute("roleId",roleId);
		return "systemcontrol/control";
	}
	



}
