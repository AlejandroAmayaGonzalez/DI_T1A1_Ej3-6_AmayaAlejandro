package ieslosmontecillos.di_t1a1_ej36_amayaalejandro;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Animacion extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Pane root = new Pane();
        root.setPrefSize(320, 240);

        Circle circle = new Circle(40, 40, 80);
        Rectangle rectangle = new Rectangle(50, 30, Color.YELLOW);

        //Centrar las figuras
        circle.setCenterX(root.getPrefWidth() / 2);
        circle.setCenterY(root.getPrefHeight() / 2);
        rectangle.setX((root.getPrefWidth() - rectangle.getWidth()) / 2);
        rectangle.setY((root.getPrefHeight() - rectangle.getHeight()) / 2);

        //Posiciones iniciales en el movimiento
        rectangle.setTranslateX(200);
        rectangle.setTranslateY(100);

        //Crear el movimiento
        PathTransition movimiento = new PathTransition();
        //Duracion del movimiento
        movimiento.setDuration(Duration.millis(4000));

        //El camino seguido del movimiento
        movimiento.setPath(circle);
        //Quien se mueve
        movimiento.setNode(rectangle);

        //Inicia el movimiento
        movimiento.play();

        //Si se mantiene pulsado el circulo se para la animacion
        circle.setOnMousePressed(event -> movimiento.pause());
        circle.setOnMouseReleased(event -> movimiento.play());

        root.getChildren().add(circle);
        root.getChildren().add(rectangle);

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Animacion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}