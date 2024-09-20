package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;

	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAll() {
		// TODO Auto-generated method stub
		return languageRepository.getAll();
	}

	@Override
	public void add(Language language) throws Exception {
		if (language.getName() == null || language.getName().trim().isEmpty()) {
			throw new Exception("İsim boş olamaz");
		}

		for (Language existingLangue : languageRepository.getAll()) {
			if (existingLangue.getName().equalsIgnoreCase(language.getName())) {
				throw new Exception("Bu programlama dili zaten mevcut: " + language.getName());
			}

		}

		languageRepository.add(language);

	}

	@Override
	public void delete(int id) {
		languageRepository.delete(id);

	}

	@Override
	public void update(int id, Language updatedLanguage) throws Exception {
		if (updatedLanguage.getName() == null || updatedLanguage.getName().trim().isEmpty()) {
			throw new Exception("İsim boş olamaz");
		}

		for (Language existingLanguage : languageRepository.getAll()) {
			if (existingLanguage.getName().equalsIgnoreCase(updatedLanguage.getName())
					&& existingLanguage.getId() != id) {
				throw new Exception("Bu programlama dili adı zaten kullanılıyor: " + updatedLanguage.getName());
			}
		}

		languageRepository.update(id, updatedLanguage);
	}

	@Override
	public Language getById(int id) {
		// TODO Auto-generated method stub
		return languageRepository.getById(id);
	}

}
