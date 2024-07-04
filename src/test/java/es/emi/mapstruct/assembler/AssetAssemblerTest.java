package es.emi.mapstruct.assembler;

import es.emi.mapstruct.dto.AssetDto;
import es.emi.mapstruct.entity.Asset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;


class AssetAssemblerTest {
    
    private final AssetAssembler assetAssembler = Mappers.getMapper(AssetAssembler.class);

    private Long id;
    private String name;
    private String description;
    private String type;
    private ZonedDateTime date;
    
    @BeforeEach
    void setUp() {
        
        id = 1L;
        name = "Super Asset";
        description = "Description for super asset";
        type = "Basic";
        date = ZonedDateTime.now();
        
    }
    
    @Test
    public void testToEntity() {

        AssetDto dto = new AssetDto();
        dto.setId(id);
        dto.setName(name);
        dto.setDescription(description);
        dto.setType(type);
        dto.setCreatedAt(date.toString());
        dto.setUpdatedAt(date.toString());
        dto.setDeleted(false);
        dto.setActive(true);
        
        Asset entity = assetAssembler.toEntity(dto);
        
        assertNotNull(entity);
        assertEquals(entity.getId(), id);
        assertEquals(entity.getName(), name);
        assertEquals(entity.getDescription(), description);
        assertEquals(entity.getType(), type);
        assertEquals(entity.getCreatedAt(), date);
        assertEquals(entity.getUpdatedAt(), date);
        assertFalse(entity.getDeleted());
        assertTrue(entity.getActive());
        
    }

    @Test
    public void testToDto() {

        Asset entity = new Asset();
        entity.setId(id);
        entity.setName(name);
        entity.setDescription(description);
        entity.setType(type);
        entity.setCreatedAt(date);
        entity.setUpdatedAt(date);
        entity.setDeleted(false);
        entity.setActive(true);
        
        AssetDto dto = assetAssembler.toDto(entity);
        
        assertNotNull(dto);
        assertEquals(dto.getId(), id);
        assertEquals(dto.getName(), name);
        assertEquals(dto.getDescription(), description);
        assertEquals(dto.getType(), type);
        assertEquals(ZonedDateTime.parse(dto.getCreatedAt()), date);
        assertEquals(ZonedDateTime.parse(dto.getUpdatedAt()), date);
        assertEquals(dto.getDeleted(), false);
        assertEquals(dto.getActive(), true);
        
    }

    @Test
    public void testToNullEntity() {

        Asset entity = assetAssembler.toEntity(null);

        assertNull(entity);

    }

    @Test
    public void testToNullDto() {

        AssetDto dto = assetAssembler.toDto(null);

        assertNull(dto);

    }

    @Test
    public void testToPartialDto() {

        Asset entity = new Asset();
        entity.setId(id);
        entity.setDescription(description);
        entity.setDeleted(false);

        AssetDto dto = assetAssembler.toDto(entity);

        assertNotNull(dto);
        assertEquals(dto.getId(), id);
        assertNull(dto.getName());
        assertEquals(dto.getDescription(), description);
        assertNull(dto.getType(), type);
        assertNull(dto.getCreatedAt());
        assertEquals(dto.getDeleted(), false);
        assertNull(dto.getActive());

    }

    @Test
    public void testToPartialEntity() {

        AssetDto dto = new AssetDto();
        dto.setId(id);
        dto.setDescription(description);
        dto.setDeleted(false);

        Asset entity = assetAssembler.toEntity(dto);

        assertNotNull(entity);
        assertEquals(entity.getId(), id);
        assertNull(entity.getName());
        assertEquals(entity.getDescription(), description);
        assertNull(entity.getType(), type);
        assertNull(entity.getCreatedAt());
        assertEquals(entity.getDeleted(), false);
        assertNull(entity.getActive());

    }
}