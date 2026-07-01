package controllerfx;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import model.KnowledgeRepository;
import model.Putusan;


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

    @FXML
    private ComboBox<String> cbPengadilan;

    @FXML
    private ComboBox<String> cbJenis;

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

        cbPengadilan.setItems(FXCollections.observableArrayList(
                "Semua",
                "Pengadilan Negeri Malang",
                "Pengadilan Negeri Surabaya",
                "Pengadilan Negeri Jakarta Selatan",
                "Pengadilan Negeri Bandung",
                "Pengadilan Negeri Semarang"
        ));

        cbJenis.setItems(FXCollections.observableArrayList(
                "Semua",
                "Sabu-sabu",
                "Ganja",
                "Ekstasi",
                "Heroin",
                "Kokain"
        ));

        cbPengadilan.getSelectionModel().selectFirst();
        cbJenis.getSelectionModel().selectFirst();

    }
    @FXML
    private void handleCari() {
        String keyword = txtSearch.getText().trim();

        if (keyword.isEmpty()) {
            data.setAll(repository.getDaftarSemua());
            return;
        }

        Putusan hasilNomor = repository.cariByNomor(keyword);

        if (hasilNomor != null) {
            data.setAll(hasilNomor);
            return;
        }
        data.setAll(repository.cariByNama(keyword));
    }
    @FXML
    private void handleFilterPengadilan() {

        String pengadilan = cbPengadilan.getValue();

        if (pengadilan == null || pengadilan.equals("Semua")) {
            data.setAll(repository.getDaftarSemua());
            return;
        }
        data.setAll(repository.filterByPengadilan(pengadilan));
    }
    @FXML
    private void handleFilterJenis() {
        String jenis = cbJenis.getValue();

        if (jenis == null || jenis.equals("Semua")) {
            data.setAll(repository.getDaftarSemua());
            return;
        }
        data.setAll(repository.filterByJenisNarkotika(jenis));
    }
    @FXML
    private void handleRefresh() {
        txtSearch.clear();

        cbPengadilan.getSelectionModel().select("Semua");
        cbJenis.getSelectionModel().select("Semua");

        data.setAll(repository.getDaftarSemua());
    }
    @FXML
    private void handleDetail() {
        Putusan putusan = tableRepository.getSelectionModel().getSelectedItem();

        if(putusan == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText(null);
            alert.setContentText("Silahkan pilih data putusan terlebih dahulu");
            alert.showAndWait();

            return;
        }
        tampilkanDetail(putusan);
    }
    private void tampilkanDetail(Putusan p) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Detail Putusan");
        alert.setHeaderText("Nomor Perkara : " + p.getNomorPerkara());

        alert.setContentText(
                "Pengadilan : " + p.getPengadilan() + "\n\n" +
                        "Tanggal Putusan : " + p.getTanggalPutusan() + "\n\n" +
                        "Nama Terdakwa : " + p.getNamaTerdakwa() + "\n" +
                        "Umur : " + p.getUmurTerdakwa() + "tahun\n" +
                        "Jenis Kelamin : " + p.getJenisKelamin() + "\n" +
                        "Pekerjaan : " + p.getPekerjaan() + "\n\n" +
                        "Jenis Narkotika : " + p.getJenisNarkotika() + "\n" +
                        "Berat Barang Bukti : " + p.getBeratBarangBukti() + "gram\n\n" +
                        "Pasal : " + p.getPasalDilanggar() + "\n" +
                        "Peran : " + p.getPeranTerdakwa() + "\n\n" +
                        "Vonis : " + p.getVonisHukuman() + "bulan\n" +
                        "Denda : " + p.getVonisDenda() + "\n\n" +
                        "Hakim : " + p.getNamaHakim()
        );
        alert.showAndWait();
    }
    @FXML
    private void handleHapus() {
        Putusan putusan = tableRepository.getSelectionModel().getSelectedItem();

        if(putusan == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText(null);
            alert.setContentText("Silahkan pilih data putusan yang akan dihapus.");
            alert.showAndWait();

            return;
        }

        Alert konfirmasi = new Alert(Alert.AlertType.CONFIRMATION);
        konfirmasi.setTitle("Konfirmasi");
        konfirmasi.setHeaderText(null);
        konfirmasi.setContentText("Apakah anda yakin ingin menghapus data ini?");

        konfirmasi.showAndWait();
    }
}
