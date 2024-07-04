package es.emi.mapstruct.dto;

import lombok.Data;

@Data
public abstract class AbstractDto {

    private Long id;
    private String createdAt;
    private String updatedAt;
    private Boolean deleted;
    private Boolean active;

}
