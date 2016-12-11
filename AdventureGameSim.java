/*Sakhari Thomas
  December 8, 2016
  Professor Krebs
  Assignment 5
*/


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import java.util.Random;

public class AdventureGameSim extends Application{
  //Variables to be used
  private Stage mainStage;
  private VBox sceneBox;
  private HBox buttonBox;
  private HBox title;
  private VBox playerSelections;
  private VBox enemySelections;
  private VBox optionSelections;
  private ListView<String> playerChoice;
  private ListView<String> playerWeapon;
  private ListView<String> enemyChoice;
  private ListView<String> enemyWeapon;
  private RadioButton numEnemies_4;
  private RadioButton numEnemies_5;
  private RadioButton numEnemies_6;
  private RadioButton numRounds_1;
  private RadioButton numRounds_5;
  private RadioButton numRounds_10;
  private RadioButton numRounds_20;
  private Text player;
  private Text enemy;
  private Text options;
  private Text header;
  private Button select_PLAYER;
  private Button select_ENEMY;
  private Button run_SIMULATION;
  private Button exit_Butt;
  private ImageView playerPic;
  private ImageView playerWeapPic;
  private ImageView enemyPic;
  private ImageView enemyWeapPic;

  private static final String PALADIN_IMG = "C:\\Users\\Khari19\\Desktop\\art (1).zip\\art\\Paladin.png";
  private static final String ROGUE_IMG = "C:\\Users\\Khari19\\Desktop\\art (1).zip\\art\\Rogue.png";
  private static final String BRUCE_LEE_IMG = "C:\\Users\\Khari19\\Desktop\\art (1).zip\\art\\JackieChan.png";
  private static final String GOBLIN_IMG = "C:\\Users\\Khari19\\Desktop\\art (1).zip\\art\\Goblin.png";
  private static final String SKELETON_IMG = "C:\\Users\\Khari19\\Desktop\\art (1).zip\\art\\Skeleton.png";
  private static final String AXE_IMG = "C:\\Users\\Khari19\\Desktop\\art (1).zip\\art\\Axe.png";
  private static final String MACE_IMG = "C:\\Users\\Khari19\\Desktop\\art (1).zip\\art\\Mace.png";
  private static final String SHORT_SWORD_IMG = "C:\\Users\\Khari19\\Desktop\\art (1).zip\\art\\ShortSword.png";
  private static final String LONG_SWORD_IMG = "C:\\Users\\Khari19\\Desktop\\art (1).zip\\art\\LongSword.png";

//battle Variables
  private int NUM_ROUNDS;
  private int NUM_ENEMIES;
  private int playerHP;
  private int enemyHP;
  private int playerSTG;
  private int enemySTG;
  private int playerDMG;
  private int enemyDMG;
  private int battleWON;
  private int battleLOST;
  private int enemiesDEF;

  @Override
  public void start (Stage simulation){
    mainStage = simulation;
    mainStage.setTitle("AdvenBattSim");

    //Places the header inside of the title HBox
    header = new Text("Adventure Game Battle Simulator");
    header.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    HBox title = new HBox(0, header);
      title.setAlignment(Pos.CENTER);
      title.setPadding(new Insets(15, 15, 15, 15));


    player = new Text("Player");
    player.setFont(Font.font("Arial", FontWeight.BOLD, 15));
    options = new Text("Options");
    options.setFont(Font.font("Arial", FontWeight.BOLD, 15));
    enemy = new Text("Enemy");
    enemy.setFont(Font.font("Arial", FontWeight.BOLD, 15));


    //Creates player ListViews and places them in the playerSelections VBox
    playerChoice = new ListView<String>();
    playerChoice.getItems().addAll("Paladin", "Rogue", "Bruce Lee");

    playerWeapon = new ListView<String>();
    playerWeapon.getItems().addAll("Mace", "Short Sword", "Long Sword", "Axe");

    select_PLAYER = new Button("Select Player");
    select_PLAYER.setOnAction(e -> setPlayer());

    playerPic = new ImageView();
    playerWeapPic = new ImageView();


    VBox playerSelections = new VBox(50, player, playerChoice, playerPic, playerWeapon, playerWeapPic, select_PLAYER);
    playerSelections.setAlignment(Pos.CENTER);
    playerSelections.setPadding(new Insets(15, 15, 15, 15));

    //Creates enemy ListViews and places them in the enemySelections VBox
    enemyChoice = new ListView<String>();
    enemyChoice.getItems().addAll("Goblin", "Skeleton");

    enemyWeapon = new ListView<String>();
    enemyWeapon.getItems().addAll("Mace", "Short Sword", "Long Sword", "Axe");

    select_ENEMY = new Button("Select Enemy");
    select_ENEMY.setOnAction(e -> setEnemy());

    enemyPic = new ImageView();
    enemyWeapPic = new ImageView();

    VBox enemySelections = new VBox(50, enemy, enemyChoice, enemyPic, enemyWeapon, enemyWeapPic, select_ENEMY);
    enemySelections.setAlignment(Pos.CENTER);
    enemySelections.setPadding(new Insets(15, 15, 15, 15));


    //Here we will construct the optionSelections VBox
    //First the number of enemies ToggleGroup
    Label numEnemiesTitle = new Label("Number of Enemies:");
    numEnemies_4 = new RadioButton("4 enemies");
    numEnemies_4.setSelected(true);
    numEnemies_5 = new RadioButton("5 enemies");
    numEnemies_6 = new RadioButton("6 enemies");

    ToggleGroup enemyNumber = new ToggleGroup();
    numEnemies_4.setToggleGroup(enemyNumber);
    numEnemies_5.setToggleGroup(enemyNumber);
    numEnemies_6.setToggleGroup(enemyNumber);
    numEnemies_4.setPadding(new Insets(12, 12, 12, 12));
    numEnemies_5.setPadding(new Insets(12, 12, 12, 12));
    numEnemies_6.setPadding(new Insets(12, 12, 12, 12));

    //Now the number of rounds ToggleGroup
    Label numRoundsTitle = new Label("Number of Rounds:");
    numRounds_1 = new RadioButton("1 rounds");
    numRounds_1.setSelected(true);
    numRounds_5 = new RadioButton("5 rounds");
    numRounds_10 = new RadioButton("10 rounds");
    numRounds_20 = new RadioButton("20 round");

    ToggleGroup roundNumber = new ToggleGroup();
    numRounds_1.setToggleGroup(roundNumber);
    numRounds_5.setToggleGroup(roundNumber);
    numRounds_10.setToggleGroup(roundNumber);
    numRounds_20.setToggleGroup(roundNumber);
    numRounds_1.setPadding(new Insets(12, 12, 12, 12));
    numRounds_5.setPadding(new Insets(12, 12, 12, 12));
    numRounds_10.setPadding(new Insets(12, 12, 12, 12));
    numRounds_20.setPadding(new Insets(12, 12, 12, 12));

    //Here is where the optionSelections VBox is filled with the ToggleGroups
    VBox enemyMenu = new VBox(numEnemiesTitle, numEnemies_4, numEnemies_5, numEnemies_6);
    enemyMenu.setAlignment(Pos.CENTER);
    VBox roundMenu = new VBox(numRoundsTitle, numRounds_1, numRounds_5, numRounds_10, numRounds_20);
    roundMenu.setAlignment(Pos.CENTER);
    optionSelections = new VBox(options, enemyMenu, roundMenu);
    optionSelections.setAlignment(Pos.CENTER);

    //Here the exit and run simulation buttons will be created
    run_SIMULATION = new Button("RUN SIMULATION");
    run_SIMULATION.setOnAction(e -> battle_Simulation());

    exit_Butt = new Button("EXIT");
    exit_Butt.setOnAction(e -> close());

    buttonBox = new HBox(30, run_SIMULATION, exit_Butt);
    buttonBox.setAlignment(Pos.CENTER);

    //Code for the display of images




    BorderPane sceneBox = new BorderPane();
    sceneBox.setTop(title);
    sceneBox.setLeft(playerSelections);
    sceneBox.setRight(enemySelections);
    sceneBox.setCenter(optionSelections);
    sceneBox.setBottom(buttonBox);



    Scene simScene = new Scene(sceneBox, 1200, 950);

    mainStage.setScene(simScene);
    mainStage.show();

}// end of Start method

//Method for setting player
public void setPlayer(){
  String chosenPlayer = playerChoice.getSelectionModel().getSelectedItem();
  Image playerIMG = null;

  String chosenPlayerWeapon = playerWeapon.getSelectionModel().getSelectedItem();
  Image playerWeaponIMG = null;

  if (chosenPlayer == null && chosenPlayerWeapon == null)
    MessageBox.show("Please select a player and a weapon! Come on Noob.", "ERROR");

  else{
    if (chosenPlayer == null)
      MessageBox.show("Please select a player! Silly Goose.", "ERROR");
    else{
      if (chosenPlayer.equals("Paladin"))
        playerIMG = new Image(PALADIN_IMG);

      else if (chosenPlayer.equals("Rogue"))
        playerIMG = new Image(ROGUE_IMG);

      else if (chosenPlayer.equals("Bruce Lee"))
        playerIMG = new Image(BRUCE_LEE_IMG);

        playerPic.setImage(playerIMG);
    }

    if (chosenPlayerWeapon == null)
      MessageBox.show("Please select a weapon", "ERROR");
    else{

      if (chosenPlayerWeapon.equals("Mace"))
        playerWeaponIMG = new Image(MACE_IMG);

      else if (chosenPlayerWeapon.equals("Short Sword"))
        playerWeaponIMG = new Image(SHORT_SWORD_IMG);

      else if (chosenPlayerWeapon.equals("Long Sword"))
        playerWeaponIMG = new Image(LONG_SWORD_IMG);

      else if (chosenPlayerWeapon.equals("Axe"))
        playerWeaponIMG = new Image(AXE_IMG);

        playerWeapPic.setImage(playerWeaponIMG);

    }
  }
}
//Method for setting enemy
public void setEnemy(){
  String chosenEnemy = enemyChoice.getSelectionModel().getSelectedItem();
  Image enemyIMG = null;

  String chosenEnemyWeapon = enemyWeapon.getSelectionModel().getSelectedItem();
  Image enemyWeaponIMG = null;

  if (chosenEnemy == null && chosenEnemyWeapon == null)
    MessageBox.show("Please select a enemy and a weapon! GET PWNED.", "ERROR");

  else{
    if (chosenEnemy == null)
      MessageBox.show("Please select a enemy! Chicken Butt.", "ERROR");
    else{
      if (chosenEnemy.equals("Goblin"))
        enemyIMG = new Image(GOBLIN_IMG);

      else if (chosenEnemy.equals("Skeleton"))
        enemyIMG = new Image(SKELETON_IMG);

        enemyPic.setImage(enemyIMG);
    }

    if (chosenEnemyWeapon == null)
      MessageBox.show("Please select a weapon", "ERROR");
    else{

      if (chosenEnemyWeapon.equals("Mace"))
        enemyWeaponIMG = new Image(MACE_IMG);

      else if (chosenEnemyWeapon.equals("Short Sword"))
        enemyWeaponIMG = new Image(SHORT_SWORD_IMG);

      else if (chosenEnemyWeapon.equals("Long Sword"))
        enemyWeaponIMG = new Image(LONG_SWORD_IMG);

      else if (chosenEnemyWeapon.equals("Axe"))
        enemyWeaponIMG = new Image(AXE_IMG);

        enemyWeapPic.setImage(enemyWeaponIMG);

    }
  }
}
//Method for simulating the unseen battle
  public void battle_Simulation(){
    int playerATK = 0;
    int minionATK = 0;
    int currentHealth = 0;
    int startingNumRounds = 0;
    playerHP = 0;
    enemyHP = 0;
    playerSTG = 0;
    enemySTG = 0;
    playerDMG = 0;
    enemyDMG = 0;
    battleWON = 0;
    battleLOST = 0;
    enemiesDEF = 0;

    Random attack = new Random();

    String hero = playerChoice.getSelectionModel().getSelectedItem();
    switch (hero){
      case "Paladin":
      playerHP = 35;
      playerSTG = 14;
      break;

      case "Rogue":
      playerHP = 55;
      playerSTG = 8;
      break;

      case "Bruce Lee":
      playerHP = 45;
      playerSTG = 10;
      break;
    }

    String minion = enemyChoice.getSelectionModel().getSelectedItem();
    switch (minion){
      case "Goblin":
      enemyHP = 25;
      enemySTG = 4;
      break;

      case "Skeleton":
      enemyHP = 25;
      enemySTG = 3;
      break;
    }

    String heroWeapon = playerWeapon.getSelectionModel().getSelectedItem();
    switch (heroWeapon){
      case "Mace":
      playerDMG = attack.nextInt(6 - 2 + 1) + 2;
      break;

      case "Short Sword":
      playerDMG = attack.nextInt(4 - 1 + 1) + 1;
      break;

      case "Long Sword":
      playerDMG = attack.nextInt(7 - 3 + 1) + 3;
      break;

      case "Axe":
      playerDMG = attack.nextInt(6 - 2 + 1) + 2;
    }

    String minionWeapon = enemyWeapon.getSelectionModel().getSelectedItem();
    switch (heroWeapon){
      case "Mace":
      enemyDMG = attack.nextInt(6 - 2 + 1) + 2;
      break;

      case "Short Sword":
      enemyDMG = attack.nextInt(4 - 1 + 1) + 1;
      break;

      case "Long Sword":
      enemyDMG = attack.nextInt(7 - 3 + 1) + 3;
      break;

      case "Axe":
      enemyDMG = attack.nextInt(6 - 2 + 1) + 2;
    }

    if (numRounds_1.isSelected())
      startingNumRounds = 1;
    else if (numRounds_5.isSelected())
      startingNumRounds = 5;
    else if(numRounds_10.isSelected())
      startingNumRounds = 10;
    else if (numRounds_20.isSelected())
      startingNumRounds = 20;

      if (numRounds_1.isSelected())
        NUM_ROUNDS = 1;
      else if (numRounds_5.isSelected())
        NUM_ROUNDS = 5;
      else if(numRounds_10.isSelected())
        NUM_ROUNDS = 10;
      else if (numRounds_20.isSelected())
        NUM_ROUNDS = 20;

      if (numEnemies_4.isSelected())
        NUM_ENEMIES = 4;
      else if (numEnemies_5.isSelected())
        NUM_ENEMIES = 5;
      else if (numEnemies_6.isSelected())
        NUM_ENEMIES = 6;

        while (NUM_ROUNDS > 0){
          currentHealth = playerHP;
          for (int j = 1; j <= NUM_ENEMIES; j++){
            enemyHP = 25;

            while (enemyHP > 0 && currentHealth > 0){
              playerATK = playerDMG + playerSTG;
              enemyHP -= playerATK;

              if (enemyHP <= 0)
              break;

              minionATK = enemyDMG + enemySTG;
              currentHealth -= minionATK;
            }

            if (currentHealth > 0)
              enemiesDEF++;

              else{
                battleLOST++;
                break;
              }
          }
          if (currentHealth > 0){
            NUM_ROUNDS--;
            battleWON++;
          }
        }
        MessageBox.show(("Number of enemies per round: " + NUM_ENEMIES + "\nNumber of rounds: " + startingNumRounds +
                        "\nNumber of battles won: " + battleWON + "\nNumber of battles lost: " + battleLOST +
                        "\nTotal number of enemies defeated: " + enemiesDEF), "SIMULATION RESULTS");
      }




  public void close() {
    mainStage.close();
  }

  public static void main(String[] args){
    Application.launch(args);
  }


}
