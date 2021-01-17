package com.rjh.crm.workbench.dao;

import com.rjh.crm.workbench.domain.Activity;

/**
 * @author rjh
 * @date 2021/1/12 17:40
 */
public interface ActivityDao {
    int save(Activity activity);
    int saveTest(Activity activity);
}
