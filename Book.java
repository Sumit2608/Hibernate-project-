package Assignment1;

public class Book {
    int bookid;
    String bookName;
    String authorName;
    Book(int bookid,String bookName,String authorName){
        this.bookid=bookid;
        this.bookName=bookName;
        this.authorName=authorName;
    }
   int getBookid(){
        return bookid;
   }
   String getBookName(){
        return bookName;
   }
   String getAuthorName(){
        return authorName;
   }
   public String toString(){
        return "Book [ bookid ="+getBookid()+", bookName = "+getBookName()+", authorName = "+getAuthorName()+" ]";
   }

}
