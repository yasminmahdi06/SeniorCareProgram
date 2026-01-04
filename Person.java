/**
 * This class stores a person's first name, last name, and age.
 *
 * Abdul Adefioye
 * November 30th, 2023
 */
public class Person
{
    //creates a private string variable to store their first name
    private String strFirstName;
    //creates a private string variable to store their last name
    private String strLastName;
    //creates of private byte variable to store their age
    private byte bytAge;
    
    //this is a constructor that takes in the first name, last name, 
    //and age of a person
    public Person(String a, String b, byte c)
    {
        //sets the strFirstName variable to the first name sent in
        this.strFirstName = a;
        //sets the strLastName variable to the last name sent in
        this.strLastName = b;
        //sets the bytAge variable to the age sent in
        this.bytAge = c;
    }
    
    //Getters for the different instance variables made in this class.
    public String getstrFirstName()
    {
        return this.strFirstName;
    }
    
    public String getstrLastName()
    {
        return this.strLastName;
    }
    
    //this will be the default constructor which will default all the instance variables to default values.
    //it will be used during file reading
    //@author(Yasmin Mahdi)
    //@version(December 4th, 2023)
    public Person() 
    {
        this.strFirstName = "";
        this.strLastName = "";
        this.bytAge = -1;
    }
    
    public byte getbytAge()
    {
        return this.bytAge;
    }
    
    //Setters for all the instance variables made in this class
    public void setstrFirstName(String a)
    {
        this.strFirstName = a;
    }
    
    public void setstrLastName(String b)
    {
        this.strLastName = b;
    }
    
    public void setbytAge(byte c)
    {
        this.bytAge = c;
    }
}