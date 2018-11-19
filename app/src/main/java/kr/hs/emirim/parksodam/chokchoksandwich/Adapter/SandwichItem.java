package kr.hs.emirim.parksodam.chokchoksandwich.Adapter;

import android.widget.ImageView;

/**
 * Created by Mirim on 2018-11-19.
 */

public class SandwichItem {
    private ImageView breadImage;
    private String breadName;
    private String firstPrice;
    private String secondPrice;
    private ImageView favorite;

    public SandwichItem(){

    }

    public SandwichItem(ImageView breadImage, String breadName, String firstPrice, String secondPrice, ImageView favorite) {
        this.breadImage = breadImage;
        this.breadName = breadName;
        this.firstPrice = firstPrice;
        this.secondPrice = secondPrice;
        this.favorite = favorite;
    }

    public SandwichItem(String breadName, String firstPrice, String secondPrice) {
        this.breadName = breadName;
        this.firstPrice = firstPrice;
        this.secondPrice = secondPrice;
    }

    public ImageView getBreadImage() {
        return breadImage;
    }

    public void setBreadImage(ImageView breadImage) {
        this.breadImage = breadImage;
    }

    public String getBreadName() {
        return breadName;
    }

    public void setBreadName(String breadName) {
        this.breadName = breadName;
    }

    public String getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(String firstPrice) {
        this.firstPrice = firstPrice;
    }

    public String getSecondPrice() {
        return secondPrice;
    }

    public void setSecondPrice(String secondPrice) {
        this.secondPrice = secondPrice;
    }

    public ImageView getFavorite() {
        return favorite;
    }

    public void setFavorite(ImageView favorite) {
        this.favorite = favorite;
    }
}
