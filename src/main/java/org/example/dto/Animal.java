package org.example.dto;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int id;
    private  String name;
    private  String color;

}
