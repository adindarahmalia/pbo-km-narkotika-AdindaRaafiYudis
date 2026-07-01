package controllerfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import model.KnowledgeRepository;
import model.PutusanCsvLoader;
import model.StatistikPutusan;

public class DashboardController {
    @FXML
    private Label lblTotalPutusan;

    @FXML
    private Label lblRataVonis;

    @FXML
    private Label lblJenisTerbanyak;

    private KnowledgeRepository repository;

    @FXML
    public void initialize() {
        repository = new KnowledgeRepository();

        PutusanCsvLoader.loadFromCsv(
                "data/putusan_narkotika.csv",
                repository
        );
        var data = repository.getDaftarSemua();
        lblTotalPutusan.setText(String.valueOf(StatistikPutusan.totalPutusan(data)));
        lblRataVonis.setText(String.format("%.2f Bulan", StatistikPutusan.rataRataVonis(data)));
        lblJenisTerbanyak.setText(StatistikPutusan.jenisNarkotikaTerbanyak(data));

    }
}
