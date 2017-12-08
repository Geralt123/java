package zad2;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javafx.fxml.FXMLLoader.load;


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        Group grupa = new Group();
        int rozdzX=800;
        int rozdzY=600;
        double przedzstart = 0, przedzkon = 80;
        double prob = 1;
        wielomian A = new wielomian();
        A.setParameters(0,0,0,0,1,0);
        ArrayList<Line> lista = new ArrayList<Line>();
        double najw = A.getY(przedzstart), najm = A.getY(przedzstart);
        for (int i=1; i<=(przedzkon-przedzstart)/prob; i++){
            lista.add(new Line(rozdzX*(i-1)*prob/(przedzkon-przedzstart), (-1*A.getY(i*prob-prob)-rozdzY/2), rozdzX*i*prob/(przedzkon-przedzstart), (-1*A.getY(i*prob)-rozdzY/2)));
            grupa.getChildren().add(lista.get(i-1));
            if (A.getY(i)>najw) {najw=A.getY(i);}
            if (A.getY(i)<najm) {najm=A.getY(i);}
        }

        primaryStage.setTitle("Wykres");
        grupa.prefWidth(600);
        grupa.prefHeight(800);
        primaryStage.setScene(new Scene(grupa,rozdzX,rozdzY ));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
