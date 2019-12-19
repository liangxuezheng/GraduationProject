package com.lxz.mapper;

import com.lxz.pojo.Order;

import java.util.List;

public interface OrderMapper {
    //生成订单
    public int insertOrder(Order order);
    public Order selorder_oid();
    //搜索订单
    public List<Order> selOrderByUid(int user_uid);
    //更改订单
    public int updateOrderByOid(Order order);
/*    //添加订单详情
    public int insertOrderDetail(OrderDetail orderDetail);
    //搜索
    public List<OrderDetail> selOrderDetail(int order_oid);*/
    public List<Order> getOrderBySid(int gid);
}
