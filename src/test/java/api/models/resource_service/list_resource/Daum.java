package api.models.resource_service.list_resource;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Daum {
    private Long id;
    private String name;
    private Long year;
    private String color;
    @JsonProperty("pantone_value")
    private String pantoneValue;

    public Daum() {

    }

    public Daum(Long id, String name, Long year, String color, String pantoneValue) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantoneValue = pantoneValue;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Long getYear() {
        return this.year;
    }

    public String getColor() {
        return this.color;
    }

    public String getPantoneValue() {
        return this.pantoneValue;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPantoneValue(String pantoneValue) {
        this.pantoneValue = pantoneValue;
    }
}
