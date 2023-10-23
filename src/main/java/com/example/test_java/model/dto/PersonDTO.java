package com.example.test_java.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDTO implements Serializable {

    private long id;

    private String firstName;

    private String username;

    private int gender;

    private int type;
}
