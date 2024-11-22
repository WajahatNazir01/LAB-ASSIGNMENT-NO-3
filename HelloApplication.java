package com.example.demo2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.layout.Region;

import java.io.File;

public class HelloApplication extends Application {

 @Override
 public void start(Stage primaryStage) {


  Image bannerImage = new Image(this.getClass().getResource("/banner2.png").toExternalForm());
  ImageView imageView = new ImageView(bannerImage);
  imageView.setFitWidth(1000);
  imageView.setFitHeight(200);


  GridPane gridPane = new GridPane();
  gridPane.setVgap(15);
  gridPane.setHgap(15);
  gridPane.setPadding(new javafx.geometry.Insets(15));


  Label nameLabel = new Label("Name of Student:");
  TextField nameField = new TextField();
  Label fatherNameLabel = new Label("Father Name:");
  TextField fatherNameField = new TextField();
  Label cnicLabel = new Label("CNIC:");
  TextField cnicField = new TextField();
  Label dobLabel = new Label("Date of Birth:");
  DatePicker dobPicker = new DatePicker();
  Label genderLabel = new Label("Gender:");
  RadioButton maleRadioButton = new RadioButton("Male");
  RadioButton femaleRadioButton = new RadioButton("Female");
  ToggleGroup genderGroup = new ToggleGroup();
  maleRadioButton.setToggleGroup(genderGroup);
  femaleRadioButton.setToggleGroup(genderGroup);
  Label cityLabel = new Label("Select City:");
  ComboBox<String> cityComboBox = new ComboBox<>();
  cityComboBox.getItems().addAll("Jhang", "Lahore", "Karachi", "Multan", "Others");

  gridPane.add(nameLabel, 0, 0);
  gridPane.add(nameField, 1, 0);
  gridPane.add(fatherNameLabel, 0, 1);
  gridPane.add(fatherNameField, 1, 1);
  gridPane.add(cnicLabel, 0, 2);
  gridPane.add(cnicField, 1, 2);
  gridPane.add(dobLabel, 0, 3);
  gridPane.add(dobPicker, 1, 3);
  gridPane.add(genderLabel, 0, 4);
  gridPane.add(maleRadioButton, 1, 4);
  gridPane.add(femaleRadioButton, 2, 4);
  gridPane.add(cityLabel, 0, 5);
  gridPane.add(cityComboBox, 1, 5);


  nameField.setStyle("-fx-background-color: #E6F7FF; -fx-border-color: #1E90FF; -fx-padding: 8px; -fx-font-family: 'Times New Roman';");
  fatherNameField.setStyle("-fx-background-color: #E6F7FF; -fx-border-color: #1E90FF; -fx-padding: 8px; -fx-font-family: 'Times New Roman';");
  cnicField.setStyle("-fx-background-color: #E6F7FF; -fx-border-color:#1E90FF; -fx-padding: 8px; -fx-font-family: 'Times New Roman';");
  cityComboBox.setStyle("-fx-background-color: #E6F7FF; -fx-border-color: #1E90FF; -fx-padding: 8px; -fx-font-family: 'Times New Roman';");
  dobPicker.setStyle("-fx-background-color: #E6F7FF; -fx-border-color: #1E90FF; -fx-padding: 8px; -fx-font-family: 'Times New Roman';");

  nameLabel.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: rgba(113,0,130,0.86);");
  fatherNameLabel.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: rgba(113,0,130,0.86);");
  cnicLabel.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: rgba(113,0,130,0.86);");
  dobLabel.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: rgba(113,0,130,0.86);");
  genderLabel.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: rgba(113,0,130,0.86);");
  cityLabel.setStyle("-fx-font-family: 'Times New Roman'; -fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: rgba(113,0,130,0.86);");


  VBox rightPanel = new VBox(10);
  rightPanel.setPadding(new javafx.geometry.Insets(15));
  rightPanel.setMinWidth(230);

  Button addPictureButton = new Button("Add Picture");
  addPictureButton.setStyle("-fx-background-color: #1E90FF; -fx-text-fill: white; -fx-font-family: 'Times New Roman'; -fx-padding: 10px; -fx-border-radius: 8px; -fx-font-size: 14px;");
  FileChooser fileChooser = new FileChooser();
  ImageView imagePreview = new ImageView();
  imagePreview.setFitWidth(180);
  imagePreview.setFitHeight(200);

  addPictureButton.setOnAction(event -> {
   File selectedFile = fileChooser.showOpenDialog(primaryStage);
   if (selectedFile != null) {
    System.out.println("File selected: " + selectedFile.getAbsolutePath());
    imagePreview.setImage(new Image("file:" + selectedFile.getAbsolutePath()));
   }
  });

  rightPanel.getChildren().addAll(addPictureButton, imagePreview);


  HBox bottomPanel = new HBox(15);
  bottomPanel.setPadding(new javafx.geometry.Insets(10));
  bottomPanel.setAlignment(Pos.CENTER_LEFT);  // this isn't working well
  

  Button saveButton = new Button("Save");
  saveButton.setMinSize(120, 40);
  saveButton.setStyle("-fx-background-color: #0d820d; -fx-text-fill: white; -fx-font-family: 'Times New Roman'; -fx-padding: 8px; -fx-border-radius: 7px; -fx-font-size: 16px;");
  saveButton.setOnAction(event -> {
   FileChooser saveChooser = new FileChooser();
   saveChooser.setTitle("Save File");
  });

  Button exitButton = new Button("Exit");
  exitButton.setMinSize(120, 40);
  exitButton.setStyle("-fx-background-color: #656565; -fx-text-fill: white; -fx-font-family: 'Times New Roman'; -fx-padding: 8px; -fx-border-radius: 7px; -fx-font-size: 16px;");
  exitButton.setOnAction(event -> primaryStage.close());

  bottomPanel.getChildren().addAll(saveButton, exitButton);


  HBox mainLayout = new HBox(20);
  mainLayout.setPadding(new javafx.geometry.Insets(15));
  mainLayout.getChildren().addAll(gridPane, rightPanel);

  // Full layout with banner image, form, and buttons
  VBox fullLayout = new VBox(20);
  fullLayout.setPadding(new javafx.geometry.Insets(20));
  fullLayout.getChildren().addAll(imageView, mainLayout, bottomPanel);


  Scene scene = new Scene(fullLayout, 1000, 750);
  primaryStage.setTitle("Data entry form for Comsats");
  primaryStage.setScene(scene);
  primaryStage.show();
 }

 public static void main(String[] args) {
  launch(args);
 }
}
