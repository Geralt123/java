package zad2;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {

    public void Linia (Group grupa, int a, int b, int c, int d){
        Line linia = new Line(a,b,c,d);
        grupa.getChildren().add(linia);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group grupa = new Group();
        double przedzstart = 0, przedzkon = 1;
        double prob = 0.2;
        double najw = A.wielomian(przedzstart), najm = A.wielomian(przedzstart);
        for (double i=przedzstart+prob; i<przedzkon; i+=prob){
            Linia(grupa, (int)(i-prob), (int)A.wielomian(i-prob), (int)i, (int)A.wielomian(i));
            if (A.wielomian(i)>najw) {najw=A.wielomian(i);}
            if (A.wielomian(i)<najm) {najm=A.wielomian(i);}
        }


        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        primaryStage.setScene(new Scene(grupa, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


class A{
public static final double wielomian(double x) {
    return (-2)*x;
    }


}