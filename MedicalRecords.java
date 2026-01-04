
/**
 * Description: This will be the class which will be connected to senior and hold the seniors medical info. 
 *
 * @author (Yasmin Mahdi)
 * @version (Nov 30, 2023)
 */
public class MedicalRecords
{
    //declare an instance private variable of type String to hold the medication name
    private String strMedName;
    
    //declare an instance private variable of type String to hold the time the medication needs to be given
    private String strTimeToGive;
    
    //declare an instance private variable of type String to hold the person who gave the medication
    private String strMedGiver;
    
    //declare a private instance variable of type boolean to hold true for if the medication is given, or false, if the 
    //medication is not given
    private boolean bolComplete;
    
    //code a constructor to take in the medication name, and the time to give the medication and populate it to the variables
    public MedicalRecords (String medName, String medTimeToGive)
    {
        this.strMedName = medName;
        this.strTimeToGive = medTimeToGive;
        
        //set default values for strMedGiver until its later set using the method to populate the variable (setter)
        this.strMedGiver = "";
        
        //set false to the bolComplete to signal that none of the medications have been given so far
        //when the medication is later given the method which will populate the variable to true - meaning its been
        //given
        this.bolComplete = false;
    }
    
    //code a default constructor to set default vales to all the variables since the senior has no medical records
    public MedicalRecords()
    {
        this.strMedName = "";
        this.strTimeToGive = "";
        this.strMedGiver = "";
        this.bolComplete = false;
    }
    
    //code a method to return the private variable strMedName when called
    public String getstrMedName()
    {
        return this.strMedName;
    }
    
    //code a method to return the private variable strTimeToGive when called
    public String getstrTimeToGive()
    {
        return this.strTimeToGive;
    }
    
    //code a method to return the private variable strMedGiver when called
    public String getstrMedGiver()
    {
        return this.strMedGiver;
    }
    
    //code a method to return the private variable bolComplete when called
    public boolean getbolComplete()
    {
        return this.bolComplete;
    }
    
    //code a method to populate the private variable bolComplete when called to the parametre coming in
    public void setbolComplete(boolean c)
    {
        this.bolComplete = c;
    }
    
    //code a method to populate the private variable strMedName when called to the parametre coming in
    public void setstrMedName(String m)
    {
        this.strMedName = m;
    }
    
    //code a method to populate the private variable strTimeToGive when called to the parametre coming in
    public void setstrTimeToGive(String m)
    {
        this.strTimeToGive = m;
    }
    
    //code a method to populate the private variable strMedGiver when called to the parametre coming in
    public void setstrMedGiver(String m)
    {
        this.strMedGiver = m;
    }
    
    //code a method to check the bolComplete variable and return a more readable "complete" or "not complete", depending
    //on if the variable is holding true or false
    public String checkCompletion()
    {
        if(getbolComplete() == true)
        {
            return "COMPLETE";
        }
        else
        {
            return "INCOMPLETE";
        }
    }
    
    //code a toString to output the variables stored in this class in an orderly fashion
    public String toString()
    {        
        //code an if statement for if the job is complete output the giver if not then dont output giver
        if(this.bolComplete)
        {
            return "Medication: " + getstrMedName() + ", time to be given: " + getstrTimeToGive() + 
            ", Medicine Given by Nurse: " + this.strMedGiver + ".\t\tStatus: " + checkCompletion();
        }
        else
        {
            return "Medication: " + getstrMedName() + ", time to be given: " + getstrTimeToGive() + 
            ".\t\tStatus: " + checkCompletion();
        }
    }
}
