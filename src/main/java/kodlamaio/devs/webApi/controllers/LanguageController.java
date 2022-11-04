package kodlamaio.devs.webApi.controllers;

import kodlamaio.devs.business.abstracts.LanguageService;
import kodlamaio.devs.entities.concretes.Language;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/language")
public class LanguageController {
    private LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }
    @GetMapping("/getall")
    public List<Language> getall(){
        return languageService.getAll();
    }
    @GetMapping("/{id}")
    public Language getbyid(@PathVariable(name="id") int id){
        return languageService.getById(id);
    }
    @PostMapping("/add")
    public void add(@RequestBody Language language) throws Exception {
        languageService.add(language);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody Language language, int id) throws Exception{
        languageService.update(language,id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws Exception{
        languageService.delete(id);
    }
}
