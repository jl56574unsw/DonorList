/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.donorlist;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author josephli
 */
public class masterDetailScreenController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button createNewDonor;

    @FXML
    private Button editDetails;

    @FXML
    private ListView<String> listOfDonors;

    @FXML
    private Text firstName;

    @FXML
    private Text lastName;

    @FXML
    private Text dateOfBirth;

    @FXML
    private Text gender;

    @FXML
    private Text bloodType;

    @FXML
    private Text emailAddress;

    @FXML
    private Text mobileNumber;

    @FXML
    private Text homeAddress;

    @FXML
    private Text notes;

    @FXML
    Label numberBlood;

    @FXML
    Label bloodDateTime;

    @FXML
    Label numberPlasma;

    @FXML
    Label plasmaDateTime;

    String[] donors = {"John Smith", "George Conroy", "Tom Cain", "Arthur Jenkins"};
    String[] textFirstName = {"John", "George", "Tom", "Arthur"};
    String[] textLastName = {"Smith", "Conroy", "Cain", "Jenkins"};
    String[] textDateOfBirth = {"17th of Jan, 1970", "28th of Mar, 2000", "14th of July, 2001", "1st of Feb, 1999"};
    String[] textGender = {"Female", "Male", "Male", "Male"};
    String[] textBloodType = {"A", "B+", "O", "O"};
    String[] textEmailAddress = {"johnsmith99@gmail.com", "gconroy8272@outlook.com", "tomcain2398@gmail.com", "AJ4299@gmail.com"};
    String[] textMobileNumber = {"0493829383", "0453627363", "0472635109", "0404726482"};
    String[] textHomeAddress = {"200 George Street, Sydney, 2000", "1 Jason Street, Hornsby, 2182", "17 Roy Watts Ave, Glenfield, 2167", "187 Macquarie Street, Sydney, 2000"};
    String[] textNotes = {"has a phobia of needles, need to cover eyes when injecting needle", "big blood vessels, easy to inject", "hard to find vessels, need experienced staff to inject needle", "needs a lot of candy afterwards"};
    int[] textNumberBlood = {17, 1, 2, 9};
    int[] textNumberPlasma = {2, 3, 5, 11};
    String[] textBloodDateTime = {"15:27 10/01/2022", "10:01 11/03/2022", "9:41 27/04/2022", "10:57 31/01/2022"};
    String[] textPlasmaDateTime = {"15:27 20/01/2022", "10:01 01/03/2022", "9:41 17/04/2022", "10:57 15/01/2022"};

    private final ArrayList<String> display = new ArrayList();
    private final ArrayList<String> donorList = new ArrayList();

    public void displayDonorDetails(String XfirstName, String XlastName, String XdateOfBirth, String Xgender, String Xbloodtype, String XemailAddress, String XmobileNumber, String XhomeAddress, String Xnotes, int Xblood, int Xplasma, String Xblooddatetime, String Xplasmadatetime) {

        display.add(XfirstName);
        display.add(XlastName);
        display.add(XdateOfBirth);
        display.add(Xgender);
        display.add(Xbloodtype);
        display.add(XemailAddress);
        display.add(XmobileNumber);
        display.add(XhomeAddress);
        display.add(Xnotes);
        display.add(String.valueOf(Xblood));
        display.add(String.valueOf(Xplasma));
        display.add(Xblooddatetime);
        display.add(Xplasmadatetime);
        donorList.add(XfirstName + " " + XlastName);

        for (int i = 0; i < display.size(); i = i + 13) {
            firstName.setText(display.get(i));
            lastName.setText(display.get(i + 1));
            listOfDonors.getItems().add(donorList.get(i));
            dateOfBirth.setText(display.get(i + 2));
            gender.setText(display.get(i + 3));
            bloodType.setText(display.get(i + 4));
            emailAddress.setText(display.get(i + 5));
            mobileNumber.setText(display.get(i + 6));
            homeAddress.setText(display.get(i + 7));
            notes.setText(display.get(i + 8));
            numberBlood.setText(display.get(i + 9));
            numberPlasma.setText(display.get(i + 10));
            bloodDateTime.setText(display.get(i + 11));
            plasmaDateTime.setText(display.get(i + 12));
        }
        System.out.println(display.toString());

    }

    @FXML
    private void editDetails(ActionEvent event) throws IOException {
        FXMLLoader load = new FXMLLoader(getClass().getResource("editNewDonorDetails.fxml"));
        root = load.load();

        editNewDonorDetailsController theController = load.getController();

        int numberBloodInt = Integer.valueOf(numberBlood.getText());

        int numberPlasmaInt = Integer.valueOf(numberPlasma.getText());

        theController.showCurrentDetails(firstName.getText(), lastName.getText(), dateOfBirth.getText(), gender.getText(), bloodType.getText(), emailAddress.getText(), mobileNumber.getText(), homeAddress.getText(), notes.getText(), numberBloodInt, numberPlasmaInt, bloodDateTime.getText(), plasmaDateTime.getText());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.setTitle("Edit Donor Details");
        stage.show();

    }

    @FXML
    private void createNewDonor(ActionEvent event) throws IOException {
        FXMLLoader load = new FXMLLoader(getClass().getResource("editNewDonorDetails.fxml"));
        root = load.load();

        editNewDonorDetailsController editController = load.getController();
        editController.EnumberBlood.setText("0");
        editController.EnumberPlasma.setText("0");

        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        editController.EbloodDateTime.setText(dateTime.format(now));
        editController.EplasmaDateTime.setText(dateTime.format(now));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1920, 1080);
        stage.setScene(scene);
        stage.setTitle("Add New Donor Details");
        stage.show();
    }

    @FXML
    public void selectSpecificDonor() {
        int ID = listOfDonors.getSelectionModel().getSelectedIndex();
        for (int i = 0; i < 5; i++) {
            if (i == ID) {
                firstName.setText(textFirstName[i]);
                lastName.setText(textLastName[i]);
                dateOfBirth.setText(textDateOfBirth[i]);
                gender.setText(textGender[i]);
                bloodType.setText(textBloodType[i]);
                emailAddress.setText(textEmailAddress[i]);
                mobileNumber.setText(textMobileNumber[i]);
                homeAddress.setText(textHomeAddress[i]);
                notes.setText(textNotes[i]);
                numberBlood.setText(String.valueOf(textNumberBlood[i]));
                numberPlasma.setText(String.valueOf(textNumberPlasma[i]));
                bloodDateTime.setText(textBloodDateTime[i]);
                plasmaDateTime.setText(textPlasmaDateTime[i]);
            }
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        firstName.setText("");
        lastName.setText("");
        dateOfBirth.setText("");
        gender.setText("");
        bloodType.setText("");
        emailAddress.setText("");
        mobileNumber.setText("");
        homeAddress.setText("");
        notes.setText("");
        numberBlood.setText("");
        numberPlasma.setText("");
        bloodDateTime.setText("");
        plasmaDateTime.setText("");

        for (int i = 0; i < donors.length; i++) {
            listOfDonors.getItems().add(donors[i]);
        }

    }

}
