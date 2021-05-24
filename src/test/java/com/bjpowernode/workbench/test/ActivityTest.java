package com.bjpowernode.workbench.test;

import com.bjpowernode.crm.utils.ServiceFactory;
import com.bjpowernode.crm.utils.UUIDUtil;
import com.bjpowernode.crm.workbench.domain.Activity;
import com.bjpowernode.crm.workbench.service.ActivityService;
import com.bjpowernode.crm.workbench.service.impl.ActivityServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

/*
    junit
        单元测试
        是未来实际项目开发中，用来代替主方法main的
 */
public class ActivityTest {

    @Test
    public void testSave(){
        //System.out.println("123");

        Activity a=new Activity();
        a.setId(UUIDUtil.getUUID());
        a.setName("宣传推广会");

        ActivityService as= (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
        boolean flag=as.save(a);

        //断言式测试     测试结果和断定结果不一样就会报错
        Assert.assertEquals(flag,true);

        //System.out.println(flag);
    }

    /*@Test
    public void testUpdate(){
        String str=null;
        str.length();
        System.out.println("234");
    }*/

}
