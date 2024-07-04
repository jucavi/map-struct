package es.emi.mapstruct.entity;

import es.emi.mapstruct.constant.UserRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDoped extends AbstractEntity {

    private String name;
    private UserRole role;

}
