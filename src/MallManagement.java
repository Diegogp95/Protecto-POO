import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
//import org.w3c.dom.Text;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MallManagement extends Application {
    @Override
    public void start(Stage primaryStage){
        MainPane mainPane = new MainPane();
        bottomPane = new BottomPane();
        mall = new Mall(3, bottomPane);
        bottomPane.setMall(mall);
        mainMenu = new MainMenu(primaryStage);

        mainPane.add(mall.getView(),1,0,1,1);
        mainPane.add(mainMenu,0,0,1,1);
        mainPane.add(bottomPane,0, 1, 2, 1);
        Scene scene = new Scene(mainPane, 1000, 600);
        primaryStage.setTitle("Mall Management Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class MainMenu extends VBox{
        private MainMenu(Stage stage) {
            floorUp = new Button("Subir piso");
            floorDown = new Button("Bajar piso");
            importButton = new Button("Abrir");
            saveButton = new Button("Guardar");
            deleteAllButton = new Button("Borrar todo");
            HBox box1 = new HBox(floorUp, floorDown);
            box1.setSpacing(20);
            box1.setAlignment(Pos.CENTER);
            HBox box2 = new HBox(importButton, saveButton);
            box2.setSpacing(20);
            box2.setAlignment(Pos.CENTER);
            final FileChooser openChooser = new FileChooser();
            final FileChooser saveChooser = new FileChooser();
            openChooser.setTitle("Abrir");
            openChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("csv files (*.csv)", "*.csv"));
            saveChooser.setTitle("Guardar");
            saveChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("csv files (*.csv)", "*.csv"));

            floorUp.setOnAction(e->mall.flooUp());
            floorDown.setOnAction(e->mall.floorDown());
            importButton.setOnAction(
                    openEvent -> {
                        File importedFile = openChooser.showOpenDialog(stage);
                        if (importedFile != null){
                            System.out.println("abrio");
                            openFile(importedFile);
                            bottomPane.getChildren().clear();
                        }
                    }
            );

            saveButton.setOnAction(
                    saveEvent -> {
                        File savedFile = saveChooser.showSaveDialog(stage);
                        if (savedFile != null){
                            String printString = mall.printShopArray();
                            saveToFile(printString, savedFile);
                        }
                    }
            );

            deleteAllButton.setOnAction(e->{
                Stage confirmStage = new Stage();
                Text confirmText = new Text("¿Borrar todo?");
                Button confirmDeleteButton = new Button("Confirmar");
                Button cancelDeleteButton = new Button("Cancelar");
                HBox hBox = new HBox(confirmDeleteButton,cancelDeleteButton);
                hBox.setSpacing(20);
                hBox.setAlignment(Pos.CENTER);
                VBox vBox = new VBox(confirmText, hBox);
                vBox.setSpacing(20);
                vBox.setAlignment(Pos.CENTER);
                confirmStage.setScene(new Scene(vBox, 200,200));
                confirmStage.initModality(Modality.APPLICATION_MODAL);

                confirmDeleteButton.setOnAction(ec->{
                    mall.resetAndDeleteAllShops();
                    bottomPane.getChildren().clear();
                    confirmStage.close();
                });
                cancelDeleteButton.setOnAction(ec2->confirmStage.close());
                confirmStage.showAndWait();
            });


            getChildren().addAll(box1, box2, deleteAllButton);

            setAlignment(Pos.CENTER);
            setSpacing(20);
        }



        private void openFile(File file){
            try {
                Scanner scanner = new Scanner(file);
                String[] shopInformation = new String[21];
                int shopViewId;
                String temp;
                if (scanner.hasNextInt()){
                    shopViewId = scanner.nextInt();
                   for (int i = 0; i < 21; i++){
                       shopInformation[i] = scanner.next();
                       //System.out.println(shopInformation[i]);
                    }
                    mall.resetAndDeleteAllShops();
                    mall.importShop(shopViewId, shopInformation);
                }
                while (scanner.hasNextInt()){
                        shopViewId = scanner.nextInt();
                        for (int i = 0; i < 21; i++){
                            temp = scanner.next();
                            if (temp == "null"){
                                shopInformation[i] = "";
                            }
                             else shopInformation[i] = temp;
                            //System.out.println(shopInformation[i]);
                        }
                        mall.importShop(shopViewId, shopInformation);

                }
                mall.printShopsInfo();
            }
            catch (IOException exception){
                System.out.println("Error al abrir el archivo.");
            }
        }



        private void saveToFile(String content, File file){
            try {
                PrintWriter writer = new PrintWriter(file);
                writer.println(content);
                writer.close();}
            catch (IOException exception){
                System.out.println("Error al guardar el archivo.");
            }
        }

        private Button deleteAllButton;
        private Button importButton;
        private Button floorUp;
        private Button floorDown;
        private Button saveButton;
    }

    private class MainPane extends GridPane{
        private MainPane(){
            setGridLinesVisible(false);
            ColumnConstraints col1 = new ColumnConstraints();
            ColumnConstraints col2 = new ColumnConstraints();
            RowConstraints row1 = new RowConstraints();
            RowConstraints row2 = new RowConstraints();
            col1.setPercentWidth(30);
            col2.setPercentWidth(70);
            row1.setPercentHeight(40);
            row2.setPercentHeight(60);
            getColumnConstraints().addAll(col1,col2);
            getRowConstraints().addAll(row1,row2);
        }
    }
    private Mall mall;
    private BottomPane bottomPane;
    private MainMenu mainMenu;
}
