package com.kodilla.testing.library;
import java.util.*;
import org.junit.Test;
import org.junit.Assert;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClassTests {

    @Test
    public void test1(){

        LibraryDatabase mock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary2 = new BookLibrary(mock);

        List<Book> listOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        listOfBooks.add(book3);
        listOfBooks.add(book4);

        when(mock.listBooksWithCondition("Secret")).thenReturn(listOfBooks);

        List<Book> result = bookLibrary2.listBooksWithCondition("Secret");

        Assert.assertEquals(4, result.size());
    }
    @Test
    public void test2(){
        LibraryDatabase mock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(mock);

        List<Book> listOfBooks = new ArrayList<>();

        when(mock.listBooksWithCondition("Kot")).thenReturn(listOfBooks);

        List<Book> result = new ArrayList<>();
        result = bookLibrary.listBooksWithCondition("Kot");

        Assert.assertEquals(0, result.size());
    }
    @Test
    public void test3(){
        LibraryUser user1 = new LibraryUser("Alicja","Kowalska","86121617029");
        LibraryDatabase mock1 = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(mock1);

        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Dom dzienny, dom nocny","Olga Tokarczuk",2018));

        when(mock1.listBooksInHandsOf(user1)).thenReturn(listOfBooks);

        List<Book> result = bookLibrary.listBooksInHandsOf(user1);
        Assert.assertEquals(1,result.size());
    }
    @Test
    public void test4(){
        LibraryUser user1 = new LibraryUser("Alicja","Kowalska","86121617029");
        LibraryDatabase mock1 = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(mock1);

        List<Book> listOfBooks = new ArrayList<>();

        when(mock1.listBooksInHandsOf(user1)).thenReturn(listOfBooks);

        List<Book> result = bookLibrary.listBooksInHandsOf(user1);
        Assert.assertEquals(0,result.size());
    }
    @Test
    public void test5(){
        LibraryUser user1 = new LibraryUser("Alicja","Kowalska","86121617029");
        LibraryDatabase mock1 = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(mock1);

        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Wiele Demonów","Jerzy Pilch",2011));
        listOfBooks.add(new Book("Żywego Ducha","Jerzy Pilch",2017));
        listOfBooks.add(new Book("Dziennik","Jerzy Pilch",2006));
        listOfBooks.add(new Book("Upadek człowieka pod dworcem centralnym","Jerzy Pilch",2007));
        listOfBooks.add(new Book("Spis cudzołożnic","Jerzy Pilch",2008));

        when(mock1.listBooksInHandsOf(user1)).thenReturn(listOfBooks);

        List<Book> result = bookLibrary.listBooksInHandsOf(user1);
        Assert.assertEquals(5,result.size());
    }
}
