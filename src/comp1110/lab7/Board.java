package comp1110.lab7;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Board extends Application {
    class Triangle extends Polygon {
        Triangle(double x, double y, double size) {
            super(size / 2, Math.sqrt(Math.pow(size, 2) - Math.pow(size / 2, 2)) / 2, -1 * size / 2, Math.sqrt(Math.pow(size, 2) - Math.pow(size / 2, 2)) / 2, 0, -1 * Math.sqrt(Math.pow(size, 2) - Math.pow(size / 2, 2)) / 2);
            super.setLayoutX(x);
            super.setLayoutY(y);
            super.setFill(Color.LIGHTGREY);
        }

        private double distance(double x, double y) {
            double a = Math.pow(x - this.getLayoutX(), 2) + Math.pow(y - this.getLayoutY(), 2);
            return Math.sqrt(a);
        }

    }


    class DraggableTriangle extends Triangle {
        private Board board;
        private double mousex, mousey;
        private double x, y;

        DraggableTriangle(double x, double y, double size, Board board) {
            super(x, y, size);
            this.x = x;
            this.y = y;
            this.board = board;
            this.setFill(Color.RED);
            this.setOnMousePressed(event -> {
                this.mousex = event.getSceneX();
                this.mousey = event.getSceneY();
                this.x = super.getLayoutX();
                this.y = super.getLayoutY();
                this.toFront();
            });
            this.setOnMouseDragged(event -> {
                this.setLayoutX(this.x+ event.getSceneX() - mousex);
                this.setLayoutY(this.y+  event.getSceneY() - mousey);
                board.highlightNearestTriangle(this.getLayoutX(), this.getLayoutY());
            });
            this.setOnMouseReleased(event -> {
                this.setLayoutX(board.highlighted.getLayoutX());
                this.setLayoutY(board.highlighted.getLayoutY());
                this.setRotate(board.highlighted.getRotate());
            });

        }


    }

    Triangle findNearestTriangle(double x, double y) {
        Triangle t = null;
        for (Triangle triangle : list) {
            if (t == null) {
                t = triangle;
            } else if (t.distance(x, y) > triangle.distance(x, y)) {
                t = triangle;
            }
        }
        return t;
    }

    ArrayList<Triangle> list;
    Triangle highlighted = null;

    void highlightNearestTriangle(double x, double y) {
        if (highlighted != null) {
            highlighted.setFill(Color.LIGHTGREY);
        }
        highlighted = findNearestTriangle(x, y);
        highlighted.setFill(Color.GREEN);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setMaxWidth(600);
        primaryStage.setWidth(600);
        primaryStage.setMaxHeight(519);
        primaryStage.setHeight(519);
        Group root = new Group();

        list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                Triangle t = new Triangle(j * 100 + 300, 86.6 + 173.2 * i, 196);
                if (Math.abs(j % 2) == 1) {
                    t.setRotate(180);
                }
                list.add(t);
            }
        }

        for (Triangle t : list) {
            root.getChildren().addAll(t);
        }
        root.getChildren().addAll(new DraggableTriangle(300, 260, 200, this));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
