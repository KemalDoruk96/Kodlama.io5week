package com.example.Kodloma.io.ProgramingLanguages.Entities;


import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="languages")
public class Language{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="language_id")
    private int id;
    @Column(name="language_name")
    private String languageName;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "language_id")
    private Set<Technology> technologies;




}
