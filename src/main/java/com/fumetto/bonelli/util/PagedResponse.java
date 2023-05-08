package com.fumetto.bonelli.util;

import java.util.List;

public class PagedResponse<T> {
    private List<T> data;
    private int total;
    private int perPage;
    private int currentPage;
    private int totalPages;

    public PagedResponse(List<T> data, int total, int perPage, int currentPage, int totalPages) {
        this.data = data;
        this.total = total;					//"total": 109
        this.perPage = perPage;				//"perPage": 10
        this.currentPage = currentPage;		//"currentPage": 0
        this.totalPages = totalPages;		// "totalPages": 11
    }

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
    
}
