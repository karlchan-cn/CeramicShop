package cn.com.kc.blog.commondao.pagination.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import cn.com.kc.blog.commondao.pagination.service.Page;

/**
 * 
 * @author kchen1
 * 
 */
public class PageImpl<T extends Serializable> implements Page<T> {
@Override
public void setContent(List<T> content) {
	this.content = content;
}

/**
 * page elementss
 */

private List<T> content;
/**
 * total numbers of all elements
 */
private long totalNumberOfElements;
/**
 * page size;
 */
private int pageSize;
/**
 * page number;
 */
private int pageNumber;
/**
 * total number of pages
 */
private int totalPages;

@Override
public Iterator<T> iterator() {
	return content.iterator();
}

@Override
public List<T> getContent() {
	return content;
}

public PageImpl(final List<T> content, final Long totalNumberOfElements, final int pageSize,
				final int pageNumber) {
	this.content = content;
	this.totalNumberOfElements = totalNumberOfElements;
	this.pageNumber = pageNumber;
	this.pageSize = pageSize;

}

@Override
public int getPageNumber() {
	return this.pageNumber;
}

@Override
public int getNumberOfElements() {
	return content.size();
}

@Override
public int getPageSize() {
	return this.pageSize;
}

@Override
public long getTotalNumberOfElements() {
	return totalNumberOfElements;
}

@Override
public int getTotalPages() {
	if (totalNumberOfElements == 0) {
		return 0;
	}
	if (getPageSize() == 0) {
		return 1;
	}
	this.totalPages = (int) (totalNumberOfElements / pageSize);
	if ((totalNumberOfElements % pageSize) > 0) {
		totalPages++;
	}
	return totalPages;
}

@Override
public boolean hasNextPage() {
	return (pageNumber + 1) > getTotalPages();
}

@Override
public boolean hasPreviousPage() {

	return (pageNumber - 1) > 0;
}

@Override
public boolean isFirstPage() {
	return pageNumber == 1;
}

@Override
public boolean isLastPage() {
	return pageNumber == getTotalPages();
}

}
