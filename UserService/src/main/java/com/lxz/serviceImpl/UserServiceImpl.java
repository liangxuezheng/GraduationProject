package com.lxz.serviceImpl;

import com.lxz.mapper.UserMapper;
import com.lxz.pojo.ShipAddress;
import com.lxz.pojo.User;
import com.lxz.pojo.UserInfo;
import com.lxz.pojo.UserShop;
import com.lxz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    //注册
    @Override
    public int addUser(User user) {
        int count = userMapper.insertUser(user);
        return count;
    }
    //修改密码
    @Override
    public int updPass(User user){
        return userMapper.updatePass(user);
    }
    //登录
    @Override
    public User getUserByPhone(String user_phone) {
        return userMapper.selUserByPhone(user_phone);
    }

    @Override
    public User getUser(User user) {
        return userMapper.selUser(user);
    }

    //完善个人信息
    @Override
    public int addUserInfo(int user_uid) {
        return userMapper.insertUserInfo(user_uid);
    }
    @Override
    public int addInfo(UserInfo userInfo){
        return userMapper.insertInfo(userInfo);
    }
    //搜索个人信息
    @Override
    public UserInfo getUserInfoByUid(int user_uid) {
        return userMapper.selUserInfoByUid(user_uid);
    }
    //邮箱认证
    @Override
    public int updUserEmail(UserInfo userInfo) {
        return userMapper.updateUserEmail(userInfo);
    }
    //申请商铺
    @Override
    public int addUserShop(UserShop userShop) {
        return userMapper.insertUserShop(userShop);
    }
    //搜索个人商铺
    @Override
    public UserShop getUserShopByUid(int user_uid) {
        return userMapper.selUserShopByUid(user_uid);
    }

    //添加地址
    @Override
    public int addAddress(ShipAddress shipAddress) {
        return userMapper.insertShipAddress(shipAddress);
    }
    //搜索地址
    @Override
    public ShipAddress getAddressByUid(int user_uid) {
        return userMapper.selAddressByUid(user_uid);
    }
    //修改地址
    @Override
    public int updAddreee(ShipAddress shipAddress) {
        return userMapper.updShipAddress(shipAddress);
    }

    //搜索所有会员信息
    @Override
    public List<UserInfo> queryMember(UserInfo userInfo){
        return userMapper.queryMember(userInfo);
    }

    @Override
    public List<UserShop> queryShop(UserShop userShop) {
        return userMapper.queryShop(userShop);
    }

    @Override
    public boolean shenhe_idcard(UserInfo userInfo) {
        if(userMapper.shenhe_idcard(userInfo)>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean shenhe_shop(UserShop userShop) {
        if(userMapper.shenhe_shop(userShop)>0){
            return true;
        }else {
            return false;
        }
    }
}
