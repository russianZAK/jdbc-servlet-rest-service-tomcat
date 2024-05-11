package by.russianzak.servlet.dto;

import by.russianzak.model.RoadSurfaceEntity.TypeOfRoadSurface;
import by.russianzak.servlet.dto.slim.ResponseStreetSlimDto;
import java.util.List;

public class ResponseRoadSurfaceEntityDto {
  private long id;
  private String type;
  private String description;
  private double frictionCoefficient;
  private List<ResponseStreetSlimDto> streets;

  public ResponseRoadSurfaceEntityDto() {}

  public ResponseRoadSurfaceEntityDto(long id, String type, String description,
      double frictionCoefficient, List<ResponseStreetSlimDto> streets) {
    this.id = id;
    this.type = type;
    this.description = description;
    this.frictionCoefficient = frictionCoefficient;
    this.streets = streets;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public List<ResponseStreetSlimDto> getStreets() {
    return streets;
  }

  public void setStreets(
      List<ResponseStreetSlimDto> streets) {
    this.streets = streets;
  }
}
