package controllerfx;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import model.KnowledgeRepository;
import model.Putusan;

public class TambahPutusanController {

    private KnowledgeRepository repository;

    @FXML private TextField txtNomorPerkara;
    @FXML private ComboBox<String> cbPengadilan;
    @FXML private DatePicker dpTanggal;

    @FXML private TextField txtNama;
    @FXML private TextField txtUmur;
    @FXML private ComboBox<String> cbJenisKelamin;
    @FXML private TextField txtPekerjaan;

    @FXML private ComboBox<String> cbJenis;
    @FXML private TextField txtBerat;

    @FXML private TextField txtPasal;
    @FXML private ComboBox<String> cbPeran;

    @FXML private TextField txtVonis;
    @FXML private TextField txtDenda;
    @FXML private TextField txtHakim;

    @FXML private Button btnSimpan;
    @FXML private Button btnReset;
    @FXML private Button btnKembali;

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

        if (!validasiForm()) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText(null);
            alert.setContentText("Semua data harus diisi.");

            alert.showAndWait();
            return;
        }
        try {
            Putusan putusan = new Putusan(
                    txtNomorPerkara.getText(),
                    cbPengadilan.getValue(),
                    dpTanggal.getValue().toString(),
                    txtNama.getText(),
                    Integer.parseInt(txtUmur.getText()),
                    cbJenisKelamin.getValue(),
                    txtPekerjaan.getText(),
                    cbJenis.getValue(),
                    Double.parseDouble(txtBerat.getText()),
                    txtPasal.getText(),
                    cbPeran.getValue(),
                    Integer.parseInt(txtVonis.getText()),
                    Double.parseDouble(txtDenda.getText()),
                    txtHakim.getText()
            );

            repository.simpan(putusan);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Berhasil");
            alert.setHeaderText(null);
            alert.setContentText("Data putusan berhasil disimpan.");
            alert.showAndWait();

            resetForm();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Salah");
            alert.setHeaderText(null);
            alert.setContentText("Umur, Berat, Vonis, dan Denda harus berupa angka.");
            alert.showAndWait();

        } catch (IllegalArgumentException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data Tidak Valid");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void handleReset() {
        resetForm();
    }

    private boolean validasiForm() {

        if (txtNomorPerkara.getText().isBlank()) return false;
        if (cbPengadilan.getValue() == null) return false;
        if (dpTanggal.getValue() == null) return false;

        if (txtNama.getText().isBlank()) return false;
        if (txtUmur.getText().isBlank()) return false;
        if (cbJenisKelamin.getValue() == null) return false;
        if (txtPekerjaan.getText().isBlank()) return false;

        if (cbJenis.getValue() == null) return false;
        if (txtBerat.getText().isBlank()) return false;

        if (txtPasal.getText().isBlank()) return false;
        if (cbPeran.getValue() == null) return false;

        if (txtVonis.getText().isBlank()) return false;
        if (txtDenda.getText().isBlank()) return false;
        if (txtHakim.getText().isBlank()) return false;

        return true;
    }

    private void resetForm() {

        txtNomorPerkara.clear();

        cbPengadilan.getSelectionModel().clearSelection();

        dpTanggal.setValue(null);

        txtNama.clear();
        txtUmur.clear();

        cbJenisKelamin.getSelectionModel().clearSelection();

        txtPekerjaan.clear();

        cbJenis.getSelectionModel().clearSelection();

        txtBerat.clear();

        txtPasal.clear();

        cbPeran.getSelectionModel().clearSelection();

        txtVonis.clear();

        txtDenda.clear();

        txtHakim.clear();
    }
}