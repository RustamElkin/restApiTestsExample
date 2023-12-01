package api.models.user_service.single_user;

public class SingleUserResponse {
    private Data data;
    private Support support;

    public SingleUserResponse() {
    }

    public SingleUserResponse(Data data, Support support) {
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

