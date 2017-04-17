package com.rookie.www.materialdesigntest;

/**
 * Created by Hi on 2017/4/17.
 */

public class ShuihuCard {

    private String cardName;
    private int imageId;

    public ShuihuCard(String cardName, int imageId) {
        this.cardName = cardName;
        this.imageId = imageId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
