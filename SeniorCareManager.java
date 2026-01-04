
/**
 * Description: This will be the main class, which will create an arraylist of type nurse and senior, and take in all the 
 * needed information to run the program, as well as give the user menu options to choose from to navigate and change the 
 * program as needed.
 *
 * @author (Yasmin, Abdul, Sanad)
 * @version (Nov 30, 2023)
 */

//import ArrayList from java library to make ArrayLists
import java.util.ArrayList;

//import scanner from java library to take user input
import java.util.Scanner;

//import java io to use file input and output
import java.io.*;

public class SeniorCareManager
{
    //creates an arraylist of seniorsList
    ArrayList <Senior> seniorsList;

    //creates an arraylist of nurses
    ArrayList <Nurses> nursesList;

    //creates a private constant/final variable of type string to store the password
    private final String PASSWORD = "1234nurses";

    //declare a private variable of type boolean to hold whetehr or not the user wants to log out or stay
    private boolean bolAgain = false;

    //declare a private instance variable of type byte to hold the nurses index that is using the program
    private byte bytNurseInProgram;

    //code a default constructor to launch the program when a SeniorCareManager object is created - here the 
    //@author (Yasmin Mahdi)
    //@version (Nov 30, 2023)
    public SeniorCareManager()
    {        
        //declare a variable of type string to hold the users response to more seniorsList to be added
        String strMoreSenior;

        //declare a variable of type string to hold the users response to more nurses to be added
        String strMoreNurses;

        //create the arrayList of seniorsList
        seniorsList = new ArrayList<Senior>();

        //create the arraylist of nurse
        nursesList = new ArrayList<Nurses>();

        //prompt the user to enter the number of seniorsList they would like to enter the info on
        System.out.println("Hello! Welcome to your very own Senior Centre Database! This will help you keep all of your needed information in check!\n" + 
            "To begin, I need you to set up!");

        //call the helper method "getseniorsList()" its a method because there is more of this same code
        getSeniors();

        //output intro message
        System.out.println("Thank you for entering the seniors information! Your are halfway done with setting up!");

        getNurses();
    }

    //code a method to return the value of the boolean variable bolAgain
    public boolean getbolAgain()
    {
        return this.bolAgain;
    }

    //This Method will check if the Senior's room number exists and if they did it will return the index of that room and if
    //it didn't find it, it will return -1 to show that it doesn't exist.
    //@author (Sanad Elsheh)
    //@version (Dec 6, 2023)
    public byte checkSenior(short shrRoomNumber)
    {

        //A for loop to loop throught the ArrayList.
        for(byte bytCounter = 0; bytCounter < seniorsList.size() ;bytCounter++)
        {
            //An if statement to check if the room number in the array list is equal to the room number the user entered.
            if(seniorsList.get(bytCounter).getRoomNumber() == shrRoomNumber)
            {

                return bytCounter;

            }

        }   

        return -1;
    }

    //code a helper method to ask for the number of seniorsList to be entered
    //@author(Yasmin Mahdi)
    //@version(December 5th, 2023)
    public void getSeniors()
    {
        //declare a variable of type boolean to help with error trapping
        boolean bolTryCatch;

        //declare a variable of type byte to hold the number of seniorsList user wants to enter info on
        byte bytNumseniorsList = 1;

        //code a do while to loop back when error is thrown
        do
        {
            //code a try catch to catch any errors
            try
            {
                //prompt the user to enter the number of seniors they would like to enter the info on
                System.out.println("How many seniors are in this centre (to keep track of their information)?");

                //populate the users answer to the variable bytNumseniorsList
                bytNumseniorsList = new Scanner(System.in).nextByte();

                //set the boolean variable to false
                bolTryCatch = false;
            }
            catch(Exception e)
            {
                //output error message
                System.out.println("ERROR: Please ensure that you have entered a whole number less than 120");

                //set the boolean variable to true
                bolTryCatch = true;
            }

            //code an if statement to catch out of range errors
            if(bytNumseniorsList <= 0)
            {
                //output error message
                System.out.println("ERROR: Please ensure that you have entered a whole number less than 120 (and more than 0!)");

                bolTryCatch = true;
            }
        }while(bolTryCatch);

        //call the helper method to loop through the number of seniorsList there is and call the allocated method to ask 
        //its a method because this code repeats in multiple areas.
        loopToAskForSeniorInfo((byte)(seniorsList.size()+bytNumseniorsList));
    }

    //code a helper method to ask for the number of nurses to be entered
    //@author(Yasmin Mahdi)
    //@version(December 5th, 2023)
    public void getNurses()
    {
        //declare a variable of type boolean to help with error trapping
        boolean bolTryCatch;

        //declare a variable of type byte to hold the number of nurses
        byte bytNurseNum = 1;

        //code a do while to loop back when error is thrown
        do
        {
            //code a try catch to catch any errors
            try
            {
                //prompt now for the nurses working at the senior care centre
                System.out.println("How many nurses work at this senior centre (to keep track of their information)?");

                //populate the users input to the allocated variable
                bytNurseNum = new Scanner(System.in).nextByte();

                //set the boolean variable to false to break loop
                bolTryCatch = false;
            }
            catch(Exception e)
            {
                //output error message to user
                System.out.println("ERROR: Please ensure that you have entered a whole number less than 120 (and more than 0!)");

                //set the boolean variable to true to give user another chance
                bolTryCatch = true;
            }

            //code an if statement to catch out of range errors
            if(bytNurseNum <= 0)
            {
                //output error message
                System.out.println("ERROR: Please ensure that you have entered a whole number less than 120 (and more than 0!)");

                bolTryCatch = true;
            }
        }while(bolTryCatch);

        //call the helper method to loop through the number of nurses there is and call the allocated method to ask 
        //its a method because this code repeats in multiple areas.
        loopToAskForNurseInfo((byte)(nursesList.size()+bytNurseNum));
    }

    //this will be a helper method that will loop through the number of seniorsList there is to be entered info on (coming in as a parametre) and call
    //the method to ask for their info
    //@author(Yasmin Mahdi)
    //@version(December 4th, 2023)
    public void loopToAskForSeniorInfo(byte bytNumseniorsList)
    {
        //declare a variable of type boolean to hold whether or not the senior has a medical record to be entered
        boolean bolMeds;

        //code a for loop to loop the number of seniorsList user wants to enter info on
        for(byte bytCounter = (byte)(seniorsList.size()+1); bytCounter<=bytNumseniorsList; bytCounter++)
        {
            bolMeds = takeseniorsListPersonalInfo((byte)(bytCounter-1));

            //code an if statement for IF the senior has a medication that needs to be taken then call this method to ask for it
            if(bolMeds)
            {
                //call the method takeMedInfo which will call the method takeMedInfo() from the senior class
                seniorsList.get(bytCounter-1).takeMedInfo();
            }
        }
    }

    //this will be a helper method that will loop through the number of seniorsList there is to be entered info on (coming in as a parametre) and call
    //the method to ask for their info
    //@author(Yasmin Mahdi)
    //@version(December 4th, 2023)
    public void loopToAskForNurseInfo(byte bytNurseNum)
    {        
        //code a for loop to loop for the number of nurses there are and take in their information
        for(byte bytNurseCounter = (byte)(nursesList.size()+1); bytNurseCounter <= bytNurseNum; bytNurseCounter++)
        {

            takeNursesPersonalInfo((byte)(bytNurseCounter-1));

        }
    }

    //This Method will ask the user for their personal information like their age, first name, and last name and store them 
    //to use them later.
    //@author (Sanad Elsheh)
    //@version (Dec 5, 2023)
    public void takeNursesPersonalInfo(byte bytNurseIndex)
    {
        //Declare a byte variable to store the Nurse's age.
        byte bytAge = -1;

        //Declare 2 String variables to store the Nurse's first and last name.
        String strFirstName = ""; 
        String strLastName = "";

        //Declare a boolean to catch errors and make the code loop till the user fix the error they have entered.
        boolean bolCatchError = false;

        //Ask the user for their information and store it.
        System.out.println("What is nurse #" + (bytNurseIndex+1) + "'s first Name?");
        strFirstName = new Scanner(System.in).nextLine();

        System.out.println("What is nurse #" + (bytNurseIndex+1) + "'s last Name?");
        strLastName = new Scanner(System.in).nextLine();

        do
        {
            try
            {
                System.out.println("How old is this nurse?");
                bytAge = new Scanner(System.in).nextByte();

                bolCatchError = false;

                //an if statement to make sure the user doesn't enter an invalid age.
                if(bytAge <= 0)
                {

                    System.out.println("Error. Please enter a positive age.");

                    bolCatchError = true;
                }
            }
            catch(Exception e)
            {
                //Tell the user that there is an error and that they will have to try again.
                System.out.println("Error. Please make sure to enter an age in whole numbers, no more than 120.");
                bolCatchError = true;

            }    
        }while(bolCatchError);

        //send in the information to the arraylist at this nurse index
        nursesList.add(new Nurses(strFirstName, strLastName, bytAge));
    }

    //this method will display the personal info menu to what the user can do - the options will be output, edit or go back
    //@author(Yasmin Mahdi)
    //@version(December 5th, 2023)
    public void displayPersonalInfoMenu(byte bytSeniorIndex) 
    {
        //declare a variable of type byte to hold the bytChoice of user for the menu
        byte bytChoice = -1;

        //declare a variable of type boolean to be used for try catch
        boolean bolTryCatch;

        //code a do while loop to loop back to menu when user errors
        do 
        {
            System.out.println("\nPersonal Information Menu:\n1. Output Personal Info\n2. Edit Personal Info\n3. Go Back to Main Menu");

            //code a try catch
            try
            {
                //prompt user to enter their choice
                System.out.print("Enter your choice: ");
                bytChoice = new Scanner(System.in).nextByte();

                //set the boolean to false to not loop again
                bolTryCatch = false;
            }
            catch(Exception e)
            {
                //output error message to user telling them its an invalid choice
                System.out.println("Invalid choice. Please try again.");

                //set to true to loop again
                bolTryCatch = true;
            }

            //code a switch to output different functions depending on the users choice
            switch (bytChoice) 
            {
                case 1:
                {
                    //output the personal info of the senior using the toString in that class
                    System.out.println(seniorsList.get(bytSeniorIndex));

                    bolTryCatch = true;
                }break;
                case 2:
                {
                    //call the method to edit the personal info
                    editPersonalInfo(bytSeniorIndex);

                    bolTryCatch = true;
                }break;
                case 3:
                {
                    //tell them we are going back to main menu and call that method
                    System.out.println("Going back to Main Menu.");
                    displayMainMenu(bytSeniorIndex);

                    bolTryCatch = false;
                }break;

                default:
                {
                    //output error message to user telling them its an invalid choice
                    System.out.println("Invalid choice. Please try again.");

                    bolTryCatch = true;
                }break;
            }
        } while (bolTryCatch);
    }

    //code a method that will allow the user to edit the the personal information of the senior when they chose to in the menu of personal info
    //it will take in the senior index that they would like to edit for
    //@author(Yasmin Mahdi)
    //@version(December 5th, 2023)
    public void editPersonalInfo(byte bytSeniorIndex)
    {
        //declare a variable of type byte to hold the users choice to edit
        byte bytEditChoice = -1;

        //declare a variable of type boolean to be used for try catch to ensure user enters a valid choice from given menu
        boolean bolTryCatch;

        //declare a variable of type boolean to be used for try catch for the inputted values to change the information
        boolean bolTryCatch2;

        //declare a variable of type byte to hold the users inputted age
        byte bytInputAge = -1;

        //declare a variable of type string to hold the users inputted value for the new name
        String strInputName = "";

        //code a do while loop to loop back to menu when user errors
        do 
        {
            System.out.println("\nEdit Personal Info: (which of the following would you like to edit from this senior's personal information?)\n1. First Name"+
                "\n2. Last Name\n3. Age");

            //code a try catch for error trapping
            try
            {
                //prompt user to enter their choice
                System.out.print("Enter your choice: ");
                bytEditChoice = new Scanner(System.in).nextByte();

                //set the boolean to false to not loop again
                bolTryCatch = false;
            }
            catch(Exception e)
            {
                //output error message to user telling them its an invalid choice
                System.out.println("Invalid choice. Please try again.");

                //set to true to loop again
                bolTryCatch = true;
            }

            //code a switch to output different functions depending on the users choice
            switch (bytEditChoice) 
            {
                case 1:
                {
                    //prompt the user to enter a replacement for the age
                    System.out.println("What would you like to update their first name to?");

                    //send in this input to the setter method in senior
                    seniorsList.get(bytSeniorIndex).setstrFirstName(new Scanner(System.in).nextLine());

                    bolTryCatch = false;
                }break;
                case 2:
                {
                    //prompt the user to enter a replacement for the age
                    System.out.println("What would you like to update their last name to?");

                    //send in this input to the setter method in senior
                    seniorsList.get(bytSeniorIndex).setstrLastName(new Scanner(System.in).nextLine());

                    bolTryCatch = false;

                }break;
                case 3:
                {
                    //code a do while loop for second chance if error is thrown
                    do
                    {
                        //code a try catch block to catch any errors
                        try
                        {
                            //prompt the user to enter a replacement for the age
                            System.out.println("What would you like to update their age to?");

                            //send in this input to the setter method in senior
                            bytInputAge = new Scanner(System.in).nextByte();

                            //send in the info to the seniorsList allocated instance variable
                            seniorsList.get(bytSeniorIndex).setbytAge(bytInputAge);

                            //set variable to false to not loop again
                            bolTryCatch2 = false;
                        }
                        catch(Exception e)
                        {
                            //output error message to user and set the variable to true
                            System.out.println("ERROR: Please make sure to enter in whole numbers, without exceeding 120");
                            bolTryCatch2 = true;
                        }

                        //code an if statement to catch out of range errors
                        if(bytInputAge <= 0)
                        {
                            //output error message to user and set the variable to true
                            System.out.println("ERROR: Please make sure to enter in whole numbers, without exceeding 120");
                            bolTryCatch2 = true;
                        }
                    }while(bolTryCatch2);
                }break;

                default:
                {
                    //output error message to user telling them its an invalid choice
                    System.out.println("Invalid choice. Please try again.");

                    bolTryCatch = true;
                }break;
            }
        } while (bolTryCatch);
    }

    //This method checks if the password inputted is correct. 
    //returns true if it is and returns false if it is not
    //@author(Abdul Adefioye)
    //@version(December 4th, 2023)
    public boolean checkPassword(String p)
    {
        //an if statement that checks if the password 
        //entered is equal to the set password
        if(p.equals(this.PASSWORD))
        {
            //returns true if this condition is true
            return true;
        }
        //otherwise returns false if it is not
        else
        {
            return false;
        }
    }

    //this method checks if the username inputted is correct.
    //returns true if it is and returns false if it is not
    //@author(Abdul Adefioye)
    //@version(December 4th, 2023)
    public boolean checkUserName(String u)
    {
        //go through the nurse arraylist and find the nurse with this username using a for loop
        for(byte bytNurseIndex = 0; bytNurseIndex<nursesList.size(); bytNurseIndex++)
        {
            //an if statement that checks if the nurse is found
            //using the program at the moment is correct

            if(u.equals(nursesList.get(bytNurseIndex).getstrUserName()))
            {
                //set the nurses index to the variable for keeping to know who is using the program
                bytNurseInProgram = bytNurseIndex;

                //if this condition is true then it will return true
                return true;
            }
        }

        //otherwise if this condition is false then it will return false
        return false;
    }

    //code a method to take in the senior index that the user would like to look into, and output a list of what they
    //can do when they clicked on "This senior's medication". This method will not return anything (void)
    //@author (Yasmin Mahdi)
    //@version (Dec 1st, 2023)
    public void displayMedicationMenu(byte bytSeniorIndex)
    {
        //declare a variable of type byte to hold the medication index that the user would like to look into
        byte bytMedIndex = -1;

        //declare a variable of type byte to hold the menu choice the user chose
        byte bytMenuChoice;

        //declare a variable of type boolean to loop again if user chooses a option that doesnt exist
        boolean bolChoicesAgain = false;

        //declare a variable of type boolean to be used for try catch
        boolean bolTryCatch = false;

        //code a do while loop to loop the menu again if there is an error
        do 
        {
            System.out.println("\nMedications Menu:\n1) Output Medication Records\n2) Give Medication\n3) Go Back");

            //prompt the user to enter their choice
            System.out.print("Enter your choice: ");

            //populate user input to the variable
            bytMenuChoice = new Scanner(System.in).nextByte();

            switch (bytMenuChoice) 
            {
                case 1:
                {
                    //otuput the medication records of this senior to the user
                    System.out.println("Medication Records for " + seniorsList.get(bytSeniorIndex).getstrLastName() + ", " 
                        + seniorsList.get(bytSeniorIndex).getstrFirstName() + ": \n" + seniorsList.get(bytSeniorIndex).outputMedRecords());

                    //set boolean to true to loop again
                    bolChoicesAgain = true;

                }break;

                case 2:
                {
                    if(seniorsList.get(bytSeniorIndex).medicalRecordList.isEmpty())
                    {
                        System.out.println("Sorry, there are no medication list to give a medication.");
                        
                        bolChoicesAgain = true;
                    }
                    else
                    {
                        //code a do while loop for error trapping
                        do
                        {
                            //code a try catch for error trapping
                            try
                            {
                                //prompt user to enter the medication to give from the list for this senior
                                System.out.println("What medication would you like to give from the list below: \n" + seniorsList.get(bytSeniorIndex).outputMedRecords());

                                //populate the users input to the allocated variable
                                bytMedIndex = new Scanner(System.in).nextByte();

                                bolTryCatch = false;
                            }
                            catch(Exception e)
                            {
                                //output error message
                                System.out.println("ERROR: Please make sure to enter a whole number that is beside the medication in the list");

                                bolTryCatch = true;
                            }

                            System.out.println(seniorsList.get(bytSeniorIndex).medicalRecordList.size());
                            
                            //code an if statement for out of range
                            if(bytMedIndex <=0 || (bytMedIndex-1)>seniorsList.get(bytSeniorIndex).medicalRecordList.size())
                            {
                                //output error message
                                System.out.println("ERROR: Please make sure to enter a positive number that is beside the medication in the list");

                                bolTryCatch = true;
                            }
                            
                            if(bolTryCatch == false)
                            {
                                //code an if statement for if this medication is already given
                                if(seniorsList.get(bytSeniorIndex).medicalRecordList.get(bytMedIndex-1).getbolComplete() == true)
                                {
                                    //tell them to choose something else
                                    System.out.println("Sorry, this medication has already been given.");
        
                                    bolTryCatch = true;
                                }
                            }
                        }while(bolTryCatch);

                        //call the method giveMedication() method, where the user will be allowed to give the medication
                        //to the senior, at the index (bytMedIndex), that they have chosen here. I will also send in the 
                        //senior index 
                        giveMedication((byte)(bytMedIndex-1), bytSeniorIndex);

                        //set boolean to true to loop again
                        bolChoicesAgain = true;
                    }

                    
                }break;

                case 3:
                {
                    //tell them they are exiting
                    System.out.println("Exiting Medications Menu.");

                    //call the display main menu and send in the index of the senior to bring them back to main menu
                    displayMainMenu(bytSeniorIndex);
                    bolChoicesAgain = false;
                }break;

                default:
                {
                    //output error message to user
                    System.out.println("Invalid choice. Please try again.");

                    //set boolean to true to loop again
                    bolChoicesAgain = true;
                }break;
            }
        } while (bolChoicesAgain);

    }
    
    //This is a method that tells the program that that specific medical 
    //record has been given to the senior for the day
    //@author(Abdul Adefioye)
    //@version(December 5th, 2023)
    public void giveMedication(byte bytMedIndex, byte bytSeniorIndex)
    {
        //gets the specific senior at the index sent in and then 
        //goes into the object and gets the medical record for that 
        //senior and then sets the bolComplete variable in the 
        //MedicalRecords class to true, so we know the senior has 
        //been given their medication - output message telling them this was done
        System.out.println("Thank you, your job was been recorded!");
        seniorsList.get(bytSeniorIndex).medicalRecordList.get(bytMedIndex).setbolComplete(true);
    
        //in addition send in their name as the giver of the medication using the bytNurseInProgram variable
        seniorsList.get(bytSeniorIndex).medicalRecordList.get(bytMedIndex).setstrMedGiver(nursesList.get(bytNurseInProgram).getstrLastName() + ", " + 
            nursesList.get(bytNurseInProgram).getstrFirstName());
    }

    public boolean takeseniorsListPersonalInfo(byte bytSeniorIndex)
    {
        //declare a variable of type boolean to catch any errors
        boolean bolCatchError;

        //declare a variable of type string to hold the users answer
        String strAnswer = "";

        //declare a variable of type string to hold the seniorsList first name
        String strFirstName;

        //declare a variable of type string to hold the seniorsList last name
        String strLastName;

        //declare a variable of type byte to hold the seniorsList age
        byte bytAge = 1;

        //declare a variable of type boolean to help with error trapping
        boolean bolTryCatch;

        //declare a variable of type boolean to help with error trapping
        boolean bolTryCatch2 = false;

        //declare a variable of type short to hold the seniorsList assigned room number
        short shrRoomNum = 1;

        //create a senior to add to the arraylist
        Senior tempSenior;

        //have a brief message telling the user what they are doing
        System.out.println("Please enter the following personal information on this senior:\nWhat is the senior #"+ (bytSeniorIndex+1) + "'s first name?");

        //populate users input to the allocated variable 
        strFirstName = new Scanner(System.in).nextLine();

        //prompt user for the seniorsList last name
        System.out.println("What is the senior #"+ (bytSeniorIndex+1) + "'s last name?");

        //populate users input to the allocated variable 
        strLastName = new Scanner(System.in).nextLine();

        //code do while loop for error trapping
        do
        {
            //code a try catch for error trapping
            try
            {
                //prompt user for the seniorsList age
                System.out.println("What is the senior #"+ (bytSeniorIndex+1) + "'s age?");

                //populate users input to the allocated variable 
                bytAge = new Scanner(System.in).nextByte();

                bolTryCatch = false;
            }
            catch(Exception e)
            {
                //output error messge
                System.out.println("ERROR: Please make sure to enter the age in whole numbers!");

                bolTryCatch = true;
            }

            //code an if statemnt for out of range
            if(bytAge <=0)
            {
                //output error messge
                System.out.println("ERROR: Please make sure to enter a positive age (not more than 120)");

                bolTryCatch = true;
            }
        }while(bolTryCatch);

        //code a do while loop to loop for erorr trapping and for logical errors to stop the iser from entering in the
        //same room number more than once
        do
        {
            //code a try catch to error trap
            try
            {
                //prompt user for the seniorsList room number
                System.out.println("What is the senior #"+ (bytSeniorIndex+1) + "'s room number?");

                //populate users input to the allocated variable 
                shrRoomNum = new Scanner(System.in).nextShort();

                bolTryCatch2 = false;
            }
            catch(Exception e)
            {
                //output error messge
                System.out.println("ERROR: please ensure to enter the room number in whole numbers.");

                bolTryCatch2 = true;
            }

            //code an if statement for if the room number is negative and if the room number is already taken
            if(shrRoomNum<=0)
            {
                //output error messge
                System.out.println("ERROR: please ensure to enter the room number in positive numbers.");

                bolTryCatch2 = true;
            }

            if(bolTryCatch2 == false)
            {
                //code a for loop to loop through the seniors already in the arraylist and check their room numbers
                for(byte bytCounter = 0; bytCounter < seniorsList.size(); bytCounter++)
                {
                    if(shrRoomNum == seniorsList.get(bytCounter).getRoomNumber())
                    {
                        //output error messge
                        System.out.println("Sorry, the room number entered is already occupied. Please enter another.");

                        bytCounter = (byte)seniorsList.size();

                        bolTryCatch2 = true;
                    }
                }
            }
        }while(bolTryCatch2);

        //create this senior and send in all the information
        tempSenior = new Senior(strFirstName, strLastName, bytAge, shrRoomNum);

        //add this senior to the arraylist
        seniorsList.add(tempSenior);

        do
        {
            try
            {
                //Ask the user if they have a medical comdition or not and returns true or false based on their answer.
                System.out.println("Does this senior have some sort of medicine that needs to be kept track of? (enter yes if you do, and anything for no)");

                strAnswer = new Scanner(System.in).nextLine();

                bolCatchError = false;
            }
            catch (Exception e)
            {
                System.out.println("Error. You can only enter Yes or No. Please try again.");
                bolCatchError = true;
            }

        }while(bolCatchError);

        if(strAnswer.equalsIgnoreCase("yes"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //this method will display the mainmenu when called and ask the user to choose between 5 options
    //1) Look Into Personal Information
    //2) Look Into Medical Information
    //3) Enter the room number for another senior
    //4) Log Out
    //5) Close the program for the day
    //@author(Abdul Adefioye)
    //@version(Dec 1st 2023)
    public void displayMainMenu(byte bytIndex)
    {
        //creates a byte variable to take in a number to do a specific action
        byte bytUserInput = -1;

        //declare a variable of type boolean to loop again if user chooses a option that doesnt exist
        boolean bolChoicesAgain = true;

        //runs this block while the input number is 1, 2, 3, 4 or 5
        while(bolChoicesAgain)
        {
            try
            {
                System.out.println("\nWelcome to the Main Menu, please select an option from below:\n1) Look into Personal Information" + 
                    "\n2) Look into Medical Information\n3) Enter the room number for another senior\n4) Log Out\n5) Close the program for the day");

                bytUserInput = new Scanner(System.in).nextByte();

            }
            //catches if the number entered is over 127
            catch(Exception e)
            {
                //prints out "Please enter a number between 1-3" if the number is over 127
                System.out.println("Please enter a whole number between 1-5");
            }

            //a switch statement to do actions depending on the number the user selected
            switch(bytUserInput)
            {
                //if the input is equal to 1 then it will print out the personal information of the senior
                case 1: 
                {

                    //call the display personal info menu to bring them further
                    displayPersonalInfoMenu(bytIndex);
    
                    //set boolean to true to loop again
                    bolChoicesAgain = false;
                }break;
                
                case 2: 
                {

                    //calls the displayMedicationMenu method to print out the medical menu to bring them further
                    displayMedicationMenu(bytIndex);
    
                    //set boolean to false to end loop
                    bolChoicesAgain = false;
                }break;
                
                case 3:
                {
                    //save false to the variable bolAgain which can be accessed by the senior care program
                    bolAgain = true;
    
                    //set boolean to false to END LOOP
                    bolChoicesAgain = false;
                }break;
                
                case 4:
                {
                    //tell user they are logging out (and return to the SeniorCareProgram) which will return them to the password and username page
                    //clear the terminal window
                    System.out.print('\u000C');
                    System.out.println("You have been logged out.");
    
                    //save false to the variable bolAgain which can be accessed by the senior care program
                    bolAgain = false;
    
                    //set boolean to false to END LOOP
                    bolChoicesAgain = false;
                }break;
            
                case 5:
                {
                    //exit program
                    System.exit(0);
    
                    //set boolean to false to END LOOP
                    bolChoicesAgain = false;

                }break;
                
                default:
                {
                    //tells the user to enter a number between 1-5
                    System.out.println("Please enter a number between 1-5");
    
                    //set boolean to true to loop again
                    bolChoicesAgain = true;
                }break;
            }
    }
    }
}

