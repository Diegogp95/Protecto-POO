import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GeneralArea extends HBox {
    public GeneralArea(String areaTag){
        setBackground(new Background(new BackgroundFill(Color.BLACK, null, null),
                new BackgroundFill(Color.WHITE, null, new Insets(1))));
        tag = areaTag;
        Text displayTag = new Text(tag);
        getChildren().add(displayTag);
        setAlignment(Pos.CENTER);
    }

    private String tag;
}
