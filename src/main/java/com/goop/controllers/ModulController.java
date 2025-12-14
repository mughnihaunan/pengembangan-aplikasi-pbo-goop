package com.goop.controllers;

import com.goop.data.DataStore;
import com.goop.models.Modul;
import com.goop.utils.SceneManager;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

/**
 * Controller untuk Modul Scene
 * Menampilkan daftar modul pembelajaran
 */
public class ModulController {

    @FXML
    private VBox modulListContainer;

    @FXML
    private VBox modulDetailView;

    @FXML
    private Text detailJudul;

    @FXML
    private Text detailKonten;

    @FXML
    private ScrollPane scrollDetail;

    private DataStore dataStore;

    public void initialize() {
        dataStore = DataStore.getInstance();
        loadModulList();
    }

    private void loadModulList() {
        modulListContainer.getChildren().clear();

        List<Modul> modulList = dataStore.getAllModul();

        if (modulList.isEmpty()) {
            Label emptyLabel = new Label("Belum ada modul tersedia.");
            emptyLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #7f8c8d;");
            modulListContainer.getChildren().add(emptyLabel);
            return;
        }

        for (Modul modul : modulList) {
            VBox card = createModulCard(modul);
            modulListContainer.getChildren().add(card);
        }
    }

    private VBox createModulCard(Modul modul) {
        VBox card = new VBox(10);
        card.getStyleClass().add("card");
        card.setPadding(new Insets(15));

        // Judul
        Text judul = new Text(modul.getJudul());
        judul.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Topik
        Label topik = new Label("📚 Topik: " + modul.getTopik());
        topik.setStyle("-fx-font-size: 13px; -fx-text-fill: #3498db;");

        // Button
        Button btnBaca = new Button("📖 Baca Modul");
        btnBaca.getStyleClass().add("btn-primary");
        btnBaca.setOnAction(e -> showModulDetail(modul));

        card.getChildren().addAll(judul, topik, btnBaca);
        return card;
    }

    private void showModulDetail(Modul modul) {
        detailJudul.setText(modul.getJudul());
        detailKonten.setText(modul.getKonten());

        modulListContainer.setVisible(false);
        modulListContainer.setManaged(false);

        modulDetailView.setVisible(true);
        modulDetailView.setManaged(true);
    }

    @FXML
    private void handleBackToList() {
        modulDetailView.setVisible(false);
        modulDetailView.setManaged(false);

        modulListContainer.setVisible(true);
        modulListContainer.setManaged(true);
    }

    @FXML
    private void handleBack() {
        SceneManager.loadScene("dashboard.fxml");
    }
}
