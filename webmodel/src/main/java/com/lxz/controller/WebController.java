package com.lxz.controller;

import com.lxz.pojo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WebController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/regist")
    public String regist_zh(){
        return "regist";
    }
    //修改密码
    @RequestMapping("/xiugai_pass")
    public String xiugai_pass(){
        return "xiugai_pass";
    }
    @RequestMapping("/member")
    public String member(){
        return "member";
    }
    //完善信息
    @RequestMapping("/perfect_information")
    public String perInfo(){
        return "per_info";
    }
    @RequestMapping("/per_info_success")
    public String perInfo_success(){return "per_info_success";}

    //邮箱认证
    @RequestMapping("/security_center")
    public String security_center(){
        return "security_center";
    }
    @RequestMapping("/certified_success")
    public String certified_success(){
        return "certified_success";
    }

    //申请商铺
    @RequestMapping("/apply_shop")
    public String apply_shop(){
        return "apply_shop";
    }
    @RequestMapping("/apply_shop_success")
    public String apply_shop_success(){
        return "apply_shop_success";
    }
    //进入商铺
    @RequestMapping("/my_shop")
    public String my_shop(){
        return "my_shop";
    }

    //上架商品
    @RequestMapping("/puton_good")
    public String puton_good(){
        return "puton_good";
    }
    //我的商品
    @RequestMapping("/my_good")
    public String my_good(){
        return "my_good";
    }
    //添加收货地址
    @RequestMapping("/tj_address")
    public String tj_address(){
        return "tj_address";
    }
    @RequestMapping("/my_address")
    public String my_address(){
        return "my_address";
    }
    //我的购物车
    @RequestMapping("/my_shipping")
    public String my_shipping(){
        return "my_shipping";
    }
    //我的订单
    @RequestMapping("/my_order")
    public String my_order(){
        return "my_order";
    }

    //商家订单
    @RequestMapping("/chuli_order")
    public String chuli_order(){
        return "chuli_order";
    }

    //后台管理
    @RequestMapping("/sys_login")
    public String sys_login(){
        return "sys_login";
    }

    @RequestMapping("/sys_index")
    public String sys_index(){
        return "sys_index";
    }

    @RequestMapping("/sys_member")
    public String sys_member(){
        return "sys_member";
    }
    @RequestMapping("/sys_idcard")
    public String sys_idcard(){
        return "sys_idcard";
    }
    @RequestMapping("/sys_shop")
    public String sys_shop(){
        return "sys_shop";
    }
    @RequestMapping("/sys_activity")
    public String sys_activity(){
        return "sys_activity";
    }
    @RequestMapping("/index1")
    public String index1(){
        return "index1";
    }

    @RequestMapping("/goedit")
    public String goedit() throws Exception {
        System.out.println("*****");
        return "sys_activity_edit";

    }

}
