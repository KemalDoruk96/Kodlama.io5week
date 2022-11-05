package com.example.Kodloma.io.ProgramingLanguages.Controller;

import com.example.Kodloma.io.ProgramingLanguages.Business.abstracts.LanguageService;
import com.example.Kodloma.io.ProgramingLanguages.Business.abstracts.TechnologyService;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.CreateTechnologyRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.DeleteTechnologyRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.UpdateLanguageRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.UpdateTechnologyRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.responses.GetAllTechnogiesRespponse;
import com.example.Kodloma.io.ProgramingLanguages.Entities.Technology;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/technology")

public class TechnolgyController {


    private TechnologyService technologyService;
    private LanguageService languageService;

    public TechnolgyController(TechnologyService technologyService, LanguageService languageService) {
        this.technologyService = technologyService;
        this.languageService = languageService;
    }

    @GetMapping("/get-all-technolgies")
    public List<GetAllTechnogiesRespponse> getAll() throws Exception{
        return technologyService.getAllTechnologies();
    }

    @PostMapping("/add-technology")
    public void addTech(@RequestBody CreateTechnologyRequest createTechnologyRequest) throws Exception{
        technologyService.addTech(createTechnologyRequest);

    }

    @DeleteMapping("/delete-technology")
    public void deleteTech(@RequestBody DeleteTechnologyRequest deleteTechnologyRequest) throws Exception{
        technologyService.deleteTech(deleteTechnologyRequest);
    }

    @PutMapping("/{id}")
    public void updateTech(@RequestBody UpdateTechnologyRequest updateTechnologyRequest,@PathVariable int id) throws  Exception{
        technologyService.updatedTech(updateTechnologyRequest, id);
    }







}
