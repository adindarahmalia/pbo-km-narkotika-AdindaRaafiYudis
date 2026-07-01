package controllerfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import javafx.application.Platform;

import model.KnowledgeRepository;
import model.StatistikPutusan;

public class DashboardController {
    @FXML
    private void handleRepository() {
        bukaHalaman("Repository.fxml");
    }

    @FXML
    private void handleTambahPutusan() {
        bukaHalaman("TambahPutusan.fxml");
    }

    @FXML
    private void handleStatistik() {
        bukaHalaman("Statistik.fxml");
    }

    @FXML
    private void handleKeluar() {
        Platform.exit();

    }

    @FXML
    private StackPane contentPane;

    @FXML
    private Label lblTotalPutusan;

    @FXML
    private Label lblRataVonis;

    @FXML
    private Label lblJenisTerbanyak;

    private KnowledgeRepository repository;

    @FXML
    public void initialize() {
        repository = SharedRepository.getRepository();
        refreshDashboard();
    }
    public void refreshDashboard() {
        var data = repository.getDaftarSemua();
        lblTotalPutusan.setText(String.valueOf(StatistikPutusan.totalPutusan(data)));
        lblRataVonis.setText(String.format("%.2f Bulan", StatistikPutusan.rataRataVonis(data)));
        lblJenisTerbanyak.setText(StatistikPutusan.jenisNarkotikaTerbanyak(data));
    }
    private void bukaHalaman(String namaFileFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/viewfx/" + namaFileFXML));
            Parent halaman = loader.load();
            contentPane.getChildren().clear();
            contentPane.getChildren().add(halaman);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
