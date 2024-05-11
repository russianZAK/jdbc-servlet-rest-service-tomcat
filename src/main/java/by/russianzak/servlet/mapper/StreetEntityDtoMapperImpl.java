package by.russianzak.servlet.mapper;

import by.russianzak.model.HouseEntity;
import by.russianzak.model.HouseEntity.TypeOfBuilding;
import by.russianzak.model.RoadSurfaceEntity;
import by.russianzak.model.RoadSurfaceEntity.TypeOfRoadSurface;
import by.russianzak.model.StreetEntity;
import by.russianzak.servlet.dto.RequestStreetEntityDto;
import by.russianzak.servlet.dto.ResponseHouseEntityDto;
import by.russianzak.servlet.dto.ResponseStreetEntityDto;
import by.russianzak.servlet.dto.slim.ResponseHouseSlimDto;
import by.russianzak.servlet.dto.slim.ResponseRoadSurfaceSlimDto;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreetEntityDtoMapperImpl implements StreetEntityDtoMapper{

  @Override
  public StreetEntity map(RequestStreetEntityDto incomingDto) {
    StreetEntity streetEntity = StreetEntity.builder()
        .setName(incomingDto.getName())
        .setPostalCode(incomingDto.getPostalCode())
        .build();

    Set<RoadSurfaceEntity> roadSurfaceEntities = Optional.ofNullable(incomingDto.getRoadSurfaces())
        .map(surfaceDtos -> surfaceDtos.stream()
            .map(surfaceDto -> RoadSurfaceEntity.builder()
                .setType(TypeOfRoadSurface.fromValue(surfaceDto.getType()))
                .setDescription(surfaceDto.getDescription())
                .setFrictionCoefficient(surfaceDto.getFrictionCoefficient())
                .build())
            .collect(Collectors.toSet()))
        .orElse(new HashSet<>());

    Set<HouseEntity> houseEntities = Optional.ofNullable(incomingDto.getHouses())
        .map(houseDtos -> houseDtos.stream()
            .map(houseDto -> HouseEntity.builder()
                .setHouseNumber(houseDto.getHouseNumber())
                .setNumFloors(houseDto.getNumFloors())
                .setBuildDate(houseDto.getBuildDate())
                .setType(TypeOfBuilding.fromValue(houseDto.getType()))
                .setStreet(streetEntity)
                .build())
            .collect(Collectors.toSet()))
        .orElse(new HashSet<>());

    streetEntity.setHouses(houseEntities);
    streetEntity.setRoadSurfaces(roadSurfaceEntities);

    return streetEntity;
  }

  @Override
  public ResponseStreetEntityDto map(StreetEntity entity) {
    List<ResponseHouseSlimDto> houseDtos = entity.getHouses().stream().map(house -> new ResponseHouseSlimDto(
        house.getId(), house.getHouseNumber(), (Date) house.getBuildDate(), house.getNumFloors(),
        house.getType())).collect(Collectors.toList());

    List<ResponseRoadSurfaceSlimDto> roadSurfaceDtos = entity.getRoadSurfaces().stream().map(roadSurface -> new ResponseRoadSurfaceSlimDto(roadSurface.getId(), roadSurface.getType(), roadSurface.getDescription(),
        roadSurface.getFrictionCoefficient())).collect(Collectors.toList());

    return new ResponseStreetEntityDto(entity.getId(), entity.getName(), entity.getPostalCode(), houseDtos, roadSurfaceDtos);
  }
}
