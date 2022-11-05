package com.example.Kodloma.io.ProgramingLanguages.Business.abstracts;

import com.example.Kodloma.io.ProgramingLanguages.Business.requests.CreateTechnologyRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.DeleteTechnologyRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.UpdateTechnologyRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.responses.GetAllTechnogiesRespponse;

import com.example.Kodloma.io.ProgramingLanguages.Entities.Language;
import com.example.Kodloma.io.ProgramingLanguages.Entities.Technology;

import java.util.List;

public interface TechnologyService {

    List<GetAllTechnogiesRespponse> getAllTechnologies () throws Exception;
    void addTech (CreateTechnologyRequest createTechnologyRequest) throws Exception;
    void deleteTech(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception ;

    UpdateTechnologyRequest updatedTech(UpdateTechnologyRequest updateTechnologyRequest,int id) throws Exception;





}
