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
    public ShopView(int id){
        setBackground(new Background(new BackgroundFill(Color.BLACK, null, null),
                new BackgroundFill(Color.WHITE, null, new Insets(1))));
        state = ShopState.ONRENT;
        ShopPlaceId = id;
        ORView = new onRentView(ShopPlaceId);
        getChildren().add(ORView);
        setAlignment(Pos.CENTER);

        setOnMouseEntered(e->{onMouseEntered();});
        setOnMouseExited(e-> onMouseExited());
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
        protected onRentView(int id){
            ShopId = id;
            Text shopState = new Text("En Arriendo");
            Text idText = new Text("Local: " + ShopId);
            getChildren().addAll(shopState, idText);
            setAlignment(Pos.CENTER);
        }

        private int ShopId;
    }

    private int ShopPlaceId;
    private ShopState state;
    private onRentView ORView;
}
