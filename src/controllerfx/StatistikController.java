package controllerfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;
import java.util.Map;

import model.KnowledgeRepository;
import model.StatistikPutusan;

public class StatistikController {

    @FXML
    private Label lblJenisTerbanyak;

    @FXML
    private PieChart pieChart;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private TextArea txtRingkasan;

    private KnowledgeRepository repository;

    @FXML
    public void initialize() {
        repository = SharedRepository.getRepository();
        var data = repository.getDaftarSemua();
        lblJenisTerbanyak.setText(StatistikPutusan.jenisNarkotikaTerbanyak(data));
        Map<String, Integer> distribusi = StatistikPutusan.distribusiJenisNarkotika(data);
        pieChart.getData().clear();
        for (Map.Entry<String, Integer> entry : distribusi.entrySet()) {
            pieChart.getData().add(new PieChart.Data(entry.getKey(), entry.getValue()));
        }
        barChart.getData().clear();

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Jumlah Putusan");

        for (Map.Entry<String, Integer> entry : distribusi.entrySet()) {
            series.getData().add(
                    new XYChart.Data<>(
                            entry.getKey(), entry.getValue()
                    )
            );
        }
        barChart.getData().add(series);

        String ringkasan =
                "=== RINGKASAN STATISTIK ===\n\n" +
                        "Total Putusan           : " + StatistikPutusan.totalPutusan(data) + "\n" +
                        "Rata-Rata Vonis         : " + String.format("%.2f", StatistikPutusan.rataRataVonis(data)) + " Bulan\n" +
                        "Rata-Rata Denda         : Rp " + String.format("%.0f", StatistikPutusan.rataRataDenda(data)) + "\n" +
                        "Jenis Terbanyak         : " + StatistikPutusan.jenisNarkotikaTerbanyak(data) + "\n" +
                        "Jumlah Kategori         : " + distribusi.size();

        txtRingkasan.setText(ringkasan);

    }

}