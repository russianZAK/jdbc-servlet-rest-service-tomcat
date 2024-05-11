package by.russianzak.servlet.dto;

import by.russianzak.servlet.dto.slim.ResponseHouseSlimDto;
import by.russianzak.servlet.dto.slim.ResponseRoadSurfaceSlimDto;
import by.russianzak.servlet.dto.slim.ResponseStreetSlimDto;
import java.util.Date;
import java.util.List;

public class ResponseStreetEntityDto {
  private long id;
  private String name;
  private Long postalCode;
  private List<ResponseHouseSlimDto> houses;
  private List<ResponseRoadSurfaceSlimDto> roadSurfaces;

  public ResponseStreetEntityDto(long id, String name, Long postalCode, List<ResponseHouseSlimDto> houses,
      List<ResponseRoadSurfaceSlimDto> roadSurfaces) {
    this.id = id;
    this.name = name;
    this.postalCode = postalCode;
    this.houses = houses;
    this.roadSurfaces = roadSurfaces;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public List<ResponseHouseSlimDto> getHouses() {
    return houses;
  }

  public void setHouses(List<ResponseHouseSlimDto> houses) {
    this.houses = houses;
  }

  public List<ResponseRoadSurfaceSlimDto> getRoadSurfaces() {
    return roadSurfaces;
  }

  public void setRoadSurfaces(
      List<ResponseRoadSurfaceSlimDto> roadSurfaces) {
    this.roadSurfaces = roadSurfaces;
  }
}
