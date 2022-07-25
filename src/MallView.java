import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class MallView extends StackPane {
    public MallView(Mall mall, BottomPane bottomPane) {

        floorArray = new floorView[mall.getFloors()];
        for (int i = 0; i < mall.getFloors(); i++) {
            floorArray[i] = new floorView();
        }

        int j = 1;
        for (int i = 0; i < mall.getFloors(); i++){
            floorArray[i].add(new ShopView(j++, i, bottomPane), 0, 0, 2, 1);
            floorArray[i].add(new ShopView(j++, i, bottomPane), 2, 0, 1, 1);
            floorArray[i].add(new ShopView(j++, i,bottomPane), 3, 0, 1, 1);
            floorArray[i].add(new ShopView(j++, i,bottomPane), 5, 0, 1, 1);
            floorArray[i].add(new ShopView(j++, i,bottomPane), 6, 0, 2, 1);
            if (i != 0){
                floorArray[i].add(new ShopView(j++, i,bottomPane), 7, 1, 1, 3);
            }
            else {
                floorArray[i].add(new GeneralArea("Entrada"), 7, 1, 1, 3);
            }
            floorArray[i].add(new ShopView(j++, i, bottomPane), 6, 4 ,2, 1);
            floorArray[i].add(new ShopView(j++, i, bottomPane), 5, 4, 1, 1);
            floorArray[i].add(new ShopView(j++, i, bottomPane), 4, 4, 1, 1);
            floorArray[i].add(new ShopView(j++, i, bottomPane), 3, 4, 1, 1);
            floorArray[i].add(new ShopView(j++, i, bottomPane), 2, 4, 1, 1);
            floorArray[i].add(new ShopView(j++, i, bottomPane), 1, 4, 1, 1);
            floorArray[i].add(new ShopView(j++, i, bottomPane), 0, 2, 1, 3);
            floorArray[i].add(new ShopView(j++, i, bottomPane), 0, 1, 1, 1);

            floorArray[i].add(new GeneralArea("Baños"), 4, 0, 1, 1);

        }

        actualFloor = 0;
        this.getChildren().add(floorArray[actualFloor]);

    }

    public ShopView getShopView(int id, int pfloor){
        for(Node sw : floorArray[pfloor].getChildren()){
            if (sw instanceof ShopView){
                if (((ShopView) sw).getShopPlaceId()== id){
                    return (ShopView) sw;
                }
            }
        }
        return null;
    }

    public void changeFloorUp(){
        actualFloor++;
        this.getChildren().clear();
        this.getChildren().add(floorArray[actualFloor]);
    }

    public void changeFloorDown(){
        actualFloor--;
        this.getChildren().clear();
        this.getChildren().add(floorArray[actualFloor]);
    }

    public int getActualFloor() {
        return actualFloor;
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
