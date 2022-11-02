package kodlamaio.devs.dataAccess.concretes;

import kodlamaio.devs.dataAccess.abstracts.LanguageRepository;
import kodlamaio.devs.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
    List<Language> languages;

    public InMemoryLanguageRepository() {
        languages = new ArrayList<>();
        languages.add(new Language(1,"Java"));
        languages.add(new Language(2,"C"));
        languages.add(new Language(3,"Python"));

    }

    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public Language getById(int id) {
        for (Language language:languages) {
            if (language.getId()==id){
                return language;
            }

        }
        return null;
    }

    @Override
    public void add(Language language) {
        languages.add(language);

    }

    @Override
    public void update(Language language,int id) {
        getById(id).setName(language.getName());

    }

    @Override
    public void delete(int id) {
        languages.remove(getById(id));


    }
}
