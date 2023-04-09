package org.example.antity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.AutoDoc;
import org.example.dto.Ouner;

import javax.persistence.*;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private  String mark;

    private  String model;

    private  String seria;

    private int year;
    @Embedded
    private Ouner ouner;
    @Embedded
    private AutoDoc autoDoc;
}
