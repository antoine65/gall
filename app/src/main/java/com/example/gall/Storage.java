package com.example.gall;

public class Storage {
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Storage(String image) {
        this.image = image;
    }

    private String image;
}
