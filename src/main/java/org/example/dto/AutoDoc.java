package org.example.dto;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class AutoDoc {
    private String stateNum;
    private String ptc;
    private int ptcDate;
    private String ctc;
    private int ctcDate;
}
