
public class GeneralCopy extends Book {
        int bookCode;//å�ڵ�
        boolean rentState;//�������
        boolean reservationState;//�������
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
