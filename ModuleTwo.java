/*
 * Name: Anna Hoerschgen
 * Date: Febuary 6, 2025
 * Filename: ModuleTwo.java
 * Assignment: Simple Web Browser in JavaFX
 */

// Imports
import java.net.URL;

public class ModuleTwo implements Initializable {
    @FXML
    private WebView webView;

    @FXML
    private TextField textField;

    private WebEngine engine;

    private String homePage;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //
        engine = webView.getEngine();
        homePage = "www.google.com";
        textField.setText(homePage);
        loadPage();
    }

    public void loadPage() {
        //
        // engine.load("http://www.google.com");
        engine.load("http://"+textField.getText());
    }

    public void refreshPage() {
        // TODO: complete tutorial
    }
}