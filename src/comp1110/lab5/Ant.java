package comp1110.lab5;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import static java.lang.Math.random;


public class Ant extends Application  {
   public void start(Stage primaryStage)  {
       Group root = new Group();
       Scene scene = new Scene(root, 800, 600, Color.WHITE);
       primaryStage.setScene(scene);
       Group ants = new Group();
       for (int i = 0;i<1000;i++){
           Circle ant = new Circle(2,Color.web("black",1));
           ants.getChildren().add(ant);
       }
       root.getChildren().add(ants);
       Timeline timeline = new Timeline();
       for (Node ant:ants.getChildren()){
           timeline.getKeyFrames().addAll(
                   new KeyFrame(Duration.ZERO,
                           new KeyValue(ant.translateXProperty(),random()*800),
                           new KeyValue(ant.translateYProperty(),random()*600)),
                   new KeyFrame(new Duration(40000),
                           new KeyValue(ant.translateXProperty(),random()*800),
                           new KeyValue(ant.translateYProperty(),random()*600))
           );
       }
       timeline.play();
       primaryStage.show();
   }
   public static void main(String[] args){
       launch(args);
   }

}
