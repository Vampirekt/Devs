package kodlamaio.devs.dataAccess.abstracts;

import kodlamaio.devs.entities.concretes.Language;

import java.util.List;

public interface LanguageRepository {
    List<Language> getAll();
    Language getById(int id);
    void add(Language language);
    void update(Language language,int id);
    void delete(int id);
}
