# 1、redis数据类型用过哪些？
参考链接：https://blog.csdn.net/ThinkWon/article/details/101521724

String（字符串）、Hash（哈希）、List（列表）、Set（集合）、Zset（sort set有序集合）。

### String（字符串）
常用命令:  set,get,decr,incr,mget 等。
String类型时二进制安全的，也就是说String包含了任何类型，如int、序列化对象、jpg等。最大存储为512MB。

### Hash（哈希）
常用命令：hget,hset,hgetall 等。
Hash是键值对（key-value）集合，特别适合存储对象。

### List（列表）
常用命令：lpush（添加头部）,rpush（添加尾部）,lpop,rpop,lrange key start stop（获取指定范围的元素）等。
List是简单的字符串列表，按照插入的顺序排序，可以添加一个元素到列表头部（lpush）或尾部（rpush）。
### Set（集合）
常用命令：sadd,spop,smembers,sunion 等。
Set是String类型的无序集合，通过哈希表实现，其添加、删除、查找复杂度都是O(1)。
### Zset（sort set有序集合）
常用命令：zadd,zrange,zrem,zcard等。
Zset是String类型有序集合，允许键key重复，但不允许成员value重复（后面添加的成员元素与集合中的相同，则替换集合中的元素）。每个元素都会关联一个double类型的score，通过score来为成员的元素从小到大排序。

# 2、Redis的优缺点

### 优点：

- 读写性能优异， Redis能读的速度是110000次/s，写的速度是81000次/s。
- 数据结构丰富，除了支持string类型的value外还支持hash、set、zset、list等数据结构。
- 支持数据持久化，支持AOF和RDB两种持久化方式。
- 支持事务，Redis的所有操作都是原子性的，同时Redis还支持对几个操作合并后的原子性执行。
- 支持主从复制，主机会自动将数据同步到从机，可以进行读写分离。

### 缺点：

- 数据库容量受到物理内存的限制，不能用作海量数据的高性能读写。
- Redis 不具备自动容错和恢复功能，主机从机的宕机都会导致前端部分读写请求失败。
- 主机宕机，宕机前有部分数据未能及时同步到从机。
- Redis 较难支持在线扩容，在集群容量达到上限时在线扩容会变得很复杂。

# 3、Setnx实现分布式锁

参考链接：https://www.jianshu.com/p/6b8b4b04f2aa