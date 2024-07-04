package es.emi.mapstruct.assembler;

import es.emi.mapstruct.dto.UserDto;
import es.emi.mapstruct.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserAssemblerTest {

    private final UserAssembler assembler = Mappers.getMapper(UserAssembler.class);

    private Long id;
    private String username;
    private String password;
    private ZonedDateTime createdAt;

    @BeforeEach
    void setUp() {

        id = 1L;
        username = "john_doe";
        password = "password123";
        createdAt = ZonedDateTime.now();

    }

    @Test
    public void testToEntity() {
        UserDto dto = new UserDto();
        dto.setId(id);

        dto.setUsername(username);
        dto.setPassword(password);
        dto.setCreatedAt(createdAt.toString());

        User entity = assembler.toEntity(dto);

        assertNotNull(entity);
        assertEquals(entity.getId(), id);
        assertEquals(entity.getUsername(), username);
        assertEquals(entity.getPassword(), password);
        assertEquals(entity.getCreatedAt(), createdAt);
    }

    @Test
    public void testToDto() {
        User entity = new User();
        entity.setId(id);
        entity.setUsername(username);
        entity.setPassword(password);
        entity.setCreatedAt(createdAt);

        UserDto dto = assembler.toDto(entity);

        assertNotNull(dto);
        assertEquals(dto.getId(), id);
        assertEquals(dto.getUsername(), username);
        assertEquals(dto.getPassword(), password);
        assertEquals(ZonedDateTime.parse(dto.getCreatedAt()), createdAt);
    }
}