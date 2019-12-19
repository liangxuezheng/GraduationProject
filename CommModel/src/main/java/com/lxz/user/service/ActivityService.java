package com.lxz.user.service;

import com.lxz.pojo.Activity;
import com.lxz.pojo.Order;

import java.util.List;

public interface ActivityService {
    //新建活动
    public boolean addActivity(Activity activity);
    //搜索活动
    public List<Activity> queryActivity(Activity activity);
    //删除活动
    public boolean delActivity(Activity activity);
    //修改活动状态
    public boolean updActivity(Activity activity);

    public Activity getActivity();
}
