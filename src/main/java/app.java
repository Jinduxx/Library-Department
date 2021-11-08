import enumeration.PersonType;
import model.Book;
import model.Person;
import service.LibraryServiceImplement;

public class app {

    public static void main(String[] args) throws Exception {
        LibraryServiceImplement librarian = new LibraryServiceImplement();

        //Stacking of book

        Book mathematics = new Book("Mathematics", 1);
        Book mathematics1 = new Book("Mathematics", 3);
        Book english = new Book("English", 4);
        Book chemistry = new Book("Chemistry", 1);
        Book biology = new Book("Biology", 2);
        librarian.stackBook(mathematics);
        librarian.stackBook(mathematics1);
        librarian.stackBook(english);
        librarian.stackBook(chemistry);
        librarian.stackBook(biology);

        System.out.println("Remaining Books: " +librarian.getLibraryBooks());

        // Object of Person Class

        Person teacher = new Person("Adamu", PersonType.TEACHER, mathematics.getTitle());
        Person juniorStudent = new Person("Luke", PersonType.JUNIOR_STUDENT, mathematics1.getTitle());
        Person seniorStudent1 = new Person("Funmi", PersonType.SENIOR_STUDENT, english.getTitle());
        Person seniorStudent2 = new Person("Leon", PersonType.SENIOR_STUDENT, english.getTitle());
        Person juniorStudent2 = new Person("Jeon", PersonType.JUNIOR_STUDENT, chemistry.getTitle());
        Person teacher1 = new Person("Lizzy", PersonType.TEACHER, chemistry.getTitle());
        Person teacher2 = new Person("Modd", PersonType.TEACHER, biology.getTitle());
        Person teacher3 = new Person("Modd", PersonType.TEACHER, biology.getTitle());

        // Queue them up
        librarian.queueUp(teacher);
        librarian.queueUp(juniorStudent);
        librarian.queueUp(seniorStudent1);
        librarian.queueUp(seniorStudent2);
        librarian.queueUp(juniorStudent2);
        librarian.queueUp(teacher1);
        librarian.queueUp(teacher2);
        librarian.queueUp(teacher3);

        // Assign Book on priority

//        for(int i =0; i< librarian.getCount(); i++){
//            librarian.borrowBookOnPriority();
//        }
//        librarian.borrowBookOnPriority();
//        librarian.borrowBookOnPriority();

        // Assign Book on FIFO

        System.out.println();

        for(int i = 0; i< librarian.getCount(); i++){
            librarian.borrowBookOnFIFO();
        }
//        librarian.borrowBookOnFIFO();
//        librarian.borrowBookOnFIFO();

        System.out.println();





        //Books remaining

        System.out.println("Remaining Books: " +librarian.getLibraryBooks());




    }
}
