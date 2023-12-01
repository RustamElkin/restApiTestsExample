package api.models.user_service.single_user;

public class Support {
    private String url;
    private String text;

    public Support() {
    }

    public Support(String url, String text) {
        this.url = url;
        this.text = text;
    }

    public String getUrl() {
        return this.url;
    }

    public String getText() {
        return this.text;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setText(String text) {
        this.text = text;
    }
}
