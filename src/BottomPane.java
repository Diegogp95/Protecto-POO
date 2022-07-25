import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BottomPane extends StackPane {
    public BottomPane(){
        onRentPane = new OnRentPane();
        rentedPane = new RentedPane();
        // this.getChildren().add(rentedPane);

    }
    public void setMall(Mall pmall){
        mall = pmall;
        return;
    }

    public void setPane(ShopView shopView){
        shopViewId = shopView.getShopPlaceId();
        shopArea = shopView.getShopArea();
        workingOnFloor = shopView.getInFloor();
        switch (shopView.getState()) {
            case ONRENT:
                onRentPane.updateForRentPane();
                getChildren().clear();
                getChildren().add(onRentPane);
                break;
            case RENTED:
                rentedPane.updateRentedPane(shopView);
                getChildren().clear();
                getChildren().add(rentedPane);
        }
        return;
    }

    private class OnRentPane extends VBox {
        private OnRentPane(){
            forRentText = new Text();
            addShopButton = new Button("Añadir arrendatario");
            this.getChildren().addAll(forRentText, addShopButton);
            setAlignment(Pos.CENTER);
            setSpacing(25);
            addShopButton.setOnAction(e-> addShopWindow());
        }

        private void updateForRentPane(){
            forRentMsg = "Local " + shopViewId + " en arriendo.";
            forRentText.setText(forRentMsg);
        }

        private void addShopWindow(){
            Stage stage = new Stage();
            Text nameText = new Text("Nombre local:");
            TextField nameField = new TextField();
            Button saveButton = new Button("Guardar");
            Button cancelButton = new Button("Cancel");
            HBox hbox1 = new HBox(nameText, nameField);
            HBox hBox2 = new HBox(saveButton, cancelButton);
            VBox vBox = new VBox(hbox1,hBox2);
            vBox.setAlignment(Pos.CENTER);
            hbox1.setAlignment(Pos.CENTER);
            hBox2.setAlignment(Pos.CENTER);
            vBox.setSpacing(20);
            hbox1.setSpacing(20);
            hBox2.setSpacing(20);
            stage.setScene(new Scene(vBox, 300, 150));
            //stage.show();
            stage.initModality(Modality.APPLICATION_MODAL);


            saveButton.setOnAction(e->{
                String newName = nameField.getText();
                if (newName.length() > 0){
                    ShopView shopView =  mall.getView().getShopView(shopViewId, workingOnFloor);
                    int shopId = mall.addShop(newName, shopView.getInFloor(), shopViewId);
                    shopView.setRenterId(shopId);
                    shopView.setState(ShopView.ShopState.RENTED);
                    setPane(shopView);
                    stage.close();
                }
            });
            cancelButton.setOnAction(e->stage.close());
            stage.showAndWait();
        }

        private Button addShopButton;
        private String forRentMsg = null;
        private Text forRentText;
    }

    private class RentedPane extends GridPane {
        private RentedPane(){
            setGridLinesVisible(true);
            ColumnConstraints col1 = new ColumnConstraints();
            ColumnConstraints col2 = new ColumnConstraints();
            ColumnConstraints col3 = new ColumnConstraints();
            ColumnConstraints col4 = new ColumnConstraints();
            ColumnConstraints col5 = new ColumnConstraints();
            ColumnConstraints col6 = new ColumnConstraints();
            col1.setPercentWidth(28);
            col2.setPercentWidth(5);
            col3.setPercentWidth(29);
            col4.setPercentWidth(5);
            col5.setPercentWidth(28);
            col6.setPercentWidth(5);
            getColumnConstraints().addAll(col1,col2,col3,col4,col5,col6);
            for (int i = 0; i < 8; i++){
                RowConstraints row = new RowConstraints();
                row.setPercentHeight(12.5);
                getRowConstraints().add(row);
            }

            paramCol1 = new HBox[8];
            paramCol2 = new HBox[8];
            paramCol3 = new HBox[5];
            shopParam = new Text[21];
            editButtons = new Button[21];
            for (int i = 0; i<8; i++){
                paramCol1[i] = new HBox();
                paramCol1[i].setAlignment(Pos.CENTER_LEFT);
                paramCol2[i] = new HBox();
                paramCol2[i].setAlignment(Pos.CENTER_LEFT);
            }
            for (int i = 0; i<5; i++){
                paramCol3[i] = new HBox();
                paramCol3[i].setAlignment(Pos.CENTER_LEFT);
            }
            for (int i = 0; i < 21; i++){
                shopParam[i] = new Text();
                editButtons[i] = new Button("Edit");
            }
            //col1
            paramCol1[0].getChildren().addAll(new Text("Nombre local: "), shopParam[0]);
            paramCol1[1].getChildren().addAll(new Text("Norma recepción: "), shopParam[1]);
            paramCol1[2].getChildren().addAll(new Text("Norma dominio: "), shopParam[2]);
            paramCol1[3].getChildren().addAll(new Text("Arrendatario: "), shopParam[3]);
            paramCol1[4].getChildren().addAll(new Text("Valor arriendo: "), shopParam[4]);
            paramCol1[5].getChildren().addAll(new Text("Monto garantía: "), shopParam[5]);
            paramCol1[6].getChildren().addAll(new Text("Fecha inicio arriendo: "), shopParam[6]);
            paramCol1[7].getChildren().addAll(new Text("Fecha término arriendo: "), shopParam[7]);
            //col2
            paramCol2[0].getChildren().addAll(new Text("Giro local: "), shopParam[8]);
            paramCol2[1].getChildren().addAll(new Text("Norma giro: "), shopParam[9]);
            paramCol2[2].getChildren().addAll(new Text("Fecha transferencia: "), shopParam[10]);
            paramCol2[3].getChildren().addAll(new Text("Norma transferencia: "), shopParam[11]);
            paramCol2[4].getChildren().addAll(new Text("Fecha consumo electricidad: "), shopParam[12]);
            paramCol2[5].getChildren().addAll(new Text("Norma electricidad: "), shopParam[13]);
            paramCol2[6].getChildren().addAll(new Text("Número cliente electricidad: "), shopParam[14]);
            paramCol2[7].getChildren().addAll(new Text("Fecha consumo Agua: "), shopParam[15]);
            //col3
            paramCol3[0].getChildren().addAll(new Text("Norma agua: "), shopParam[16]);
            paramCol3[1].getChildren().addAll(new Text("Número cliente agua: "), shopParam[17]);
            paramCol3[2].getChildren().addAll(new Text("Fecha consumo gas: "), shopParam[18]);
            paramCol3[3].getChildren().addAll(new Text("Norma gas: "), shopParam[19]);
            paramCol3[4].getChildren().addAll(new Text("Número cliente gas: "), shopParam[20]);

            for (int i = 0; i < 8; i++){
                add(paramCol1[i],0,i);
                add(editButtons[i], 1, i);
                add(paramCol2[i], 2, i);
                add(editButtons[i+8], 3, i);
            }
            for (int i = 0; i < 5; i++){
                add(paramCol3[i], 4, i);
                add(editButtons[i+16], 5,i);
            }
            for (int i = 0; i < 21; i++) {
                int finalI = i;
                editButtons[i].setOnAction(e -> editShopParam(finalI));
            }
        }

        private void editShopParam(int i){
            Text textDisplay = new Text();
            Stage stage = new Stage();
            TextField textField = new TextField();
            Button saveButton = new Button("Guardar");
            Button cancelButton = new Button("Cancel");
            HBox hbox1 = new HBox(textDisplay, textField);
            HBox hBox2 = new HBox(saveButton, cancelButton);
            VBox vBox = new VBox(hbox1,hBox2);
            vBox.setAlignment(Pos.CENTER);
            hbox1.setAlignment(Pos.CENTER);
            hBox2.setAlignment(Pos.CENTER);
            vBox.setSpacing(20);
            hbox1.setSpacing(20);
            hBox2.setSpacing(20);
            stage.setScene(new Scene(vBox, 300, 150));
            stage.initModality(Modality.APPLICATION_MODAL);

            switch (i) {
                case 0:
                    textDisplay.setText("Nombre local:");
                    break;
                case 1:
                    textDisplay.setText("Norma recepción:");
                    break;
                case 2:
                    textDisplay.setText("Norma Dominio:");
                    break;
                case 3:
                    textDisplay.setText("Arrendatario:");
                    break;
                case 4:
                    textDisplay.setText("Valor arriendo:");
                    break;
                case 5:
                    textDisplay.setText("Monto garantía:");
                    break;
                case 6:
                    textDisplay.setText("Fecha inicio arriendo:");
                    break;
                case 7:
                    textDisplay.setText("Fecha término arriendo");
                    break;
                case 8:
                    textDisplay.setText("Giro local:");
                    break;
                case 9:
                    textDisplay.setText("Norma giro local:");
                    break;
                case 10:
                    textDisplay.setText("Fecha transferencia:");
                    break;
                case 11:
                    textDisplay.setText("Norma transferencia:");
                    break;
                case 12:
                    textDisplay.setText("Fecha consumo electricidad:");
                    break;
                case 13:
                    textDisplay.setText("Norma electricidad:");
                    break;
                case 14:
                    textDisplay.setText("Número cliente electricidad:");
                    break;
                case 15:
                    textDisplay.setText("Fecha consumo agua:");
                    break;
                case 16:
                    textDisplay.setText("Norma agua:");
                    break;
                case 17:
                    textDisplay.setText("Número cliente agua");
                    break;
                case 18:
                    textDisplay.setText("Fecha consumo gas");
                    break;
                case 19:
                    textDisplay.setText("Norma gas:");
                    break;
                case 20:
                    textDisplay.setText("Número cliente gas:");

            }
            saveButton.setOnAction(e->{
                String newParam = textField.getText();
                if (newParam.length() > 0){
                    ShopView shopView = mall.getView().getShopView(shopViewId, workingOnFloor);
                    Shop shop = mall.searchForShop(shopView.getInFloor(), shopView.getRenterId());
                    switch (i) {
                        case 0:
                            shop.setNombreLocal(newParam);
                        case 1:
                            shop.setNormaRecepcion(newParam);
                            break;
                        case 2:
                            shop.setNormaDominio(newParam);
                            break;
                        case 3:
                            shop.setArrendatario(newParam);
                            break;
                        case 4:
                            shop.setPrecioArriendo(newParam);
                            break;
                        case 5:
                            shop.setMontoGarantia(newParam);
                            break;
                        case 6:
                            shop.setFechaInicio(newParam);
                            break;
                        case 7:
                            shop.setFechaTermino(newParam);
                            break;
                        case 8:
                            shop.setGiroloLocal(newParam);
                            break;
                        case 9:
                            shop.setNormaGiro(newParam);
                            break;
                        case 10:
                            shop.setFechaTransferencia(newParam);
                            break;
                        case 11:
                            shop.setNormaTransferencia(newParam);
                            break;
                        case 12:
                            shop.setFechaConsumoLuz(newParam);
                            break;
                        case 13:
                            shop.setNormaLuz(newParam);
                            break;
                        case 14:
                            shop.setNumeroClienteLuz(newParam);
                            break;
                        case 15:
                            shop.setFechaConsumoAgua(newParam);
                            break;
                        case 16:
                            shop.setNormaAgua(newParam);
                            break;
                        case 17:
                            shop.setNumeroClienteAgua(newParam);
                            break;
                        case 18:
                            shop.setFechaConsumoGas(newParam);
                            break;
                        case 19:
                            shop.setNormaGas(newParam);
                            break;
                        case 20:
                            shop.setNumeroClienteGas(newParam);

                    }
                    updateRentedPane(shopView);
                    stage.close();
                }
            });


            cancelButton.setOnAction(e->stage.close());
            stage.showAndWait();
        }



        private void updateRentedPane(ShopView shopView){
            int shopId = shopView.getRenterId();
            if (shopId >=0){
                Shop shop = mall.searchForShop(shopView.getInFloor(), shopId);
                if (shop != null){
                    shopParam[0].setText(shop.getNombreLocal());
                    shopParam[1].setText(shop.getNormaRecepcion());
                    shopParam[2].setText(shop.getNormaDominio());
                    shopParam[3].setText(shop.getArrendatario());
                    shopParam[4].setText(shop.getPrecioArriendo());
                    shopParam[5].setText(shop.getMontoGarantia());
                    shopParam[6].setText(shop.getFechaInicio());
                    shopParam[7].setText(shop.getFechaTermino());
                    shopParam[8].setText(shop.getGiroLocal());
                    shopParam[9].setText(shop.getNormaGiro());
                    shopParam[10].setText(shop.getFechaTransferencia());
                    shopParam[11].setText(shop.getNormaTransferencia());
                    shopParam[12].setText(shop.getFechaConsumoLuz());
                    shopParam[13].setText(shop.getNormaLuz());
                    shopParam[14].setText(shop.getNumeroClienteLuz());
                    shopParam[15].setText(shop.getFechaConsumoAgua());
                    shopParam[16].setText(shop.getNormaAgua());
                    shopParam[17].setText(shop.getNumeroClienteAgua());
                    shopParam[18].setText(shop.getFechaConsumoGas());
                    shopParam[19].setText(shop.getNormaGas());
                    shopParam[20].setText(shop.getNumeroClienteGas());

                }
            }
        }

        private HBox[] paramCol1;
        private HBox[] paramCol2;
        private HBox[] paramCol3;
        private Text[] shopParam;
        private Button[] editButtons;
    }

    private int shopViewId;
    private double shopArea;
    private OnRentPane onRentPane;
    private RentedPane rentedPane;
    private Mall mall;
    private int workingOnFloor;
}
