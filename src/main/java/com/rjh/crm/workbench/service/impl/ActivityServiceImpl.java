package com.rjh.crm.workbench.service.impl;

import com.rjh.crm.util.SqlSessionUtil;
import com.rjh.crm.vo.PaginationVO;
import com.rjh.crm.workbench.dao.ActivityDao;
import com.rjh.crm.workbench.domain.Activity;
import com.rjh.crm.workbench.service.ActivityService;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author rjh
 * @date 2021/1/12 17:43
 */
public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao = (ActivityDao) SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);

    public PaginationVO<Activity> pageList(Map<String, Object> map) {
        int total = activityDao.getTotalByCondition(map);
        List<Activity> dataList = activityDao.getActivityListByCondition(map);
        PaginationVO<Activity> vo = new PaginationVO<Activity>();
        vo.setDataList(dataList);
        vo.setTotal(total);
        return vo;
    }

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
