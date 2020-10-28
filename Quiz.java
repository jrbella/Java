import java.util.*;

/**
 * Author: Jeff Bella
 * Date October, 2020
 * Summary:
 *  This program will be used to create quizzes and test users
 *  based on these quizzes.
 */

public class Quiz {

    public static void main(String[] args) {
        
        // declare secret
        String secretCode = "myCode1";          // secret code
        
        // validate the secret code
        // system exits after 5 attempts
        checkSecretCode(secretCode);
        System.out.print("Secret Code Validated");

        // user menu
        int userMenuChoice = userMenuSelection();
        
        // debugging line
        System.out.print("you have chose option: " + userMenuChoice + "\n");

        // parsing the users choice
        switch(userMenuChoice){
            case 1:
                // run method
                quizCreationMode();
                break;
            case 2:
                // run method
                break;
            default:
                System.out.print("\nExiting System ...");
                System.exit(0);
        }
    }

    public static void quizCreationMode(){

        System.out.print("What would you like to do?\n" +
                        "Add a new question                :1\n" +
                        "Delete an exsisting Question      :2\n" +
                        "List all available questions      :3\n" +
                        "Go back to the main menu          :4\n" +
                        "Your choice:                      :");
        
        // get user response
        int response = getUserInt();
        
        // debug line
        System.out.print("You have entered option: " + response + "\n");

        // add question method
        if(response == 1){
            addNewQuestion();
        }
        // delete question method

        // show questions method

        // go to the main menu
    }
    
    public static void addNewQuestion(){

        /* 
            Note:
                before the execution of each
                method make sure I put a message
                to the user.  Just got really confused
                in debugging lol
        */

        // Get the question code from the user
        System.out.print("Please enter the Question Code (#):   ");
        int questionCode = getUserInt();

        // Get the question Text
        System.out.print("Please enter the questions' text:    ");
        String questionText = getUserStr();
        
        // Get the number of possible answers'
        System.out.print("Please enter the number of possible answers: ");
        int numberOfPossibleAnswers = getUserInt();

        for(int i = 0; i < numberOfPossibleAnswers; i++){
            
            // message to tell user which question they are on
            System.out.print("Please enter  answer #" + (i+1) + ":  ");
            storeQuizQuestionAnswer();

        }

        // Get the correct answer
        System.out.print("Please enter the correct Answer: ");
        storeQuizQuestionAnswer();



    }

    
    public static void storeQuizQuestionAnswer(){

        // gets the users string and stores it
        String result = getUserStr();

        // check for duplicates

        // debug and message the user
        System.out.print("Answer has been stored!\n");


        // future code to store the result string
    }


    public static boolean checkSecretCode(String secretCode){

        final int maximumSecretAttempts = 5;    // maximum secret attempts
        int currentSecretAttempts = 0;          // current secret attempts

        // get user data
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please  your secret code: ");
        String userInput = keyboard.nextLine();

        // unary operator trick from professor
        while(!secretCode.equals(userInput)){

            // checking user can make a secret attempt
            if(checkSecretAttempts(currentSecretAttempts, maximumSecretAttempts)){

                // let user know its incorrect
                System.out.print("You have ed an incorrect code" +
                                    " please try again: ");
                userInput = keyboard.nextLine();

                // increment counter currentSecretAttempts
                currentSecretAttempts ++;
                
                // message to user also a debug line
                System.out.print("Attempt " + currentSecretAttempts + "\n");
            }
            else{

                // failed to login
                System.out.print("You have reached the maximum Secret attempts");
                System.out.print(" System exiting ....");
                System.exit(0);
            }
        }

        // return true if passes valdiation
        return true;
    }

    /**
     * This method gets and validates an integer
     * input 
     * @return returns a vaild integer from a user input
     */

    public static String getUserStr(){
        
        // validation flag
        boolean isInvalid = true;
        String result;

        // create keyboard object
        Scanner keyboard = new Scanner(System.in);

        // start validation loop
        while(isInvalid){
            try{

                isInvalid = false;
                result = keyboard.nextLine();
                return result;
            }
            catch(InputMismatchException e){

                // let user know that the input type is invalid
                System.out.print("Your input is invalid. Please  again  ");
                result = keyboard.nextLine();
            }   
        }

        // redundant
        return "";
    }
    public static int getUserInt(){

        // validation flag
        boolean isInvalid = true;
        int result;

        // create keyboard object
        Scanner keyboard = new Scanner(System.in);

        // start validation loop
        while(isInvalid){
            try{

                isInvalid = false;
                result = keyboard.nextInt();
                return result;
            }
            catch(InputMismatchException e){

                // let user know that the input type is invalid
                System.out.print("Your input is invalid. Please  again  ");
                result = keyboard.nextInt();
            }   
        }

        // redundant
        return 0;
    }

    /**
     * This is a helper method to determine if a user has reached
     * their maximum attempts on their secret
     * @param currentSecretAttempts which secret attempt they are currently on.
     * @param maximumSecretAttempts the maximum secret attempts allowed.
     * @return
     */

    public static boolean checkSecretAttempts(int currentSecretAttempts, int maximumSecretAttempts){
        
        boolean result = currentSecretAttempts < maximumSecretAttempts ? true : false;
        return result;
    }

    /**
     * This is a method for user selection on the main 
     * menu
     * @return returns the user selection
     */
    public static int userMenuSelection(){
        
        // user selection flag
        boolean userMenuSelectionFlag = true;
  
        while(userMenuSelectionFlag){
      
            System.out.print("Welcome to the quiz Master\n" +
            "If you want to manage questions  :1 \n" +
            "If you want to take a quiz       :2 \n" +
            "If you want to exit              :3 \n" +
            "  your choice:                   |");
            
            try{
                int userSelection = getUserInt();
                
                // Checks for numbers 1,2,3
                if(Arrays.asList(1,2,3).contains(userSelection)){
                   
                    userMenuSelectionFlag = false;
                    return userSelection;
                }
                else{

                    System.out.print("Please select a valid number");
                }
                
            }

            // incase user puts in a letter
            catch(InputMismatchException e){
                // this catches an empty mismatch error and reruns the loop
                // not really sure how to write these just try-ing it out :p                
            }
                 
        }

        // No idea why this works
        return 0;
    }

}
