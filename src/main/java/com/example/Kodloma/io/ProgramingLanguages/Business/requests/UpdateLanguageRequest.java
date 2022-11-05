package com.example.Kodloma.io.ProgramingLanguages.Business.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguageRequest {

    public int id;
    public String name;


}
