package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> a=new ArrayList<>();
        a.add(new Book(12,"ikigai","Hector garcia"));
        a.add(new Book(13,"Harry Potter","J.k Rowling"));
        a.add(new Book(14,"percy Jackson","Rick Riordan"));
        System.out.println("--All Books--");
        for(Book b:a){
            System.out.println(b.toString());
        }
    }
}
