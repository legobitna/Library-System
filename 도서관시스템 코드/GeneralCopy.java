
public class GeneralCopy extends Book {
        int bookCode;//책코드
        boolean rentState;//대출상태
        boolean reservationState;//예약상태
        GeneralCopy(){
        	
        }
       
        GeneralCopy(Book b,int bookCode, boolean rentState){
      	  this.bookCode=bookCode;
      	  this.rentState=rentState;
      	  this.bookName=b.bookName;
      	  this.bookAuthor=b.bookAuthor;
      	  this.publisher=b.publisher;
      	  this.categoryCode=b.categoryCode;
      	  this.bookKind=true;
        }
        
}
