package com.lxz.mapper;

import com.lxz.pojo.Goods;
import com.lxz.pojo.Shipping;

import java.util.List;

public interface GoodsMapper {
    //上架商品
    public int insertGood(Goods goods);
    //搜索个人商品
    public List<Goods> selGoodsBySid(int shop_sid);
    //搜索单个商品
    public Goods selGoodsByGid(int gid);
    //搜索所有商品
    public List<Goods> selAllGoods(Goods good);
    //下架商品
    public int deleteGood(int good_gid);
    //加入购物车
    public int insertShip(Shipping shipping);
    //搜索购物车
    public List<Shipping> selShipByUid(int user_uid);
    //清空购物车
    public int delShipBySid(int good_gid);

}
