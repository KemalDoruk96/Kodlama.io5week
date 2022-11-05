package com.example.Kodloma.io.ProgramingLanguages.Controller;


import com.example.Kodloma.io.ProgramingLanguages.Business.abstracts.LanguageService;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.CreateLanguageRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.DeleteLanguageRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.requests.UpdateLanguageRequest;
import com.example.Kodloma.io.ProgramingLanguages.Business.responses.GetAllLanguagesResponses;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation
@RequestMapping("/api/languages")
public class LanguageController {

    private LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall-languages")
    public List<GetAllLanguagesResponses> getAll(){
        return languageService.GetAll();

    }

    @PostMapping ("/add-language")
    public void add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception{
        languageService.add(createLanguageRequest);

    }

    @DeleteMapping("/delete-language")
    public void delete(@RequestBody DeleteLanguageRequest deleteLanguageRequest){

        languageService.delete(deleteLanguageRequest);

    }

    @PutMapping("/update-language")
    public void update(@NotNull @RequestBody UpdateLanguageRequest updateLanguageRequest) throws Exception{

        languageService.update(updateLanguageRequest);

    }






}
