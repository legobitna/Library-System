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
		
	    void searchGeneralBook(Member m, int code){//å �����ϱ� �̺�Ʈ copy�� ã���ְ� �׿����� �����������Ѵ�
	    	boolean s=false;
	    	for(int i=0;i<list.size();i++){
	    		if(list.get(i).bookCode==code){
	    			if(m.count<=6){
	    			Rent r=new Rent(m,list.get(i));//���ⰴü ���� 
	    			m.rent.add(r);
	    			m.count++;
	    			}
	    			else
	    				System.out.println("�����ѵ��� �ʰ��߽��ϴ�");//ȸ���� 6���̻� ������ �����ѵ��ʰ��� ����Ұ�
	    			s=true;
	    		}
	    		
	    		
	    		
	    	}
	    }

}
