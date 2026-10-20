package c_searching_and_sorting.apps;

import c_searching_and_sorting.entities.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestBuiltInSorting {
    private final static Random randomGenerator = new Random();

    private final static String[] titles = {
      "To Kill a Mockingbird", "Catch-22", "Catcher in the Rye",
      "One Flew Over the Cuckoo's Nest", "'twas the Night Before Christmas",
      "The Grinch Who Stole Christmas", "One Fish, Two Fish, Red Fish, Blue Fish",
      "Looshkin", "Percy Jackson and the Lightning Thief",
      "Harry Potter and the Goblet of Fire", "The Magicians"
    };

    private final static String[] authors = {
            "Dr Seuss", "Rick Riordan", "JK Rowling", "Jamie Smart",
            "Harper Lee", "JD Salinger", "Lev Grossman", "Joseph Heller"
    };

    private static Book generateBook(){
        int randomTitleIndex = randomGenerator.nextInt(titles.length);
        int randomAuthorIndex = randomGenerator.nextInt(authors.length);

        return new Book(titles[randomTitleIndex], authors[randomAuthorIndex]);
    }

    static void main(String[] args) {
        List<Book> unsortedBooks = new ArrayList<>();
        List<Book> booksToSortUsingComparable = new ArrayList<>();
        List<Book> booksToSortUsingLambda = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Book book = generateBook();
            unsortedBooks.add(book);
            booksToSortUsingComparable.add(book);
            booksToSortUsingLambda.add(book);
        }

        System.out.println("Before sorting: ");
        for (Book book : unsortedBooks) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
        System.out.println("==============================================");
        Collections.sort(booksToSortUsingComparable);
        System.out.println("After sorting: ");
        for (Book book : booksToSortUsingComparable) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
        System.out.println("==============================================");

        Collections.sort(booksToSortUsingLambda,
                (Book b1, Book b2) ->
                        b1.getAuthor().compareToIgnoreCase(b2.getAuthor()) * -1
                );
        System.out.println("After sorting: ");
        for (Book book : booksToSortUsingLambda) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
        System.out.println("==============================================");
    }
}
