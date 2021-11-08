import enumeration.PersonType;
import model.Book;
import service.LibraryServiceImplement;
import model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceBookLibrary {
    LibraryServiceImplement lib;

    @BeforeEach
    void setUp(){
       lib = new LibraryServiceImplement();
    }

    @Test
    public void isBookExistingInLibrary(){
        lib.getLibraryBooks().put("english",1);
        assertTrue(lib.getLibraryBooks().containsKey("english"));
    }

    @Test
    public void isTeacherInQueue() throws Exception {
        Book mathematics = new Book("Mathematics", 1);
        Person teacher = new Person("Adam", PersonType.TEACHER, mathematics.getTitle());
        lib.queueUp(teacher);
        assertTrue(lib.getPersonQueue().contains(teacher));
    }

    @Test
    public void ifPriorityIsConsidered() throws Exception {
        Book mathematics = new Book("Mathematics", 3);
        Person senior = new Person("Pope", PersonType.SENIOR_STUDENT, mathematics.getTitle());
        Person teacher = new Person("Adam", PersonType.TEACHER, mathematics.getTitle());
        lib.queueUp(teacher);
        lib.queueUp(senior);
        assertEquals("Adam", lib.getPriorityQueue().remove().getName());
    }

    @Test
    public void ifFIFOIsConsidered() throws Exception {
        Book mathematics = new Book("Mathematics", 3);
        Person senior = new Person("Pope", PersonType.SENIOR_STUDENT, mathematics.getTitle());
        Person teacher = new Person("Adam", PersonType.TEACHER, mathematics.getTitle());
        lib.queueUp(teacher);
        lib.queueUp(senior);
        assertEquals("Adam", lib.getPersonQueue().remove().getName());
    }
}
