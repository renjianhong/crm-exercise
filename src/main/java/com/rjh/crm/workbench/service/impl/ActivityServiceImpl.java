package com.rjh.crm.workbench.service.impl;

import com.rjh.crm.util.SqlSessionUtil;
import com.rjh.crm.workbench.dao.ActivityDao;
import com.rjh.crm.workbench.domain.Activity;
import com.rjh.crm.workbench.service.ActivityService;

/**
 * @author rjh
 * @date 2021/1/12 17:43
 */
public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao = (ActivityDao) SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);

    public boolean save(Activity activity) {
        boolean flag = false;
        int result = activityDao.save(activity);
        if (result > 0) {
            flag = true;
        }
        return flag;
    }

    public boolean saveTest(Activity activity) {
        boolean flag = false;
        int result = activityDao.saveTest(activity);
        if (result > 0) {
            flag = true;
        }
        return flag;
    }
}
