package com.rjh.crm.workbench.service;

import com.rjh.crm.workbench.domain.Activity;

/**
 * @author rjh
 * @date 2021/1/12 17:42
 */
public interface ActivityService {

    boolean save(Activity activity);
    boolean saveTest(Activity activity);
}
