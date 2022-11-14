package kodlamaio.devs.webApi.controllers;

import kodlamaio.devs.business.abstracts.LanguageService;
import kodlamaio.devs.dto.requests.LanguageRequest;
import kodlamaio.devs.dto.responses.LanguageResponse;
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
    public List<LanguageResponse> getall(){
        return languageService.getAll();
    }
    @GetMapping("/{id}")
    public LanguageResponse getbyid(@PathVariable(name="id") int id){
        return languageService.getById(id);
    }
    @PostMapping("/add")
    public void add(@RequestBody LanguageRequest languageRequest) throws Exception {
        languageService.add(languageRequest);
    }
    @PutMapping("/{id}")
    public void update(@RequestBody LanguageRequest languageRequest, @PathVariable int id) throws Exception{
        languageService.update(languageRequest,id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws Exception{
        languageService.delete(id);
    }
}
