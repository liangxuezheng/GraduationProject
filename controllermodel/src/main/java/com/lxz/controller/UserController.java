package com.lxz.controller;

import com.lxz.pojo.ShipAddress;
import com.lxz.pojo.User;
import com.lxz.pojo.UserInfo;
import com.lxz.pojo.UserShop;
import com.lxz.tools.MD5Util;
import com.lxz.user.service.UserService;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;
    //判断是否登录
    @RequestMapping("/yn_dl")
    public User yn_dl(HttpSession session){
        User user =(User) session.getAttribute("user");
        return user;
    }
    //退出
    @RequestMapping("/tuchu")
    public String tuchu(HttpSession session){
        User user =(User) session.getAttribute("user");
        if(user!=null){
            session.removeAttribute("user" );
            return "退出成功";
        }else {
            return "您还未登录";
        }
    }
    //注册并加密
    @RequestMapping("/regist")
    public String regist(User user){
        System.out.println(user);
        //创建盐
        String salt="";
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<6;i++){
            char ch=(char)(int)(Math.random()*26+97);
            sb.append(ch);
        }
        salt=sb.toString();
        user.setUser_salt(salt);
        int count = userService.addUser(user);
        return "success";
    }
    //修改密码
    @RequestMapping("/xiugai_pass")
    public String xiugai_pass(User user,String info_email){
        System.out.println(user.toString());
        User user1 = userService.getUserByPhone(user.getUser_phone());
        user.setUser_uid(user1.getUser_uid());
        if(userService.getUserInfoByUid(user1.getUser_uid()).getInfo_email().equals(info_email)){
            int count = userService.updPass(user);
            if(count!=0){
                return "修改成功";
            }else {
                return "修改失败";
            }
        }else{
            return "注册手机号与注册邮箱不匹配";
        }

    }
    //登录
    @RequestMapping("/login")
    public User login(User user,HttpSession session) {
        System.out.println(user);
        User u = userService.getUser(user);
        System.out.println(u);
        if (u == null) {
            return u;
        } else {

            UserInfo userInfoByUid = userService.getUserInfoByUid(u.getUser_uid());
            if(userInfoByUid==null){
                userService.addUserInfo(u.getUser_uid());
            }
            if (u.getUser_flag() == 2) {
                session.setAttribute("user",u);
                System.out.println("*************"+session.getAttribute("user"));
                return u;
            } else{
                session.setAttribute("sysuser",u);
                return u;
            }
        }
    }
    //完善个人信息
    @RequestMapping("/per_info")
    public String per_info(UserInfo userInfo,HttpSession session){
        User user =(User) session.getAttribute("user");
        userInfo.setUser_uid(user.getUser_uid());
        int count = userService.addInfo(userInfo);
        if(count!=0){
            session.setAttribute("userInfo",userInfo);
            return "成功";
        }else {
            return "失败";
        }
    }
    //查看个人信息
    @RequestMapping("/per_info_success")
    public UserInfo user_info(HttpSession session){
        User user =(User) session.getAttribute("user");
        System.out.println("*************"+session.getAttribute("user").toString());
        UserInfo userInfo = userService.getUserInfoByUid(user.getUser_uid());
        if(userInfo!=null){
            return userInfo;
        }else {
            userInfo=new UserInfo();
            return userInfo;
        }
    }
    //邮箱认证
    @RequestMapping("/certified_mail")
    public String certified_mail(UserInfo userInfo,HttpSession session){
        System.out.println(userInfo);
        User user =(User) session.getAttribute("user");
        userInfo.setUser_uid(user.getUser_uid());
        int count = userService.updUserEmail(userInfo);
        if(count!=0){
            return "认证成功";
        }else {
            return "认证失败";
        }
    }
    //申请商铺
    @RequestMapping("/apply_shop")
    public String apply_shop(UserShop userShop,HttpSession session){
        User user =(User) session.getAttribute("user");
        userShop.setUser_uid(user.getUser_uid());
        int count = userService.addUserShop(userShop);
        if(count!=0){
            return "申请已提交，请等待审核";
        }else {
            return "申请失败";
        }
    }
    //搜索个人商铺
    @RequestMapping("/user_shop")
    public UserShop user_shop(HttpSession session){
        User user =(User) session.getAttribute("user");
        UserShop myshop = userService.getUserShopByUid(user.getUser_uid());
        if(myshop!=null){
            return myshop;
        }else {
            myshop=new UserShop();
            return myshop;
        }
    }
    //添加地址
    @RequestMapping("/tj_address")
    public String tj_address(ShipAddress shipAddress, HttpSession session){
        System.out.println(shipAddress);
        User user = (User) session.getAttribute("user");
        shipAddress.setUser_uid(user.getUser_uid());
        shipAddress.setAdd_flag(1);
        int count = userService.addAddress(shipAddress);
        if(count!=0){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }
    //搜索地址
    @RequestMapping("/my_address")
    public ShipAddress my_address(HttpSession session){
        User user = (User)session.getAttribute("user");
        ShipAddress my_address = userService.getAddressByUid(user.getUser_uid());
        return my_address;
    }
    //修改地址
    @RequestMapping("/update_address")
    public String update_address(ShipAddress shipAddress,HttpSession session){
        User user = (User)session.getAttribute("user");
        shipAddress.setUser_uid(user.getUser_uid());
        int count = userService.updAddreee(shipAddress);
        if(count!=0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }
}
