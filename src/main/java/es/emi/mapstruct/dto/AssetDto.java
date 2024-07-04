package es.emi.mapstruct.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AssetDto extends AbstractDto {

    private String name;
    private String description;
    private String type;

}
