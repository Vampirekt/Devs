package kodlamaio.devs.business.concretes;

import kodlamaio.devs.business.abstracts.LanguageService;
import kodlamaio.devs.dataAccess.abstracts.LanguageRepository;
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
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public Language getById(int id) {
        return languageRepository.getById(id);
    }

    @Override
    public void add(Language language) throws Exception {
        isNameValid(language.getName());
        if (isIdExist(language.getId())){
            throw new Exception("id tekrar edemez");

        }



        languageRepository.add(language);

    }

    @Override
    public void update(Language language, int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("id bulunamadi");

        }

        languageRepository.update(language,id);

    }

    @Override
    public void delete(int id) throws Exception {
        if(!isIdExist(id)){
            throw new Exception("id bulunamadi");
        }
        languageRepository.delete(id);

    }
    private boolean isNameValid(String name) throws Exception {
        if(name.isBlank()){
            throw new Exception("isim bos olamaz");

        }
        for (Language language:getAll()
             ) {if (language.getName().equalsIgnoreCase(name)){
                 throw new Exception("isim tekrar edemez");
        }

        }
        return true;
    }
    private boolean isIdExist(int id){
        for (Language language:getAll()
             ) {if (language.getId()==id) {
                 return true;
        }

        }
    return false;
    }
}
