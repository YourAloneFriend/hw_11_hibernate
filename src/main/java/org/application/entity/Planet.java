package org.application.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "planet")
public class Planet {

    @Id
    private String id;

    @Column
    private String name;


}
