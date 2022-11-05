package com.example.Kodloma.io.ProgramingLanguages.dataAcsess.abstracts;

import com.example.Kodloma.io.ProgramingLanguages.Entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {

       Language findById(int i);


}
