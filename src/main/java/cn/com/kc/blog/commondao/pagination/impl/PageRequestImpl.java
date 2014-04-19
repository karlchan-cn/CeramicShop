package cn.com.kc.blog.commondao.pagination.impl;

import java.util.ArrayList;
import java.util.List;

import cn.com.kc.blog.commondao.pagination.service.PageRequest;

public class PageRequestImpl implements PageRequest {
/**
 * default constructor.
 */
public PageRequestImpl() {

}
/**
 * columns to be used to filter query.
 */
public List<String> filterColumns =  new ArrayList<String>();
/**
 * columns to be used to sort.
 */
public List<String> sortColumns =  new ArrayList<String>();
/**
 * constructor.
 * 
 * @param pageNumber
 *            number of pages to request
 * @param pageSize
 *            number of entity to show / page
 */
public PageRequestImpl(final int pageNumber, final int pageSize) {
	this.pageNumber = pageNumber;
	this.pageSize = pageSize;
}

/**
 * page number requested
 */
private Integer pageNumber;
/**
 * page size requested
 */
private Integer pageSize;

@Override
public Integer getPageNumber() {
	return pageNumber;
}

@Override
public Integer getPageSize() {
	// TODO Auto-generated method stub
	return pageSize;
}

/**
 * get requested page number
 * 
 * @param pageNumber
 *            page number
 */
public void setPageNumber(final Integer pageNumber) {
	this.pageNumber = pageNumber;
}

/**
 * get requested page size
 * 
 * @param pageSize
 *            page size
 */
public void setPageSize(final Integer pageSize) {
	this.pageSize = pageSize;
}

@Override
public List<String> getFilterColumns() {
	return this.filterColumns;
}

@Override
public List<String> getSortColumns() {
	return this.sortColumns;
}

}
