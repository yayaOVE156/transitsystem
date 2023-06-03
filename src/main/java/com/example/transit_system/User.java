package com.example.transit_system;


public class User extends Account{
        Ticket tickets[];

        public User(){};
        public User(String user, String pass, String Email, String phonenumber, String address, int iD)
        {
            super(user, pass, Email, phonenumber, address, iD);
            Admin = false;
        }
        Transportation Book_Transport(Transportation transport)
        {

               return null;
        }

        public void addTickets()
        {

        }
}
