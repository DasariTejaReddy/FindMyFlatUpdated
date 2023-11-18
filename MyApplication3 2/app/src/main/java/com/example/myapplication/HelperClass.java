package com.example.myapplication;

public class HelperClass 
{



        String name, email, username, password;

//getter method called getname
        public String getName() {

            return name;
        }

        public void setName(String name) {

            this.name = name;
        }

        public String getEmail() {

            return email;
        }
//setter method called setemail
        public void setEmail(String email) {

            this.email = email;
        }
//getter method called getusername 
        public String getUsername() {

            return username;
        }
//setter method called setusername 
        public void setUsername(String username) {

            this.username = username;
        }

        public String getPassword() {

            return password;
        }
//setter method setpassword
        public void setPassword(String password) {

            this.password = password;
        }
//constructor 
        public HelperClass(String name, String email, String username, String password) {

            this.name = name;

            this.email = email;

            this.username = username;

            this.password = password;
        }

        public HelperClass()
         {
        }
    }

