package com.rjh.crm.workbench.service.impl;

import com.rjh.crm.util.SqlSessionUtil;
import com.rjh.crm.workbench.dao.ActivityDao;
import com.rjh.crm.workbench.service.ActivityService;

/**
 * @author rjh
 * @date 2021/1/12 17:43
 */
public class ActivityServiceImpl implements ActivityService {
    private ActivityDao activityDao = (ActivityDao) SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);

    
}
