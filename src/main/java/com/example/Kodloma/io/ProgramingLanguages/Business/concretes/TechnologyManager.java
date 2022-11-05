package com.example.Kodloma.io.ProgramingLanguages.Business.concretes;

import com.example.Kodloma.io.ProgramingLanguages.Business.abstracts.TechnologyService;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.CreateTechnologyRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.DeleteTechnologyRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.UpdateTechnologyRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.responses.GetAllTechnogiesRespponse;

import com.example.Kodloma.io.ProgramingLanguages.Entities.Language;
import com.example.Kodloma.io.ProgramingLanguages.Entities.Technology;
import com.example.Kodloma.io.ProgramingLanguages.dataAcsess.abstracts.LanguageRepository;
import com.example.Kodloma.io.ProgramingLanguages.dataAcsess.abstracts.TechnologyRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager  implements TechnologyService {


    private LanguageRepository languageRepository;
    private TechnologyRepository technologyRepository;

    public TechnologyManager(LanguageRepository languageRepository, TechnologyRepository technologyRepository) {
        this.languageRepository = languageRepository;
        this.technologyRepository = technologyRepository;
    }

    @Override
    public List<GetAllTechnogiesRespponse> getAllTechnologies() throws Exception {


            List<Technology> technologyList = technologyRepository.findAll();
            List<GetAllTechnogiesRespponse> getAllTechnogiesRespponseList = new ArrayList<>();
            for(Technology technology:technologyList){

                GetAllTechnogiesRespponse response = new GetAllTechnogiesRespponse();
                response.setTechnology_name(technology.getName());
                response.setLanguage_name(technology.getLanguage().getLanguageName());

                getAllTechnogiesRespponseList.add(response);

            }
            System.out.println(getAllTechnogiesRespponseList);
            return getAllTechnogiesRespponseList;

    }



    @Override
    public void addTech(CreateTechnologyRequest createTechnologyRequest) throws Exception {

        Language language=languageRepository.findById(createTechnologyRequest.getLanguage_id());

        Technology technology=new Technology();
        technology.setName(createTechnologyRequest.getName());
        technology.setLanguage(language);

        technologyRepository.save(technology);


    }

    @Override
    public void deleteTech(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {

         technologyRepository.deleteById(deleteTechnologyRequest.getId());

    }

    @Override
    public UpdateTechnologyRequest updatedTech(UpdateTechnologyRequest updateTechnologyRequest, int id) throws Exception {
       Technology technology = technologyRepository.findById(id)
               .orElseThrow(()->new RuntimeException("No technology found on this id"));

       technology.setName(updateTechnologyRequest.getName());
       technologyRepository.save(technology);


       return updateTechnologyRequest;

    }


    public boolean isExistTech(CreateTechnologyRequest createTechnologyRequest){

        List<Technology> technologies = new ArrayList<Technology>();
        technologies.addAll(technologyRepository.findAll());

        boolean control=false;
        for (Technology tch:technologies){
            if(tch.getName().equals(createTechnologyRequest.getName())){
                control=true;
            }

        }

        return control;


    }


    public boolean isExistProgramingLanguage(CreateTechnologyRequest createTechnologyRequest){

        List<Language> languages = new ArrayList<Language>();
        languages.addAll(languageRepository.findAll());

        boolean control=false;
        for (Language lng:languages){
            if(lng.getId()==createTechnologyRequest.getLanguage_id()){
               control=true;

            }

        }

        return control;


    }

}
