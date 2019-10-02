package com.example.naci.retrofitsample.network.model;

import com.google.gson.annotations.SerializedName;

public class NumberData {
    @SerializedName("text")
    private String text;
    @SerializedName("found")
    private boolean found;
    @SerializedName("number")
    private int number;
    @SerializedName("type")
    private String type;
    /*@SerializedName("date")
    private String date;*/

    public NumberData(String text, boolean found, int number, String type/*, String date*/) {
        this.text = text;
        this.found = found;
        this.number = number;
        this.type = type;
        //this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }*/
}
