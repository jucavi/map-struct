package es.emi.mapstruct.assembler;

import es.emi.mapstruct.constant.UserRole;
import es.emi.mapstruct.dto.UserDopedDto;
import es.emi.mapstruct.entity.UserDoped;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = { UserRole.class }
)
public interface UserDopedAssembler {

    UserDoped toEntity(UserDopedDto source);
    UserDopedDto toDto(UserDoped source);
}
