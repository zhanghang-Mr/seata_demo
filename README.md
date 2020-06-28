# seata_demo
eureka 集成 seata1.1版本

此demo是使用了springCloud 框架

  使用eureka作为注册中心
  
  使用feign 作为远程调用工具
  
  集成 seata1.1 测试
  
  1，eureka_server 注册中心
  
  2，consumer_demo 为客户端，调用方
  
  3，product3_demo 为客户端，被调用方，
  
  4，transaction_demo 为客户端，被调用方，
  
 seata1.1:
 
     新建一个数据库用来当作seata服务器的所需
     seata1.1版本没有自带seata所需的sql，可以使用seata0.9版本里面自带的sql，
     也可以自己在网上找
     
    注意事项：
    1, 修改conf包下file_conf文件：
        1，修改mode 为db类型
        2，修改db中mysql连接属性，
            注意：mysql8.0以上版本需要自己将mysql-connector-java-8.0.jar匹配的
                jar包下载下来放到seata下面的lib包下，将自带的mysql依赖包删除掉
   
     2，修改conf包下registry.conf文件：
        1，将type的属性值修改为eureka，我使用的是eureka作为注册中心
        2，修改eureka下的serviceUrl 为自己的注册地址
            application 的值与file.conf.example下面的vgroupMapping.my_test_tx_group值相同
        
     3，修改file.conf.example文件：
        1，修改store下面的mode的值为db
        2，根据自己的数据库信息修改连接信息
        3，service下面的vgroupMapping.my_test_tx_group = "default" 可以修改也可以不修改
            my_test_tx_group和default都是可以根据自己的意思修改的
          
    至此：先运行eureka_server,在运行seata包下bin下seata-server.bat，
            我这里使用的是windows版seata来作为测试
            
 启动成功后，创建三个eureka客户端：
    
        在客户端的每一个数据库中添加undo_log表 用来记录日志用于回滚
        undo_log表是seata官方提供
        将file.conf文件和registry。conf文件复制到每一个客户端的resource目录下
        
        注意事项：
        
            1，修改file.conf文件：
                1，修改vgroupMapping.my_test_tx_group = "default" 
                    my_test_tx_group根据自己的需求修改，
                    注意：跟seata中的值和其他客户端不同
                    default 应与seata中的值相同
                    例如：将my_test_tx_group 修改为 pro1_tx_group
                    
                 2，在application.yml配置文件中添加
                 spring: 
                    cloud:
                        alibaba:
                           seata:
                                tx-service-group: pro1_tx_group
                 注意事项：tx-service-group：的值应与file.conf文件中的相同
                 
 注意事项：
    在每一个客户端下面要使用 数据源代理                
 最后在调用方的controller方法上添加注解@GlobalTransactional(name = "fsp-order-create",rollbackFor = Exception.class)
 name值为自己设置， rollbackFor 为回滚。 
 最后客户端服务启动，进行测试，回滚成功，可以在手动抛出异常进行测试，在抛出异常之前
 打断点，查看数据库，seata日志记录         
   
 