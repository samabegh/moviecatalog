package io.javapro.moviecatalogservice.resources.models;

public class CatalogItem
{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String disc;
    private int rating;

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public CatalogItem(String name, String disc, int rating) {
        this.name = name;
        this.disc = disc;
        this.rating = rating;
    }
}
