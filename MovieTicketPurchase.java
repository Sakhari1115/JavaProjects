import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.geometry.*;

public class MovieTicketPurchase extends Application {

  // Declare the class properties
  private Stage stage;
  private VBox sceneBox;
  private HBox movieListingBox;
  private HBox numTicketsBox;
  private HBox buttonBox;
  private Label movieListingLabel;
  private Label numTicketsLabel;
  private ChoiceBox<String> movieChoiceBox;
  private TextField numTicketsTextField;
  private Button purchaseButton;
  private Button cancelButton;

  // Use these constants when calculating total cost
  private static double TICKET_PRICE_3D = 17.0;
  private static double TICKET_PRICE_2D = 12.0;

  @Override
  public void start(Stage primaryStage) {
    stage = primaryStage;
    stage.setTitle("PURCHASE MOVIE TICKETS");

    // Initialize movieListingLabel and set its minimum width to 75
    movieListingLabel = new Label("Select a movie");
    movieListingLabel.setMinWidth(75);

    // Initialize movieChoiceBox and add the following movie titles to it:
    // Batman V Superman (3D)
    // Kung Fu Panda 3 (2D)
    // My Big Fat Greek Wedding 2 (3D)
    // Rush Hour (2D)
    movieChoiceBox = new ChoiceBox<String>();
    movieChoiceBox.getItems().addAll("Batman V Superman (3D)", "Kung Fu Panda 3 (2D)", "My Big Fat Greek Wedding 2 (3D)", "Rush Hour (2D)");


    // Place movieListingLabel and movieChoiceBox into the movieListingBox container
    movieListingBox = new HBox(20, movieListingLabel, movieChoiceBox);

    // Initialize numTicketsLabel and set its minimum width to 75
    numTicketsLabel = new Label("Number of tickets");
    numTicketsLabel.setMinWidth(75);


    // Initialize numTicketsTextField and set its preferred column width to 4
    numTicketsTextField = new TextField();
    numTicketsTextField.setPrefColumnCount(4);


    // Place numTicketsLabel and numTicketsTextField into the numTicketsBox container
    numTicketsBox = new HBox(20, numTicketsLabel, numTicketsTextField);

    //  Initialize purchaseButton and cancelButton
    purchaseButton = new Button("Complete Purchase");
    cancelButton = new Button("Cancel Order");


    // Set the actions for the buttons
    cancelButton.setOnAction(e -> close());
    purchaseButton.setOnAction(e -> displayResults());

    // Place the two buttons into buttonBox with 60 pixels between them
    HBox buttonBox = new HBox(60, purchaseButton, cancelButton);

    // Center the buttons in buttonBox
    buttonBox.setAlignment(Pos.CENTER);

    // Add the sub-containers to the sceneBox and put some padding around each one
    sceneBox = new VBox(60, movieListingBox, numTicketsBox, buttonBox);
    sceneBox.setPadding(new Insets(30,20,30,20));

    // Create a new Scene object with the sceneBox in it
    Scene scene = new Scene(sceneBox, 440, 280);

    // Set scene to be the scene for stage and show the stage
    stage.setScene(scene);
    stage.show();

  }

  // This method will close and application
  public void close() {
    stage.close();
  }

public void displayResults(){
  int numTickets = 0;
  double totalCost = 0.0;

  String movieSelection = movieChoiceBox.getValue();

  if (movieSelection == null){
  MessageBox pickMovie = new MessageBox();
  pickMovie.show("You must select a movie!", "Select Movie");
  }
else{
   try{
     numTickets = Integer.parseInt(numTicketsTextField.getText());

      if (movieSelection.endsWith("(2D)")){
        totalCost = numTickets * TICKET_PRICE_2D;
      }

      else if (movieSelection.endsWith("(3D)")) {
        totalCost = numTickets * TICKET_PRICE_3D;
      }


    MessageBox complete = new MessageBox();
    complete.show("Your total is: $" + totalCost, "Purchase Complete");
  } catch (NumberFormatException e){
    MessageBox selectTickets = new MessageBox();
    selectTickets.show("Please enter a number for the number of tickets!", "Buy Tickets");
  }
}
}

  public static void main(String[] args) {
    Application.launch(args);
  }

}
