package kodlamaio.devs.business.abstracts;

import kodlamaio.devs.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    List<Language> getAll();
    Language getById(int id);
    void add(Language language) throws Exception;
    void update(Language language,int id) throws Exception;
    void delete(int id) throws Exception;
}
