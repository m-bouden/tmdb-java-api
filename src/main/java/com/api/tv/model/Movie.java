package com.api.tv.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "MOVIES")
@Getter @Setter @NoArgsConstructor
@Accessors(fluent = true)
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String status;
    private String language;
    private double voteAverage;
    private int voteCount;
    private boolean adult;

    @OneToMany(mappedBy = "id")
    private Set<Rating> ratings;
}
