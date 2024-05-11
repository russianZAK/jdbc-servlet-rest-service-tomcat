package by.russianzak.servlet.mapper;

import by.russianzak.model.RoadSurfaceEntity;
import by.russianzak.model.RoadSurfaceEntity.TypeOfRoadSurface;
import by.russianzak.model.StreetEntity;
import by.russianzak.servlet.dto.RequestRoadSurfaceEntityDto;
import by.russianzak.servlet.dto.ResponseRoadSurfaceEntityDto;
import by.russianzak.servlet.dto.slim.ResponseStreetSlimDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoadSurfaceEntityDtoMapperImpl implements RoadSurfaceEntityDtoMapper{

  @Override
  public RoadSurfaceEntity map(RequestRoadSurfaceEntityDto incomingDto) {
    List<StreetEntity> streetEntities = Optional.ofNullable(incomingDto.getStreets())
        .map(streetDtos -> streetDtos.stream()
            .map(streetDto -> StreetEntity.builder()
                .setName(streetDto.getName())
                .setPostalCode(streetDto.getPostalCode())
                .build())
            .collect(Collectors.toList()))
        .orElse(new ArrayList<>());


    return RoadSurfaceEntity.builder().setType(TypeOfRoadSurface.valueOf(incomingDto.getType()))
            .setDescription(incomingDto.getDescription())
                .setFrictionCoefficient(incomingDto.getFrictionCoefficient())
                    .setStreets(streetEntities).build();
  }

  @Override
  public ResponseRoadSurfaceEntityDto map(RoadSurfaceEntity entity) {
    List<ResponseStreetSlimDto> streetDtos = entity.getStreets().stream()
        .map(street -> new ResponseStreetSlimDto(street.getId(), street.getName(), street.getPostalCode()))
        .collect(Collectors.toList());

    return new ResponseRoadSurfaceEntityDto(entity.getId(), entity.getType(), entity.getDescription(), entity.getFrictionCoefficient(), streetDtos);
  }
}
