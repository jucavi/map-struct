package es.emi.mapstruct.assembler;


import es.emi.mapstruct.dto.AssetDto;
import es.emi.mapstruct.entity.Asset;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.time.ZonedDateTime;

@Mapper(
        componentModel = "spring",
        uses = { ZonedDateTime.class },
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface AssetAssembler {

    Asset toEntity(AssetDto source);
    AssetDto toDto(Asset source);
}
