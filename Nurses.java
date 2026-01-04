/**
 * Description: This Class will store the user's First name, Last name, and age 
 * and then it will populate the UserName variable to use it later.
 *
 * @author (Sanad Elsheh)
 * @version (30 Nov, 2023)
 */
public class Nurses extends Person
{
    //declare private variables to store information an populate them later.
    private String strUserName;
    
    //a constructor to populate the private variables with the information coming 
    //from the Person class.
    public Nurses(String fn, String ln, byte a)
    {
         super(fn, ln, a);
         
         //call the create username to create their username
         createUserName();
    }
    
    //A method to populate the username to what we got from the Person class.
    public void createUserName()
    {
        //UserName format:  FirstName.LastName-Age
        this.strUserName = this.getstrFirstName() + "." + this.getstrLastName() + "-" 
        + this.getbytAge();
        
    }
    
    //Getter method to get the private variable and get it where it is needed.
    public void setstrUserName(String strNewUserName)
    {
        
        this.strUserName = strNewUserName;
        
    }
    
    
    //Getter method to get the private variable and get it where it is needed.
    public String getstrUserName()
    {
        return this.strUserName;
        
        
    }
    
    
}