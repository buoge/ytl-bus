package com.lty.redis;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisHelper {

	private static Logger logger = Logger.getLogger(RedisHelper.class);

	private static JedisPool jedisPool;
	
	public RedisHelper(JedisPool pool) {
		RedisHelper.jedisPool = pool;
	}
	
	public static String set(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String rtn = jedis.set(key, value);
			return rtn;
		} catch(Exception e) {
			logger.error("set方法报错：key=" + key + ",value=" + value, e);
			throw new RuntimeException("set方法报错。");
		} finally {
			if(jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}
	
	public static String set(byte[] key, byte[] value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String rtn = jedis.set(key, value);
			return rtn;
		} catch(Exception e) {
			logger.error("set方法报错：key=" + key + ",value=" + value, e);
			throw new RuntimeException("set方法报错。");
		} finally {
			if(jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}

	/** 根据key从redis删除相关值 */
	public static void del(String key) {
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			jedis.del(key);
		} catch(Exception e) {
			logger.error("del方法报错：key=" + key, e);
		} finally {
			if(jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}
	
	/** 可以设置过期时间的set方法 */
	public static String setWithExpireTime(String key, String value, int seconds) {
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			String rtn = jedis.set(key, value);
			jedis.expire(key, seconds);
			return rtn;
		} catch(Exception e) {
			logger.error("setWithExpireTime方法报错：key=" + key + ",value=" + value, e);
			throw new RuntimeException("get方法报错。");
		} finally {
			if(jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}
	
	/** 根据key从redis获取相关值 */
	public static String get(String key) {
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			String rtn = jedis.get(key);
			return rtn;
		} catch(Exception e) {
			logger.error("get方法报错：key=" + key, e);
			throw new RuntimeException("get方法报错。");
		} finally {
			if(jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}

	/**
	 * 根据key从redis获取相关值
	 * @param key byte[]
	 * @return byte[]
	 */
	public static byte[] get(byte[] key) {
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			byte[] rtn = jedis.get(key);
			return rtn;
		} catch(Exception e) {
			logger.error("get方法报错：key=" + key, e);
			throw new RuntimeException("get方法报错。");
		} finally {
			if(jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}

	/** 往redis中设置map对象 */
	public static String hmset(String key, Map<String, String> hash) {
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			String rtn = jedis.hmset(key, hash);
			return rtn;
		} catch(Exception e) {
			logger.error("hmset方法报错：key=" + key, e);
			throw new RuntimeException("hmset方法报错。");
		} finally {
			if(jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}
	
	/** 从redis中获取map对象 */
	public static Map<String, String> hgetall(String key) {
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			Map<String, String> rtn = jedis.hgetAll(key);
			return rtn;
		} catch(Exception e) {
			logger.error("hgetall方法报错：key=" + key, e);
			throw new RuntimeException("hgetall方法报错。");
		} finally {
			if(jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}
	
	/** 从redis中获取map中的某个字段 */
	public static String hget(String key, String field) {
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			String rtn = jedis.hget(key, field);
			return rtn;
		} catch(Exception e) {
			logger.error("hget方法报错：key=" + key, e);
			throw new RuntimeException("hget方法报错。");
		} finally {
			if(jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}
	
	/** 从redis中删除map中的某个字段 */
	public static void hdel(String key, String field) {
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			jedis.hdel(key, field);
		} catch(Exception e) {
			logger.error("hdel方法报错：key=" + key, e);
			throw new RuntimeException("hdel方法报错。");
		} finally {
			if(jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}

	/** 往redis中设置List对象 */
	public static void setList(String key, List<String> list) {
		if(list != null) {
			Jedis jedis = null;
			try{
				jedis = jedisPool.getResource();
				jedis.del(key);
				for (String str : list) {
					jedis.rpush(key, str);
				}
			} catch(Exception e) {
				logger.error("setList方法报错：key=" + key, e);
				throw new RuntimeException("setList方法报错。");
			} finally {
				if(jedis != null) {
					jedisPool.returnResource(jedis);
				}
			}
		}
	}
	
	/** 给特定key的值新增制定值，返回新增后该key的值 */
	public static long incrBy(String key, long value) {
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			long rtn = jedis.incrBy(key, value);
			return rtn;
		} catch(Exception e) {
			logger.error("incrBy方法报错：key=" + key + ",value=" + value, e);
			throw new RuntimeException("incrBy方法报错。");
		} finally {
			if(jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}

	/** 给特定key的值减少指定，返回修改后该key的值 */
	public static long decrBy(String key, long value) {
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			long rtn = jedis.decrBy(key, value);
			return rtn;
		} catch(Exception e) {
			logger.error("decrBy方法报错：key=" + key + ",value=" + value, e);
			throw new RuntimeException("decrBy方法报错。");
		} finally {
			if(jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}
	
	/** 判断key是否已经在缓存中存在 */
	public static boolean isKeyExistSetWithExpire(String key, int seconds) {
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			long rtn = jedis.setnx(key, "1");
			if(1 == rtn) {
				if(seconds > 0) {
					jedis.expire(key, seconds);
				}
			}
			return rtn == 0;
		} catch(Exception e) {
			logger.error("isKeyExistSetWithExpire方法报错：key=" + key + ",seconds=" + seconds, e);
			throw new RuntimeException("isKeyExistSetWithExpire方法报错。");
		} finally {
			if(jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}
	
	/** 设置过期时间的方法 */
	public static void expireByKey(String key, int seconds) {
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			if(seconds > 0) {
				jedis.expire(key, seconds);
			}
		} catch(Exception e) {
			logger.error("expireByKey方法报错：key=" + key + ",seconds=" + seconds, e);
			throw new RuntimeException("expireByKey方法报错。");
		} finally {
			if(jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}
	
	/** 判断key在缓存中是否存在  */
	public static boolean isKeyExist(String key) {
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			return jedis.exists(key);
		} catch(Exception e) {
			logger.error("isKeyExist方法报错：key=" + key, e);
			throw new RuntimeException("isKeyExist方法报错。");
		} finally {
			if(jedis != null) {
				jedisPool.returnResource(jedis);
			}
		}
	}

}