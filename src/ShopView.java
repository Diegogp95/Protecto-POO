import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.text.Text;


public class ShopView extends HBox {
    public ShopView(int id){

        state = ShopState.ONRENT;
        ShopPlaceId = id;
        ORView = new onRentView(ShopPlaceId);
        getChildren().add(ORView);
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
