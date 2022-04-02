package com.freedougall.demo.example.graborders;


/**
 * @author liudandan
 */
public class JedisCommon {

    //@Resource
    //private JedisPool jedisPool;
    //
    //@Resource
    //private Jedis jedis;

    /**
     * 删除锁
     *
     * @param key
     * @param val
     * @return
     */
    public int delnx(String key, String val) {
        //try {
        //    jedis = jedisPool.getResource();
        //    if (jedis == null) {
        //        return 0;
        //    }
        //
        //    //if redis.call('get','orderkey')=='1111' then return redis.call('del','orderkey') else return 0 end
        //    StringBuilder sbScript = new StringBuilder();
        //    sbScript.append("if redis.call('get','").append(key).append("')").append("=='").append(val).append("'").
        //            append(" then ").
        //            append("    return redis.call('del','").append(key).append("')").
        //            append(" else ").
        //            append("    return 0").
        //            append(" end");
        //
        //    return Integer.valueOf(jedis.eval(sbScript.toString()).toString());
        //} catch (Exception ex) {
        //} finally {
        //    if (jedis != null) {
        //        jedis.close();
        //    }
        //}
        return 0;
    }

    /**
     * nx生成锁
     *
     * @param key
     * @param val
     * @return
     */
    public boolean setnx(String key, String val) {
        //try {
        //    jedis = jedisPool.getResource();
        //    if (jedis == null) {
        //        return false;
        //    }
        //    //NX：是否存在key，存在就不set成功
        //    //PX：key过期时间单位设置为毫秒（EX：单位秒）
        //    return jedis.set(key, val, "NX", "PX", 1000 * 60).equalsIgnoreCase("ok");
        //} catch (Exception ex) {
        //} finally {
        //    if (jedis != null) {
        //        jedis.close();
        //    }
        //}
        return false;
    }

}
