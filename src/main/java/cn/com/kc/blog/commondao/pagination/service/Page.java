package cn.com.kc.blog.commondao.pagination.service;

import java.io.Serializable;
import java.util.List;

/**
 * page conten object
 * 
 * @author kchen1
 * 
 * @param <T>
 */
public interface Page<T extends Serializable> extends Iterable<T> {
/**
 * get page content list.
 * 
 * @return
 */
List<T> getContent();

void setContent(List<T> content);

/**
 * get current page number.
 * 
 * @return page number;
 */
int getPageNumber();

/**
 * get page content 's size
 * 
 * @return content size
 */
int getNumberOfElements();

/**
 * get current page's size
 * 
 * @return page's size
 */
int getPageSize();

/**
 * total number of elements
 * 
 * @return the sum of total number
 */
long getTotalNumberOfElements();

/**
 * get the sum of total pages
 * 
 * @return total page sum
 */
int getTotalPages();

/**
 * has next page
 * 
 * @return true or false
 */
boolean hasNextPage();

/**
 * has previous page
 * 
 * @return true or false
 */
boolean hasPreviousPage();

/**
 * is the first page
 * 
 * @return true or false
 */
boolean isFirstPage();

/**
 * is the last page
 * 
 * @return true or false
 */
boolean isLastPage();

}
