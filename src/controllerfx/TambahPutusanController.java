package controllerfx;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class TambahPutusanController {

    @FXML
    private TextField txtNomorPerkara;

    @FXML
    private ComboBox<String> cbPengadilan;

    @FXML
    private DatePicker dpTanggal;

    @FXML
    public void initialize() {
    }
}
