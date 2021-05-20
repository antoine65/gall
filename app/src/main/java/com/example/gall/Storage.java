package com.example.gall;

public class Storage {
    private String image;
    public Storage(){

    }
    public Storage(String image){ this.image = image; }

    public String getImageUrl() {

        return image;
    }

    public void setImageUrl(String image) {
        this.image = image;
    }



}
