package cn.com.grocery.common;

import java.util.List;

/**
 * 定义一个分页对象
 * @author chenjinlong
 *
 */
public class Pager {

	private int index = 0;// 当前页码

	private int pageCount;// 总页码

	private int count;// 总条数

	private int pageSize = 10;// 每页显示条数

	private String hql;// 分页语句

	private List<?> list;// 返回的数据集合

	public Pager() {
		super();
	}

	public String getHql() {
		return hql;
	}

	public void setHql( String hql ) {
		this.hql = hql;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex( int index ) {
		this.index = index;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount( int pageCount ) {
		this.pageCount = pageCount;
	}

	public int getCount() {
		return count;
	}

	public void setCount( int count ) {
		this.count = count;
		pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize( int pageSize ) {
		this.pageSize = pageSize;
	}

	public List<?> getList() {
		return list;
	}

	public void setList( List<?> list ) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Pager [list=" + list + ", index=" + index + ", pageCount="
				+ pageCount + ", count=" + count + ", pageSize=" + pageSize
				+ "]";
	}

}