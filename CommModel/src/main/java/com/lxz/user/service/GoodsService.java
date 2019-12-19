package com.lxz.user.service;

import com.lxz.pojo.Goods;
import com.lxz.pojo.Shipping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface GoodsService {
    //上架商品
    public int addGoods(Goods goods);
    //搜索个人商品
    public List<Goods> getMyGoods(int shop_sid);
    //搜索单个商品
    public Goods getGoodsByGid(int gid);
    //搜索所有商品
    public List<Goods> getAllGoods(Goods good);
    //下架商品
    public int delGoods(int good_gid);
    //加入购物车
    public int addShip(Shipping shipping);
    //搜索购物车
    public List<Shipping> selShipByUid(int user_uid);
    //清空购物车
    public int delShipBySid(int sh_sid);
}
