package application;

import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class playerNumberController {
	@FXML
	Button back;
	@FXML
	Button twoPlayer;
	@FXML
	Button threePlayer;
	@FXML
	Button fourPlayer;
	@FXML
	ImageView backImage;
	@FXML
	ImageView twoPlayerImage;
	@FXML
	ImageView threePlayerImage;
	@FXML
	ImageView fourPlayerImage;
	
	public static Stage stage;
	private int portNumber = 10000;
	
	Image image1 = new Image(this.getClass().getResourceAsStream("/buttons/backLeft1.png"));
	Image image2 = new Image(this.getClass().getResourceAsStream("/buttons/backLeft2.png"));
	Image image3 = new Image(this.getClass().getResourceAsStream("/buttons/2players.png"));
	Image image4 = new Image(this.getClass().getResourceAsStream("/buttons/2players(o).png"));
	Image image5 = new Image(this.getClass().getResourceAsStream("/buttons/3players.png"));
	Image image6 = new Image(this.getClass().getResourceAsStream("/buttons/3players(o).png"));
	Image image7 = new Image(this.getClass().getResourceAsStream("/buttons/4players.png"));
	Image image8 = new Image(this.getClass().getResourceAsStream("/buttons/4players(o).png"));
	
	@FXML
	public void initialize() {
		MultiplayerSelectionController.playerNumberStage = true;
		EventHandler<MouseEvent> event1 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				EventTarget target = event.getTarget();
				if(target == back) backImage.setImage(image1);
				else if(target == twoPlayer) twoPlayerImage.setImage(image4);
				else if(target == threePlayer) threePlayerImage.setImage(image6);
				else if(target == fourPlayer) fourPlayerImage.setImage(image8);
			}
		};
		EventHandler<MouseEvent> event2 = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				EventTarget target = event.getTarget();
				if(target == back) backImage.setImage(image2);
				else if(target == twoPlayer) twoPlayerImage.setImage(image3);
				else if(target == threePlayer) threePlayerImage.setImage(image5);
				else if(target == fourPlayer) fourPlayerImage.setImage(image7);
			}
		};
		
		back.addEventFilter(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		back.addEventFilter(MouseEvent.MOUSE_EXITED_TARGET, event2);
		twoPlayer.addEventFilter(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		twoPlayer.addEventFilter(MouseEvent.MOUSE_EXITED_TARGET, event2);
		threePlayer.addEventFilter(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		threePlayer.addEventFilter(MouseEvent.MOUSE_EXITED_TARGET, event2);
		fourPlayer.addEventFilter(MouseEvent.MOUSE_ENTERED_TARGET, event1);
		fourPlayer.addEventFilter(MouseEvent.MOUSE_EXITED_TARGET, event2);
	}
	
	public void handleBack() {
		MultiplayerSelectionController.stage.close();
		try {
			stage = new Stage();
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("multiplayerSelectionUI.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("Rabby hops - Bananas Hamp");
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {
					System.exit(0);
				}
			});
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void handleTwoPlayer() {
		new WaitingHostController(portNumber, 2);
		portNumber++;
	}
	
	public void handleThreePlayer() {
		new WaitingHostController(portNumber, 3);
		portNumber++;
	}
	
	public void handleFourPlayer() {
		new WaitingHostController(portNumber, 4);
		portNumber++;
	}
	
}
