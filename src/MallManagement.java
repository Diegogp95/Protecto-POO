import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MallManagement extends Application {
    @Override
    public void start(Stage primaryStage){
        MainPane mainPane = new MainPane();
        BottomPane bottomPane = new BottomPane();
        Mall mall = new Mall(3, bottomPane);
        bottomPane.setMall(mall);
        MainMenu mainMenu = new MainMenu();

        mainMenu.floorUp.setOnAction(e->{
            mall.flooUp();
        });
        mainMenu.floorDown.setOnAction(e->{
            mall.floorDown();
        });

        mainPane.add(mall.getView(),1,0,1,1);
        mainPane.add(mainMenu,0,0,1,1);
        mainPane.add(bottomPane,0, 1, 2, 1);
        Scene scene = new Scene(mainPane, 1000, 600);
        primaryStage.setTitle("Mall Management Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class MainMenu extends VBox{
        private MainMenu() {
            floorUp = new Button("Subir piso");
            floorDown = new Button("Bajar piso");

            getChildren().add(floorUp);
            getChildren().add(floorDown);


            setAlignment(Pos.CENTER);
            setSpacing(5);
        }

        Button floorUp;
        Button floorDown;
    }

    private class MainPane extends GridPane{
        private MainPane(){
            setGridLinesVisible(true);
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
}
