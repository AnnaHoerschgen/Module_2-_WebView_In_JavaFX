/*
 * Name: Anna Hoerschgen
 * Date: February 6, 2025
 * Filename: ModuleTwo.java
 * Assignment: Simple Web Browser in JavaFX
 */

// Required imports for JavaFX WebView and other functionalities
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

public class ModuleTwo implements Initializable {
    
    @FXML
    private WebView webView; // WebView component to display web pages

    @FXML
    private TextField textField; // TextField for entering the URL

    private WebEngine engine; // WebEngine to load and render web pages
    private WebHistory history; // WebHistory to track browsing history

    private String homePage; // Default home page URL
    private double webZoom; // Zoom level for the WebView

    // Initialize method called when the controller is loaded
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        engine = webView.getEngine(); // Get WebEngine instance from WebView
        homePage = "www.google.com"; // Set default homepage
        textField.setText(homePage); // Display homepage in text field
        webZoom = 1; // Default zoom level
        loadPage(); // Load the initial homepage
    }

    // Loads the page entered in the text field
    public void loadPage() {
        engine.load("http://" + textField.getText()); // Load the URL
    }

    // Reloads the current page
    public void refreshPage() {
        engine.reload();
    }

    // Zoom in by increasing zoom level
    public void zoomIn() {
        webZoom += 0.25;
        webView.setZoom(webZoom);
    }

    // Zoom out by decreasing zoom level
    public void zoomOut() {
        webZoom -= 0.25;
        webView.setZoom(webZoom);
    }

    // Displays browsing history in the console
    public void displayHistory() {
        history = engine.getHistory(); // Get browsing history
        ObservableList<WebHistory.Entry> entries = history.getEntries();

        for (WebHistory.Entry entry : entries) {
            System.out.println(entry.getUrl() + " " + entry.getLastVisitedDate()); // Print history entries
        }
    }

    // Navigates back in browsing history
    public void back() {
        history = engine.getHistory(); // Get browsing history
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(-1); // Go back one page
        textField.setText(entries.get(history.getCurrentIndex()).getUrl()); // Update text field
    }

    // Navigates forward in browsing history
    public void forward() {
        history = engine.getHistory(); // Get browsing history
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(1); // Go forward one page
        textField.setText(entries.get(history.getCurrentIndex()).getUrl()); // Update text field
    }

    // Executes a JavaScript command to navigate to YouTube
    public void executeJS() {
        engine.executeScript("window.location = \"https://youtube.com\";");
    }
}
