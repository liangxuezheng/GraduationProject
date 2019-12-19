package com.lxz.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lxz.pojo.Activity;
import com.lxz.pojo.UserInfo;
import com.lxz.pojo.UserShop;
import com.lxz.user.service.ActivityService;
import com.lxz.user.service.GoodsService;
import com.lxz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class SysController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;
    @Autowired
    private ActivityService activityService;

    @RequestMapping("/queryMember")
    @ResponseBody
    public JSONObject queryMember(UserInfo userInfo,String p_pageSize,String p_pageIndex){
        JSONObject json = new JSONObject();
        Integer  pageSize = Integer.parseInt(p_pageSize);
        Integer pageIndex = Integer.parseInt(p_pageIndex);
        Page page = PageHelper.startPage(pageIndex, pageSize);

        System.out.println(userInfo.toString());
        List<UserInfo> list = this.userService.queryMember(userInfo);//获取信息
        json.put("rows", list);
        json.put("total", page.getTotal());
        return json;
    }

    @RequestMapping("/ShenHeShop")
    @ResponseBody
    public JSONObject ShenHeShop(UserShop userShop, String p_pageSize, String p_pageIndex){
        JSONObject json = new JSONObject();

        List<UserShop> list = this.userService.queryShop(userShop);//获取信息
        json.put("rows", list);
        return json;
    }

    /**
     * 审核idcard
     */
    @RequestMapping("/ShenHe_IdCard")
    @ResponseBody
    public JSONObject ShenHe_IdCard(UserInfo userInfo){
        System.out.println(userInfo);
        JSONObject json=new JSONObject();
        if(userService.shenhe_idcard(userInfo)){
            json.put("msg","success");
        }else {
            json.put("msg","fail");
        }
        return json;
    }
    /**
     * 审核店铺
     */
    @RequestMapping("/ShenHe_Shop")
    @ResponseBody
    public JSONObject ShenHe_Shop(UserShop userShop){
        JSONObject json=new JSONObject();
        if(userService.shenhe_shop(userShop)){
            json.put("msg","success");
        }else {
            json.put("msg","fail");
        }
        return json;
    }
    /**
     * 新建活动
     */
    @RequestMapping("/addActivity")
    @ResponseBody
    public JSONObject addActivity(Activity activity){
        System.out.println(activity);
        JSONObject json=new JSONObject();
        if(activityService.addActivity(activity)){
            json.put("msg","success");
        }else {
            json.put("msg","fail");
        }
        return json;
    }
    /**
     * 删除活动
     */
    @RequestMapping("/delActivity")
    @ResponseBody
    public JSONObject delActivity(Activity activity){
        JSONObject json=new JSONObject();
        if(activityService.delActivity(activity)){
            json.put("msg","success");
        }else {
            json.put("msg","fail");
        }
        return json;
    }
    /**
     * 修改活动
     */
    @RequestMapping("/updActivity")
    @ResponseBody
    public JSONObject updActivity(Activity activity){
        JSONObject json=new JSONObject();
        List<Activity> activities = activityService.queryActivity(null);
        if(activity.getState()==1){
            for(Activity a:activities){
                if (a.getState()==activity.getState()){
                    json.put("msg","chongfu_success");
                    return json;
                }
            }
        }
        if(activityService.updActivity(activity)){
            json.put("msg","success");
        }else {
            json.put("msg","fail");
        }
        return json;
    }
    /**
     * 查询活动
     */
    @RequestMapping("/queryActivity")
    @ResponseBody
    public JSONObject queryActivity(Activity activity, String p_pageSize, String p_pageIndex){
        JSONObject json = new JSONObject();
        Integer  pageSize = Integer.parseInt(p_pageSize);
        Integer pageIndex = Integer.parseInt(p_pageIndex);
        Page page = PageHelper.startPage(pageIndex, pageSize);
        /*activity.setCreat_time(start);
        activity.setEnd_time(end);*/
        List<Activity> list = this.activityService.queryActivity(activity);//获取信息
        json.put("rows", list);
        json.put("total", page.getTotal());
        return json;
    }



}
