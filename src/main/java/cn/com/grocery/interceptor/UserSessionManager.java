/**
 * 
 */
package cn.com.grocery.interceptor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import cn.com.grocery.common.constants.RedisKeys;
import cn.com.grocery.vo.AdminUserVO;
import redis.clients.jedis.Jedis;

/**
 * @author karl
 *
 */
@Service
public class UserSessionManager {
	private static final Logger ILOG = LoggerFactory.getLogger(UserSessionManager.class);
	@Autowired(required = false)
	private Jedis jedis;

	// CacheBuilder<Long, AdminUserVO> bu
	private LoadingCache<Long, AdminUserVO> LOCAL_USER_INFO_CACHE = CacheBuilder.newBuilder().maximumSize(10000)
			.expireAfterAccess(15l, TimeUnit.MINUTES).build(new CacheLoader<Long, AdminUserVO>() {
				@Override
				public AdminUserVO load(Long userId) throws Exception {
					String jsonInfo = jedis.get(String.format(RedisKeys.CONST_LOGIN_USER_INFO_KEY, userId));
					if (StringUtils.isNoneBlank(jsonInfo)) {
						return JSON.parseObject(jsonInfo, AdminUserVO.class);
					}
					return null;
				}

			});

	// get cached user info.
	public AdminUserVO getAdminUser(Long userId) {

		try {
			return LOCAL_USER_INFO_CACHE.get(userId);
		} catch (ExecutionException e) {
			ILOG.error("get user info got error:" + e.getMessage(), e);
		}
		return null;
	}
}
