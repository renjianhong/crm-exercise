package com.rjh.crm.workbench.service;

import com.rjh.crm.vo.PaginationVO;
import com.rjh.crm.workbench.domain.Activity;

import java.util.Map;

/**
 * @author rjh
 * @date 2021/1/12 17:42
 */
public interface ActivityService {

    boolean save(Activity activity);
    boolean saveTest(Activity activity);

    PaginationVO<Activity> pageList(Map<String, Object> map);
}
