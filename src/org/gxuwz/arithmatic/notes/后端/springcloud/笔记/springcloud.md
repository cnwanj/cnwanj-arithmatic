# 一、Eureka服务注册中心

​		每个微服务都会向注册中心去注册自己的地址及端口信息，注册中心维护着服务名称与服务实例的对应关系。每个微服务都会定时从注册中心获取服务列表，同时汇报自己的运行情况，这样当有的服务需要调用其他服务时，就可以从自己获取到的服务列表中获取实例地址进行调用，Eureka实现了这套服务注册与发现机制。

## 1.搭建Eureka注册中心

### 1.1搭建Eureka服务端

创建Maven父工程

![image-20210205161915546](upload/image-20210205161915546.png)

![image-20210205161949493](upload/image-20210205161949493.png)

![image-20210205162006540](upload/image-20210205162006540.png)

修改父工程的打包方式：

![image-20210205162105096](upload/image-20210205162105096.png)

在父工程中创建Eureka服务模块：

![image-20210205162253671](upload/image-20210205162253671.png)

创建SpringBoot项目

![image-20210205162333128](upload/image-20210205162333128.png)

![image-20210205162535891](upload/image-20210205162535891.png)

![image-20210205162614388](upload/image-20210205162614388.png)

创建完成后会发现pom.xml文件中已经有了eureka-server的依赖

![image-20210205162645666](upload/image-20210205162645666.png)

在启动类上添加@EnableEurekaServer注解来启用Euerka注册中心功能

```java
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
```

在eureka-server项目的配置文件application.yml中添加Eureka注册中心的配置，如下

```yml
# 运行端口
server:
  port: 8000

# 服务器名称
spring:
  application:
    name: eureka-server

# 主机地址
eureka:
  instance:
    hostname: localhost
  client:
    # 默认情况下该服务会作为客户端尝试注册自己，需要禁止客户端注册行为
    # 是否从注册中心获取服务（注册中心不需要开启）
    fetch-registry: false
    # 是否将当前服务注册到注册中心（注册中心不需要开启）
    register-with-eureka: false
```

直接启动SpringCloud应用并访问，如下：

![image-20210205163212728](upload/image-20210205163212728.png)

### 1.2搭建Eureka客户端

新建一个eureka-client模块，注意：不要选择任何依赖，创建成功后在pom.xml中添加如下依赖：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

在启动类上添加@EnableDiscoveryClient注解表明是一个Eureka客户端

```java
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

}
```

在配置文件application.yml中添加Eureka客户端的配置

```yml
# 指定运行端口
server:
  port: 8100

# 指定服务名称
spring:
  application:
    name: eureka-client

eureka:
  client:
    # 注册eureka到注册中心
    register-with-eureka: true
    # 获取注册实例列表
    fetch-registry: true
    # 注册中心地址
    service-url:
      defaultZone: http://localhost:8000/eureka
```

运行客户端并访问服务注册中心如下：

![image-20210205163658740](upload/image-20210205163658740.png)

### 1.3搭建Eureka注册中心集群

> 由于所有服务都会注册到注册中心去，服务之间的调用都是通过从注册中心获取的服务列表来调用，注册中心一旦宕机，所有服务调用都会出现问题。所以我们需要多个注册中心组成集群来提供服务，下面将搭建一个双节点的注册中心集群。

给eureka-sever添加配置文件application-replica1.yml配置第一个注册中心

```yml
server:
  port: 8001

spring:
  application:
    name: eureka-server

# 主机地址
eureka:
  instance:
    hostname: replica1
  client:
    fetch-registry: true
    register-with-eureka: true
    service-url:
      # 注册到另一个eureka注册中心
      defaultZone: http://replica2:8002/eureka/
```

给eureka-sever添加配置文件application-replica2.yml配置第二个注册中心

```yml
server:
  port: 8002

spring:
  application:
    name: eureka-server

# 主机地址
eureka:
  instance:
    hostname: replica2
  client:
    fetch-registry: true
    register-with-eureka: true
    service-url:
      # 注册到另一个eureka注册中心
      defaultZone: http://replica1:8001/eureka/
```

**这里我们通过两个注册中心互相注册，搭建了注册中心的双节点集群，由于defaultZone使用了域名，所以还需在本机的host文件中配置一下。**

修改本地host文件，用管理员权限进入C:\Windows\System32\drivers\etc，添加如下配置，然后保存

```
127.0.0.1 replica1
127.0.0.1 replica2
```

添加两个配置，从原来的eureka-server中复制，分别以application-replica1.yml和application-replica2.yml来启动eureka-server：

![image-20210205164311288](upload/image-20210205164311288.png)

![image-20210205164345412](upload/image-20210205164345412.png)

**注意：最后一个Active profiles是对应指yml配置文件名称application-replica1的后缀replica1。**

启动两个eureka-server，访问其中一个注册中心http://replica1:8001/发现另一个已经成为其备份，如下：

![image-20210205164738023](upload/image-20210205164738023.png)

修改Eureka-client，让其连接到集群

> 添加eureka-client的配置文件application-replica.yml，让其同时注册到两个注册中心。

```yml
server:
  port: 8101

# 指定服务器名称
spring:
  application:
    name: eureka-client


eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      # 同时注册到两个注册中心
      defaultZone: http://replica1:8001/eureka/, http://replica2:8002/eureka/
```

复制一份配置文件并修改如下：

![image-20210205164232850](upload/image-20210205164232850.png)

以该配置文件启动后访问任意一个注册中心节点都可以看到eureka-client:8101

![image-20210205164958182](upload/image-20210205164958182.png)

### 1.4给Eureka注册中心添加认证

创建一个eureka-security-server模块，并选中两个依赖如下：

![image-20210205193655464](upload/image-20210205193655464.png)

两个依赖如下所示：

```xml
<!--安全认证-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
<!--注册中心服务端-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

在启动类中添加@EnableEurekaServer注解，成为安全服务注册中心。

配置如下：

```yml
server:
  port: 8003

spring:
  application:
    name: eureka-server-security
  # 配置安全认证登录用户名密码
  security:
    user:
      name: root
      password: root

eureka:
  instance:
    hostname: localhost
  client:
    register-with-eureka: false
    fetch-registry: false
```

在根目录下创建安全配置文件：/config/WebSecurityConfig.class

> - 默认情况下添加SpringSecurity依赖的应用每个请求都要token认证。
>
> - 需要配置eureka/**路径不需要安全认证。

```java
/**
 * 默认情况下添加SpringSecurity依赖的应用每个请求都要token认证，
 * 需要配置eureka/**路径不需要安全认证
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
}
```

启动该模块，访问http://localhost:8003/如下：

![image-20210205205933448](upload/image-20210205205933448.png)

在客户端模块eureka-client中创建配置文件application-security.yml，配置如下：

```yml
# 指定运行端口
server:
  port: 8102

# 指定服务名称
spring:
  application:
    name: eureka-client

eureka:
  client:
    # 注册到Eureka的注册中心
    register-with-eureka: true
    # 获取注册实例列表
    fetch-registry: true
    service-url:
      # 配置安全注册中心地址：http://${username}:${password}@${hostname}:${port}/eureka/
      defaultZone: http://root:root@localhost:8003/eureka/
```

以application-security.yml配置运行eureka-client，可以在认证注册中心界面看到eureka-client已经成功注册：

![image-20210205205836049](upload/image-20210205205836049.png)

**涉及到的模块**

```
springcloud-learning
├── eureka-server -- eureka注册中心
├── eureka-server-security -- 带登录认证的eureka注册中心
└── eureka-client -- eureka客户端
```