# thread-pool-demo
Spring Boot项目中使用线程池示例。使用ThreadPoolTaskExecutor类创建线程池，并注入到ioc容器中，全局可使用该线程池。

业务类[Input2OutputServiceImpl](https://github.com/AnizOoalGown/thread-pool-demo/blob/master/src/main/java/club/nazarick/threadpool/service/impl/Input2OutputServiceImpl.java)中有三个方法：

- singleProcess：处理单个业务
- multiProcess：批量处理业务
- asyncProcess：异步处理业务

测试类[ThreadPoolApplicationTests](https://github.com/AnizOoalGown/thread-pool-demo/blob/master/src/test/java/club/nazarick/threadpool/ThreadPoolApplicationTests.java)中调用了multiProcess、asyncProcess作为示例。