package com.pialenko.figuresfx.Controller;

import com.pialenko.figuresfx.Controller.Figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {


    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        random = new Random(System.currentTimeMillis());
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        repaint();
    }

    private List<Figure> figures = new ArrayList<>();
    private Random random;

    private Figure createFigure(double x, double y){
        Figure figure = null;

        switch (random.nextInt(3)){
            case Figure.FIGURE_TIPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(2), Color.GREEN, random.nextInt(50));
                break;

            case Figure.FIGURE_TIPE_PRIAMOYGOLNIK:
                figure = new Rectangle(x, y, random.nextInt(4), Color.YELLOW, random.nextInt(100), random.nextInt(100));
                break;
            case Figure.FIGURE_TIPE_TREYGOLNIK:
                figure = new Triangle(x, y, random.nextInt(6), Color.BLUE, random.nextInt(150));
                break;
             default: System.out.println("Unknown Figure type");
        }return figure;
    }

    private void addFigure(Figure figure){
        figures.add(figure);
    }

    private void repaint(){
        canvas.getGraphicsContext2D().clearRect(0,0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.drawFigures(canvas.getGraphicsContext2D());

//        for(Figure figure: figures){
//            if (figure != null){
//                figure.draw(canvas.getGraphicsContext2D());
//            }
//        }
    }


}
