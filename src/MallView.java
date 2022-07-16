import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class MallView extends StackPane {
    public MallView(Mall mall){

        ShopView shop1 = new ShopView(1);
        ShopView shop2 = new ShopView(2);
        ShopView shop3 = new ShopView(3);
        floorArray = new floorView[mall.getFloors()];
        for(int i = 0; i < mall.getFloors(); i++){
            floorArray[i] = new floorView();
        }

        // pruebas de piso
        this.getChildren().add(floorArray[1]);
        floorArray[1].add(shop1, 0, 0);
        floorArray[1].add(shop2, 5, 2);
        floorArray[1].add(shop3, 3, 0);

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
}
