package kodlamaio.devs.business.abstracts;

import kodlamaio.devs.dto.requests.LanguageRequest;
import kodlamaio.devs.dto.responses.LanguageResponse;
import kodlamaio.devs.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    List<LanguageResponse> getAll();
    LanguageResponse getById(int id);
    void add(LanguageRequest language) throws Exception;
    void update(LanguageRequest language,int id) throws Exception;
    void delete(int id) throws Exception;
}
