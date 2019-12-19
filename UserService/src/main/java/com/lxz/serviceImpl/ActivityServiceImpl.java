package com.lxz.serviceImpl;

import com.lxz.mapper.ActivityMapper;
import com.lxz.pojo.Activity;
import com.lxz.user.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public boolean addActivity(Activity activity) {
        if(activityMapper.addActivity(activity)>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public List<Activity> queryActivity(Activity activity) {
        return activityMapper.queryActivity(activity);
    }

    @Override
    public boolean delActivity(Activity activity) {
        if(activityMapper.delActivity(activity)>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean updActivity(Activity activity) {
        if(activityMapper.updActivity(activity)>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Activity getActivity() {
        return activityMapper.getActivity();
    }
}
