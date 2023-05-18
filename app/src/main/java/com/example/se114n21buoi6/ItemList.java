package com.example.se114n21buoi6;

import java.io.Serializable;

public class ItemList implements Serializable {
    private String name;
    private String description;
    private String finishDate;
    private boolean mark;

    public ItemList(String name, String description, String finishDate, boolean mark) {
        this.name = name;
        this.description = description;
        this.finishDate = finishDate;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }
}
