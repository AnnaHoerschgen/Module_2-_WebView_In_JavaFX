/*
 * Name: Anna Hoerschgen
 * Date: Febuary 6, 2025
 * Filename: ModuleTwo.java
 * Assignment: Simple Web Browser in JavaFX
 */

// Imports
import java.net.URL;
import java.util.Observable;

public class ModuleTwo implements Initializable {
    @FXML
    private WebView webView;

    @FXML
    private TextField textField;

    private WebEngine engine;
    private WebHistory history;

    private String homePage;

    private double webZoom;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        engine = webView.getEngine();
        homePage = "www.google.com";
        textField.setText(homePage);
        webZoom = 1;
        loadPage();
    }

    public void loadPage() {
        engine.load("http://"+textField.getText());
    }

    public void refreshPage() {
        
        engine.reload();
    }

    public void zoomIn() {
        webZoom += 0.25;
        webView.setZoom(webZoom);
    }

    public void zoomOut() {
        webZoom -= 0.25;
        webView.setZoom(webZoom);
    }

    public void displayHistory() {
        history = engine.getHistory;
        ObservableList<WebHistory.Entry> entries = history.getEntries();

        for (WebHistory.Entry entry : entries) {
            // System.out.println(entry);
            System.out.println(entry.getUrl()+" "+entry.getLastVisitedDate());
        }
    }

    public void back() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(-1);
        textField.setText(entries.get(history.getCurrentIndex));
    }

    public void forward() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(1);
        textField.setText(entries.get(history.getCurrentIndex));
    }

    public void executeJS() {
        engine.executeScript("window.location = \"https://youtube.com\";");
    }
}