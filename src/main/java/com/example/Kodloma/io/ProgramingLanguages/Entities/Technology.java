package com.example.Kodloma.io.ProgramingLanguages.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Technologies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="technology_id")
    private int id;
    @Column(name="technology_name")
    private String name;


    @ManyToOne
    @JoinColumn(name="language_id")
    private Language language;







}
