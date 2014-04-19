package cn.com.kc.blog.commondao.pagination.service;

import java.util.List;

/**
 * paging request object
 * 
 * @author kchen1
 * 
 */
public interface PageRequest {
/**
 * default page size.
 */
public static final Integer DEFAULT_PAGESIZE = 10;
/**
 * default page number;
 */
public static final Integer DEFAULT_PAGENUMBER = 1;


/**
 * get Filtercolumns list.
 * 
 * @return list
 */
List<String> getFilterColumns();

/**
 * sort columns list.
 * 
 * @return list
 */
List<String> getSortColumns();

/**
 * query page number
 * 
 * @return
 */
Integer getPageNumber();

/**
 * query page size.
 * 
 * @return
 */
Integer getPageSize();

/**
 * 
 * @param size
 */
void setPageNumber(final Integer size);

/**
 * 
 * @param size
 */
void setPageSize(final Integer size);
}
