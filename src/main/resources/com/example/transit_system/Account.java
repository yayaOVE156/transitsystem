package com.example.transit_system;
import javafx.scene.image.Image;

public abstract class Account
{
    // Declaration for the account data field names
    String UserName;
    String Password;
    String Email;
    String PhoneNumber;  //Made a string for the chance of having a "+" sign at the begininng of a number
    String Address;
    int ID;
    Image ProfilePicture;  //A Taymour exclusive field, Taymour will handel it in future updates


    //Need accessor and mutator for UserName
    public String getUserName()
    {
        return UserName;
    }
    public void setUserName(String UserName)
    {
        this.UserName = UserName;
    }

    // Accessor and Mutator for ID (Not sure if it should be written)
    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    // Accessor and Mutator for Email
    public String getEmail()
    {
        return Email;
    }
    public void setEmail(String Email)
    {
        this.Email = Email;
    }

    //Accessor and Mutator for Password
    public String getPassword()
    {
        return Password;
    }

    public void setPassword(String password)
    {
        this.Password = password;
    }

    //Accessor and Mutator for Address
    public String getAddress()
    {
        return Address;
    }
    public void setAddress(String Address)
    {
        this.Address=Address;
    }

    //Accessor and Mutator for Phone Number
    public String getPhoneNumber()
    {
        return PhoneNumber;
    }

    //Accessor and Mutator for Phone Number
    public void setPhoneNumber(String PhoneNumber)
    {
        this.PhoneNumber=PhoneNumber;
    }

    //Accessor and Mutator for Profile Picture
    public Image getProfilePicture()
    {
        return ProfilePicture;
    }
    public void setProfilePicture(Image image)
    {
        this.ProfilePicture = image;
    }
}