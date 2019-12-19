package com.lxz.mapper;

import com.lxz.pojo.ShipAddress;
import com.lxz.pojo.User;
import com.lxz.pojo.UserInfo;
import com.lxz.pojo.UserShop;

import java.util.List;

public interface UserMapper {
    //注册
    public int insertUser(User user);
    //修改密码
    public int updatePass(User user);
    //登录
    public User selUserByPhone(String user_phone);
    public User selUser(User user);
    //完善个人信息
    public int insertUserInfo(int user_uid);
    public int insertInfo(UserInfo userInfo);
    //搜索个人信息
    public UserInfo selUserInfoByUid(int user_uid);

    //邮箱认证
    public int updateUserEmail(UserInfo userInfo);

    //申请商铺
    public int insertUserShop(UserShop userShop);
    //搜索商铺信息
    public UserShop selUserShopByUid(int user_uid);
    //添加收货地址
    public int insertShipAddress(ShipAddress shipAddress);
    //搜索地址
    public ShipAddress selAddressByUid(int user_uid);
    //修改地址
    public int updShipAddress(ShipAddress shipAddress);

    List<UserInfo> queryMember(UserInfo userInfo);
    List<UserShop> queryShop(UserShop userShop);
    //审核身份证
    int shenhe_idcard(UserInfo userInfo);
    //审核店铺
    int shenhe_shop(UserShop userShop);
}
