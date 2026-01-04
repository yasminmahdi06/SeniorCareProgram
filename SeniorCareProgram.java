
/**
 * Description: This will be the main class to which the program will be launched by creating an object of SeniorCareManager.
 *
 * @author (Yasmin Mahdi)
 * @version (Dec 1, 2023)
 */
import java.util.Scanner;

public class SeniorCareProgram 
{
    public static void main(String[] args) 
    {
        //declare and create a variable of type SeniorCareManager to take in all needed info from user to start the program
        SeniorCareManager seniorCareManager = new SeniorCareManager();
        
        //declare a variable of type short to hold the seniors room which the user will enter when they want to search for a senior
        short shrSeniorRoomNum = -1;
        
        //declare a variable of type boolean to catch any errors in the program and allow the user to get a second chance
        boolean bolTryCatch;
        
        //declare a variable of type boolean to catch any errors in the program and allow the user to get a second chance
        boolean bolTryCatch2;
        
        //declare a variable of type byte to hold the senior index which will return from the checkSenior() method
        byte bytSeniorIndex = -1;
        
        //declare a variable of type boolean to hold whether or not this user wants to look into the info of another senior
        boolean bolAgain = false;
        
        //declare a variable of type boolean to hold whether or not this username is valid 
        boolean bolValidUsername;
        
        //declare a variable of type boolean to 
        boolean bolAskVerification = false;
        
        //declare a variable of type string to hold the username when user enters
        String strUsername;
        
        //declare a variable of type string to hold the password when user enters
        String strPassword;
        
        //declare a variable of type boolean to hold whether or not this password is valid 
        boolean bolValidPassword = false;
        
        byte bytPasswordChance = 0;
        
        final byte CHANCE = 3;
        
        //code a do while loop to loop this entering password and username again everytime the user is done
        do
        {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            
            //clear terminal window
            System.out.print('\u000C');
            
            //prompt the user to enter the username
            System.out.println("What is the username? (Its in the format: \"FirstName.LastName-Age\")");
            
            //populate user input to the variable
            strUsername = new Scanner(System.in).next();
            
            //call the method getUserName connected with seniorcaremanager - it will return true for if valid and false whether or not this is correct
            bolValidUsername = seniorCareManager.checkUserName(strUsername);
            
            //if the bolValidUsername is false then make it true
            if(bolValidUsername == false)
            {
                //output error message
                System.out.println("Sorry, this username is invalid.");
                
                //set to true to come again
                bolAskVerification = true;
            }
            //code a do while loop to loop through the code to give the user multiple chances to enter the password
            else
            {
                //set the bytPasswordChance to zero
                bytPasswordChance = 0;
                
                do
                {
                    //prompt the user to enter the password
                    System.out.println("What is the password? (you have "+ (CHANCE) +" chances)");
                    
                    //populate user input to the variable
                    strPassword = new Scanner(System.in).next();
                    
                    //call the method checkPassword connected with seniorcaremanager - it will return true for if valid and false whether or not this is correct
                    bolValidPassword = seniorCareManager.checkPassword(strPassword);
                                        
                    //code an if statement for if the bolValid is true to run the code as normal and if not then to go back to the question after telling the user
                    //the password and/or username is wrong
                    if(bolValidPassword)
                    {
                        //code a do while to let user enter another senior
                        do
                        {
                            //code a do while loop to allow user a second chance when causing an error
                            do
                            {
                                //code a try catch to catch any errors
                                try
                                {
                                    //prompt user to enter the room number of this senior they are looking to get info on
                                    System.out.println("Enter the room number of the senior you'd like to look into: ");
                                    
                                    //populate user input to the allocated variable
                                    shrSeniorRoomNum = new Scanner(System.in).nextShort();
                                    
                                    //set the bolTryCatch to false the user has entered the correct data type
                                    bolTryCatch = false;
                                
                                //check if this room number exists by calling the method checkSenior(), and if its not found will return -1
                                bytSeniorIndex = seniorCareManager.checkSenior(shrSeniorRoomNum);
                                
                                
                                //code an if statement to 
                                if(bytSeniorIndex == -1)
                                {
                                    //output error message
                                    System.out.println("ERROR: Invalid room number, this room number does not exist");
                                    
                                    //set the boolean to true to loop again
                                    bolTryCatch = true;
                                }
                                if(shrSeniorRoomNum <= 0)
                                {
                                    System.out.println("ERROR: Please make sure to enter the room number is between 1-127.");
                                    
                                    bolTryCatch = true;
                                }
                            }
                                catch(Exception e)
                                {
                                    //output error message and set the boolean to true to loop the question again
                                    System.out.println("ERROR: Please make sure to enter the room number in WHOLE NUMBERS between 0-127.");
                                    
                                    bolTryCatch = true;
                                }
                                
                            }while(bolTryCatch);
                            
                            
                            
                            //call the display menu to get the user to all the things they can do to access the seniors info
                            seniorCareManager.displayMainMenu(bytSeniorIndex);
                            
                            bolAgain = seniorCareManager.getbolAgain();
                            
                        }while(bolAgain);
                        
                        //set the bolAskVerification to true because the user will go back to the main page
                        bolAskVerification = true;
                        
                        //set the bytPasswordChance to the number of chances to exit the do while loop for password repeat
                        bytPasswordChance = CHANCE;
                        
                    }
                    else
                    {
                         //output message saying password and/or username is incorrect
                         System.out.println("Sorry, password and/or username is INCORRECT.");
                                             
                         //increment the password chances user has
                         bytPasswordChance++;
                         
                         //code an if statement for if the counter for giving them three chances is up, to go back to main menu.
                         if(bytPasswordChance < CHANCE)
                         {
                             //set the boolean variable bolAskVerification to true to loop back to the page where they are asked for their password
                             bolAskVerification = true;
                         }
                         
                    }
                }while(bytPasswordChance < CHANCE);
            }
        }while(bolAskVerification);
    }

}