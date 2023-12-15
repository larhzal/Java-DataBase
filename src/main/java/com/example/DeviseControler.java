package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class DeviseControler {
    DeviseDao deviseDao = new DeviseDao();

    @FXML
    private ComboBox<Devise> cmbDevise;
 
    @FXML
    private MenuButton deviseMenu;

    @FXML
    private TextField madText;

    @FXML
    private TextField montantText;

    @FXML
    private void initialize(){
    for (Devise dev : deviseDao.getAllDevise()) {
        cmbDevise.getItems().add(dev);
    }
    }

    @FXML
    void onClick(ActionEvent event) {
        Devise devise = cmbDevise.getSelectionModel().getSelectedItem();
        Double montant = Double.parseDouble(montantText.getText());
        Double montants = montant*devise.getTaux();
        madText.setText(""+montants);

    }
}
