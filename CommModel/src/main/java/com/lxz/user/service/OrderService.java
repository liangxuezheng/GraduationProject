package com.lxz.user.service;

import com.lxz.pojo.Order;

import java.util.List;

public interface OrderService {
    //生成订单
    public int addOrder(Order order);
    public Order getOrder_oid();
    //查看个人订单
    public List<Order> getOrderByUid(int user_uid);
    //修改订单
    public int updOrderByOid(Order order);
  /*  //订单详情
    public int addOrderDetail(OrderDetail orderDetail);
    //搜索
    public List<OrderDetail> getOrderDetail(int order_oid);*/
  //商家查看订单
    public List<Order> getOrderBySid(int sid);
}
