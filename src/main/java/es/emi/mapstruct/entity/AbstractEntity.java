package es.emi.mapstruct.entity;


import lombok.Data;

import java.time.ZonedDateTime;

@Data
public abstract class AbstractEntity {

    private Long id;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private Boolean deleted;
    private Boolean active;

}
