package by.russianzak.servlet.dto.slim;

import java.sql.Date;

public class RequestHouseSlimDto {
    private String houseNumber;
    private Date buildDate;
    private int numFloors;
    private String type;

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Date getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(Date buildDate) {
        this.buildDate = buildDate;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RequestHouseSlimDto(String houseNumber, Date buildDate, int numFloors, String type) {
        this.houseNumber = houseNumber;
        this.buildDate = buildDate;
        this.numFloors = numFloors;
        this.type = type;
    }
}
