package controllerfx;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.beans.property.ReadOnlyObjectWrapper;

import model.KnowledgeRepository;
import model.Putusan;
import model.PutusanCsvLoader;

public class RepositoryController {
    @FXML
    private TableView<Putusan> tableRepository;

    @FXML
    private TableColumn<Putusan, String> colNomorPerkara;

    @FXML
    private TableColumn<Putusan, String> colNamaTerdakwa;

    @FXML
    private TableColumn<Putusan, String> colJenis;

    @FXML
    private TableColumn<Putusan, Integer> colVonis;

    @FXML
    private TableColumn<Putusan, String> colPengadilan;

    @FXML
    private TableColumn<Putusan, Integer> colNo;

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnCari;

    private KnowledgeRepository repository;
    private ObservableList<Putusan> data;

    @FXML
    public void initialize() {
        repository = SharedRepository.getRepository();
        data = FXCollections.observableArrayList(repository.getDaftarSemua());
        colNomorPerkara.setCellValueFactory(new PropertyValueFactory<>("nomorPerkara"));
        colNamaTerdakwa.setCellValueFactory(new PropertyValueFactory<>("namaTerdakwa"));
        colJenis.setCellValueFactory(new PropertyValueFactory<>("jenisNarkotika"));
        colVonis.setCellValueFactory(new PropertyValueFactory<>("vonisHukuman"));
        colPengadilan.setCellValueFactory(new PropertyValueFactory<>("pengadilan"));
        colNo.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(
                tableRepository.getItems().indexOf(cellData.getValue()) + 1
        ));

        tableRepository.setItems(data);

    }
}
