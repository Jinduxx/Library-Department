package service;


import model.Book;
import model.Person;

import java.util.*;


public class Library implements LibraryService {

    private static int count;
    private Map<String,Integer> libraryBooks = new HashMap<>();
    private final static Queue<Person> personQueue = new ArrayDeque<>();
    private final static Queue<Person> priorityQueue = new PriorityQueue<>(new Comparator<Person>() {

        @Override
        public int compare(Person one, Person two) {
            if(one.getPriority() > two.getPriority()){
                return -1;
            }else if(one.getPriority() < two.getPriority()){
                return 1;
            }else{
                return 0;
            }
        }
    });



    public Queue<Person> getPriorityQueue() {
        return priorityQueue;
    }


    public Queue<Person> getPersonQueue() {
        return personQueue;
    }


    private void addToQueue (Person person){
        if(!personQueue.contains(person)){
            personQueue.add(person);
        }

        if(!priorityQueue.contains(person)){
            priorityQueue.add(person);
        }
    }

    public Map<String, Integer> getLibraryBooks() {
        return libraryBooks;
    }


    @Override
    public void queueUp(Person person) {
        if(person != null){
            addToQueue(person);

        }
        count++;
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
            if((libraryBooks.get(bookBorrower.getBook()) == 0)){
                System.out.println("Apologies "+ bookBorrower.getName() + ", " + bookBorrower.getBook() + " Book"+ " is already taken");
            }else {
                int old = libraryBooks.get(bookBorrower.getBook());
                libraryBooks.put(bookBorrower.getBook(), old -1);
                System.out.println(bookBorrower.getName() +  " You have Successfully borrowed " + bookBorrower.getBook() +" Book");
            }
        } else{
            throw new Exception("Nobody is in the Queue. Go and rest :)");
//            System.out.println();
        }


    }

    @Override
    public void borrowBookOnFIFO() throws Exception {
        if(!personQueue.isEmpty()) {
            final  Person bookBorrower = personQueue.remove();
            if ((libraryBooks.get(bookBorrower.getBook()) == 0)) {
                System.out.println("Apologies "+ bookBorrower.getName() + ", " + bookBorrower.getBook() + " Book"+ " is already taken");
            } else {
                int old = this.libraryBooks.get(bookBorrower.getBook());
                libraryBooks.put(bookBorrower.getBook(), old - 1);
                System.out.println(bookBorrower.getName() + " You have Successfully borrowed " + bookBorrower.getBook() +" Book");
            }
        }else {
            throw new Exception("Nobody is in the Queue. Go and rest :)");

        }

    }
//
//    @Override
//    public void borrowBookOnFIFO() {
//
//        if(!personQueue.isEmpty()){
//
//
//
//            System.out.printf("%n %s Borrowed %s %n",bookBorrower.getName(),bookBorrower.getBook());
//
//
//        }
//
//    }

    public  int getCount() {
        return count;
    }
}
