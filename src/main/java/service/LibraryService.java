package service;

import model.Book;
import model.Person;

public interface LibraryService {

    void queueUp(Person person) throws Exception;
    void stackBook(Book book);
    void borrowBookOnPriority() throws Exception;
    void borrowBookOnFIFO() throws Exception;
}
