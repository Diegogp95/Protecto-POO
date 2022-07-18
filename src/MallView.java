import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class MallView extends StackPane {
    public MallView(Mall mall) {

        floorArray = new floorView[mall.getFloors()];
        for (int i = 0; i < mall.getFloors(); i++) {
            floorArray[i] = new floorView();
        }

        int j = 1;
        for (int i = 0; i < mall.getFloors(); i++){
            floorArray[i].add(new ShopView(j++), 0, 0, 2, 1);
            floorArray[i].add(new ShopView(j++), 2, 0, 1, 1);
            floorArray[i].add(new ShopView(j++), 3, 0, 1, 1);
            floorArray[i].add(new ShopView(j++), 5, 0, 1, 1);
            floorArray[i].add(new ShopView(j++), 6, 0, 2, 1);
            if (i != 0){
                floorArray[i].add(new ShopView(j++), 7, 1, 1, 3);
            }
            else {
                floorArray[i].add(new GeneralArea("Entrada"), 7, 1, 1, 3);
            }
            floorArray[i].add(new ShopView(j++), 6, 4 ,2, 1);
            floorArray[i].add(new ShopView(j++), 5, 4, 1, 1);
            floorArray[i].add(new ShopView(j++), 4, 4, 1, 1);
            floorArray[i].add(new ShopView(j++), 3, 4, 1, 1);
            floorArray[i].add(new ShopView(j++), 2, 4, 1, 1);
            floorArray[i].add(new ShopView(j++), 1, 4, 1, 1);
            floorArray[i].add(new ShopView(j++), 0, 2, 1, 3);
            floorArray[i].add(new ShopView(j++), 0, 1, 1, 1);

            floorArray[i].add(new GeneralArea("Baños"), 4, 0, 1, 1);

        }

        actualFloor = 0;
        this.getChildren().add(floorArray[actualFloor]);

        // Prueba de cambio de piso con boton
        Button floorButton = new Button("Cambiar piso");
        floorButton.setOnAction(e -> {
            actualFloor = (actualFloor+1) % floorArray.length;
            this.changeFloor(actualFloor, floorButton);
        });
        getChildren().add(floorButton);


    }

    // metodo de prueba de cambio de piso
    private void changeFloor(int nextFloor, Button button){
        this.getChildren().clear();
        this.getChildren().addAll(floorArray[nextFloor], button);

    }

    private class floorView extends GridPane{
        private floorView(){
            setGridLinesVisible(true);
            ColumnConstraints col1 = new ColumnConstraints();
            ColumnConstraints col2 = new ColumnConstraints();
            ColumnConstraints col3 = new ColumnConstraints();
            ColumnConstraints col4 = new ColumnConstraints();
            ColumnConstraints col5 = new ColumnConstraints();
            ColumnConstraints col6 = new ColumnConstraints();
            ColumnConstraints col7 = new ColumnConstraints();
            ColumnConstraints col8 = new ColumnConstraints();
            col1.setPercentWidth(10);
            col2.setPercentWidth(16.5);
            col3.setPercentWidth(16.5);
            col4.setPercentWidth(17);
            col5.setPercentWidth(10);
            col6.setPercentWidth(10);
            col7.setPercentWidth(10);
            col8.setPercentWidth(10);

            RowConstraints row1 = new RowConstraints();
            RowConstraints row2 = new RowConstraints();
            RowConstraints row3 = new RowConstraints();
            RowConstraints row4 = new RowConstraints();
            RowConstraints row5 = new RowConstraints();
            row1.setPercentHeight(25);
            row2.setPercentHeight(15.625);
            row3.setPercentHeight(18.75);
            row4.setPercentHeight(15.625);
            row5.setPercentHeight(25);

            getColumnConstraints().addAll(col1,col2,col3,col4,col5,col6,col7,col8);
            getRowConstraints().addAll(row1,row2,row3,row4,row5);
        }

    }
    private floorView[] floorArray;
    private int actualFloor;
}
