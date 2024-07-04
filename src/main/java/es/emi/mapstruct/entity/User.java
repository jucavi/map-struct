package es.emi.mapstruct.entity;


import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class User {

    private Long id;
    private String username;
    private String password;
    private ZonedDateTime createdAt;

}
