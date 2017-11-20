package UISubsystem;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public abstract class UIWindow extends BorderPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final AnchorPane anchorPane;
    protected final Button button;
    protected final AnchorPane anchorPane0;
    protected final Button button0;
    protected final AnchorPane anchorPane1;
    protected final Button button1;
    protected final AnchorPane anchorPane2;
    protected final Button button2;
    protected final AnchorPane anchorPane3;
    protected final Button button3;
    protected final AnchorPane anchorPane4;
    protected final Button button4;
    protected final AnchorPane anchorPane5;
    protected final Button button5;
    protected final AnchorPane anchorPane6;
    protected final Button button6;
    protected final AnchorPane anchorPane7;
    protected final Button button7;
    protected final TabPane tabPane;
    protected final Tab tab;
    protected final AnchorPane anchorPane8;
    protected final RadioButton radioButton;
    protected final RadioButton radioButton0;
    protected final Label label;
    protected final Button button8;
    protected final CheckBox checkBox;
    protected final Tab tab0;
    protected final AnchorPane anchorPane9;
    protected final Button button9;
    protected final TextField textField;
    protected final TextField textField0;
    protected final TextField textField1;
    protected final TextField textField2;
    protected final SplitPane splitPane;
    protected final AnchorPane anchorPane10;
    protected final Label label0;
    protected final AnchorPane anchorPane11;
    protected final Button button10;
    protected final Label label1;

    public UIWindow() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        anchorPane = new AnchorPane();
        button = new Button();
        anchorPane0 = new AnchorPane();
        button0 = new Button();
        anchorPane1 = new AnchorPane();
        button1 = new Button();
        anchorPane2 = new AnchorPane();
        button2 = new Button();
        anchorPane3 = new AnchorPane();
        button3 = new Button();
        anchorPane4 = new AnchorPane();
        button4 = new Button();
        anchorPane5 = new AnchorPane();
        button5 = new Button();
        anchorPane6 = new AnchorPane();
        button6 = new Button();
        anchorPane7 = new AnchorPane();
        button7 = new Button();
        tabPane = new TabPane();
        tab = new Tab();
        anchorPane8 = new AnchorPane();
        radioButton = new RadioButton();
        radioButton0 = new RadioButton();
        label = new Label();
        button8 = new Button();
        checkBox = new CheckBox();
        tab0 = new Tab();
        anchorPane9 = new AnchorPane();
        button9 = new Button();
        textField = new TextField();
        textField0 = new TextField();
        textField1 = new TextField();
        textField2 = new TextField();
        splitPane = new SplitPane();
        anchorPane10 = new AnchorPane();
        label0 = new Label();
        anchorPane11 = new AnchorPane();
        button10 = new Button();
        label1 = new Label();

        setMinHeight(750.0);
        setMinWidth(750.0);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(anchorPane, 1);
        GridPane.setRowIndex(anchorPane, 1);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(200.0);

        AnchorPane.setBottomAnchor(button, 0.0);
        AnchorPane.setLeftAnchor(button, 0.0);
        AnchorPane.setRightAnchor(button, 0.0);
        AnchorPane.setTopAnchor(button, 0.0);
        button.setId("gb4");
        button.setMnemonicParsing(false);
        button.setText(" ");

        anchorPane0.setPrefHeight(200.0);
        anchorPane0.setPrefWidth(200.0);

        AnchorPane.setBottomAnchor(button0, 0.0);
        AnchorPane.setLeftAnchor(button0, 0.0);
        AnchorPane.setRightAnchor(button0, 0.0);
        AnchorPane.setTopAnchor(button0, 0.0);
        button0.setId("gb0");
        button0.setLayoutX(50.0);
        button0.setLayoutY(127.0);
        button0.setMnemonicParsing(false);

        GridPane.setColumnIndex(anchorPane1, 1);
        anchorPane1.setPrefHeight(200.0);
        anchorPane1.setPrefWidth(200.0);

        AnchorPane.setBottomAnchor(button1, 0.0);
        AnchorPane.setLeftAnchor(button1, 0.0);
        AnchorPane.setRightAnchor(button1, 0.0);
        AnchorPane.setTopAnchor(button1, 0.0);
        button1.setId("gb1");
        button1.setLayoutX(45.0);
        button1.setLayoutY(89.0);
        button1.setMnemonicParsing(false);
        button1.setText(" ");

        GridPane.setColumnIndex(anchorPane2, 2);
        anchorPane2.setPrefHeight(200.0);
        anchorPane2.setPrefWidth(200.0);

        AnchorPane.setBottomAnchor(button2, 0.0);
        AnchorPane.setLeftAnchor(button2, 0.0);
        AnchorPane.setRightAnchor(button2, 0.0);
        AnchorPane.setTopAnchor(button2, 0.0);
        button2.setId("gb2");
        button2.setLayoutX(54.0);
        button2.setLayoutY(103.0);
        button2.setMnemonicParsing(false);
        button2.setText(" ");

        GridPane.setRowIndex(anchorPane3, 1);
        anchorPane3.setPrefHeight(200.0);
        anchorPane3.setPrefWidth(200.0);

        AnchorPane.setBottomAnchor(button3, 0.0);
        AnchorPane.setLeftAnchor(button3, 0.0);
        AnchorPane.setRightAnchor(button3, 0.0);
        AnchorPane.setTopAnchor(button3, 0.0);
        button3.setId("gb3");
        button3.setLayoutX(103.0);
        button3.setLayoutY(89.0);
        button3.setMnemonicParsing(false);
        button3.setText(" ");

        GridPane.setColumnIndex(anchorPane4, 2);
        GridPane.setRowIndex(anchorPane4, 1);
        anchorPane4.setPrefHeight(200.0);
        anchorPane4.setPrefWidth(200.0);

        AnchorPane.setBottomAnchor(button4, 0.0);
        AnchorPane.setLeftAnchor(button4, 0.0);
        AnchorPane.setRightAnchor(button4, 0.0);
        AnchorPane.setTopAnchor(button4, 0.0);
        button4.setId("gb5");
        button4.setLayoutY(75.0);
        button4.setMnemonicParsing(false);
        button4.setText(" ");

        GridPane.setRowIndex(anchorPane5, 2);
        anchorPane5.setPrefHeight(200.0);
        anchorPane5.setPrefWidth(200.0);

        AnchorPane.setBottomAnchor(button5, 0.0);
        AnchorPane.setLeftAnchor(button5, 0.0);
        AnchorPane.setRightAnchor(button5, 0.0);
        AnchorPane.setTopAnchor(button5, 0.0);
        button5.setId("gb6");
        button5.setLayoutX(100.0);
        button5.setLayoutY(42.0);
        button5.setMnemonicParsing(false);
        button5.setText(" ");

        GridPane.setColumnIndex(anchorPane6, 1);
        GridPane.setRowIndex(anchorPane6, 2);
        anchorPane6.setPrefHeight(200.0);
        anchorPane6.setPrefWidth(200.0);

        AnchorPane.setBottomAnchor(button6, 0.0);
        AnchorPane.setLeftAnchor(button6, 0.0);
        AnchorPane.setRightAnchor(button6, 0.0);
        AnchorPane.setTopAnchor(button6, 0.0);
        button6.setId("gb7");
        button6.setLayoutX(43.0);
        button6.setLayoutY(47.0);
        button6.setMnemonicParsing(false);
        button6.setFont(new Font("Arial", 36.0));

        GridPane.setColumnIndex(anchorPane7, 2);
        GridPane.setRowIndex(anchorPane7, 2);
        anchorPane7.setPrefHeight(200.0);
        anchorPane7.setPrefWidth(200.0);

        AnchorPane.setBottomAnchor(button7, 0.0);
        AnchorPane.setLeftAnchor(button7, 0.0);
        AnchorPane.setRightAnchor(button7, 0.0);
        AnchorPane.setTopAnchor(button7, 0.0);
        button7.setId("gb8");
        button7.setLayoutX(62.0);
        button7.setLayoutY(123.0);
        button7.setMnemonicParsing(false);
        button7.setFont(new Font("Arial", 36.0));
        setCenter(gridPane);

        BorderPane.setAlignment(tabPane, javafx.geometry.Pos.CENTER);
        tabPane.setPrefHeight(200.0);
        tabPane.setPrefWidth(200.0);
        tabPane.setTabClosingPolicy(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE);

        tab.setText("Human Vs AI");

        anchorPane8.setMinHeight(0.0);
        anchorPane8.setMinWidth(0.0);
        anchorPane8.setPrefHeight(180.0);
        anchorPane8.setPrefWidth(200.0);

        radioButton.setLayoutX(50.0);
        radioButton.setLayoutY(54.0);
        radioButton.setMnemonicParsing(false);
        radioButton.setText("Human First");

        radioButton0.setLayoutX(50.0);
        radioButton0.setLayoutY(72.0);
        radioButton0.setMnemonicParsing(false);
        radioButton0.setText("AI First");

        label.setLayoutX(50.0);
        label.setLayoutY(31.0);
        label.setText("First Move");

        button8.setId("PlayLocalButton");
        button8.setLayoutX(56.0);
        button8.setLayoutY(617.0);
        button8.setMnemonicParsing(false);
        button8.setText("Play Game!");

        checkBox.setLayoutX(41.0);
        checkBox.setLayoutY(116.0);
        checkBox.setMnemonicParsing(false);
        checkBox.setText("Death Match");
        tab.setContent(anchorPane8);

        tab0.setText("AI Vs AI");

        anchorPane9.setMinHeight(0.0);
        anchorPane9.setMinWidth(0.0);
        anchorPane9.setPrefHeight(180.0);
        anchorPane9.setPrefWidth(200.0);

        button9.setId("PlayServerButton");
        button9.setLayoutX(56.0);
        button9.setLayoutY(617.0);
        button9.setMnemonicParsing(false);
        button9.setText("Play Game!");

        textField.setLayoutX(17.0);
        textField.setLayoutY(38.0);
        textField.setPromptText("Server Address");

        textField0.setLayoutX(17.0);
        textField0.setLayoutY(86.0);
        textField0.setPromptText("Port Number");

        textField1.setLayoutX(17.0);
        textField1.setLayoutY(132.0);
        textField1.setPromptText("Timeout (In Seconds)");

        textField2.setLayoutX(17.0);
        textField2.setLayoutY(170.0);
        textField2.setPromptText("Team ID");
        tab0.setContent(anchorPane9);
        setRight(tabPane);

        BorderPane.setAlignment(splitPane, javafx.geometry.Pos.CENTER);
        splitPane.setDividerPositions(0.29797979797979796);
        splitPane.setPrefHeight(25.0);
        splitPane.setPrefWidth(500.0);

        anchorPane10.setMinHeight(0.0);
        anchorPane10.setMinWidth(0.0);
        anchorPane10.setPrefHeight(160.0);
        anchorPane10.setPrefWidth(100.0);

        label0.setId("bottomLabel");

        anchorPane11.setMinHeight(0.0);
        anchorPane11.setMinWidth(0.0);
        anchorPane11.setPrefHeight(160.0);
        anchorPane11.setPrefWidth(100.0);

        AnchorPane.setBottomAnchor(button10, 0.0);
        AnchorPane.setLeftAnchor(button10, 0.0);
        AnchorPane.setRightAnchor(button10, 0.0);
        AnchorPane.setTopAnchor(button10, 0.0);
        button10.setId("restartButton");
        button10.setMnemonicParsing(false);
        button10.setText("Restart");
        button10.setTextFill(javafx.scene.paint.Color.valueOf("#b92929"));
        button10.setFont(new Font("Arial Bold", 13.0));
        setBottom(splitPane);

        BorderPane.setAlignment(label1, javafx.geometry.Pos.CENTER);
        label1.setId("topLabel");
        label1.setText("Click Play Game!");
        setTop(label1);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        anchorPane.getChildren().add(button);
        gridPane.getChildren().add(anchorPane);
        anchorPane0.getChildren().add(button0);
        gridPane.getChildren().add(anchorPane0);
        anchorPane1.getChildren().add(button1);
        gridPane.getChildren().add(anchorPane1);
        anchorPane2.getChildren().add(button2);
        gridPane.getChildren().add(anchorPane2);
        anchorPane3.getChildren().add(button3);
        gridPane.getChildren().add(anchorPane3);
        anchorPane4.getChildren().add(button4);
        gridPane.getChildren().add(anchorPane4);
        anchorPane5.getChildren().add(button5);
        gridPane.getChildren().add(anchorPane5);
        anchorPane6.getChildren().add(button6);
        gridPane.getChildren().add(anchorPane6);
        anchorPane7.getChildren().add(button7);
        gridPane.getChildren().add(anchorPane7);
        anchorPane8.getChildren().add(radioButton);
        anchorPane8.getChildren().add(radioButton0);
        anchorPane8.getChildren().add(label);
        anchorPane8.getChildren().add(button8);
        anchorPane8.getChildren().add(checkBox);
        tabPane.getTabs().add(tab);
        anchorPane9.getChildren().add(button9);
        anchorPane9.getChildren().add(textField);
        anchorPane9.getChildren().add(textField0);
        anchorPane9.getChildren().add(textField1);
        anchorPane9.getChildren().add(textField2);
        tabPane.getTabs().add(tab0);
        anchorPane10.getChildren().add(label0);
        splitPane.getItems().add(anchorPane10);
        anchorPane11.getChildren().add(button10);
        splitPane.getItems().add(anchorPane11);

    }
}
