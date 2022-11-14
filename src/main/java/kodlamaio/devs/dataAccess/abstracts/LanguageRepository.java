package kodlamaio.devs.dataAccess.abstracts;

import kodlamaio.devs.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language,Integer> {
    boolean existsByName(String name);
}
