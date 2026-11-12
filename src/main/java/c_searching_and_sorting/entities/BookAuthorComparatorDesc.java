package c_searching_and_sorting.entities;

import java.util.Comparator;

public class BookAuthorComparatorDesc implements Comparator<Book> {
    public int compare(Book b1, Book b2){
        return b1.getAuthor().compareToIgnoreCase(b2.getAuthor()) * -1;
    }
}
