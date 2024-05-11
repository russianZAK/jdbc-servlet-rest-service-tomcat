package by.russianzak.servlet.dto;

import by.russianzak.servlet.dto.slim.RequestStreetSlimDto;
import java.util.List;

public class RequestRoadSurfaceEntityDto {
  private String type;
  private String description;
  private double frictionCoefficient;
  private List<RequestStreetSlimDto> streets;

  public RequestRoadSurfaceEntityDto(){}

  public RequestRoadSurfaceEntityDto(String type, String description, double frictionCoefficient,
      List<RequestStreetSlimDto> streets) {
    this.type = type;
    this.description = description;
    this.frictionCoefficient = frictionCoefficient;
    this.streets = streets;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getFrictionCoefficient() {
    return frictionCoefficient;
  }

  public void setFrictionCoefficient(double frictionCoefficient) {
    this.frictionCoefficient = frictionCoefficient;
  }

  public List<RequestStreetSlimDto> getStreets() {
    return streets;
  }

  public void setStreets(
      List<RequestStreetSlimDto> streets) {
    this.streets = streets;
  }
}
