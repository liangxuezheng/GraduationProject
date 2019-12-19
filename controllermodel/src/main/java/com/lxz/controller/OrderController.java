package com.lxz.controller;

import com.lxz.pojo.*;
import com.lxz.user.service.ActivityService;
import com.lxz.user.service.GoodsService;
import com.lxz.user.service.OrderService;
import com.lxz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;
    @Autowired
    private ActivityService activityService;
    //生成订单
    //结算购物车，生成订单
    @RequestMapping("/generate_order")
    public String generate_order(HttpSession session,String[] checkID, String z_price){
        //先判断有没有收货地址
        User user =(User) session.getAttribute("user");
        ShipAddress address = userService.getAddressByUid(user.getUser_uid());
        int count=0;
        if(address==null){
            return "结算失败，请填写收货地址！!";
        }else {
            Order order = new Order();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (String gid : checkID) {
                Goods goods = goodsService.getGoodsByGid(Integer.valueOf(gid));
                Activity activity = activityService.getActivity();
                if(activity!=null){
                    if(goods.getGood_ynact().equals("是")){
                        order.setOrder_allpri(goods.getGood_price()*activity.getAct_yhl());
                    }else {
                        order.setOrder_allpri(goods.getGood_price());
                    }
                }else {
                    order.setOrder_allpri(goods.getGood_price());
                }

                int sid = goods.getShop_sid();
                order.setOrder_time(df.format(new Date()));
                order.setAdd_aid(address.getAdd_aid());
                order.setUser_uid(user.getUser_uid());

                order.setSh_sid(sid);
                order.setGood_name(goods.getGood_name());
                order.setGood_gid(Integer.valueOf(gid));
                order.setUpda_time(df.format(new Date()));
                count = orderService.addOrder(order);
               count+=count;
                goodsService.delShipBySid(Integer.valueOf(gid));
            }
            if(count!=0){
                return "结算成功";
            }else{
                return "结算失败";
            }
        }
           /* order.setOrder_time(df.format(new Date()));
            order.setAdd_aid(address.getAdd_aid());
            order.setUser_uid(user.getUser_uid());
            order.setOrder_allpri(allpri);
            int count = orderService.addOrder(order);
            if(count!=0){
                Order order_oid = orderService.getOrder_oid();
                for (String gid:checkID){
                    Integer good_gid=Integer.valueOf(gid);
                    OrderDetail orderDetail=new OrderDetail();
                    orderDetail.setOrder_oid(order_oid.getOrder_oid());
                    orderDetail.setGood_gid(good_gid);
                    orderService.addOrderDetail(orderDetail);
                    goodsService.delShipBySid(good_gid);
                }
                return "结算成功";
            }else{
                return "结算失败";
            }*/

    }
    //搜索订单
    @RequestMapping("/my_order")
    public List<Order> my_order(HttpSession session){
        User user =(User) session.getAttribute("user");
        List<Order> orders = orderService.getOrderByUid(user.getUser_uid());
        return orders;
    }
    //商家订单
    @RequestMapping("/chuli_order")
    public List<Order> chuli_order(HttpSession session){
        User user =(User) session.getAttribute("user");
        int sid=userService.getUserShopByUid(user.getUser_uid()).getShop_sid();
        List<Order> orders=orderService.getOrderBySid(sid);
        return orders;
    }
    //更改订单状态
    @RequestMapping("/update_order_state")
    public String update_order_state(Order order){
        System.out.println(order.toString());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setUpda_time(df.format(new Date()));
        int count = orderService.updOrderByOid(order);
        if(count!=0){
            return "订单状态更改成功";
        }else {
            return "订单状态更改失败";
        }
    }
}
