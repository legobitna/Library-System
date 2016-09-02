import java.util.*;
public class Book {
	
	String bookName;
	String bookAuthor;
	String publisher;
	int  categoryCode;
	boolean bookKind;
	ArrayList <GeneralCopy> list=  new ArrayList <GeneralCopy>();
	 ArrayList<ReferenceCopy> list2=new ArrayList <ReferenceCopy>();
	 Book( String bookName, String bookAuthor, String publisher, int categoryCode, boolean bookKind){
	    	this.bookName=bookName;
	    	this.bookAuthor=bookAuthor;
	    	this.publisher=publisher;
	    	this.categoryCode=categoryCode;
	    	this.bookKind=bookKind;
	    }
	    Book(){
	    }
		
	    void searchGeneralBook(Member m, int code){//책 대출하기 이벤트 copy를 찾아주고 그에대한 대출을생성한다
	    	boolean s=false;
	    	for(int i=0;i<list.size();i++){
	    		if(list.get(i).bookCode==code){
	    			if(m.count<=6){
	    			Rent r=new Rent(m,list.get(i));//대출객체 생성 
	    			m.rent.add(r);
	    			m.count++;
	    			}
	    			else
	    				System.out.println("대출한도를 초과했습니다");//회원이 6권이상 빌리면 대출한도초과로 대출불가
	    			s=true;
	    		}
	    		
	    		
	    		
	    	}
	    }

}
