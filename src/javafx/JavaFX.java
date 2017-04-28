package javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author Нина
 */
public class JavaFX extends Application {
    TextArea txt = new TextArea();
    
           
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("База данных");
        stage.setWidth(300);
        stage.setHeight(250);
        VBox vbox = new VBox();
        txt.setMaxHeight(60);
        
        Button btn = new Button();
        btn.setText("Список студентов");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str;
                JavaToMySQL c=new JavaToMySQL();
                str=c.connect();
                System.out.println(str);
                txt.setText(str);
            }
        });
        
        vbox.getChildren().addAll(txt,btn);
        vbox.setSpacing(10);
        ((Group)scene.getRoot()).getChildren().addAll(vbox);
        
        stage.setScene(scene);
        stage.show();
    }
}
