package com.example.aammu.databaseexample;

//Plain Old Java Object
public class Person {
    private String personName;
    private String personContact;
    private String personEmail;

    public Person() {
    }

    public Person(String personName,
                  String personContact,
                  String personEmail) {
        this.personName = personName;
        this.personContact = personContact;
        this.personEmail = personEmail;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonContact() {
        return personContact;
    }

    public void setPersonContact(String personContact) {
        this.personContact = personContact;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }
}
