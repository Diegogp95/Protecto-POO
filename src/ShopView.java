import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;


public class ShopView extends HBox {
    public ShopView(int id, int floor, BottomPane bottomPane){
        setBackground(new Background(new BackgroundFill(Color.BLACK, null, null),
                new BackgroundFill(Color.WHITE, null, new Insets(1))));
        inFloor = floor;
        state = ShopState.ONRENT;
        ShopPlaceId = id;
        shopArea = 52.5;
        ORView = new onRentView(ShopPlaceId);
        getChildren().add(ORView);
        setAlignment(Pos.CENTER);

        setOnMouseEntered(e->{onMouseEntered();});
        setOnMouseExited(e-> onMouseExited());
        setOnMouseClicked(e->{bottomPane.setPane(this);
            System.out.println(""+renterId);});
    }

    public void onMouseEntered(){
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null),
                new BackgroundFill(Color.LIGHTCORAL, null, new Insets(1))));
    }

    public void onMouseExited(){
        this.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null),
                new BackgroundFill(Color.WHITE, null, new Insets(1))));
    }



    public enum ShopState{
        ONRENT,
        RENTED
    }

    private class onRentView extends VBox {
        private onRentView(int id){
            ShopId = id;
            Text shopState = new Text("En Arriendo");
            Text idText = new Text("Local: " + ShopId);
            getChildren().addAll(shopState, idText);
            setAlignment(Pos.CENTER);
        }

        private int ShopId;
    }

    private class rentedView extends VBox{
        private rentedView(String shopName){
            nameDisplay = shopName;
            Text name = new Text(nameDisplay);
            getChildren().addAll(name);
            setAlignment(Pos.CENTER);
        }
        private String nameDisplay;
    }

    public int getShopPlaceId() {
        return ShopPlaceId;
    }

    public ShopState getState() {
        return state;
    }

    public double getShopArea() {
        return shopArea;
    }

    public void setRenterId(int renterId) {
        this.renterId = renterId;
    }

    public int getRenterId() {
        return renterId;
    }

    public void setState(ShopState state) {
        this.state = state;
    }

    public int getInFloor() {
        return inFloor;
    }

    private int ShopPlaceId;
    private ShopState state;
    private onRentView ORView;
    private double shopArea;
    private int renterId = -1;
    private int inFloor;
}
