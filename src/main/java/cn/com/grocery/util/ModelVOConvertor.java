/**
 * 
 */
package cn.com.grocery.util;

import cn.com.grocery.domain.GroceryEntity;
import cn.com.grocery.vo.GroceryEntityVO;

/**
 * @author karl
 *
 */
public final class ModelVOConvertor {

	public static void toGroceryEntityVO(GroceryEntity src, GroceryEntityVO des) {
		des.setId(src.getId());
		des.setIcon(src.getIcon());
		des.setBrief(src.getBrief());
		des.setDescription(des.getDescription());
		des.setName(src.getName());
		des.setThumnail(src.getThumnail());
	}

	public static void toGroceryEntity(GroceryEntityVO src, GroceryEntity des) {
		des.setId(src.getId());
		des.setIcon(src.getIcon());
		des.setBrief(src.getBrief());
		des.setDescription(des.getDescription());
		des.setName(src.getName());
		des.setThumnail(src.getThumnail());
	}
}
