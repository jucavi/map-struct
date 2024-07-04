package es.emi.mapstruct.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Asset extends AbstractEntity {

    private String name;
    private String description;
    private String type;

}
