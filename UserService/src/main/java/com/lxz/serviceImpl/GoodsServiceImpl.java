package com.lxz.serviceImpl;

import com.lxz.mapper.GoodsMapper;
import com.lxz.pojo.Goods;
import com.lxz.pojo.Shipping;
import com.lxz.user.service.GoodsService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.insertGood(goods);
    }
    //个人商品
    @Override
    public List<Goods> getMyGoods(int shop_sid) {
        return goodsMapper.selGoodsBySid(shop_sid);
    }
    //单个商品
    @Override
    public Goods getGoodsByGid(int gid) {
        return goodsMapper.selGoodsByGid(gid);
    }

    //所有商品
    @Override
    public List<Goods> getAllGoods(Goods good) {
        return goodsMapper.selAllGoods(good);
    }
    //下架商品
    @Override
    public int delGoods(int good_gid){
        return goodsMapper.deleteGood(good_gid);
    }
    //加入购物车
    @Override
    public int addShip(Shipping shipping) {
        return goodsMapper.insertShip(shipping);
    }
    //搜索
    @Override
    public List<Shipping> selShipByUid(int user_uid) {
        return goodsMapper.selShipByUid(user_uid);
    }
    //清空购物车
    @Override
    public int delShipBySid(int gid) {
        return goodsMapper.delShipBySid(gid);
    }



}
