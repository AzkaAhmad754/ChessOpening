package application;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Create a BorderPane for the main layout
            BorderPane root = new BorderPane();

            // Create an ImageView for the background image
            ImageView backgroundImage = new ImageView(new Image("Chess wallpaper.png"));
            root.getChildren().add(backgroundImage);

            // Set the size of the ImageView to match the scene dimensions
            backgroundImage.fitWidthProperty().bind(primaryStage.widthProperty());
            backgroundImage.fitHeightProperty().bind(primaryStage.heightProperty());

            // Create ImageViews for buttons
            ImageView startGameButton = new ImageView(new Image("Play.png"));
            ImageView instructionsButton = new ImageView(new Image("Instructions.png"));
            ImageView computerButton = new ImageView(new Image("Computer.png"));
            
            // Set size of the ImageViews
            startGameButton.setFitWidth(100);
            startGameButton.setFitHeight(50);
            instructionsButton.setFitWidth(100);
            instructionsButton.setFitHeight(50);
            computerButton.setFitWidth(100);
            computerButton.setFitHeight(50);
            
            // Create a VBox to hold the buttons
            VBox buttonBox = new VBox(10); // spacing
            buttonBox.setAlignment(Pos.CENTER); // alignment
            buttonBox.setPadding(new Insets(50)); // padding

            // Create Buttons using ImageViews
            Button startGame = createButton(startGameButton);
            Button instructions = createButton(instructionsButton);
            Button computer = createButton(computerButton);
            
            // Add buttons to the VBox
            buttonBox.getChildren().addAll(startGame, instructions, computer);

            // Add event handler to the Instructions button
            instructions.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    // Display another image when the Instructions button is clicked
                    ImageView page2Image = new ImageView(new Image("page2.png"));

                    // Bind the size of the ImageView to the size of the BorderPane
                    page2Image.fitWidthProperty().bind(root.widthProperty());
                    page2Image.fitHeightProperty().bind(root.heightProperty());

                    // Create a return button to go back to the previous page
                    ImageView returnButtonImage = new ImageView(new Image("Return.png"));
                    returnButtonImage.setFitWidth(10); // Adjust the width as needed
                    returnButtonImage.setFitHeight(10); // Adjust the height as needed
                    Button returnButton = new Button("", returnButtonImage);
                    returnButton.setOnAction(e -> root.setCenter(buttonBox));


                    // Create a Check button
                    ImageView checkButtonImage = new ImageView(new Image("Check.png"));
                    checkButtonImage.setFitWidth(90); // Adjust the width as needed
                    checkButtonImage.setFitHeight(70); // Adjust the height as needed
                    Button checkButton = createButton(checkButtonImage);

                    // Add event handler to the Check button
                    checkButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            // Display the Check description image when the Check button is clicked
                            ImageView checkDescriptionImage = new ImageView(new Image("CheckDescription.png"));
                            checkDescriptionImage.fitWidthProperty().bind(root.widthProperty());
                            checkDescriptionImage.fitHeightProperty().bind(root.heightProperty());
                            
                            // Create a return button on top of the Check description image
                            ImageView returnButtonImage = new ImageView(new Image("Return.png"));
                            returnButtonImage.setFitWidth(10); // Adjust the width as needed
                            returnButtonImage.setFitHeight(10); // Adjust the height as needed
                            Button returnButton = new Button("", returnButtonImage);
                            returnButton.setOnAction(e -> root.setCenter(buttonBox));

                            // Create a StackPane to hold the Check description image and the return button
                            StackPane checkDescriptionPane = new StackPane();
                            checkDescriptionPane.getChildren().addAll(checkDescriptionImage, returnButton);
                            checkDescriptionPane.setAlignment(returnButton, Pos.TOP_LEFT);
                            
                            root.setCenter(checkDescriptionPane);
                        }
                    });

                    // Create a SpecialMoves button
                    ImageView specialMovesButtonImage = new ImageView(new Image("SpecialMoves.png"));
                    specialMovesButtonImage.setFitWidth(100); // Adjust the width as needed
                    specialMovesButtonImage.setFitHeight(70); // Adjust the height as needed
                    Button specialMovesButton = createButton(specialMovesButtonImage);
                 // Add event handler to the SpecialMoves button
                    specialMovesButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            // Display the EnPassant image when the SpecialMoves button is clicked
                            ImageView enPassantImage = new ImageView(new Image("EnPassant.png"));
                            enPassantImage.fitWidthProperty().bind(root.widthProperty());
                            enPassantImage.fitHeightProperty().bind(root.heightProperty());
                            
                            // Create a return button on top of the EnPassant image
                            ImageView returnButtonImage = new ImageView(new Image("Return.png"));
                            returnButtonImage.setFitWidth(10); // Adjust the width as needed
                            returnButtonImage.setFitHeight(10); // Adjust the height as needed
                            Button returnButton = new Button("", returnButtonImage);
                            returnButton.setOnAction(e -> root.setCenter(buttonBox));
                            
                            // Create a next button on EnPassant.png to open Castling.png
                            ImageView nextButtonImage = new ImageView(new Image("Next.png"));
                            nextButtonImage.setFitWidth(10); // Adjust the width as needed
                            nextButtonImage.setFitHeight(10); // Adjust the height as needed
                            Button nextButton = new Button("", nextButtonImage);
                            nextButton.setOnAction(e -> {
                                ImageView castlingImage = new ImageView(new Image("Castling.png"));
                                castlingImage.fitWidthProperty().bind(root.widthProperty());
                                castlingImage.fitHeightProperty().bind(root.heightProperty());
                                
                                // Create a return button on top of the Castling image
                                Button returnButtonForCastling = new Button("", returnButtonImage);
                                returnButtonForCastling.setOnAction(ev -> root.setCenter(buttonBox));
                                
                                // Create a next button on Castling.png to open Promotion.png
                                ImageView nextButtonOnCastlingImage = new ImageView(new Image("Next.png"));
                                nextButtonOnCastlingImage.setFitWidth(10); // Adjust the width as needed
                                nextButtonOnCastlingImage.setFitHeight(10); // Adjust the height as needed
                                Button nextButtonOnCastling = new Button("", nextButtonOnCastlingImage);
                                nextButtonOnCastling.setOnAction(ev -> {
                                    ImageView promotionImage = new ImageView(new Image("Promotion.png"));
                                    promotionImage.fitWidthProperty().bind(root.widthProperty());
                                    promotionImage.fitHeightProperty().bind(root.heightProperty());
                                    
                                    // Create a return button on top of the Promotion image
                                    Button returnButtonForPromotion = new Button("", returnButtonImage);
                                    returnButtonForPromotion.setOnAction(eve -> root.setCenter(buttonBox));
                                    
                                    // Create a StackPane to hold the Promotion image and the return button
                                    StackPane promotionPane = new StackPane();
                                    promotionPane.getChildren().addAll(promotionImage, returnButtonForPromotion);
                                    promotionPane.setAlignment(returnButtonForPromotion, Pos.TOP_LEFT);
                                    
                                    root.setCenter(promotionPane);
                                });
                                
                                // Create a StackPane to hold the Castling image and the next button
                                StackPane castlingPane = new StackPane();
                                castlingPane.getChildren().addAll(castlingImage, returnButtonForCastling, nextButtonOnCastling);
                                castlingPane.setAlignment(returnButtonForCastling, Pos.TOP_LEFT);
                                castlingPane.setAlignment(nextButtonOnCastling, Pos.TOP_RIGHT);
                                
                                root.setCenter(castlingPane);
                            });

                            // Create a StackPane to hold the EnPassant image and the return button
                            StackPane enPassantPane = new StackPane();
                            enPassantPane.getChildren().addAll(enPassantImage, returnButton, nextButton);
                            enPassantPane.setAlignment(returnButton, Pos.TOP_LEFT);
                            enPassantPane.setAlignment(nextButton, Pos.TOP_RIGHT);
                            
                            root.setCenter(enPassantPane);
                        }
                    });

                    // Create a BasicConcepts button
                    ImageView basicConceptsButtonImage = new ImageView(new Image("BasicConcepts.png"));
                    basicConceptsButtonImage.setFitWidth(100); // Adjust the width as needed
                    basicConceptsButtonImage.setFitHeight(70); // Adjust the height as needed
                    Button basicConceptsButton = createButton(basicConceptsButtonImage);
                    
                    // Add event handler to the BasicConcepts button
                    basicConceptsButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            // Display the BasicConceptsDescription image when the BasicConcepts button is clicked
                            ImageView basicConceptsDescriptionImage = new ImageView(new Image("Basic conceptsDescription.png"));
                            basicConceptsDescriptionImage.fitWidthProperty().bind(root.widthProperty());
                            basicConceptsDescriptionImage.fitHeightProperty().bind(root.heightProperty());
                            
                            // Create a return button on top of the BasicConceptsDescription image
                            ImageView returnButtonImage = new ImageView(new Image("Return.png"));
                            returnButtonImage.setFitWidth(10); // Adjust the width as needed
                            returnButtonImage.setFitHeight(10); // Adjust the height as needed
                            Button returnButton = new Button("", returnButtonImage);
                            returnButton.setOnAction(e -> root.setCenter(buttonBox));

                            // Create a StackPane to hold the BasicConceptsDescription image and the return button
                            StackPane basicConceptsDescriptionPane = new StackPane();
                            basicConceptsDescriptionPane.getChildren().addAll(basicConceptsDescriptionImage, returnButton);
                            basicConceptsDescriptionPane.setAlignment(returnButton, Pos.TOP_LEFT);
                            
                            root.setCenter(basicConceptsDescriptionPane);
                        }
                    });

                    // Create a Moves button
                    ImageView movesButtonImage = new ImageView(new Image("Moves.png"));
                    movesButtonImage.setFitWidth(90); // Adjust the width as needed
                    movesButtonImage.setFitHeight(70); // Adjust the height as needed
                    Button movesButton = createButton(movesButtonImage);

                    // Add event handler to the Moves button
                    movesButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            // Display the movesDescription image when the Moves button is clicked
                            ImageView movesDescriptionImage = new ImageView(new Image("MovesDescription.png"));
                            movesDescriptionImage.fitWidthProperty().bind(root.widthProperty());
                            movesDescriptionImage.fitHeightProperty().bind(root.heightProperty());
                            
                            // Create a return button on top of the moves description image
                            ImageView returnButtonImage = new ImageView(new Image("Return.png"));
                            returnButtonImage.setFitWidth(10); // Adjust the width as needed
                            returnButtonImage.setFitHeight(10); // Adjust the height as needed
                            Button returnButton = new Button("", returnButtonImage);
                            returnButton.setOnAction(e -> root.setCenter(buttonBox));

                            // Create a StackPane to hold the moves description image and the return button
                            StackPane movesDescriptionPane = new StackPane();
                            movesDescriptionPane.getChildren().addAll(movesDescriptionImage, returnButton);
                            movesDescriptionPane.setAlignment(returnButton, Pos.TOP_LEFT);
                            
                            root.setCenter(movesDescriptionPane);
                        }
                    });

                    // Create a StackPane to center the Moves button and add the other buttons around it with some spacing
                    StackPane page2Content = new StackPane();
                    page2Content.getChildren().addAll(page2Image, movesButton, checkButton, specialMovesButton, basicConceptsButton);
                    page2Content.setAlignment(movesButton, Pos.CENTER);
                    checkButton.setTranslateX(-70); // Move the Check button to the left by 70 pixels
                    checkButton.setTranslateY(100); // Move the Check button down by 100 pixels
                    specialMovesButton.setTranslateX(70); // Move the SpecialMoves button to the right by 70 pixels
                    specialMovesButton.setTranslateY(100); // Move the SpecialMoves button down by 100 pixels
                    basicConceptsButton.setTranslateX(70); // Move the BasicConcepts button up by 50 pixels
                    movesButton.setTranslateX(-70);//on up by 100 pixels

                    // Create a BorderPane to hold the return button and the StackPane
                    BorderPane page2Layout = new BorderPane();
                    page2Layout.setTop(returnButton);
                    page2Layout.setAlignment(returnButton, Pos.TOP_LEFT);
                    page2Layout.setCenter(page2Content);

                    
                    
                    // Add the BorderPane to a VBox
                    VBox vbox = new VBox(10); // spacing
                    vbox.setAlignment(Pos.CENTER); // alignment
                    vbox.getChildren().addAll(page2Layout);

                    // Set the center of the BorderPane to display the second page
                    root.setCenter(vbox);
                }
            });

            // Add the button box to the center of the BorderPane
            root.setCenter(buttonBox);

            // Create a Scene with the BorderPane as its root
            Scene scene = new Scene(root, 990, 688);

            // Set the Scene to the Stage
            primaryStage.setScene(scene);

            // Set the title of the Stage
            primaryStage.setTitle("Chess Game");

            // Show the Stage
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    // Method to create a button with animation effect
    private Button createButton(ImageView imageView) {
        Button button = new Button("", imageView);
        
        // Add event handler for mouse enter to apply animation
        button.setOnMouseEntered(event -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), button);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.play();
        });
        
        // Add event handler for mouse exit to revert to original size
        button.setOnMouseExited(event -> {
            ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), button);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });
        
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}