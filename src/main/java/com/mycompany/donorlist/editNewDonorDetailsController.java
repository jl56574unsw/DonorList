/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.donorlist;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author josephli
 */
public class editNewDonorDetailsController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button save;

    @FXML
    private TextField EfirstName;

    @FXML
    private TextField ElastName;

    @FXML
    private TextField EdateOfBirth;

    @FXML
    private TextField Egender;

    @FXML
    private TextField EbloodType;

    @FXML
    private TextField EemailAddress;

    @FXML
    private TextField EmobileNumber;

    @FXML
    private TextField EhomeAddress;

    @FXML
    private TextField Enotes;

    @FXML
    TextField EnumberBlood;

    @FXML
    TextField EbloodDateTime;

    @FXML
    TextField EnumberPlasma;

    @FXML
    TextField EplasmaDateTime;

    @FXML
    private Button minusBlood;

    @FXML
    private Button plusBlood;

    @FXML
    private Button minusPlasma;

    @FXML
    private Button plusPlasma;

    @FXML
    private void actionAfterSaveButton(ActionEvent event) throws IOException {

        String XfirstName = EfirstName.getText();
        String XlastName = ElastName.getText();
        String XdateOfBirth = EdateOfBirth.getText();
        String Xgender = Egender.getText();
        String XbloodType = EbloodType.getText();
        String XemailAddress = EemailAddress.getText();
        String XmobileNumber = EmobileNumber.getText();
        String XhomeAddress = EhomeAddress.getText();
        String Xnotes = Enotes.getText();
        int Xblood = Integer.valueOf(EnumberBlood.getText());
        int Xplasma = Integer.valueOf(EnumberPlasma.getText());
        String Xblooddatetime = EbloodDateTime.getText();
        String Xplasmadatetime = EplasmaDateTime.getText();

        FXMLLoader load = new FXMLLoader(getClass().getResource("masterDetailScreen.fxml"));
        root = load.load();

        masterDetailScreenController masterController = load.getController();
        masterController.displayDonorDetails(XfirstName, XlastName, XdateOfBirth, Xgender, XbloodType, XemailAddress, XmobileNumber, XhomeAddress, Xnotes, Xblood, Xplasma, Xblooddatetime, Xplasmadatetime);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.setTitle("Donor List");
        stage.show();

        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        masterController.bloodDateTime.setText(dateTime.format(now));
        masterController.plasmaDateTime.setText(dateTime.format(now));

    }

    @FXML
    private void plusBlood(ActionEvent event) throws IOException {
        String text = EnumberBlood.getText();
        int count = Integer.parseInt(text);
        count++;
        String numAfterEdit = Integer.toString(count);
        EnumberBlood.setText(numAfterEdit);

        FXMLLoader load = new FXMLLoader(getClass().getResource("masterDetailScreen.fxml"));
        root = load.load();
        masterDetailScreenController mainController = load.getController();

        mainController.numberBlood.setText(numAfterEdit);
    }

    @FXML
    private void minusBlood(ActionEvent event) throws IOException {
        String text = EnumberBlood.getText();
        int count = Integer.parseInt(text);
        count--;
        String numAfterEdit = Integer.toString(count);
        EnumberBlood.setText(numAfterEdit);

        FXMLLoader load = new FXMLLoader(getClass().getResource("masterDetailScreen.fxml"));
        root = load.load();
        masterDetailScreenController mainController = load.getController();

        mainController.numberBlood.setText(numAfterEdit);
    }

    @FXML
    private void plusPlasma(ActionEvent event) throws IOException {
        String text = EnumberPlasma.getText();
        int count = Integer.parseInt(text);
        count++;
        String numAfterEdit = Integer.toString(count);
        EnumberPlasma.setText(numAfterEdit);

        FXMLLoader load = new FXMLLoader(getClass().getResource("masterDetailScreen.fxml"));
        root = load.load();
        masterDetailScreenController mainController = load.getController();

        mainController.numberPlasma.setText(numAfterEdit);
    }

    @FXML
    private void minusPlasma(ActionEvent event) throws IOException {
        String text = EnumberPlasma.getText();
        int count = Integer.parseInt(text);
        count--;
        String numAfterEdit = Integer.toString(count);
        EnumberPlasma.setText(numAfterEdit);

        FXMLLoader load = new FXMLLoader(getClass().getResource("masterDetailScreen.fxml"));
        root = load.load();
        masterDetailScreenController mainController = load.getController();

        mainController.numberPlasma.setText(numAfterEdit);

    }

    public void showCurrentDetails(String fname, String lname, String dob, String lgender, String lbloodtype, String lemailaddress, String mobile, String haddress, String lnotes, int lnumberblood, int lnumberplasma, String lblooddatetime, String lplasmadatetime) {

        EfirstName.setText(fname);
        ElastName.setText(lname);
        EdateOfBirth.setText(dob);
        Egender.setText(lgender);
        EbloodType.setText(lbloodtype);
        EemailAddress.setText(lemailaddress);
        EmobileNumber.setText(mobile);
        EhomeAddress.setText(haddress);
        Enotes.setText(lnotes);
        EnumberBlood.setText(String.valueOf(lnumberblood));
        EnumberPlasma.setText(String.valueOf(lnumberplasma));
        EbloodDateTime.setText(lblooddatetime);
        EplasmaDateTime.setText(lplasmadatetime);

    }

}
