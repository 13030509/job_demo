package com.demo.job.listener;

import com.demo.job.annotation.TaskNode;
import com.demo.job.singleton.SystemCache;
import com.demo.job.constants.CommonConstant;
import com.demo.job.entity.TaskInfo;
import com.demo.job.util.ClassUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: jiangjie
 * @date: 2019/12/24
 */
@Component
public class AppStaredListener implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //获取系统缓存
        Map<String, Object> cacheMap = SystemCache.getInstance().getCacheMap();
        //获取task包下的所有任务
        Set<Class<?>> taskSet = ClassUtil.getClasses("com.demo.job.task");
        List<TaskInfo> taskInfoList = new ArrayList<>();
        taskSet.stream().forEach(t -> {
            TaskNode taskNode = t.getAnnotation(TaskNode.class);
            if (taskNode != null) {
                TaskInfo taskInfo = new TaskInfo();
                taskInfo.setTaskClassName(t.getName());
                taskInfo.setTaskName(taskNode.taskName());
                taskInfoList.add(taskInfo);
            }
        });
        //将定时任务信息放入缓存中
        cacheMap.put(CommonConstant.TASK_CACHE_KEY, taskInfoList);

    }
}
