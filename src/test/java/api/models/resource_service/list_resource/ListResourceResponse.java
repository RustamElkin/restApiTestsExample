package api.models.resource_service.list_resource;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListResourceResponse {
    private Long page;
    @JsonProperty("per_page")
    private Long perPage;
    private Long total;
    @JsonProperty("total_pages")
    private Long totalPages;
    private List<Daum> data;
    private Support support;

    public ListResourceResponse() {

    }

    public ListResourceResponse(Long page, Long perPage, Long total, Long totalPages, List<Daum> data, Support support) {
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPages = totalPages;
        this.data = data;
        this.support = support;
    }

    public Long getPage() {
        return this.page;
    }

    public Long getPerPage() {
        return this.perPage;
    }

    public Long getTotal() {
        return this.total;
    }

    public Long getTotalPages() {
        return this.totalPages;
    }

    public List<Daum> getData() {
        return this.data;
    }

    public Support getSupport() {
        return this.support;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public void setPerPage(Long perPage) {
        this.perPage = perPage;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public void setData(List<Daum> data) {
        this.data = data;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}


