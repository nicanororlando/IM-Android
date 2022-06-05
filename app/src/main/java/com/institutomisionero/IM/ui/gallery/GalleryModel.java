/*
 * Created by Nicanor Orlando.
 * Copyright (c) 5/31/22, 11:41 AM.
 * All rights reserved.
 */

package com.institutomisionero.IM.ui.gallery;

public class GalleryModel {
    int id;
    String title;
    String url;
    String image;
    String description;

    // ctrl + n --> Constructor:
    public GalleryModel(int id, String title, String url, String image, String description) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.image = image;
        this.description = description;
    }

    public GalleryModel() {

    }

    // ctrl + n --> Getter and Setter:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
