package controllerfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import model.KnowledgeRepository;
import model.StatistikPutusan;

public class StatistikController {

    @FXML
    private Label lblJenisTerbanyak;

    private KnowledgeRepository repository;

    @FXML
    public void initialize() {

        repository = SharedRepository.getRepository();

        var data = repository.getDaftarSemua();

        lblJenisTerbanyak.setText(
                StatistikPutusan.jenisNarkotikaTerbanyak(data)
        );

    }

}