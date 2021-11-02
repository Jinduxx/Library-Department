package model;

import java.util.Objects;

public class Book{
       private String title;
       private int noOfCopies;


       public Book (String title, int noOfCopies){
           this.title = title;
           this.noOfCopies= noOfCopies;
       }

    public String getTitle() {
        return title;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return noOfCopies == book.noOfCopies && Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, noOfCopies);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", noOfCopies=" + noOfCopies +
                '}';
    }
}
