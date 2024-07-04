package es.emi.mapstruct.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDopedDto extends AbstractDto {

    private String name;
    private String role;

}
