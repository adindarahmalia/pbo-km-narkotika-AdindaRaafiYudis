package controllerfx;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import model.KnowledgeRepository;
import model.Putusan;
import model.PutusanCsvLoader;

public class TambahPutusanController {

    private KnowledgeRepository repository;

    @FXML
    private TextField txtNomorPerkara;

    @FXML
    private ComboBox<String> cbPengadilan;

    @FXML
    private DatePicker dpTanggal;

    @FXML
    private TextField txtNama;

    @FXML
    private TextField txtUmur;

    @FXML
    private ComboBox<String> cbJenisKelamin;

    @FXML
    private TextField txtPekerjaan;

    @FXML
    private ComboBox<String> cbJenis;

    @FXML
    private TextField txtBerat;

    @FXML
    private TextField txtPasal;

    @FXML
    private ComboBox<String> cbPeran;

    @FXML
    private TextField txtVonis;

    @FXML
    private TextField txtDenda;

    @FXML
    private TextField txtHakim;

    @FXML
    private Button btnSimpan;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnKembali;

    @FXML
    public void initialize() {

        repository = SharedRepository.getRepository();

        cbPengadilan.setItems(FXCollections.observableArrayList(
                "Pengadilan Negeri Malang",
                "Pengadilan Negeri Surabaya",
                "Pengadilan Negeri Jakarta Selatan",
                "Pengadilan Negeri Bandung",
                "Pengadilan Negeri Semarang"
        ));

        cbJenisKelamin.setItems(FXCollections.observableArrayList(
                "Laki-laki",
                "Perempuan"
        ));

        cbJenis.setItems(FXCollections.observableArrayList(
                "Sabu-sabu",
                "Ganja",
                "Ekstasi",
                "Heroin",
                "Kokain"
        ));

        cbPeran.setItems(FXCollections.observableArrayList(
                "Pengguna",
                "Pengedar",
                "Kurir",
                "Produsen"
        ));
    }

    @FXML
    private void handleSimpan() {

        String nomorPerkara = txtNomorPerkara.getText();
        String pengadilan = cbPengadilan.getValue();
        String tanggal = dpTanggal.getValue().toString();

        String nama = txtNama.getText();
        int umur = Integer.parseInt(txtUmur.getText());
        String jenisKelamin = cbJenisKelamin.getValue();
        String pekerjaan = txtPekerjaan.getText();

        String jenis = cbJenis.getValue();
        double berat = Double.parseDouble(txtBerat.getText());

        String pasal = txtPasal.getText();
        String peran = cbPeran.getValue();

        int vonis = Integer.parseInt(txtVonis.getText());
        double denda = Double.parseDouble(txtDenda.getText());

        String hakim = txtHakim.getText();

        Putusan putusan = new Putusan(nomorPerkara, pengadilan, tanggal, nama, umur, jenisKelamin, pekerjaan, jenis, berat, pasal, peran, vonis, denda, hakim);
        repository.simpan(putusan);

        System.out.println("Total data: " + repository.getTotalData());


    }
    @FXML
    private void handleReset() {

    }
    @FXML
    private void handleKembali() {

    }
    @FXML
    private void handleCari() {

    }
    @FXML
    private void handleRefresh() {

    }
    @FXML
    private void handleDetail() {

    }
}