package controllerfx;

import model.KnowledgeRepository;
import model.PutusanCsvLoader;

public class SharedRepository {
    private static final KnowledgeRepository repository  = new KnowledgeRepository();

    static {
        PutusanCsvLoader.loadFromCsv("data/putusan_narkotika.csv", repository);
    }
    public static KnowledgeRepository getRepository() {
        return repository;
    }
}
