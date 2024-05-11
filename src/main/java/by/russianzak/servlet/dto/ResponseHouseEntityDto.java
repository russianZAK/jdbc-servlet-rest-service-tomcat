package by.russianzak.servlet.dto;

import by.russianzak.servlet.dto.slim.ResponseStreetSlimDto;
import java.util.Date;

public class ResponseHouseEntityDto {
  private Long id;
  private String houseNumber;
  private Date buildDate;
  private int numFloors;
  private String type;
  private ResponseStreetSlimDto street;

  public ResponseHouseEntityDto(Long id, String houseNumber, Date buildDate, int numFloors, String type, ResponseStreetSlimDto streetDto) {
    this.id = id;
    this.houseNumber = houseNumber;
    this.buildDate = buildDate;
    this.numFloors = numFloors;
    this.type = type;
    this.street = streetDto;
  }

  public ResponseHouseEntityDto() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public ResponseStreetSlimDto getStreet() {
    return street;
  }

  public void setStreet(ResponseStreetSlimDto streetId) {
    this.street = streetId;
  }

}
