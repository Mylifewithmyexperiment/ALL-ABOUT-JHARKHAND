package ca.blogspot.sjatyourservice.allaboutjharkhand;

/**
 * Created by SHASHI on 18-Aug-17.
 */

public class DatName
{
    // private static  Email;
    private static String Name;
    private static String Email;
    public DatName(String Name, String Email)
    {
        this.setName(Name);
        this.setEmail(Email);
    }


    public static String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static String getEmail() {
        return Email;


    }

    public void setEmail(String email) {
        Email = email;
    }
}
