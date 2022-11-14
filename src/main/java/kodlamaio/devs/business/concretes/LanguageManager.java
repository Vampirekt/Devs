package kodlamaio.devs.business.concretes;

import kodlamaio.devs.business.abstracts.LanguageService;
import kodlamaio.devs.dataAccess.abstracts.LanguageRepository;
import kodlamaio.devs.dto.requests.LanguageRequest;
import kodlamaio.devs.dto.responses.LanguageResponse;
import kodlamaio.devs.entities.concretes.Language;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageManager implements LanguageService {

    LanguageRepository languageRepository;

    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<LanguageResponse> getAll() {
        List<Language> languages =languageRepository.findAll();
        return languages.stream()
                .map(language -> new LanguageResponse(language.getId(),language.getName()))
                .toList();

    }

    @Override
    public LanguageResponse getById(int id) {
        Language language = languageRepository.findById(id).get();
        return new LanguageResponse(language.getId(),language.getName());
    }

    @Override
    public void add(LanguageRequest languageRequest) throws Exception {
        isNameValid(languageRequest.getName());
        if(this.languageRepository.existsByName(languageRequest.getName())){
            throw new Exception("aynı isimde kayıt var");
        }
        Language language = new Language();
        language.setName(languageRequest.getName());
        languageRepository.save(language);

    }

    @Override
    public void update(LanguageRequest languageRequest, int id) throws Exception {
        if (!this.languageRepository.existsById(id)) {
            throw new Exception("id bulunamadi");

        }
        Language language = this.languageRepository.findById(id).get();
        language.setName(languageRequest.getName());
        languageRepository.save(language);

    }

    @Override
    public void delete(int id) throws Exception {
        if(!this.languageRepository.existsById(id)){
            throw new Exception("id bulunamadi");
        }
        languageRepository.deleteById(id);

    }
    private boolean isNameValid(String name) throws Exception {
        if(name.isBlank()){
            throw new Exception("isim bos olamaz");

        }
        return true;

    }
//    private boolean isIdExist(int id){
//        for (Language language:getAll()
//             ) {if (language.getId()==id) {
//                 return true;
//        }
//
//        }
//    return false;
//    }
}
