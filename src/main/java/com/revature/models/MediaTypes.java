package com.revature.models;

public enum MediaTypes {

    BOOK("Book"), MOVIE("Movie"), SHOW("Show");

    private String mediaType;

    MediaTypes(String type) {
        this.mediaType = type;
    }

    @Override
    public String toString() {
        return this.mediaType;
    }

}
