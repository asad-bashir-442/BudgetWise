package com.example.budgetwise;

import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Objects;

/**
 * Author: 4A Development
 * Student Number:0841073
 * to show the credits of the project
 */
public class Credits extends Stage {
    Text lujiaText;
    Text apText;
    Text jaiText;
    Text asadText;
    Text groupName;
    ImageView logoImage;
    public Credits() {
        BorderPane root = new BorderPane();

       Image logo = new Image(getClass().getResource("/logo1.png").toString());

        logoImage = new ImageView(logo);
        logoImage.setX(200); // 设置初始位置
        logoImage.setY(150);
        logoImage.setFitHeight(200);
        logoImage.setFitWidth(200);
        VBox vbox = new VBox();
        VBox vBox2=new VBox();
        lujiaText = new Text("Lujia Yang-0841073");
        apText = new Text("Apekshya khanal-0842585");
        asadText = new Text("Asad bashir-0848761");
        jaiText = new Text("Jai Vashisht-0845065");
        groupName=new Text("4A Development");
        //font and size
        Font nameFont = Font.font("Comic Sans MS", 15);
        Color nameColor = Color.rgb(0, 0, 139);
        lujiaText.setFill(nameColor);
        lujiaText.setFont(nameFont);
         apText.setFill(nameColor);
        apText.setFont(nameFont);
        asadText.setFill(nameColor);
        asadText.setFont(nameFont);
        jaiText.setFill(nameColor);
        jaiText.setFont(nameFont);
        groupName.setFill(nameColor);
        groupName.setFont(nameFont);
//background color
        Color bgColor = Color.rgb(250, 245, 220);
        root.setBackground(new Background(new BackgroundFill(bgColor, CornerRadii.EMPTY, Insets.EMPTY)));

        vbox.getChildren().addAll( groupName, apText, jaiText, asadText,lujiaText);
        vBox2.getChildren().addAll(logoImage,vbox);
        vBox2.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);

        //animatin
        TranslateTransition imageTranslate=new TranslateTransition();
        imageTranslate.setNode(logoImage);
        imageTranslate.setFromX(-250);
        imageTranslate.setFromY(-250);
        imageTranslate.setToX(0);
        imageTranslate.setToY(0);
        //imageTranslate.setCycleCount(TranslateTransition.INDEFINITE);
        imageTranslate.setAutoReverse(true);
        //imageTranslate.play();

        TranslateTransition textTranslate=new TranslateTransition();
        textTranslate.setNode(vbox);
        textTranslate.setFromX(500);
        textTranslate.setFromY(0);
        textTranslate.setToX(0);
        textTranslate.setToY(0);
        //imageTranslate.setCycleCount(TranslateTransition.INDEFINITE);
        textTranslate.setAutoReverse(true);
       // textTranslate.play();

        FillTransition lujiaFill = new FillTransition(Duration.millis(1500), lujiaText, Color.RED, nameColor);
        FillTransition asadFill = new FillTransition(Duration.millis(1500), asadText, Color.RED, nameColor);
        FillTransition jaiFill = new FillTransition(Duration.millis(1500), jaiText, Color.RED, nameColor);
        FillTransition apFill = new FillTransition(Duration.millis(1500), apText, Color.RED, nameColor);
        SequentialTransition sequentialTransition = new SequentialTransition( apFill,jaiFill,asadFill,lujiaFill);

        //image
        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setNode(logoImage);
        scaleTransition.setDuration(Duration.seconds(1));
        scaleTransition.setByX(-1);
        scaleTransition.setCycleCount(3);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setOnFinished(e->
        {
            logoImage.setScaleX(1);
            logoImage.setX(200);
        });


        ParallelTransition parallelTransition = new ParallelTransition(imageTranslate, textTranslate,sequentialTransition,scaleTransition);

        parallelTransition.setCycleCount(-1);
        parallelTransition.play();
        root.setCenter(vBox2);

        Scene scene = new Scene(root, 500, 500);
        super.setTitle("Credits");
        super.setScene(scene);
        //super.show();
    }


}





