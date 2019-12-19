package com.lxz.mapper;

import com.lxz.pojo.Activity;
import com.lxz.pojo.Order;

import java.util.List;

public interface ActivityMapper {
    //新建活动
    public int addActivity(Activity activity);
    //搜索活动
    public List<Activity> queryActivity(Activity activity);
    //删除活动
    public int delActivity(Activity activity);
    //修改活动状态
    public int updActivity(Activity activity);

    //获得开启的活动
    public Activity getActivity();
}
