import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MallManagement extends Application {
    @Override
    public void start(Stage primaryStage){
        StackPane pane = new StackPane();
        Mall mall = new Mall(3);
        pane.getChildren().add(mall.getView());
        Scene scene = new Scene(pane, 800, 500);
        primaryStage.setTitle("Mall Management Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
