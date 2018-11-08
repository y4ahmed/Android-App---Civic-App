package com.ps.citizen3.data.api.GoogleCivicModel;

import com.google.gson.annotations.Expose;

public class Address {

    @Expose
    private String line1;
    @Expose
    private String line2;
    @Expose
    private String city;
    @Expose
    private String state;
    @Expose
    private String zip;

    /**
     *
     * @return
     * The line1
     */
    public String getLine1() {
        return line1;
    }

    /**
     *
     * @param line1
     * The line1
     */
    public void setLine1(String line1) {
        this.line1 = line1;
    }

    /**
     *
     * @return
     * The line2
     */
    public String getLine2() {
        return line2;
    }

    /**
     *
     * @param line2
     * The line2
     */
    public void setLine2(String line2) {
        this.line2 = line2;
    }

    /**
     *
     * @return
     * The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The state
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     * The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     * The zip
     */
    public String getZip() {
        return zip;
    }

    /**
     *
     * @param zip
     * The zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

}