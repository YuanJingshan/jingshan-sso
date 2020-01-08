package com.up.jingshan.client.auth.user.controller;

import com.up.jingshan.client.auth.common.Constants;
import com.up.jingshan.client.auth.common.utils.DateUtil;
import com.up.jingshan.client.auth.user.model.Permission;
import com.up.jingshan.client.auth.user.model.Role;
import com.up.jingshan.client.auth.user.model.User;
import com.up.jingshan.client.auth.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author YuanJingshan
 * @version 1.0
 * @description 管理系统用户业务逻辑
 * @date Create in 2018/11/28 13:13
 */
@Slf4j
@Controller
@RequestMapping
public class UserController {
    private final String LOGIN_URL = "login";
    private final String INDEX_URL = "index";
    private final String MANAGE_HOME_URL = "home";
    private final String USER_COUNT = "faq/user/user_account";
    private final String USER_LIST = "faq/user/user_list";
    private final String USER_PWD = "faq/user/user_pwd";

    @Autowired
    @Qualifier(value = "userServiceImpl")
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login() {
        return LOGIN_URL;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Authentication authentication, HttpServletRequest request, Model model) {
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        List<Permission> menus = new ArrayList<>();
        for (Role role : user.getRoles()) {
            List<Permission> permissions = role.getPermissions();
            for (Permission permission: permissions) {
                if (Constants.RESOUCE_TYPE_MENU == permission.getType()) {
                    menus.add(permission);
                }
            }
        }
        Collections.sort(menus);
        request.getSession().setAttribute("admin", user);
        request.getSession().setAttribute("version", DateUtil.formatDate(new Date(), DateUtil.DATE_FMT_YMDHMS));
        model.addAttribute("menus", menus);

        return INDEX_URL;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return MANAGE_HOME_URL;
    }
//
//    @RequestMapping(value = "faq/login", method = RequestMethod.GET)
//    public String tologin() {
//        return LOGIN_URL;
//    }
//
//    @RequestMapping(value = "faq/login/operate", method = RequestMethod.POST)
//    @ResponseBody
//    public MapResult login(String userName, String password, HttpServletRequest request) {
//        try {
//            if (StringUtils.isEmpty(userName)) {
//                return new MapResult().error(Constants.CODE_ERROR_VALIDATION, "用户名不能为空");
//            }
//
//            if (StringUtils.isEmpty(password)) {
//                return new MapResult().error(Constants.CODE_ERROR_VALIDATION, "密码不能为空");
//            }
//            User user = userService.findByUserName(userName);
//            if (user == null) {
//                return new MapResult().error(Constants.CODE_ERROR_VALIDATION, "用户名不正确");
//            }
//            String salt = user.getSalt();
//            String pwd = password + salt;
//            String encrypt = SM3Util.encrypt(pwd);
//            if (!user.getPassword().equals(encrypt)) {
//                return new MapResult().error(Constants.CODE_ERROR_VALIDATION, "密码不正确");
//            }
//            if (!user.isStatus()) {
//                return new MapResult().error(Constants.CODE_ERROR_VALIDATION, "用户已停用，请联系管理员");
//            }
//            HttpSession session = request.getSession();
//            session.setAttribute("loginUser", user);
//
//            return new MapResult().ok("登录成功");
//        } catch (Exception e) {
//            log.error("用户的登录异常， userName={}， password={}", userName, password, e);
//            return new MapResult().error("登录失败");
//        }
//    }
//
//    @RequestMapping(value = "faq/logout", method = RequestMethod.GET)
//    public String logout(HttpServletRequest request) {
//        request.getSession().invalidate();
//        return "redirect:/faq/login";
//    }
//
//    @RequestMapping(value = "faq/user/{id}", method = RequestMethod.GET)
//    public String account(@PathVariable String id, Model model) {
//        User user = userService.findByID(id);
//        model.addAttribute("user", user);
//        return USER_COUNT;
//    }
//
//    @RequestMapping(value = "faq/user/pwd/{id}", method = RequestMethod.GET)
//    public String pwd(@PathVariable String id, Model model) {
//        User user = userService.findByID(id);
//        model.addAttribute("user", user);
//        return USER_PWD;
//    }
//
//    @RequestMapping(value = "faq/user/changpwd", method = RequestMethod.POST)
//    @ResponseBody
//    public MapResult changPwd(User user) {
//        try {
//            if (!user.getNewPassword().equals(user.getNewPassword())) {
//                return new MapResult().error("新密码两次输入不一致");
//            }
//            boolean flag = userService.changePwd(user);
//
//            if (flag) {
//                return new MapResult().ok("密码修改成功");
//            }
//            return new MapResult().error("密码不能与旧密码一致");
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            return new MapResult().error("保存失败");
//        }
//    }
//
//
//    @ResponseBody
//    @RequestMapping(value = "faq/user/save", method = RequestMethod.POST)
//    public MapResult save(HttpServletRequest request, User user) {
//        try {
//            if (!StringUtils.isEmpty(user.getId())) {
//                if (!userService.updateUser(user)) {
//                    return new MapResult().error("修改失败");
//                }
//                //修改自己，刷新session
//                if ("0".equals(user.getMine())) {
//                    HttpSession session = request.getSession();
//                    session.setAttribute("loginUser", user);
//                }
//                return new MapResult().ok("修改成功");
//            } else {
//                boolean exists = userService.checkUserName(user.getUserName());
//                if (exists) {
//                    return new MapResult().error("用户名已存在");
//                } else {
//                    userService.saveUser(user);
//                    return new MapResult().ok("添加成功");
//                }
//            }
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            return new MapResult().error("保存失败");
//        }
//    }
//
//    @RequestMapping(value = "faq/user/list", method = RequestMethod.GET)
//    public String list() {
//        return USER_LIST;
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "faq/user/list/data", method = RequestMethod.GET)
//    public PageResult listData(HttpServletRequest request, int page, int limit) {
//        User loginUser = (User) request.getSession().getAttribute("loginUser");
//        return userService.queryByPage(page, limit, loginUser);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "faq/user/delete/{id}", method = RequestMethod.GET)
//    public MapResult delete(@PathVariable String id) {
//        try {
//            userService.deleteByID(id);
//        } catch (Exception e) {
//            log.info("desc: {}, params: {}, execption: {}", "删除失败", id, e);
//            return new MapResult().error();
//        }
//        return new MapResult().ok();
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "faq/user/pwd/reset/{id}", method = RequestMethod.GET)
//    public MapResult pwdReset(@PathVariable String id) {
//        try {
//            userService.pwdResetByID(id);
//        } catch (Exception e) {
//            log.info("desc: {}, params: {}, execption: {}", "重置密码失败", id, e);
//            return new MapResult().error();
//        }
//        return new MapResult().ok();
//    }

}
