package org.application.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    private int id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "from_planet_id")
    private String fromPlanetId;

    @Column(name = "to_planet_id")
    private String toPlanetId;
}
