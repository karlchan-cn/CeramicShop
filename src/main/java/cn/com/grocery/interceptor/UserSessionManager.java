/**
 * 
 */
package cn.com.grocery.interceptor;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;

import cn.com.grocery.vo.AdminUserVO;

/**
 * @author karl
 *
 */
public class UserSessionManager {
	// CacheBuilder<Long, AdminUserVO> bu
//	private static final LoadingCache<Long, AdminUserVO> LOCAL_USER_INFO_CACHE = CacheBuilder.newBuilder().build();
	public AdminUserVO getAdminUser(){
//		LOCAL_USER_INFO_CACHE.get(arg0)
		return null;
	}
}
