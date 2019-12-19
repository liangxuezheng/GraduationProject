package com.lxz.user.service;

import com.lxz.pojo.ShipAddress;
import com.lxz.pojo.User;
import com.lxz.pojo.UserInfo;
import com.lxz.pojo.UserShop;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    //注册
    public int addUser(User user);
    //修改密码
    public int updPass(User user);
    //登录
    public User getUserByPhone(String user_phone);
    public User getUser(User user);
    //完善个人信息
    public int addUserInfo(int user_uid);
    public int addInfo(UserInfo userInfo);
    //搜索个人信息
    public UserInfo getUserInfoByUid(int user_uid);
    //邮箱认证
    public int updUserEmail(UserInfo userInfo);
    //申请店铺
    public int addUserShop(UserShop userShop);
    //搜索个人商铺
    public UserShop getUserShopByUid(int user_uid);
    //添加收货地址
    public int addAddress(ShipAddress shipAddress);
    //搜索收货地址
    public ShipAddress getAddressByUid(int user_uid);
    //修改地址
    public int updAddreee(ShipAddress shipAddress);

    List<UserInfo> queryMember(UserInfo userInfo);

    List<UserShop> queryShop(UserShop userShop);

    boolean shenhe_idcard(UserInfo userInfo);
    boolean shenhe_shop(UserShop userShop);
}
