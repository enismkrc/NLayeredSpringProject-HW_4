package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {
	List<Language> getAll();

	void add(Language language) throws Exception;

	void delete(int id);

	void update(int id, Language updatedLanguage) throws Exception;

	Language getById(int id);

}
