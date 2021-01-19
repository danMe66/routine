# mysql查询优化

1. 对查询进行优化，应尽量避免全局扫描，首先应考虑在 where 及 order by 涉及的列上建立索引

2. 应尽量避免在 where 子句中对有索引的字段进行 null 值判断，否则将导致引擎放弃使用索引而进行全表扫描，如：

   ```sql
   SELECT id FROM table where num is null
   ```

   可以在 num 上设置默认值，确保表中 num 列没有 null 值，然后这样查询：

   ```sql
   SELECT id FROM table where num = 0
   ```

3. 应尽量避免在 where 子句中使用 != 或 <> 操作符，否则将引擎放弃使用索引而进行全表扫描。

4. 应尽量避免在 where 子句中使用 or 来连接条件，否则将导致引擎放弃使用索引而进行全表扫描，如：

   ```sql
   SELECT id FROM table WHERE num = 10 or num = 20
   ```

   可以这样查询

   ```mysql
   SELECT id FROM table where num = 10 UNION ALL SELECT id FROM table WHERE num = 20
   ```

5. in 和 not in 也要慎用，否则会导致全表扫描，如：

   ```mysql
   SELECT id FROM table WHERE NUM in (1,2,3)
   ```

   对于连续的值，能用 between 就不要用 in ：

   ```mysql
   SELECT id FROM table where num BETWEEN 1 AND 3
   ```

6. 对于下面的查询也会导致全表扫描：

   ```mysql
   SELECT id FROM table WHERE name LIKE '%abc%'
   ```

7. 应尽量避免在 where 子句中对字段进行函数操作，这将导致引擎放弃索引而进行全表扫描，如：

   ```mysql
   SELECT id FROM table substring(name,1,3) = 'abc' -- 释义：name 以abc开头的id
   ```

   应改为：

   ```mysql
   SELECT id FROM table WHERE name LIKE 'abc%'
   ```

8. 应尽量避免在 where 子句中进行表达式操作，这将导致引擎放弃使用索引而进行全表扫描，如：

   ```mysql
   SELECT id FROM table WHERE num/2 = 100
   ```

9. 不要在 where 子句中的 "=" 左边进行函数、算法运算或其他表达式运算，否则系统将可能无法正确使用索引

10. 在使用索引字段作为条件时，如果该索引是符合索引，那么必须使用到该索引的第一个字段作为条件时才能保证系统使用该索引，否则该索引将不会被使用，并且应尽可能的让字段顺序与索引顺序相一致。

11. 很多时候用 exists 代替 in 是一个好的选择：

    ```mysql
    SELECT num FROM a WHERE num in(SELECT num FROM b)
    ```

    用下面的语句替换：

    ```mysql
    SELECT num FROM a WHERE EXISTS(SELECT 1 FROM b WHERE num = a.num)
    ```

12. 并不是所有索引对查询都有效，SQL 是根据表中数据来进行查询优化的，当索引列有大量数据重复时，SQL 查询可能不会去利用索引，如一表中有字段 sex，type 几乎各占一半，那么即使在 sex 上建了索引也对查询效率起不了作用。

13. 索引并不是越多越好，索引固然可以提高相应的 SELECT 的效率，但同时也降低了 insert 以及 update 的效率

    因为 insert 或者 update 的时候有可能会重建索引，所以怎样建索引需要慎重考虑，视具体情况而定。一个表的索引数量最好不要超过6个，若太多则应考虑一下不常使用到的列上建的索引是否有必要。

14. 尽量使用数字型字段，若只含数值信息的字段尽量不要设计为字符型，这会降低查询和连接的性能，并会增加存储开销。这是因为引擎在处理查询和连接时会逐个比较字符串中每一个字符，而对于数字型而言只需要比较一次即可。

15. 尽可能的使用 varchar 代替 char ,因为首先 边长字段存储空间小，可以节省存储空间。其次对于查询来说，在一个相对较小的字段内搜索效率显然要高些。

16. 任何地方都不要使用 `SELECT * FROM table` ,用具体的子弹列表 代替 * ，不要返回用不到的任何字段。

17. 避免频繁创建和删除临时表，以减少系统表资源的消耗。

18. 临时表并不是不可以使用，适当的使用它们可以提高业务速度和难度。但是，对于一次性事件，最好使用导出表。

19. 在新建临时表时，如果一次性插入数据量很大，那么可以使用 `SELECT INTO` 代替 `CREATE TABLE`, 避免造成大量 log，以提高速度；如果数据量不大，为了缓和系统表的资源，应先 `CREATE TABLE`, 然后 `INSERT`。

20. 如果用到了临时表，在存储过程的最后务必将所有的临时表显式删除，先 `truncate table` ，然后 `drop table`, 这样可以避免系统表的较长时间锁定。

21. 尽量避免使用游标，因为游标的效率极差，如果游标操作的数据超过1万行，那么就应该考虑改写。

22. 尽量避免大事务操作，提高系统并发能力。

23. 尽量避免向客户端返回大数据量，若数据量过大，应该考虑相应需求是否合理。





 **<u>[<<点击返回主页](https://liudandandear.gitee.io)</u>**