import java.util.*;
public class ReferenceCopy extends Book {
	 int bookCode;
     
     ReferenceCopy(Book b,int bookCode){
   	  this.bookCode=bookCode;
   	
   	  this.bookName=b.bookName;
   	  this.bookAuthor=b.bookAuthor;
   	  this.publisher=b.publisher;
   	  this.categoryCode=b.categoryCode;
   	  this.bookKind=true;
     }
}
