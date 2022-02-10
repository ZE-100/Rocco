//package com.rocco.backend;
//
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.animation.TranslateTransition;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//import java.net.URL;
//import java.util.Random;
//import java.util.ResourceBundle;
//
//public class Kanvas extends Application implements Initializable {
//
//	@FXML
//	private AnchorPane anchorPane;
//
//	TranslateTransition transition;
//
//	TranslateTransition transition_1;
//
//	Random rand = new Random();
//
//	@Override
//	public void start(Stage primaryStage) throws Exception{
//		Parent root = FXMLLoader.load(getClass().getResource("canvas.fxml"));
//		primaryStage.setTitle("Hello World");
//		primaryStage.setScene(new Scene(root));
//		primaryStage.show();
//	}
//
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	@FXML
//	void start(ActionEvent event) {
//		resetRectangles();
//		transition.play();
//		transition_1.play();
//	}
//
//	public void resetRectangles(){
//		int recHeightX = rand.nextInt(250);
//
//		int recHeight = 25 + rand.nextInt(50);
//		int recWidth = 25 + rand.nextInt(50);
//
//		Rectangle rectangle = new Rectangle(-100,recHeightX,recHeight,recWidth);
//
//		transition = new TranslateTransition();
//
//		anchorPane.getChildren().addAll(rectangle);
//		rectangle.setFill(Color.web("#2191FB"));
//
//		//Rectangle transition
//		transition.setNode(rectangle);
//		transition.setDuration(Duration.seconds(5));
//		transition.setToX(700);
//	}
//
//	@Override
//	public void initialize(URL url, ResourceBundle resourceBundle) {
//		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), e->{
//			resetRectangles();
//			transition.play();
//		}));
//		timeline.setCycleCount(Timeline.INDEFINITE);
//		timeline.play();
//	}
//}