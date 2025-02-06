/*
 * Name: Anna Hoerschgen
 * Date: Febuary 6, 2025
 * Filename: ModuleTwo.java
 * Assignment: Simple Web Browser in JavaFX
 */

// Imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ModuleTwo extends Application {

    // Create the WebView and TextField (address bar)
    WebView webView;
    TextField addressBar;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize WebView
        webView = new WebView();

        // Create an address bar for URL input
        addressBar = new TextField();
        addressBar.setPromptText("Enter URL...");

        // Create a button to load the page
        Button goButton = new Button("Go");
        goButton.setOnAction(e -> loadPage());

        // Create a layout (HBox) for the address bar and the Go button
        HBox hBox = new HBox(10, addressBar, goButton);

        // Create the main layout with WebView and the controls
        HBox mainLayout = new HBox(10, hBox, webView);

        // Set up the scene
        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Web Browser");
        primaryStage.show();
    }

    // Method to load the webpage
    private void loadPage() {
        String url = addressBar.getText();
        if (!url.isEmpty()) {
            // Prepend "http://" if the user doesn't include it
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "http://" + url;
            }
            webView.getEngine().load(url);
        }
    }

    Button backButton = new Button("Back");
    backButton.setOnAction(e -> webView.getEngine().executeScript("history.back()"));

    Button forwardButton = new Button("Forward");
    forwardButton.setOnAction(e -> webView.getEngine().executeScript("history.forward()"));
}