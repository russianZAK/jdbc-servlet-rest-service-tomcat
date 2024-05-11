package by.russianzak.servlet.dto;


import by.russianzak.servlet.dto.slim.RequestHouseSlimDto;
import by.russianzak.servlet.dto.slim.RequestRoadSurfaceSlimDto;
import com.google.gson.annotations.SerializedName;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class RequestStreetEntityDto {
  private String name;
  private Long postalCode;
  private List<RequestHouseSlimDto> houses;
  private List<RequestRoadSurfaceSlimDto> roadSurfaces;

  public RequestStreetEntityDto() {}

  public RequestStreetEntityDto(String name, Long postalCode, List<RequestHouseSlimDto> houses, List<RequestRoadSurfaceSlimDto> roadSurfaces) {
    this.name = name;
    this.postalCode = postalCode;
    this.houses = houses;
    this.roadSurfaces = roadSurfaces;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(Long postalCode) {
    this.postalCode = postalCode;
  }

  public List<RequestHouseSlimDto> getHouses() {
    return houses;
  }

  public void setHouses(List<RequestHouseSlimDto> houses) {
    this.houses = houses;
  }

  public List<RequestRoadSurfaceSlimDto> getRoadSurfaces() {
    return roadSurfaces;
  }

  public void setRoadSurfaces(
      List<RequestRoadSurfaceSlimDto> roadSurfaces) {
    this.roadSurfaces = roadSurfaces;
  }

}
