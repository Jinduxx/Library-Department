package service;

import model.Book;
import model.Person;

import java.util.*;

public class LibraryServiceImplement implements LibraryService {

    private static int count;
    private final Map<String, String> bookRegister = new HashMap<>();
    private final Map<String,Integer> libraryBooks = new HashMap<>();
    private static final Queue<Person> personQueue = new ArrayDeque<>();


    private static final Queue<Person> priorityQueue = new PriorityQueue<>((one, two) ->
            Integer.compare(two.getPriority(), one.getPriority()));

    public Queue<Person> getPriorityQueue() {
        return priorityQueue;
    }

    public Queue<Person> getPersonQueue() {
        return personQueue;
    }

    public Map<String, Integer> getLibraryBooks() {
        return libraryBooks;
    }

    public Map<String, String> getBookRegister() {
        return bookRegister;
    }

    public  int getCount() {
        return count;
    }

    private void addToQueue (Person person){
        if(!personQueue.contains(person)){
            personQueue.add(person);
        }

        if(!priorityQueue.contains(person)){
            priorityQueue.add(person);
        }
    }

    @Override
    public void queueUp(final Person person) {
        if(person != null){
            addToQueue(person);
            count++;
        }
    }

    @Override
    public void stackBook(final Book book) {
        if(libraryBooks.containsKey(book.getTitle())){
            int old = this.libraryBooks.get(book.getTitle());
            this.libraryBooks.put(book.getTitle(), old + book.getNoOfCopies());
        }else{
            this.libraryBooks.put(book.getTitle(), book.getNoOfCopies());
        }
    }

    @Override
    public void borrowBookOnPriority() throws Exception {
        if(!priorityQueue.isEmpty()){
            final  Person bookBorrower = priorityQueue.remove();
            if(libraryBooks.get(bookBorrower.getBook()) == 0){
                System.out.println("Apologies "+ bookBorrower.getPersonType() + " " +  bookBorrower.getName() + ", " + bookBorrower.getBook() + " Book"+ " is already taken");
            }else {
                if(bookRegister.containsKey(bookBorrower.getName()) && bookRegister.containsValue(bookBorrower.getBook())){
                    System.out.println(bookBorrower.getPersonType() + " " + bookBorrower.getName() +" You can't borrow same book twice");
//                    throw new Exception(bookBorrower.getPersonType() + " " + bookBorrower.getName() +" You can't borrow same book twice");
                } else{
                    bookRegister.put(bookBorrower.getName(),bookBorrower.getBook());
                    libraryBooks.put(bookBorrower.getBook(), libraryBooks.get(bookBorrower.getBook()) -1);
                    System.out.println(bookBorrower.getPersonType() + " " + bookBorrower.getName() +  " You have Successfully borrowed " + bookBorrower.getBook() +" Book");
                }
            }
        } else{
            throw new Exception("Nobody is in the Queue. Go and rest :)");
        }
    }

    @Override
    public void borrowBookOnFIFO() throws Exception {
        if(!personQueue.isEmpty()) {
            final  Person bookBorrower = personQueue.remove();
            if (libraryBooks.get(bookBorrower.getBook()) == 0) {
                System.out.println("Apologies "+ bookBorrower.getPersonType() + " " +  bookBorrower.getName() + ", " + bookBorrower.getBook() + " Book"+ " is already taken");
            } else {
                if(bookRegister.containsKey(bookBorrower.getName()) && bookRegister.containsValue(bookBorrower.getBook())){
//                    System.out.println(bookBorrower.getPersonType() + " " + bookBorrower.getName() + " You can't borrow same book twice");
                    throw new Exception(bookBorrower.getPersonType() + " " + bookBorrower.getName() +" You can't borrow same book twice");
                } else{
                    bookRegister.put(bookBorrower.getName(),bookBorrower.getBook());
                    libraryBooks.put(bookBorrower.getBook(), libraryBooks.get(bookBorrower.getBook()) -1);
                    System.out.println(bookBorrower.getPersonType() + " " + bookBorrower.getName() +  " You have Successfully borrowed " + bookBorrower.getBook() +" Book");
                }
            }
        }else {
            throw new Exception("Nobody is in the Queue. Go and rest :)");
        }
    }
}
