# 了解 Redis

Redis 是一个开源的内存中的数据结构存储系统，它可以用作数据库、缓存和消息中间件。它支持多种类型的数据结构，如：

字符串（strings）、散列（hashes）、列表（lists）、集合（sets）、有序集合（sorted sets）。

Redis 内置了复制、LUA 脚本、LRU 驱动事件、事务和不同级别的磁盘持久化，并通过 Redis 哨兵 和 自动分区 提供高可用性。

## Redis 数据类型介绍

Redis 并不是简单的 key-value 存储，实际上是一个数据结构服务器，支持不同类型的值。也就是说，你不必仅仅把字符串当做键所指向的值。

## Redis 的值类型有：

- 二进制安全的字符串
- Lists：按插入顺序排序的字符串元素的集合，他们基本上都是链表（linked lists）
- Sets：不重复且无序的字符串元素的集合
- Sorted sets：类似 Sets ，但是每个字符串元素都关联到一个叫 score 浮动数值。里边的元素总是通过 score 进行排序，所以不同的是，它是可以检索的一系列元素。
- Hashes：由 field 和关联的 value 组成的 map。
- Bit arrays：通过特殊的命令，你可以将 String 值当做一系列 bits 处理：可以设置和清除单独的 bits，数出所有设为1 的bits 的数量，找到 最前的被设置为 1 或者0 的bit，等等。
- HyperLogLogs：这是被用于估计一个 set 中元素数量的概率性的数据结构。



## Redis 超时：数据在限定时间内存货（过期时间设定）

在 redis 中可以对 key 设置一个超时时间，当这个时间达到后会被删除。精度可以使用毫秒或者秒。

```
// 对指定keys设置过期时间为60s
expire key 60
// 在给key设置value的时候同时设置过期时间为60s
set key value ex 60
// 查询key还有多久过期
ttl key
```