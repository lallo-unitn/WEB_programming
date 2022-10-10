package it.unitn.disi.web.RG.esamegiugno21.beans;

import java.io.Serializable;
import java.util.Date;

public class ItemBean implements Serializable {
    private static int serial = 0;
    private String title = null;
    private String description = null;
    private Integer currPrice = null;
    private String bestOfferer = null;
    private Date timestamp = null;
    private int id;

    public ItemBean(){}
    public ItemBean(
            String title,
            String description,
            Integer currPrice,
            String bestOfferer,
            Date d
    ){
        this.id = (++ItemBean.serial);
        this.title = title;
        this.description = description;
        this.currPrice = currPrice;
        this.bestOfferer = bestOfferer;
        this.timestamp = d;
    }

    ///////////////// GETTERS /////////////////

    public Integer getCurrPrice() {
        return currPrice;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getBestOfferer() {
        return bestOfferer;
    }

    public Date getTimestamp() { return timestamp; }

    public int getId() { return id; }

    ///////////////// SETTERS /////////////////

    public void setBestOfferer(String bestOfferer) {
        this.bestOfferer = bestOfferer;
    }

    public void setCurrPrice(Integer currPrice) {
        this.currPrice = currPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) { this.id = id; }

    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
}
