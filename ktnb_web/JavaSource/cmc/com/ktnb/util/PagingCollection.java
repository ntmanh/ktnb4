package cmc.com.ktnb.util;

import java.util.*;

public class PagingCollection {
	private Collection col_splitPage;
	private long totalItem;
	private long totalPage;
	private long pagePosition;
	private long pagesize;

	public PagingCollection(long pageNum, long pageSize, Collection col_data) {
		ArrayList arr_temp = new ArrayList();
		Iterator itera = col_data.iterator();

		//               if(pageNum>(long)Math.floor((double)col_data.size()/pageSize))
		//               {
		//                 pageNum=1;
		//               }
		pageNum = 1;
		this.pagePosition = pageNum;
		this.pagesize = pageSize;
		long index = 0;
		long star_pos = pageSize * (pageNum - 1) + 1;
		long end_pos = pageSize + pageSize * (pageNum - 1);
		while (itera.hasNext()) {
			index++;
			Object obj_temp = null;
			obj_temp = itera.next();
			if ((index >= star_pos) && (index <= end_pos)) {
				arr_temp.add(obj_temp);
			}
		}
		col_splitPage = arr_temp;
		totalItem = 0;
		totalItem = col_data.size();

		totalPage = 0;
		long tmp = totalItem / pageSize;
		if (tmp * pageSize == totalItem) {
			totalPage = tmp;
		} else {
			totalPage = tmp + 1;
		}
	}

	public long getTotalItem() {
		return totalItem;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public Collection getCollection() {
		return col_splitPage;
	}
	public long getPagePosition() {
		return this.pagePosition;
	}
	public long getPageSize() {
		return this.pagesize;
	}
}