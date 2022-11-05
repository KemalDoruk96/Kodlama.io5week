package com.example.Kodloma.io.ProgramingLanguages.Business.concretes;

import com.example.Kodloma.io.ProgramingLanguages.Business.abstracts.LanguageService;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.CreateLanguageRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.DeleteLanguageRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.UpdateLanguageRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.responses.GetAllLanguagesResponses;
import com.example.Kodloma.io.ProgramingLanguages.Entities.Language;
import com.example.Kodloma.io.ProgramingLanguages.dataAcsess.abstracts.LanguageRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class LanguageManager implements LanguageService {


    private LanguageRepository languageRepository;





    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;

    }

    @Override
    public List<GetAllLanguagesResponses> GetAll() {

       return createGetAllResponses(languageRepository.findAll());



    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) throws Exception{

        Language language=new Language();
        language.setLanguageName(createLanguageRequest.getName());
        if(!isExistProgramingLanguage(language)){
            this.languageRepository.save(language);
        }
       else{

            throw new Exception("There is a language that contains this name");

        }


    }

    @Override
    public void delete(DeleteLanguageRequest deleteLanguageRequest) {

         languageRepository.deleteById(deleteLanguageRequest.getId());

    }

    @Override
    public void update( UpdateLanguageRequest updateLanguageRequest) throws Exception  {


           addUpdateLanguageRequest(updateLanguageRequest);


    }





    private List<GetAllLanguagesResponses> createGetAllResponses(List<Language> languages){

        List<GetAllLanguagesResponses> getAllLanguagesResponses=new ArrayList<>();
        for(Language lng:languages){
            GetAllLanguagesResponses getAllLanguagesResponse=new GetAllLanguagesResponses();
            getAllLanguagesResponse.setId(lng.getId());
            getAllLanguagesResponse.setName(lng.getLanguageName());

            getAllLanguagesResponses.add(getAllLanguagesResponse);

        }

        return getAllLanguagesResponses;



    }




    private void addUpdateLanguageRequest(UpdateLanguageRequest updateLanguageRequest) throws Exception{

        Language language= languageRepository.findById(updateLanguageRequest.getId());
        if(language==null){

            throw new Exception("Language does not exit");
        }

        language.setLanguageName(updateLanguageRequest.getName());
        this.languageRepository.save(language);


    }


    public boolean isExistProgramingLanguage(Language language){

        List<Language> languages = new ArrayList<Language>();
        languages.addAll(languageRepository.findAll());

        boolean control=false;
        for (Language lng:languages){
            if(lng.getLanguageName().equals(language.getLanguageName()) || lng.getId()==language.getId()){
                  control=true;
            }

        }

        return control;


    }









}
