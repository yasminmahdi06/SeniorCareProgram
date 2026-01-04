/**
 * This class extends off of the Person Class and takes in 
 * the room number of the senior. It also sends Medical Information 
 * to the MedicalRecords class.
 *
 * Abdul Adefioye
 * November 30th 2023
 */

//import arraylist from java library to create an arraylist
import java.util.ArrayList;

//import scanner from java library to take user input
import java.util.Scanner;

public class Senior extends Person
{
    //creates a private short variable to store the room number
    private short shrRoomNumber;
    
    //creates a MedicalRecords ArrayList to help send information to the MedicalRecords class
    ArrayList <MedicalRecords> medicalRecordList;
    
    //this is a constructor that takes in the first name, last name, age, and room number of 
    //the senior
    public Senior(String a, String b, byte c, short d)
    {
        //sends the first name, last name, and age into the constructor made 
        //in the person class and inherits it
        super(a,b,c);
        
        //create the medicalRecordList arraylist
        medicalRecordList = new ArrayList<MedicalRecords>();
        
        //sets the shrRoomNumber variable to the room number sent in
        this.shrRoomNumber = d;
        
    }
    
    //this is a method that connects this class to the MedicalRecords class by sending 
    //in the information that class needs
    public void takeMedInfo()
    {
        //declare a variable of type string to hold the medicine name
        String strMedName;
        
        //declare a variable of type string to hold the time needed to give this medicine
        String strTimeToGive;
        
        //declare a variable of type boolean to error trap
        boolean bolTryCatch;
        
        //declare a variable of type byte to hold the number of medicines this senior has
        byte bytMedNum = 2;
        
        //code a do while loop to loop for error trapping
        do
        {
            //code a try catch for error trapping
            try
            {
                //prompt the user to enter how many medications this senior has
                System.out.println("How many medications do they have?");
                
                //populate the user input to bytMedNum
                bytMedNum = new Scanner(System.in).nextByte();
                
                bolTryCatch = false;
            }
            catch(Exception e)
            {
                //output error message
                System.out.println("ERROR: Please make sure to enter the medication number in whole numbers");
                
                bolTryCatch = true;
            }
            
            //code an if statement for the out of range
            if(bytMedNum<=0 || bytMedNum >=10)
            {
                //output error message
                System.out.println("ERROR: Please make sure to enter a positive medication number, no more than 10");
                
                bolTryCatch = true;
            }
            
        }while(bolTryCatch);
            
        //code a for loop to loop the number of medicines the senior has and ask for all needed info
        for(byte bytCounter = 1; bytCounter <= bytMedNum; bytCounter++)
        {
            //prompt the user for the medicine name
            System.out.println("What is the name of medicine #" + bytCounter + "?");
            
            //populate user input to the variable strMedName
            strMedName = new Scanner(System.in).nextLine();
            
            //prompt the user for the time to give this medicine 
            System.out.println("What is the time to give medicine #" + bytCounter + " during a day? (for example: \"4:30 pm\")");
            
            //populate user input to the variable strTimeToGive
            strTimeToGive = new Scanner(System.in).nextLine();
            
            //sends in the medicine name and the nurse giving the medicine to the MedicalRecord class
            medicalRecordList.add(new MedicalRecords(strMedName, strTimeToGive));
        }
    }
    
    //this will be the default constructor which will default all the instance variables to default values.
    //it will be used during file reading
    //@author(Yasmin Mahdi)
    //@version(December 4th, 2023)
    public Senior() 
    {
        //call the default constructor of the super class person
        super();
        
        //set the default room number to zero
        this.shrRoomNumber = 0;
        
    }
    
    //code a non void method to save the medication records held in the medicalRecords arraylist in a string variable then
    //return it
    //@author (Yasmin Mahdi)
    //@version (Dec 1st, 2023)
    public String outputMedRecords()
    {
        //declare a variable of type string to hold all the med records and then return it
        String strMedRecords = "";
        
        //code an if statement for if the arraylisy is empty meaning no medical info to return no medical info
        if(medicalRecordList.isEmpty())
        {
            //return no medical info
            return "no medical information";
        }
        else
        {
            //code a for loop to loop and output the medication records numbered
            for(byte bytCounter = 0; bytCounter<medicalRecordList.size(); bytCounter++)
            {
                strMedRecords += (bytCounter+1) + ". " + medicalRecordList.get(bytCounter) + "\n";
            }
            
            //return this string
            return strMedRecords;
        }
    }
    
    //this is a getter method to get the room number
    public short getRoomNumber()
    {
        return this.shrRoomNumber;
    }
    
    //this is a setter method to set the room number to a different value
    public void setRoomNumber(short d)
    {
        this.shrRoomNumber = d;
    }
    
    //this is a tostring method to format and pring out the information of the senior
    public String toString()
    {
        return "First Name: " + super.getstrFirstName() + "\nLast Name: " + super.getstrLastName() + "\nAge: " + super.getbytAge()
        + "\nRoom Number: " + this.shrRoomNumber;
    }
}