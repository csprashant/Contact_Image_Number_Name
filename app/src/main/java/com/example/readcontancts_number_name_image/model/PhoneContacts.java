package com.example.readcontancts_number_name_image.model;

import android.net.Uri;

public class PhoneContacts {
    String name;
    String phoneNumber;
    Uri imageUrl;
    public PhoneContacts(){    }
    public PhoneContacts(String name, String phoneNumber, Uri imageUrl) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Uri getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Uri imageUrl) {
        this.imageUrl = imageUrl;
    }
}
