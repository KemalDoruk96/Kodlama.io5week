package com.example.Kodloma.io.ProgramingLanguages.Business.requests;

import com.example.Kodloma.io.ProgramingLanguages.Entities.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTechnologyRequest {

    private String name;
    private int language_id;



}
