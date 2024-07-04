package es.emi.mapstruct.assembler;

import es.emi.mapstruct.constant.UserRole;
import es.emi.mapstruct.dto.AssetDto;
import es.emi.mapstruct.dto.UserDopedDto;
import es.emi.mapstruct.dto.UserDto;
import es.emi.mapstruct.entity.Asset;
import es.emi.mapstruct.entity.User;
import es.emi.mapstruct.entity.UserDoped;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserDopedAssemblerTest {

    private final UserDopedAssembler assembler = Mappers.getMapper(UserDopedAssembler.class);

    private Long id;
    private String name;
    private UserRole role;

    @BeforeEach
    void setUp() {

        id = 1L;
        name = "john_doe";
        role = UserRole.USER;

    }

    @Test
    public void testToEntity() {

        UserDopedDto dto = new UserDopedDto();
        dto.setId(id);
        dto.setName(name);
        dto.setRole(role.toString());

        UserDoped entity = assembler.toEntity(dto);

        assertNotNull(entity);
        assertEquals(entity.getId(), id);
        assertEquals(entity.getName(), name);
        assertEquals(entity.getRole(), role);
    }

    @Test
    public void testToDto() {
        UserDoped entity = new UserDoped();
        entity.setId(id);
        entity.setName(name);
        entity.setRole(role);

        UserDopedDto dto = assembler.toDto(entity);

        assertNotNull(dto);
        assertEquals(dto.getId(), id);
        assertEquals(dto.getName(), name);
        assertEquals(dto.getRole(), role.toString());
    }

    @Test
    public void testToNullEntity() {

        UserDoped entity = assembler.toEntity(null);

        assertNull(entity);

    }

    @Test
    public void testToNullDto() {

        UserDopedDto dto = assembler.toDto(null);

        assertNull(dto);

    }
}