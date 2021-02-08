# 一、Eureka服务注册中心

​		每个微服务都会向注册中心去注册自己的地址及端口信息，注册中心维护着服务名称与服务实例的对应关系。每个微服务都会定时从注册中心获取服务列表，同时汇报自己的运行情况，这样当有的服务需要调用其他服务时，就可以从自己获取到的服务列表中获取实例地址进行调用，Eureka实现了这套服务注册与发现机制。

## 1.搭建Eureka服务端

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
