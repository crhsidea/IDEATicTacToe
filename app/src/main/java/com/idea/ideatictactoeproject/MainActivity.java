package com.idea.ideatictactoeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    private Button[][] board = new Button[3][3];

    private boolean player1turn = true;

    private int roundCount;

    private int player1points;
    private int player2points;

    private TextView player1text;
    private TextView player2text;

    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Part 2: Setting up logic

        //Lets connect our xml to our Java code now
        //We'll assign variables for each thing inside of the XML

        //player1text will refer to the player1 text we created
        //We can access it by ID, by doing findViewByID(R.id.player1_text)
        player1text = findViewById(R.id.player1_text);
        //now lets do the same thing with player2text in the next line:
        //player2text = ;

        //this loops through all the buttons and assigns them to a 2D array of buttons
        //it looks complicated but it's just a nested for loop that loops through the buttons by calling their IDs
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                String ID = "button_" + i + j;
                int resID = getResources().getIdentifier(ID, "id", getPackageName());
                board[i][j] = findViewById(resID);
                //you'll notice that each button has an onclicklistener set. this will be explained more later
                board[i][j].setOnClickListener(this);
            }
        }

        //Here, we connect the resetButton, and set an onclicklistener
        resetButton = findViewById(R.id.reset_button);

        //an onclicklistener basically is just code that is executed when a button is clicked
        //this code below demonstrates the syntax
        resetButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBoard();
            }
        });
    }

    //remember that we set the onclicklistner of board to "this"? that was just to make it easier to put more code for what to do when the button is clicked
    @Override
    public void onClick(View v) {
        //if the button is not empty (already filled), exit
        if(!((Button) v).getText().toString().equals("")){
            return;
        }
        //if it is player 1's turn, set the button text to "X"
        //setText does exactly what you think it would: it sets the text of a textview or button to whatever you put in the parentheses
        if(player1turn){
            ((Button) v).setText("X");
        }
        //if it's player 2's turn, set the button text to "O"
        //write the code for this one on your own. it should be exactly like the code for player1turn, but you setText to O
        else{

        }

        roundCount++;

        //here, we check for whether either player has won. the logic for checking is written in the checkForWin method below
        if(checkForWin()){
            if(player1turn){
                player1win();
            }
            else{
                player2win();
            }
        }
        else if(roundCount == 9){
            draw();
        }
        else{
            player1turn = !player1turn;
        }

    }

    private boolean checkForWin(){
        //first, we take the text value of all the buttons, and put them into a string array so they are more accessible
        String [][] boardString = new String[3][3];

        //puts the buttons into string array
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                boardString[i][j] = board[i][j].getText().toString();
            }
        }

        //now we need to check the array to see if the conditions for winning are met.
        //first we will check rows for a win
        //we loop through each row, and check to see if the first box is filled, and if the rest are equal to it
        for(int i = 0; i < 3; i++){
            if(!boardString[i][0].equals("") && boardString[i][0].equals(boardString[i][1]) && boardString[i][0].equals(boardString[i][2])){
                return true;
            }
        }

        //now, you write the code for checking columns
        //it should be very similar, with minor adjustments to check columns instead of rows
        for(int i = 0; i < 3; i++){

        }

        //now, write 2 if statements to check for diagonals on your own.
        //you can do it, i believe in you
        if(){

        }

        if(){

        }


        return false;
    }

    //this is the code for if player1wins.
    private void player1win(){
        //we give a point to player 1
        player1points++;
        //then we use Toast to send a message to the player. A toast is a notification that appears on the screen, and then disappears after a short time
        Toast.makeText(this, "Player 1 Wins", Toast.LENGTH_SHORT).show();
        //we call the updatepointstext method which will change the score display
        updatePointsText();
        //we reset the board so they can play again
        resetBoard();
    }

    //write the code for player2win on your own!
    //make sure to add points, display a toast, update the scoreboard text, and reset the board
    private void player2win(){

    }

    //the draw case is when there are no more possible moves. Do this method on your own as well
    //make it display a toast, and then reset the board
    private void draw(){

    }

    private void updatePointsText(){
        //here we use the .setText method again, and set the scoreboard to display the right amount of points
        player1text.setText("Player 1: " + player1points);
        player2text.setText("Player 2: " + player2points);
    }

    private void resetBoard(){

        //this simply loops through each button, and sets it to ""
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j].setText("");
            }
        }

        roundCount = 0;
        player1turn = true;
    }

    //Try running the program now, and see if it works!



    //Challenge: Increase the size of the board to 5x5, and try to make it work. You will need to update the number of buttons, and change the logic slightly in order for it to work
}


