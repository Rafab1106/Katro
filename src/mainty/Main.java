package mainty;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jeu.Joueur;
import jeu.Regle;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

public class Main extends Application {

    double x = 50, y = 50, speedX = 2, speedY = 2;
    int li, co;
    Joueur j = new Joueur(16, true, null);
    Joueur j2 = new Joueur(16, true, null);

    @Override
    public void start(Stage stage) {

        GridPane grilleJ1 = new GridPane();
        grilleJ1.setHgap(10);
        grilleJ1.setVgap(10);
        grilleJ1.setStyle("-fx-background-color: #cce5ff; -fx-padding: 10; -fx-border-color: #004085; -fx-border-width: 2;");

        GridPane grilleJ2 = new GridPane();
        grilleJ2.setHgap(10);
        grilleJ2.setVgap(10);
        grilleJ2.setStyle("-fx-background-color: #f8d7da; -fx-padding: 10; -fx-border-color: #721c24; -fx-border-width: 2;");

        afficherCases(grilleJ1, j);
        afficherCases(grilleJ2, j2);

        Button btn = new Button("Jouer");

        btn.setOnAction(event -> {
            j = Regle.getCase(j, li, co);
            Regle.chooseDirection(j, j2);
            afficherCases(grilleJ1, j);
            afficherCases(grilleJ2, j2);
        });

        VBox layout = new VBox(20); // <-- ESPACE ENTRE LES GRILLES (20 px)
        layout.setPadding(new Insets(15, 15, 15, 15));
        layout.getChildren().addAll(btn, grilleJ1, grilleJ2);

        Scene scene = new Scene(layout, 400, 350);
        stage.setScene(scene);
        stage.show();
    }

    private void afficherCases(GridPane grille, Joueur j) {
        grille.getChildren().clear();

        int[][] cases = j.getCases();

        for (int ligne = 0; ligne < 2; ligne++) {
            for (int col = 0; col < 4; col++) {

                final int l = ligne;
                final int c = col;

                String valeur = String.valueOf(cases[l][c]);

                Button btnCase = new Button(valeur);
                btnCase.setPrefWidth(50);
                btnCase.setPrefHeight(50);
                btnCase.setStyle("-fx-font-size: 16; -fx-background-color: #dddddd; -fx-border-color: black;");

                btnCase.setOnAction(e -> {
                    System.out.println("Case (" + l + "," + c + ") cliquée");
                    li = l;
                    co = c;
                });

                grille.add(btnCase, c, l);
            }
        }
    }

    // @Override
    // public void start(Stage stage) {
    //     Canvas canvas = new Canvas(400, 300);
    //     GraphicsContext gc = canvas.getGraphicsContext2D();


    //     int d = j.getCases()[0][0];
        
    //     Button btn = new Button(String.valueOf(d));
    //     btn.setLayoutX(100);
    //     btn.setLayoutY(10);

    //     btn.setOnAction(event -> {
    //         j = Regle.getCase(j, 0, 0);
    //         Regle.chooseDirection(j);
    //         for (int i = 0; i < 4; i++) {
    //             System.out.println("Voici les jetons dans la ligne :"+ 0 +" et la col "+i +" = "+j.getCases()[0][i]);
    //         }
    //         for (int k = 3; k >= 0; k--) {
    //             System.out.println("Voici les jetons dans la ligne :"+ 1 +" et la col "+k +" = "+j.getCases()[1][k]);
    //         }
    //     });

    //     // new AnimationTimer() {
    //     //     @Override
    //     //     public void handle(long now) {

    //     //         gc.setFill(Color.WHITE);
    //     //         gc.fillRect(0, 0, 400, 300);

    //     //         gc.setFill(Color.RED);
    //     //         gc.fillOval(x, y, 20, 20);

    //     //         x += speedX;
    //     //         y += speedY;
    //     //         System.out.println("Voici la vitesse x:"+speedX+" et la vitesse y:"+speedY);
                
    //     //         if (x <= 0 || x >= 380) speedX = -speedX;
    //     //         if (y <= 0 || y >= 280) speedY = -speedY;
    //     //     }
    //     // }.start();

    //     Pane root = new Pane(canvas,btn);
    //     Scene scene = new Scene(root);
    //     stage.setTitle("Jeu JavaFX 2D");
        

    //     stage.setScene(scene);
    //     stage.show();
    // }

    public static void main(String[] args) {
        launch(args);
    }
}

