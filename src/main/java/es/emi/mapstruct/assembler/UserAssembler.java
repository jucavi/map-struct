package es.emi.mapstruct.assembler;


import es.emi.mapstruct.dto.UserDto;
import es.emi.mapstruct.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.time.ZonedDateTime;

@Mapper(
        componentModel = "spring",
        uses = { ZonedDateTime.class },
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface UserAssembler {

    User toEntity(UserDto source);
    UserDto toDto(User source);

}
