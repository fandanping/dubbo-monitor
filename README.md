# dubbo-monitor

例子缘由：dubbo提供的监控页面不符合需求，需求自定义监控系统

此模块功能：获取各个provider的接口状态，包括：
    
# 数据库中各字段实例：

*   此接口所在的应用名: application
*   接口名  :service
*   此次调用的方法名 :method
*   调用精准时间：invoke-time
*   调用 日期 invoke-date
*   调用成功次数：success
*   调用失败次数: faulure
*   成功调用总耗时  ：elapsed
*   调用最大耗时  :max-elapsed
*   并发数： concurrent
*   最大并发数：  max-consurrent
*   调用此接口的消费者IP :cosumer
*   提供此接口的提供者IP :provider
*   此服务类型：提供者、消费者 :type


# 流程图： 

1. 定时收集数据

1).各个provider只要开启监控功能，dubboMonitor本身就会收集服务监控信息，定时一分钟发送
2).s-rdcp平台实现monitorService的collect（）即可获取数据，保存到队列中

2.数据按照格式存储到对象中

1).初始化起一个线程，不断扫描队列，将数据存入对象中

3.存储

1).将对象放入缓存中




