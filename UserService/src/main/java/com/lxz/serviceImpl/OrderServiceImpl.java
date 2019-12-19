package com.lxz.serviceImpl;

import com.lxz.mapper.OrderMapper;
import com.lxz.pojo.Order;
import com.lxz.user.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    //生成订单
    @Override
    public int addOrder(Order order) {
        return orderMapper.insertOrder(order);
    }

    @Override
    public Order getOrder_oid() {
        return orderMapper.selorder_oid();
    }

    //搜索
    @Override
    public List<Order> getOrderByUid(int user_uid) {
        return orderMapper.selOrderByUid(user_uid);
    }
//更改
    @Override
    public int updOrderByOid(Order order) {
        return orderMapper.updateOrderByOid(order);
    }

    @Override
    public List<Order> getOrderBySid(int sid) {
        return orderMapper.getOrderBySid(sid);
    }
  /*  //生成订单详情
    @Override
    public int addOrderDetail(OrderDetail orderDetail) {
        return orderMapper.insertOrderDetail(orderDetail);
    }
    //搜索订单详情
    @Override
    public List<OrderDetail> getOrderDetail(int order_oid) {
        return orderMapper.selOrderDetail(order_oid);
    }*/
}
