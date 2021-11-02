import enumeration.PersonType;
import model.Book;
import service.Library;
import model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceBookLibrary {
    Library lib;


    @BeforeEach
    void setUp(){
       lib = new Library();
    }


    @Test
    public void libraryIsEmpty(){
        assertNotNull(lib.getLibraryBooks());
    }


    @Test
    public void isBookExistingInLibrary(){
        lib.getLibraryBooks().put("english",1);
        assertTrue(lib.getLibraryBooks().containsKey("english"));
    }

    @Test
    public void isTeacherInQueue(){
        Book mathematics = new Book("Mathematics", 1);
        Person teacher = new Person("Adam", PersonType.TEACHER, mathematics.getTitle());
        lib.queueUp(teacher);
        assertTrue(lib.getPersonQueue().contains(teacher));
    }



    @Test
    public void ifPriorityIsConsidered(){
        Book mathematics = new Book("Mathematics", 1);
        Book mathematics1 = new Book("Mathematics", 3);
        Book english = new Book("English", 4);
        Person junior = new Person("Finger", PersonType.JUNIOR_STUDENT, mathematics.getTitle());
        Person senior = new Person("Pope", PersonType.SENIOR_STUDENT, mathematics1.getTitle());
        Person teacher = new Person("Adam", PersonType.TEACHER, english.getTitle());
        lib.queueUp(junior);
        lib.queueUp(teacher);
        lib.queueUp(senior);

        assertEquals("Adam", lib.getPriorityQueue().remove().getName());

    }



    @Test
    public void ifFIFOIsConsidered(){
        Book mathematics = new Book("Mathematics", 1);
        Book mathematics1 = new Book("Mathematics", 3);
        Book english = new Book("English", 4);
        Person junior = new Person("Finger", PersonType.JUNIOR_STUDENT, mathematics.getTitle());
        Person senior = new Person("Pope", PersonType.SENIOR_STUDENT, mathematics1.getTitle());
        Person teacher = new Person("Adam", PersonType.TEACHER, english.getTitle());
        lib.queueUp(junior);
        lib.queueUp(teacher);
        lib.queueUp(senior);

        assertEquals("Finger", lib.getPersonQueue().remove().getName());

    }


}
