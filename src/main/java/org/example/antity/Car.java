package org.example.antity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private  String mark;
    @Column
    private  String model;
    @Column(name = "state_number")
    private  String stateNumber;
    @Column
    private int year;
}
