package model;


import enumeration.PersonType;

public class Person {
    private final String name;
    private final PersonType personType;
    private int priority;
    private final String book;

    public Person(String name, PersonType personType, String book) {
        this.name = name != null && name.length() > 2 ? name: "Human";
        this.personType =personType != null ? personType: PersonType.TEACHER;
        this.book = book != null? book : "Choose a book";
        setPriority();
    }

    public String getBook() {
        return book;
    }

    public String getName() {
        return name;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority() {
        if(personType == PersonType.TEACHER){
            this.priority = PersonType.TEACHER.getPriority();
        } else if(personType == PersonType.SENIOR_STUDENT){
            this.priority = PersonType.SENIOR_STUDENT.getPriority();
        } else{
            this.priority = PersonType.JUNIOR_STUDENT.getPriority();
        }
    }
}
