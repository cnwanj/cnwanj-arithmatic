# 一、Eureka服务注册中心

​		每个微服务都会向注册中心去注册自己的地址及端口信息，注册中心维护着服务名称与服务实例的对应关系。每个微服务都会定时从注册中心获取服务列表，同时汇报自己的运行情况，这样当有的服务需要调用其他服务时，就可以从自己获取到的服务列表中获取实例地址进行调用，Eureka实现了这套服务注册与发现机制。

## 1.搭建Eureka服务端

>  创建Maven父工程

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

## 2.搭建Eureka客户端

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

## 3.搭建Eureka注册中心集群

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

==**注意：最后一个Active profiles是对应指yml配置文件名称application-replica1的后缀replica1。**==

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

## 4.给Eureka注册中心添加认证

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
springcloud-hello
├── eureka-server -- eureka注册中心
├── eureka-server-security -- 带登录认证的eureka注册中心
└── eureka-client -- eureka客户端
```

参考链接：https://thinkwon.blog.csdn.net/article/details/103726655

# 二、Ribbon服务消费者（负载均衡策略）

### Ribbon简介：

在微服务架构中，很多服务都会部署多个，其他服务去调用该服务的时候，如何保证负载均衡是个不得不去考虑的问题。负载均衡可以增加系统的可用性和扩展性，当我们使用RestTemplate来调用其他服务时，Ribbon可以很方便的实现负载均衡功能。

### RestTemplate的使用：

RestTemplate是一个HTTP客户端，使用它我们可以方便的调用HTTP接口，支持GET、POST、PUT、DELETE等方法。

### 负载均衡实现：

```
											   -> user-service（服务1）
客户端请求 -> ribbon-service（负载均衡请求分发）-> |
											   -> user-service（服务2）
```

每次请求都分别发放到不同的服务器。

## 1.创建user-service模块

user-service模块是给Ribbon-service模块提供服务的，目录如下：

![image-20210206172442972](upload/image-20210206172442972.png)



在启动类中添加@EnableDiscoveryClient注解。

pom.xml中添加相关依赖如下：

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

在application.yml进行配置：

```yml
server:
  port: 8201

spring:
  application:
    name: user-service

eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8000/eureka/
```

创建用户类User和统一返回前端的响应类Result。

用户类User.class：

```java
public class User {

    private Long id;
    private String username;
    private String password;

    public User() {
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    // 省略setter和getter方法
}
```

响应类Result.class：

```java
public class Result<T> {

    private T data;

    private String message;

    private int code;

    public Result() {
    }

    public Result(T data, String message, int code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public Result(String message, Integer code) {
        this(null, message, code);
    }

    public Result(T data) {
        this(data, "操作成功", 200);
    }

    // 省略setter和getter方法
    
}
```

添加UserController用于提供调用接口：

```java
@RestController
@RequestMapping("/user/")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("insert")
    public Result insert(@RequestBody User user) {
        userService.insert(user);
        return new Result("操作成功", 200);
    }

    @GetMapping("{id}")
    public Result<User> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        LOGGER.info("根据id获取的用户名称为：{}", user.getUsername());
        return new Result<User>(user);
    }

    @GetMapping("listUsersByIds")
    public Result<List<User>> listUsersByIds(@RequestParam List<Long> ids) {
        List<User> users = userService.listUsersByIds(ids);
        LOGGER.info("根据ids获取用户列表：{}", users);
        return new Result<>(users);
    }

    @GetMapping("getByUsername")
    public Result<User> getByUsername(@RequestParam String username) {
        User user = userService.getByUsername(username);
        return new Result<>(user);
    }

    @PostMapping("update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return new Result("操作成功", 200);
    }

    @PostMapping("delete/{id}")
    public Result delete(@PathVariable Long id) {
        userService.delete(id);
        return new Result("操作成功", 200);
    }
}
```

添加UserServiceImpl实现类如下：

```java
@Service
public class UserServiceImpl implements UserService {

    private List<User> userList;

    @Override
    public void insert(User user) {
        userList.add(user);
    }

    @Override
    public User getUser(Long id) {
        List<User> list = userList.stream().filter(u -> u.getId().equals(id)).collect(Collectors.toList());
        return !CollectionUtils.isEmpty(list) ? list.get(0) : null;
    }

    @Override
    public void update(User user) {
        userList.stream().filter(u -> u.getId().equals(user.getId())).forEach(u -> {
            u.setUsername(user.getUsername());
            u.setPassword(user.getPassword());
        });
    }

    @Override
    public void delete(Long id) {
        User user = getUser(id);
        if (user != null) userList.remove(user);
    }

    @Override
    public User getByUsername(String username) {
        List<User> list = userList.stream().filter(u -> u.getUsername().equals(username)).collect(Collectors.toList());
        return !CollectionUtils.isEmpty(list) ? list.get(0) : null;
    }

    @Override
    public List<User> listUsersByIds(List<Long> ids) {
        return userList.stream().filter(u -> ids.contains(u.getId())).collect(Collectors.toList());
    }

    @PostConstruct
    public void initData() {
        userList = new ArrayList<>();
        userList.add(new User(1L, "jourwon", "123456"));
        userList.add(new User(2L, "andy", "123456"));
        userList.add(new User(3L, "mark", "123456"));
    }
}
```

## 2.创建ribbon-service模块

>  ribbon-service模块请求调用user-service模块实现负载均衡。

目录如下：

![image-20210206205631093](upload/image-20210206205631093.png)

在启动类中添加@EnableDiscoveryClient注解。

pom.xml中添加相关依赖如下：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!--最新版本的eureka整合了ribbon，只要引入eureka依赖即可-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

<!--而之前的版本需要分别引入ribbon依赖如下-->
<!--<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>-->
```

在application.yml进行配置，如下：

```yml
server:
  port: 8301

spring:
  application:
    name: ribbon-service

eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8000/eureka/

service-url:
  user-service: http://user-service/
```

使用@LoadBalanced注解赋予RestTemplate负载均衡的能力，创建RibbonConfig配置类如下：

```java
@Configuration
public class RibbonConfig {

    @Bean
    @LoadBalanced // 开启RestTemplate负载均衡功能
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```

创建UserRibbonController类如下：

```java
@RestController
@RequestMapping("/user")
public class UserRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @GetMapping("/{id}")
    public Result getUser(@PathVariable Long id) {
        return restTemplate.getForObject(userServiceUrl + "user/{1}", Result.class, id);
    }

    @GetMapping("/getByUsername")
    public Result getByUsername(@RequestParam String username) {
        return restTemplate.getForObject(userServiceUrl + "user/getByUsername?username={1}", Result.class, username);
    }

    @GetMapping("/getEntityByUsername")
    public Result getEntityByUsername(@RequestParam String username) {
        ResponseEntity<Result> entity = restTemplate.getForEntity(userServiceUrl + "user/getEntityByUsername?username={1}", Result.class, username);
        if (entity.getStatusCode().is2xxSuccessful())
            return entity.getBody();
        else
            return new Result("操作失败", 500);
    }

    @PostMapping("/insert")
    public Result insert(@RequestParam User user) {
        return restTemplate.postForObject(userServiceUrl + "user/insert", user, Result.class);
    }

    @PostMapping("/update")
    public Result update(@RequestParam User user) {
        return restTemplate.postForObject(userServiceUrl + "user/update", user, Result.class);
    }
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable Long id) {
        return restTemplate.postForObject(userServiceUrl + "user/delete{1}", null, Result.class, id);
    }
}
```

启动eureka-server于8000端口；

启动user-service于8201端口；

启动另一个user-service为8202端口，可以通过修改IDEA中的SpringBoot的启动配置实现：

![image-20210206205827353](upload/image-20210206205827353.png)

启动ribbon-service于8301端口；

访问eureka-server服务注册中心http://localhost:8000显示如下，user-service两个端口和ribbon-service都注册放到了服务中心：

![image-20210206210334280](upload/image-20210206210334280.png)

回调数据如下：

![image-20210206210505182](upload/image-20210206210505182.png)

可以发现运行在8201和8202的user-service控制台交替打印如下信息：

user-service:8201：

![image-20210206210629038](upload/image-20210206210629038.png)

user-service:8202：

![image-20210206210712926](upload/image-20210206210712926.png)

### Ribbon的常用配置：

全局配置：

```yml
ribbon:
  ConnectTimeout: 1000 #服务请求连接超时时间（毫秒）
  ReadTimeout: 3000 #服务请求处理超时时间（毫秒）
  OkToRetryOnAllOperations: true #对超时请求启用重试机制
  MaxAutoRetriesNextServer: 1 #切换重试实例的最大个数
  MaxAutoRetries: 1 # 切换实例后重试最大次数
  NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule #修改负载均衡算法
```

指定服务进行配置：

>  就是针对挂载在ribbon下的节点进行配置，如下就是ribbon-service调用user-service时的单独配置。

```yml
user-service:
  ribbon:
    ConnectTimeout: 1000 #服务请求连接超时时间（毫秒）
    ReadTimeout: 3000 #服务请求处理超时时间（毫秒）
    OkToRetryOnAllOperations: true #对超时请求启用重试机制
    MaxAutoRetriesNextServer: 1 #切换重试实例的最大个数
    MaxAutoRetries: 1 # 切换实例后重试最大次数
    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule #修改负载均衡算法
```

### Ribbon的负载均衡策略：

负载均衡策略，就是当A服务调用B服务时，此时B服务有多个实例，这时A服务以何种方式来选择调用的B实例。ribbon可以选择以下几种负载均衡策略：

1. com.netflix.loadbalancer.RandomRule：从提供服务的实例中以随机的方式；

2. com.netflix.loadbalancer.RoundRobinRule：以线性轮询的方式，就是维护一个计数器，从提供服务的实例中按顺序选取，第一次选第一个，第二次选第二个，以此类推，到最后一个以后再从头来过；

3. com.netflix.loadbalancer.RetryRule：在RoundRobinRule的基础上添加重试机制，即在指定的重试时间内，反复使用线性轮询策略来选择可用实例；

4. com.netflix.loadbalancer.WeightedResponseTimeRule：对RoundRobinRule的扩展，响应速度越快的实例选择权重越大，越容易被选择；

5. com.netflix.loadbalancer.BestAvailableRule：选择并发较小的实例；

6. com.netflix.loadbalancer.AvailabilityFilteringRule：先过滤掉故障实例，再选择并发较小的实例；

7. com.netflix.loadbalancer.ZoneAwareLoadBalancer：采用双重过滤，同时过滤不是同一区域的实例和故障实例，选择并发较小的实例。

**涉及到的模块**

```
springcloud-hello
├── eureka-server -- eureka注册中心
├── user-service -- 提供User对象CRUD接口的服务
└── ribbon-service -- ribbon服务调用测试服务
```

参考链接：https://blog.csdn.net/ThinkWon/article/details/103729080

# 三、Hystrix断路器

### Hystrix 简介：

​		在微服务架构中，服务与服务之间通过远程调用的方式进行通信，一旦某个被调用的服务发生了故障，其依赖服务也会发生故障，此时就会发生故障的蔓延，最终导致系统瘫痪。Hystrix实现了断路器模式，当某个服务发生故障时，通过断路器的监控，给调用方返回一个错误响应，而不是长时间的等待，这样就不会使得调用方由于长时间得不到响应而占用线程，从而防止故障的蔓延。Hystrix具备服务降级、服务熔断、线程隔离、请求缓存、请求合并及服务监控等强大功能。

## 1.创建hystrix-service模块

在pom.xml中添加相关依赖

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<!--注册中心服务端-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<!--熔断服务-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```

在application.yml进行配置

```yml
server:
  port: 8401

spring:
  application:
    name: hystrix-service
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      defaultZone: http://localhost:8001/eureka/

# user-service的调用路径
service-url:
  user-service: http://user-service/
```

在启动类上添加@EnableCircuitBreaker来开启Hystrix的断路器功能，如下：

```java
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class HystrixServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixServiceApplication.class, args);
    }
}
```

创建UserHystrixController接口用于调用user-service服务。此处省略了创建用户类User和统一返回前端的响应类Result，RestTemplate配置，UserService接口的创建，具体的可以参考项目源码。

```java
@RestController
@RequestMapping("/user/")
public class UserHystrixController {

    @Autowired
    private UserService userService;

    /**
     * 服务熔断降级
     * @param id
     * @return
     */
    @GetMapping("testFallback/{id}")
    public Result testFallback(@PathVariable Long id) {
        return userService.getUser(id);
    }

    /**
     * 异常服务降级
     * @param id
     * @return
     */
    @GetMapping("testException/{id}")
    public Result testException(@PathVariable Long id) {
        return userService.getUserException(id);
    }

    /**
     * 参数设置
     * @param id
     * @return
     */
    @GetMapping("testCommand/{id}")
    public Result testCommand(@PathVariable Long id) {
        return userService.getUserCommand(id);
    }

    /**
     * 获取缓存中的user信息
     * @param id
     * @return
     */
    @GetMapping("testCache/{id}")
    public Result testCache(@PathVariable Long id) {
        userService.getUserCache(id);
        userService.getUserCache(id);
        userService.getUserCache(id);
        return new Result("操作成功", 200);
    }

    /**
     * 移除缓存
     * @param id
     * @return
     */
    @GetMapping("testRemoveCache/{id}")
    public Result testRemoveCache(@PathVariable Long id) {
        userService.getUserCache(id);
        userService.removeCache(id);
        userService.getUserCache(id);
        return new Result("操作成功", 200);
    }

    @GetMapping("testCollapser")
    public Result testCollapser() throws ExecutionException, InterruptedException {
        Future<User> future1 = userService.getUserFuture(1L);
        Future<User> future2 = userService.getUserFuture(2L);
        future1.get();
        future2.get();
        ThreadUtil.safeSleep(200);
        Future<User> future3 = userService.getUserFuture(3L);
        future3.get();
        return new Result("操作成功", 200);
    }
}
```

### （1）服务降级演示

在UserHystrixController中添加用于测试服务降级的接口：

```java
@GetMapping("/testFallback/{id}")
public Result testFallback(@PathVariable Long id) {
	return userService.getUser(id);
}
```

在UserService中添加调用方法与服务降级方法，方法上需要添加@HystrixCommand注解：

```java
@HystrixCommand(fallbackMethod = "fallbackMethod1")
public Result getUser(Long id) {
    return restTemplate.getForObject(userServiceUrl + "user/{1}", Result.class, id);
}

// 声明的参数需要包含controller的声明参数
public Result fallbackMethod1(@PathVariable Long id) {
    return new Result("服务调用失败", 500);
}
```

启动eureka-server、user-service、hystrix-service服务，访问：http://localhost:8001/，如下

![image-20210301215119134](upload/image-20210301215119134.png)

调用接口进行测试：http://localhost:8401/user/testFallback/1，如下：

![image-20210301215235254](upload/image-20210301215235254.png)

关闭user-service服务重新测试该接口，发现已经发生了服务降级：

![image-20210301215333302](upload/image-20210301215333302.png)

**@HystrixCommand详解**
**@HystrixCommand中的常用参数**
fallbackMethod：指定服务降级处理方法；
ignoreExceptions：忽略某些异常，不发生服务降级；
commandKey：命令名称，用于区分不同的命令；
groupKey：分组名称，Hystrix会根据不同的分组来统计命令的告警及仪表盘信息；
threadPoolKey：线程池名称，用于划分线程池。

### （2）设置命令、分组及线程池名称

在UserHystrixController中添加测试接口：

```java
@GetMapping("/testCommand/{id}")
public Result getUserCommand(@PathVariable Long id) {
	return userService.getUserCommand(id);
}
```

在UserService中添加方式实现功能：

```java
@HystrixCommand(fallbackMethod = "fallbackMethod1",
            commandKey = "getUserCommand",
            groupKey = "getUserGroup",
            threadPoolKey = "getUserThreadPool")
public Result getUserCommand(Long id) {
    return restTemplate.getForObject(userServiceUrl + "/user/{1}", Result.class, id);
}
```

### （3）使用ignoreExceptions忽略某些异常降级

在UserHystrixController中添加测试接口：

```java
@GetMapping("/testException/{id}")
public Result testException(@PathVariable Long id) {
	return userService.getUserException(id);
}
```

在UserService中添加实现方法，这里忽略了NullPointerException，当id为1时抛出IndexOutOfBoundsException，id为2时抛出NullPointerException：

```java
@HystrixCommand(fallbackMethod = "fallbackMethod2", ignoreExceptions = {NullPointerException.class})
public Result getUserException(Long id) {
	if (id == 1) {
		throw new IndexOutOfBoundsException();
	} else if (id == 2) {
		throw new NullPointerException();
	}

	return restTemplate.getForObject(userServiceUrl + "/user/{1}", Result.class, id);
}

public Result fallbackMethod2(@PathVariable Long id, Throwable e) {
	LOGGER.error("id {},throwable class:{}", id, e.getClass());
	return new Result("服务调用失败", 500);
}
```

调用接口进行测试：http://localhost:8401/user/testException/1，异常被处理导致服务降级如下：

![image-20210301220319317](upload/image-20210301220319317.png)

调用接口进行测试：http://localhost:8401/user/testException/2，异常未处理如下：

![image-20210301220337349](upload/image-20210301220337349.png)

### （4）Hystrix的请求缓存

> 当系统并发量越来越大时，我们需要使用缓存来优化系统，达到减轻并发请求线程数，提供响应速度的效果。

**相关注解**

- @CacheResult：开启缓存，默认所有参数作为缓存的key，cacheKeyMethod可以通过返回String类型的方法指定key；
- @CacheKey：指定缓存的key，可以指定参数或指定参数中的属性值为缓存key，cacheKeyMethod还可以通过返回String类型的方法指定；
- @CacheRemove：移除缓存，需要指定commandKey。

**测试使用缓存**
在UserHystrixController中添加使用缓存的测试接口，直接调用三次getUserCache方法：

```java
@GetMapping("/testCache/{id}")
public Result testCache(@PathVariable Long id) {
	userService.getUserCache(id);
	userService.getUserCache(id);
	userService.getUserCache(id);
	return new Result("操作成功", 200);
}
```

在UserService中添加具有缓存功能的getUserCache方法：

```java
// 设置缓存
@CacheResult(cacheKeyMethod = "getCacheKey")
@HystrixCommand(fallbackMethod = "fallbackMethod1", commandKey = "getUserCache")
public Result getUserCache(Long id) {
    LOGGER.info("getUserCache id:{}", id);
    return restTemplate.getForObject(userServiceUrl + "user/{1}", Result.class, id);
}

// 为缓存生成key的方法
public String getCacheKey(Long id) {
    return String.valueOf(id);
}
```

调用接口测试http://localhost:8401/user/testCache/1，这个接口中调用了三次getUserCache方法，但是只打印了一次日志，说明有两次走的是缓存：

![image-20210301221242013](upload/image-20210301221242013.png)

**测试移除缓存**

在UserHystrixController中添加移除缓存的测试接口，调用一次removeCache方法：

```java
@GetMapping("/testRemoveCache/{id}")
public Result testRemoveCache(@PathVariable Long id) {
	userService.getUserCache(id);
	userService.removeCache(id);
	userService.getUserCache(id);
	return new Result("操作成功", 200);
}
```

在UserService中添加具有移除缓存功能的removeCache方法：

```java
@HystrixCommand
@CacheRemove(commandKey = "getUserCache", cacheKeyMethod = "getCacheKey")
public Result removeCache(Long id) {
	LOGGER.info("removeCache id:{}", id);
	return restTemplate.postForObject(userServiceUrl + "/user/delete/{1}", null, Result.class, id);
}
```

调用接口测试http://localhost:8401/user/testRemoveCache/1，可以发现有两次查询都走的是接口：

![image-20210301221337910](upload/image-20210301221337910.png)

**缓存使用过程中的问题**

在缓存使用过程中，我们需要在每次使用缓存的请求前后对HystrixRequestContext进行初始化和关闭，否则会出现如下异常：

```java
java.lang.IllegalStateException: Request caching is not available. Maybe you need to initialize the HystrixRequestContext?
	at com.netflix.hystrix.HystrixRequestCache.get(HystrixRequestCache.java:104) ~[hystrix-core-1.5.18.jar:1.5.18]
	at com.netflix.hystrix.AbstractCommand$7.call(AbstractCommand.java:478) ~[hystrix-core-1.5.18.jar:1.5.18]
	at com.netflix.hystrix.AbstractCommand$7.call(AbstractCommand.java:454) ~[hystrix-core-1.5.18.jar:1.5.18]
```

这里我们通过使用过滤器，在每个请求前后初始化和关闭HystrixRequestContext来解决该问题：

```java
@Component
@WebFilter(urlPatterns = "/*", asyncSupported = true)
public class HystrixRequestContextFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();

        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            context.close();
        }
    }

}
```

### （5）请求合并

> 微服务系统中的服务间通信，需要通过远程调用来实现，随着调用次数越来越多，占用线程资源也会越来越多。Hystrix中提供了@HystrixCollapser用于合并请求，从而达到减少通信消耗及线程数量的效果。

**@HystrixCollapser的常用属性**
batchMethod：用于设置请求合并的方法；
collapserProperties：请求合并属性，用于控制实例属性，有很多；
timerDelayInMilliseconds：collapserProperties中的属性，用于控制每隔多少时间合并一次请求；
**功能演示**
在UserHystrixController中添加testCollapser方法，这里我们先进行两次服务调用，再间隔200ms以后进行第三次服务调用：

```java
@GetMapping("/testCollapser")
public Result testCollapser() throws ExecutionException, InterruptedException {
	Future<User> future1 = userService.getUserFuture(1L);
	Future<User> future2 = userService.getUserFuture(2L);
	future1.get();
	future2.get();
	ThreadUtil.safeSleep(200);
	Future<User> future3 = userService.getUserFuture(3L);
	future3.get();
	return new Result("操作成功", 200);
}
```

使用@HystrixCollapser实现请求合并，所有对getUserFuture的的多次调用都会转化为对getUserByIds的单次调用：

```java
@HystrixCollapser(batchMethod = "listUsersByIds",collapserProperties = {
		@HystrixProperty(name = "timerDelayInMilliseconds",value = "100")
})
public Future<User> getUserFuture(Long id) {
	return new AsyncResult<User>() {
		@Override
		public User invoke() {
			Result result = restTemplate.getForObject(userServiceUrl + "/user/{1}", Result.class, id);
			Map data = (Map) result.getData();
			User user = BeanUtil.mapToBean(data, User.class, true);
			LOGGER.info("getUserById username:{}",user.getUsername());
			return user;
		}
	};
}

@HystrixCommand
public List<User> listUsersByIds(List<Long> ids) {
	LOGGER.info("listUsersByIds:{}",ids);
	Result result = restTemplate.getForObject(userServiceUrl + "/user/listUsersByIds?ids={1}", Result.class, CollUtil.join(ids, ","));
	return (List<User>)result.getData();
}
```

> 注意：测试之前需要重启user-service服务，因为刚才测试请求缓存把数据删了一个，不然会报错

访问接口测试http://localhost:8401/user/testCollapser，由于我们设置了100毫秒进行一次请求合并，前两次被合并，最后一次自己单独合并了。

### （6）Hystrix的常用配置

**全局配置**

```yml
hystrix:
  command: #用于控制HystrixCommand的行为
    default:
      execution:
        isolation:
          strategy: THREAD #控制HystrixCommand的隔离策略，THREAD->线程池隔离策略(默认)，SEMAPHORE->信号量隔离策略
          thread:
            timeoutInMilliseconds: 1000 #配置HystrixCommand执行的超时时间，执行超过该时间会进行服务降级处理
            interruptOnTimeout: true #配置HystrixCommand执行超时的时候是否要中断
            interruptOnCancel: true #配置HystrixCommand执行被取消的时候是否要中断
          timeout:
            enabled: true #配置HystrixCommand的执行是否启用超时时间
          semaphore:
            maxConcurrentRequests: 10 #当使用信号量隔离策略时，用来控制并发量的大小，超过该并发量的请求会被拒绝
      fallback:
        enabled: true #用于控制是否启用服务降级
      circuitBreaker: #用于控制HystrixCircuitBreaker的行为
        enabled: true #用于控制断路器是否跟踪健康状况以及熔断请求
        requestVolumeThreshold: 20 #超过该请求数的请求会被拒绝
        forceOpen: false #强制打开断路器，拒绝所有请求
        forceClosed: false #强制关闭断路器，接收所有请求
      requestCache:
        enabled: true #用于控制是否开启请求缓存
  collapser: #用于控制HystrixCollapser的执行行为
    default:
      maxRequestsInBatch: 100 #控制一次合并请求合并的最大请求数
      timerDelayinMilliseconds: 10 #控制多少毫秒内的请求会被合并成一个
      requestCache:
        enabled: true #控制合并请求是否开启缓存
  threadpool: #用于控制HystrixCommand执行所在线程池的行为
    default:
      coreSize: 10 #线程池的核心线程数
      maximumSize: 10 #线程池的最大线程数，超过该线程数的请求会被拒绝
      maxQueueSize: -1 #用于设置线程池的最大队列大小，-1采用SynchronousQueue，其他正数采用LinkedBlockingQueue
      queueSizeRejectionThreshold: 5 #用于设置线程池队列的拒绝阀值，由于LinkedBlockingQueue不能动态改版大小，使用时需要用该参数来控制线程数
```

**实例配置**

>实例配置只需要将全局配置中的default换成与之对应的key即可。

```yml
hystrix:
  command:
    HystrixComandKey: #将default换成HystrixComrnandKey
      execution:
        isolation:
          strategy: THREAD
  collapser:
    HystrixCollapserKey: #将default换成HystrixCollapserKey
      maxRequestsInBatch: 100
  threadpool:
    HystrixThreadPoolKey: #将default换成HystrixThreadPoolKey
      coreSize: 10
```

配置文件中相关key的说明
- HystrixComandKey对应@HystrixCommand中的commandKey属性；
- HystrixCollapserKey对应@HystrixCollapser注解中的collapserKey属性；
- HystrixThreadPoolKey对应@HystrixCommand中的threadPoolKey属性。
使用到的模块

```
springcloud-learning
├── eureka-server -- eureka注册中心
├── user-service -- 提供User对象CRUD接口的服务
└── hystrix-service -- hystrix服务调用测试服务
```

参考链接：https://blog.csdn.net/ThinkWon/article/details/103732497

## 2.创建hystrix-dashboard模块



![image-20210302213655595](upload/image-20210302213655595.png)



![image-20210302214611909](upload/image-20210302214611909.png)

## 3.创建turbine-service模块

![image-20210302223246169](upload/image-20210302223246169.png)



![image-20210302223951012](upload/image-20210302223951012.png)



# 四、OpenFeign服务消费者



![image-20210304230029069](upload/image-20210304230029069.png)



![image-20210304230108762](upload/image-20210304230108762.png)



```
2021-03-04 22:58:32.809 DEBUG 18424 --- [-user-service-5] c.j.springcloud.service.UserService      : [UserService#getUser] ---> GET http://user-service/user/1 HTTP/1.1
2021-03-04 22:58:32.809 DEBUG 18424 --- [-user-service-5] c.j.springcloud.service.UserService      : [UserService#getUser] ---> END HTTP (0-byte body)
2021-03-04 22:58:32.812 DEBUG 18424 --- [-user-service-5] c.j.springcloud.service.UserService      : [UserService#getUser] <--- HTTP/1.1 200 (2ms)
2021-03-04 22:58:32.812 DEBUG 18424 --- [-user-service-5] c.j.springcloud.service.UserService      : [UserService#getUser] connection: keep-alive
2021-03-04 22:58:32.812 DEBUG 18424 --- [-user-service-5] c.j.springcloud.service.UserService      : [UserService#getUser] content-type: application/json
2021-03-04 22:58:32.812 DEBUG 18424 --- [-user-service-5] c.j.springcloud.service.UserService      : [UserService#getUser] date: Thu, 04 Mar 2021 14:58:32 GMT
2021-03-04 22:58:32.812 DEBUG 18424 --- [-user-service-5] c.j.springcloud.service.UserService      : [UserService#getUser] keep-alive: timeout=60
2021-03-04 22:58:32.812 DEBUG 18424 --- [-user-service-5] c.j.springcloud.service.UserService      : [UserService#getUser] transfer-encoding: chunked
2021-03-04 22:58:32.812 DEBUG 18424 --- [-user-service-5] c.j.springcloud.service.UserService      : [UserService#getUser] 
2021-03-04 22:58:32.812 DEBUG 18424 --- [-user-service-5] c.j.springcloud.service.UserService      : [UserService#getUser] {"data":{"id":1,"username":"jourwon","password":"123456"},"message":"操作成功","code":200}
2021-03-04 22:58:32.812 DEBUG 18424 --- [-user-service-5] c.j.springcloud.service.UserService      : [UserService#getUser] <--- END HTTP (94-byte body)
```

**feign常用配置**

```yml
feign:
  hystrix:
    enabled: true #在Feign中开启Hystrix
  compression:
    request:
      enabled: false #是否对请求进行GZIP压缩
      mime-types: text/xml,application/xml,application/json #指定压缩的请求数据类型
      min-request-size: 2048 #超过该大小的请求会被压缩
    response:
      enabled: false #是否对响应进行GZIP压缩
logging:
  level: #修改日志级别
    com.jourwon.springcloud.service: debug
```

**使用到的模块**

```
springcloud-learning
├── eureka-server -- eureka注册中心
├── user-service -- 提供User对象CRUD接口的服务
└── feign-service -- feign服务调用测试服务 
```

参考链接：[https://blog.csdn.net/ThinkWon/article/details/103735751](https://blog.csdn.net/ThinkWon/article/details/103735751)

