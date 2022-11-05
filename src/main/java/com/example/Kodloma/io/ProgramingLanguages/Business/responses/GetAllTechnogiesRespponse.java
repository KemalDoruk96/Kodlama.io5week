package com.example.Kodloma.io.ProgramingLanguages.Business.responses;

import com.example.Kodloma.io.ProgramingLanguages.Entities.Language;
import com.example.Kodloma.io.ProgramingLanguages.Entities.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechnogiesRespponse {

    private String technology_name;
    private String language_name;

}
