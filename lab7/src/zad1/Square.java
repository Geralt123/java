package zad1;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Square implements Shape {
    public Object draw(Group grupa){
        Rectangle kwadrat = new Rectangle(50, 50, 100, 100);
        kwadrat.setFill(Color.BLUE);
        grupa.getChildren().add(kwadrat);
        return kwadrat;

    }
}
