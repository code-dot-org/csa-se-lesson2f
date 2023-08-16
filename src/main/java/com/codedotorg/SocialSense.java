package com.codedotorg;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SocialSense {

    /** The main window to display the app */
    private Stage window;

    /** The width of the scene in the app */
    private int width;

    /** The height of the scene in the app */
    private int height;

    /** The text box that displays the results */
    private TextArea results;

    /** The list of positive words */
    private ArrayList<String> positiveWords;

    /** The list of negative words */
    private ArrayList<String> negativeWords;

    /** The text box for the user to enter their response */
    private TextField inputField;

    /**
     * This class represents a SocialSense object that contains a window, width, height, results,
     * positiveWords, negativeWords, and inputField. The SocialSense object is used to analyze
     * text input and determine if it contains positive or negative words.
     * 
     * @param window the stage to display the results on
     * @param width the width of the window
     * @param height the height of the window
     */
    public SocialSense(Stage window, int width, int height) {
        this.window = window;
        this.width = width;
        this.height = height;

        results = new TextArea();
        results.setWrapText(true);

        positiveWords = createPositiveWords();
        negativeWords = createNegativeWords();

        inputField = createInputField();
    }
    
    /**
     * This method starts the SocialSense application by setting the title of the window to "SocialSense",
     * creating the main scene, adding the styles.css file to the scene, setting the scene to the main scene,
     * and showing the window.
     */
    public void startApp() {
        window.setTitle("SocialSense");

        Scene mainScene = createMainScene();
        mainScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        window.setScene(mainScene);
        window.show();
    }

    /**
     * Creates the main scene for the SocialSense application.
     * 
     * @return the main scene for the application
     */
    public Scene createMainScene() {
        Label titleLabel = new Label("SocialSense");
        titleLabel.setId("titleLabel");
        
        HBox inputLayout = createInputLayout();
        
        VBox mainLayout = new VBox(20);
        mainLayout.getChildren().addAll(titleLabel, results, inputLayout);

        Scene mainScene = new Scene(mainLayout, width, height);

        return mainScene;
    }

    /**
     * Creates an HBox layout containing a Label and an input field for entering a post.
     * 
     * @return the HBox layout containing the Label and input field
     */
    public HBox createInputLayout() {
        Label inputLabel = new Label("Enter the post:");
        inputLabel.setPadding(new Insets(0, 5, 0, 0));

        HBox tempLayout = new HBox();
        tempLayout.getChildren().addAll(inputLabel, inputField);
        tempLayout.setAlignment(Pos.CENTER);

        return tempLayout;
    }

    /**
     * Analyzes the sentiment of a given input string.
     * It splits the input string into words and checks each word against a list of
     * positive and negative words. If a word is found in the positive words list,
     * the positive count is incremented. If a word is found in the negative words
     * list, the negative count is incremented. After all words have been checked,
     * the method returns "Positive" if there are more positive words, "Negative" if
     * there are more negative words, and "Neutral" if the counts are equal.
     *
     * @param input The string to be analyzed.
     * @return A string indicating the overall sentiment ("Positive", "Negative", or "Neutral").
     */
    public String analyzeSentiment(String input) {
        
        return "";
    }

    /**
     * Creates an ArrayList of positive words.
     * 
     * @return ArrayList<String> - Returns an ArrayList containing positive words.
     */
    public ArrayList<String> createPositiveWords() {
        ArrayList<String> temp = new ArrayList<String>();

        temp.add("good");
        temp.add("great");
        temp.add("awesome");
        temp.add("fantastic");
        temp.add("excellent");

        return temp;
    }

    /**
     * Creates a list of negative words.
     * 
     * @return ArrayList<String> This returns the list of negative words.
     */
    public ArrayList<String> createNegativeWords() {
        ArrayList<String> temp = new ArrayList<String>();

        temp.add("bad");
        temp.add("terrible");
        temp.add("awful");
        temp.add("horrible");

        return temp;
    }

    /**
     * Creates a new TextField for user input and sets an action to be performed
     * when the user presses enter. The action updates the user input and sentiment
     * results, and clears the TextField.
     *
     * @return the created TextField
     */
    public TextField createInputField() {
        TextField tempField = new TextField();

        tempField.setOnAction(event -> {
            String userInput = tempField.getText();

            updateUserInput(userInput);
            updateSentimentResults(userInput);
            
            tempField.clear();
        });

        return tempField;
    }

    /**
     * Updates the user input in the results text area.
     * 
     * @param userInput the user's input to be displayed in the results text area
     */
    public void updateUserInput(String userInput) {
        results.appendText("Post: " + userInput + "\n");
    }

    /**
     * Updates the sentiment results based on the user input.
     * Calls the analyzeSentiment method to analyze the sentiment of the user input.
     * Appends the sentiment result to the results text area.
     *
     * @param userInput the user input to analyze the sentiment of
     */
    public void updateSentimentResults(String userInput) {
        String sentiment = analyzeSentiment(userInput);
        results.appendText("Sentiment: " + sentiment + "\n");
    }
    
}
