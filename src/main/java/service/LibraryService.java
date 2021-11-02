package service;

import model.Book;
import model.Person;

public interface LibraryService {

    void queueUp(Person person);
    void stackBook(Book book);
    void borrowBookOnPriority();
    void borrowBookOnFIFO();



}