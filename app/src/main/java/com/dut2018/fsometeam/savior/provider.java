package com.dut2018.fsometeam.savior;

import android.graphics.drawable.Drawable;

public class provider {
    private int m_idImage;
    private String m_nameProvider;
    private String m_addressProvider;
    private String m_distance;
    private Drawable m_url_image;

    public provider(String name, String address, String distance, Drawable idImage){
        this.m_nameProvider = name;
        this.m_addressProvider = address;
        this.m_distance = distance;
        this.m_url_image = idImage;
    }


    public int getM_idImage() {
        return m_idImage;
    }

    public void setM_idImage(int m_idImage) {
        this.m_idImage = m_idImage;
    }

    public String getM_nameProvider() {
        return m_nameProvider;
    }

    public void setM_nameProvider(String m_nameProvider) {
        this.m_nameProvider = m_nameProvider;
    }

    public String getM_addressProvider() {
        return m_addressProvider;
    }

    public void setM_addressProvider(String m_addressProvider) {
        this.m_addressProvider = m_addressProvider;
    }

    public String getM_distance() {
        return m_distance;
    }

    public void setM_distance(String m_distance) {
        this.m_distance = m_distance;
    }

    public Drawable getM_url_image() {
        return m_url_image;
    }

    public void setM_url_image(Drawable m_url_image) {
        this.m_url_image = m_url_image;
    }
}
