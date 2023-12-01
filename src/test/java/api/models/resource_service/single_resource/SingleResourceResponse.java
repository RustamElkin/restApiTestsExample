package api.models.resource_service.single_resource;

public class SingleResourceResponse {
    private Data data;
    private Support support;
    public SingleResourceResponse() {

    }

    public SingleResourceResponse(Data data, Support support) {
        this.data = data;
        this.support = support;
    }

    public Data getData() {
        return this.data;
    }

    public Support getSupport() {
        return this.support;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}

