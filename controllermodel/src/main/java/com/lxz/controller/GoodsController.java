package com.lxz.controller;

import com.lxz.pojo.*;
import com.lxz.user.service.ActivityService;
import com.lxz.user.service.GoodsService;
import com.lxz.user.service.UserService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;
    @Autowired
    private ActivityService activityService;

    //上架商品
    @RequestMapping("/puton_good")
    public String puton_good(Goods goods,HttpSession session){
        System.out.println(goods.toString());
        User user =(User) session.getAttribute("user");
        UserShop shop = userService.getUserShopByUid(user.getUser_uid());
        goods.setShop_sid(shop.getShop_sid());
        int count=0;
        int cont = goodsService.addGoods(goods);
        if(cont!=0){
            return "上架成功";
        }else {
            return "上架失败";
        }
    }
    //个人商品
    @RequestMapping("/my_goods")
    public List<Goods> my_goods(HttpSession session){
        User user =(User) session.getAttribute("user");
        UserShop shop = userService.getUserShopByUid(user.getUser_uid());
        List<Goods> myGoods = goodsService.getMyGoods(shop.getShop_sid());
        return myGoods;
    }
    //所有商品
    @RequestMapping("/all_goods")
    public List<Goods> all_goods(Goods good){

        Activity activity = activityService.getActivity();
        List<Goods> goods = goodsService.getAllGoods(good);
        if(activity!=null){
            for(Goods g:goods){
                if(g.getGood_ynact().equals("是")){
                    double jiage=g.getGood_price()*activity.getAct_yhl();
                    DecimalFormat df = new DecimalFormat( "0.0"); //设置double类型小数点后位数格式
                    g.setGood_price(Double.valueOf(df.format(jiage)));
                }
            }
        }

        return goods;
    }
    //下架商品
    @RequestMapping("/under_good")
    public String under_good(String good_gid){
        Integer gid=Integer.valueOf(good_gid);
        int count = goodsService.delGoods(gid);
        if(count!=0){
            return "下架成功";
        }else {
            return "下架失败";
        }
    }
    //加入购物车
    @RequestMapping("/add_to_cart")
    public String add_to_cart(HttpSession session,String good_gid){
        User user =(User) session.getAttribute("user");
        Integer gid=Integer.valueOf(good_gid);
        Shipping shipping = new Shipping();
        if(user==null){
            return "加入失败，请先登录";
        }else {
            if(userService.getUserShopByUid(user.getUser_uid())!=null){
                if(goodsService.getGoodsByGid(gid).getShop_sid()==userService.getUserShopByUid(user.getUser_uid()).getShop_sid()){
                    return "您不能将自己的商品加入购物车！！";
                }else {
                    Activity activity = activityService.getActivity();
                    Goods goods = goodsService.getGoodsByGid(gid);
                    if(activity!=null){
                        if(goods.getGood_ynact().equals("是")){
                            shipping.setGood_price(goods.getGood_price()*activity.getAct_yhl());
                        }else {
                            shipping.setGood_price(goods.getGood_price());
                        }
                    }else {
                        shipping.setGood_price(goods.getGood_price());
                    }
                    shipping.setGood_gid(gid);
                    shipping.setUser_uid(user.getUser_uid());
                    shipping.setGood_name(goods.getGood_name());
                    shipping.setGood_jianjie(goods.getGood_info());
                    shipping.setGood_p1(goods.getGood_p1());
                    goodsService.addShip(shipping);
                    return "添加成功";
                }
            }else{
                Activity activity = activityService.getActivity();
                Goods goods = goodsService.getGoodsByGid(gid);
                if(activity!=null){
                    if(goods.getGood_ynact().equals("是")){
                        shipping.setGood_price(goods.getGood_price()*activity.getAct_yhl());
                    }else {
                        shipping.setGood_price(goods.getGood_price());
                    }
                }else {
                    shipping.setGood_price(goods.getGood_price());
                }
                shipping.setGood_gid(gid);
                shipping.setUser_uid(user.getUser_uid());
                shipping.setGood_name(goods.getGood_name());
                shipping.setGood_jianjie(goods.getGood_info());
                shipping.setGood_p1(goods.getGood_p1());
                goodsService.addShip(shipping);
                return "添加成功";
            }

        }
    }
    //搜索购物车
    @RequestMapping("/my_shipping")
    public List<Shipping> my_shipping(HttpSession session){
        User user =(User) session.getAttribute("user");
        List<Shipping> shippings = goodsService.selShipByUid(user.getUser_uid());
        return shippings;
    }
    //移除购物车
    @RequestMapping("/remove_ship")
    public String remove_ship(String good_gid){
        Integer gid=Integer.valueOf(good_gid);
        int count = goodsService.delShipBySid(gid);
        if(count!=0){
            return "移除成功";
        }else {
            return "移除失败";
        }
    }
}
