package cn.com.kc.blog.common.util;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import cn.com.kc.blog.commondao.pagination.impl.PageRequestImpl;
import cn.com.kc.blog.commondao.pagination.service.Page;
import cn.com.kc.blog.commondao.pagination.service.PageRequest;

import com.alibaba.fastjson.JSONObject;

/**
 * utility class to extract datatable request parameters and so on.
 * 
 * @author kchen1
 * 
 */
public class DataTableUtility {

/**
 * seperator symbol-$;
 */
public static final String CONST_PARANAME_SEPERATOR_AT = "@";
/**
 * Column being sorted on (you will need to decode this number for your
 * database).
 */
public static final String CONST_PARANAME_iSortCol_ = "iSortCol_";
/**
 * The value specified by mDataProp for each column. This can be useful for
 * ensuring that the processing of data is independent from the order of the
 * columns.
 */
public static final String CONST_PARANAME_mDataProp_ = "mDataProp_";
/**
 * Direction to be sorted - "desc" or "asc".
 */
public static final String CONST_PARANAME_sSortDir_ = "sSortDir_";

/**
 * iDisplayStart-Display start point in the current data set.
 */
public static final String CONST_PARANAME_iDisplayStart = "iDisplayStart";
/**
 * iDisplayLength-Number of records that the table can display in the current
 * draw. It is expected that the number of records returned will be equal to
 * this number, unless the server has fewer records to return.
 */
public static final String CONST_PARANAME_iDisplayLength = "iDisplayLength";
/**
 * iColumns-Number of columns being displayed (useful for getting individual
 * column search info)
 */
public static final String CONST_PARANAME_iColumns = "iColumns";
/**
 * sSearch- Global search field
 */
public static final String CONST_PARANAME_sSearch = "sSearch";
/**
 * bRegex-True if the global filter should be treated as a regular expression
 * 
 * for advanced filtering, false if not.
 */
public static final String CONST_PARANAME_bRegex = "bRegex";

/**
 * iSortingCols-Number of columns to sort on
 */
public static final String CONST_PARANAME_iSortingCols = "iSortingCols";
/**
 * sEcho-Information for DataTables to use for rendering.
 */
public static final String CONST_PARANAME_sEcho = "sEcho";

/**
 * iTotalRecords-Total records, before filtering (i.e. the total number of
 * records in the database).
 */
public static final String CONST_PARANAME_iTotalRecords = "iTotalRecords";
/**
 * sEcho-Total records, after filtering (i.e. the total number of records after
 * filtering has been applied - not just the number of records being returned in
 * this result set).
 */
public static final String CONST_PARANAME_iTotalDisplayRecords = "iTotalDisplayRecords";

/**
 * aaData-array-The data in a 2D array. Note that you can change the name of
 * this parameter with sAjaxDataProp..
 */
public static final String CONST_PARANAME_aaData = "aaData";

/**
 * avoid being instanced
 */
private DataTableUtility() {

}

/**
 * 
 the post data datatables UI would send to server like this. bRegex false
 * bRegex_0 false bRegex_1 false bRegex_2 false bRegex_3 false bRegex_4 false
 * bSearchable_0 true bSearchable_1 true bSearchable_2 true bSearchable_3 true
 * bSearchable_4 true bSortable_0 true bSortable_1 true bSortable_2 true
 * bSortable_3 true bSortable_4 true iColumns 5 iDisplayLength 10 iDisplayStart
 * 0 iSortCol_0 2 iSortingCols 1 mDataProp_0 idx mDataProp_1 name mDataProp_2
 * user mDataProp_3 createDate mDataProp_4 createDate sColumns sEcho 8 sSearch
 * sSearch_0 sSearch_1 sSearch_2 sSearch_3 sSearch_4 sSortDir_0 asc
 */
/**
 * extract datatable parameter to java object.
 */
public static PageRequest extractRequstParameters(
				final HttpServletRequest request) {
	final PageRequest pageRequest = new PageRequestImpl();
	final Integer startPlace = Integer.valueOf(request
					.getParameter(CONST_PARANAME_iDisplayStart));
	final Integer displayLength = Integer.valueOf(request
					.getParameter(CONST_PARANAME_iDisplayLength));
	pageRequest.setPageNumber(startPlace / displayLength + 1);
	final Integer sortingCols = Integer.valueOf(request
					.getParameter(CONST_PARANAME_iSortingCols));
	final StringBuffer sortStringBuffer = new StringBuffer();
	for (int i = 0; i < sortingCols; i++) {
		//get the sorting column's name
		sortStringBuffer.append(String.valueOf(request.getParameter(CONST_PARANAME_mDataProp_ + Integer.valueOf(request
						.getParameter(CONST_PARANAME_iSortCol_ + i)).toString()))).append(CONST_PARANAME_SEPERATOR_AT);
		// get the sorting direction asc or desc.
		pageRequest.getSortColumns().add(sortStringBuffer.append(String.valueOf(request
						.getParameter(CONST_PARANAME_sSortDir_ + i))).toString());
		// clear the str
		sortStringBuffer.setLength(0);
	}
	pageRequest.setPageSize(displayLength);
	return pageRequest;

}

/**
 * 组装表格数据.
 * 
 * @return 表格数据.
 */
public static JSONObject assembleTableData(Page page) {
	JSONObject jsonObject = new JSONObject();
	jsonObject.put(CONST_PARANAME_iTotalRecords,
					page.getTotalNumberOfElements());
	jsonObject.put(CONST_PARANAME_iTotalDisplayRecords, page.getTotalNumberOfElements());
	jsonObject.put(CONST_PARANAME_aaData, page.getContent());
	return jsonObject;
}
}
