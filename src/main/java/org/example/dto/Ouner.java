package org.example.dto;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Ouner {
    private String firstName;
    private String lastName;
    private String middleName;
    private int birthday;
}
