import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Kanvas extends Application implements Initializable {

	@FXML
	private AnchorPane anchorPane;

	TranslateTransition transition;

	TranslateTransition transition_1;

	Random rand = new Random();


	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("canvas.fxml"));
		primaryStage.setTitle("Hello World");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}

	@FXML
	void start(ActionEvent event) {
		resetRectangles();
		transition.play();
		transition_1.play();
	}

	public void resetRectangles(){
		int recHeightX = rand.nextInt(250);
		int recHeightX_1 = rand.nextInt(250);

		int recHeight = 25 + rand.nextInt(50);
		int recWidth = 25 + rand.nextInt(50);

		int recHeight_1 = 25 + rand.nextInt(50);
		int recWidth_1 = 25 + rand.nextInt(50);

		Rectangle rectangle = new Rectangle(-100,recHeightX,recHeight,recWidth);

		Rectangle rectangle_1 = new Rectangle(600,recHeightX_1,recHeight_1,recWidth_1);

		transition = new TranslateTransition();

		transition_1 = new TranslateTransition();

		anchorPane.getChildren().addAll(rectangle,rectangle_1);
		rectangle.setFill(Color.web("#2191FB"));
		rectangle_1.setFill(Color.web("#BA274A"));

		//Rectangle transition
		transition.setNode(rectangle);
		transition.setDuration(Duration.seconds(5));
		transition.setToX(700);


		//Rectangle_1 transition
		transition_1.setNode(rectangle_1);
		transition_1.setDuration(Duration.seconds(5));
		transition_1.setToX(-700);
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), e->{
			resetRectangles();
			transition.play();
			transition_1.play();
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
}