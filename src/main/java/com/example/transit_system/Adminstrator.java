package com.example.transit_system;

public class Adminstrator extends Account{

    Feedback feedback[];
    Adminstrator(){}
    Adminstrator(String username, String password, String email, String phonenum, String address, int id )
    {
        super(username, password, email, phonenum, address, id);
        Admin = true;
    }


    public String ViewFeedBack() // return feedbacks
    {
        for(int i = 0; i < feedback.length ; i++)
        {
            return "Feedback num"+i+": "+feedback[i].getMessage()+"\n";
        }
        return "That is all the feedback for this ID"; // message to be edited at the end of all the feedbacks :) <YahyaAdawy>
    }
}
