import enumeration.PersonType;
import model.Book;
import service.Library;
import model.Person;

public class app {

    public static void main(String[] args) throws Exception {
        Library librarian = new Library();

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
        Person jStudent = new Person("Luke", PersonType.JUNIOR_STUDENT, mathematics1.getTitle());
        Person sStudent1 = new Person("Funmi", PersonType.SENIOR_STUDENT, english.getTitle());
        Person sStudent2 = new Person("Leon", PersonType.SENIOR_STUDENT, english.getTitle());
        Person jStudent2 = new Person("Jeon", PersonType.JUNIOR_STUDENT, chemistry.getTitle());
        Person teacher1 = new Person("Lizzy", PersonType.TEACHER, chemistry.getTitle());
        Person teacher2 = new Person("Modd", PersonType.TEACHER, biology.getTitle());
        Person teacher3 = new Person("Modd", PersonType.TEACHER, biology.getTitle());



        // Queue them up
        librarian.queueUp(teacher);
        librarian.queueUp(jStudent);
        librarian.queueUp(sStudent1);
        librarian.queueUp(sStudent2);
        librarian.queueUp(jStudent2);
        librarian.queueUp(teacher1);
        librarian.queueUp(teacher2);
        librarian.queueUp(teacher3);


//        Iterator<Person> iter = librarian.getPriorityQueue().iterator();
//        while(iter.hasNext()){
//            System.out.println(iter.next().getBooky());
//        }




        // Assign Book on priority

//        for(int i =0; i< librarian.getCount(); i++){
//            librarian.borrowBookOnPriority();
//        }
//        librarian.borrowBookOnPriority();
//        librarian.borrowBookOnPriority();


        // Assign Book on FIFO

        for(int i =0; i< librarian.getCount(); i++){
            librarian.borrowBookOnFIFO();
        }
        librarian.borrowBookOnFIFO();
        librarian.borrowBookOnFIFO();







        //Books remaining

        System.out.println("Remaining Books: " +librarian.getLibraryBooks());




    }
}
