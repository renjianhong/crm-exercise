package com.rjh.crm.workbench.service;

import com.rjh.crm.util.DateTimeUtil;
import com.rjh.crm.util.ServiceFactory;
import com.rjh.crm.util.UUIDUtil;
import com.rjh.crm.workbench.domain.Activity;
import com.rjh.crm.workbench.service.impl.ActivityServiceImpl;
import org.junit.Test;

/**
 * @author rjh
 * @date 2021/1/12 20:52
 */
public class ActivityServiceTest {
    @Test
    public void testSaveTest() {
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        Activity a = new Activity();
        a.setId(UUIDUtil.getUUID());
        a.setName("希希洪");
        if (as.saveTest(a)) {
            System.out.println("success");
        }
    }

    @Test
    public void testSave() {
        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        Activity a = new Activity();
        a.setId(UUIDUtil.getUUID());
        a.setOwner("06f5fc056eac41558a964f96daa7f27c");
        a.setName("任建宏");
        a.setStartDate("2021-01-17");
        a.setEndDate("2021-02-18");
        a.setCost("123");
        a.setDescription("123");
        a.setCreateTime(DateTimeUtil.getSysTime());
        a.setCreateBy("人家红");
        if (as.save(a)) {
            System.out.println("success");
        }
    }
}
