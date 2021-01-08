package com.packpoised;

    public class Person {
        String personTitle;
        String personName;
        String personSurname;
        String personEmail;
        String personPhysicalAddress;
        String personPhoneNumber;

        public Person(String personTitle, String personName,String personSurname, String personEmail,
                      String personPhysicalAddress, String personPhoneNumber){
            this.personTitle = personTitle;
            this.personName = personName;
            this.personSurname = personSurname;
            this.personEmail = personEmail;
            this.personPhysicalAddress = personPhysicalAddress;
            this.personPhoneNumber = personPhoneNumber;
        }
        public String getPersonTitle() {
            return personTitle;
        }

        public void setPersonTitle(String personTitle) {
            this.personTitle = personTitle;
        }

        public String getPersonName() {
            return personName;
        }

        public String getPersonSurname(){
            return personSurname;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public String getPersonEmail() {
            return personEmail;
        }

        public void setPersonEmail(String personEmail) {
            this.personEmail = personEmail;
        }

        public String getPersonPhysicalAddress() {
            return personPhysicalAddress;
        }

        public void setPersonPhysicalAddress(String personPhysicalAddress) {
            this.personPhysicalAddress = personPhysicalAddress;
        }

        public String getPersonPhoneNumber() {
            return personPhoneNumber;
        }

        public void setPersonPhoneNumber(String personPhoneNumber) {
            this.personPhoneNumber = personPhoneNumber;
        }
        public String toString(){
            String output = "Title " + personTitle;
            output += "\nName: " + personName;
            output += "\nEmail: " + personEmail;
            output += "\nPhysical Address: "+ personPhysicalAddress;
            output += "\nPhone Number: " + personPhoneNumber;
            return output;
        }
    }

