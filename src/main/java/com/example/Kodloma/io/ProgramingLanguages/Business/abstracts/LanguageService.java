package com.example.Kodloma.io.ProgramingLanguages.Business.abstracts;

import com.example.Kodloma.io.ProgramingLanguages.Business.requests.CreateLanguageRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.DeleteLanguageRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.UpdateLanguageRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.responses.GetAllLanguagesResponses;
import com.example.Kodloma.io.ProgramingLanguages.Entities.Language;

import java.util.List;

public interface LanguageService {

    List<GetAllLanguagesResponses> GetAll();
    void add(CreateLanguageRequest createLanguageRequest) throws Exception;
    void delete(DeleteLanguageRequest deleteLanguageRequest);
    void update(UpdateLanguageRequest updateLanguageRequest) throws  Exception;





}
