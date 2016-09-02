import java.util.*;
public class Library {
	ArrayList <User> user=new ArrayList<User>();//����� ����Ʈ
	ArrayList <Book> book=new ArrayList <Book>();//å����Ʈ
	 ArrayList<Book> result=new ArrayList<Book>();//�˻��� å������ ����Ʈ
	GeneralCopy gc=new GeneralCopy();
	Scanner sc=new Scanner(System.in);
	Library(){
		
	}
	void logIn(User u){//�α����̺�Ʈ
		Iterator<User> it = user.iterator();
		while(it.hasNext()){
			User t=it.next();
			if((t.id).equals(u.id)&& (t.pw).equals(u.pw)){
				u.loginState=true;
				u.Authority=t.Authority;
			}
		}
		
	}
	void addBook(Book b, int code){//å����̺�Ʈ  Book �� Copy�� ���� 
		boolean ad=false;
		for(int i=0;i<book.size();i++){
		  if((book.get(i).categoryCode)==(b.categoryCode)){
			  if(b.bookKind==true){
				  GeneralCopy gc=new GeneralCopy(b,code,true);
				  book.get(i).list.add(gc);
				  
				  ad=true;
			  }
			  else if(b.bookKind==false){
				  ReferenceCopy rc=new ReferenceCopy(b,code);
				  book.get(i).list2.add(rc);
				  
				  ad=true;
			  }
		  }
		}
		  if(ad==false){
			 book.add(b);
			 if(b.bookKind==true){
			 GeneralCopy nc=new GeneralCopy(b,code,true);
			 book.get(book.size()-1).list.add(nc);
			 }
			 else if(b.bookKind==false){
				 ReferenceCopy rnc=new ReferenceCopy(b,code);
				 book.get(book.size()-1).list2.add(rnc);
			 }
		  }
		}
	void searchBookByCode(Member m,int ccode, int code){//�����̺�Ʈ 
		boolean bl=false;
		for(int i=0;i<book.size();i++){
			
				if((book.get(i).categoryCode)==(ccode)){
				     if(book.get(i).bookKind==false){
					System.out.println("�������� ������ �Ұ��� �մϴ�");
					bl=true;
				     }
				else if(book.get(i).bookKind==true){
					book.get(i).searchGeneralBook(m,code);//copy�� ���� �˻��� book��ü�� ���� �˻��Ѵ�
					bl=true;
				    }
				}
				
			
		}
		if(bl==false)
			System.out.println("��ġ�ϴ� å�� ã�� �� �����ϴ�");
	}
	void returnBook(Member m, int code){//�ݳ��̺�Ʈ
		boolean r=false;
		for(int i=0;i<m.rent.size();i++){
			if(m.rent.get(i).copy.bookCode==code){
				m.rent.get(i).copy.rentState=true;
				m.count--;
				m.rent.remove(i);
				r=true;
				System.out.println("�ݳ��� �Ϸ�Ǿ����ϴ�");
			}
		}
		if(r==false)
			System.out.println("��ġ�ϴ� å�� ã�� �� �����ϴ�");
		
	}
	boolean searchByTitle(String title){ //å �������� �˻��ϱ� 
		boolean u=false;
		for(int i=0;i<book.size();i++){
			if(book.get(i).bookName.equals(title)){
				
				result.add(book.get(i));
				u=true;
			}
		}
		
		int x=1;
		System.out.println("no.    å����         ����          ���ǻ�               ī�װ��ڵ� ");
		for(int j=0;j<result.size();j++){
			
			System.out.println(x+".     "+result.get(j).bookName+"     "+result.get(j).bookAuthor+"     "+result.get(j).publisher+"         "
					+result.get(j).categoryCode);
			x++;
			
		}
		if(u==false){
			System.out.println("��ġ�ϴ�å�� ã�� �� �����ϴ�");
		}
		return u;
	}
	boolean searchByAuthor(String title){// ���ڷ� �˻��ϱ� 
		boolean u=false;
		for(int i=0;i<book.size();i++){
			if(book.get(i).bookAuthor.equals(title)){
				result.add(book.get(i));
				u=true;
			}
			
		}
		
		int x=1;
		System.out.println("no.    å����         ����          ���ǻ�               ī�װ��ڵ� ");
		for(int j=0;j<result.size();j++){
			
			System.out.println(x+".       "+result.get(j).bookName+"     "+result.get(j).bookAuthor+"     "+result.get(j).publisher+"         "
					+result.get(j).categoryCode);
			x++;
			
		}
		if(u==false){
			System.out.println("��ġ�ϴ�å�� ã�� �� �����ϴ�");
			
		}
		return u;
		
	}	
	boolean searchByPublisher(String title){ //���ǻ�� �˻��ϱ� 
		boolean u=false;
		for(int i=0;i<book.size();i++){
			if(book.get(i).publisher.equals(title)){
				result.add(book.get(i));
				u=true;
			}
		}
		
		int x=1;
		System.out.println("no.    å����         ����          ���ǻ�               ī�װ��ڵ� ");
		for(int j=0;j<result.size();j++){
			
			System.out.println(x+".     "+result.get(j).bookName+"     "+result.get(j).bookAuthor+"     "+result.get(j).publisher+"         "
					+result.get(j).categoryCode);
			x++;
			
		}if(u==false){
			System.out.println("��ġ�ϴ�å�� ã�� �� �����ϴ�");
		}
		return u;
	}
	boolean searchByCategoryCode(int code){ //ī�װ��ڵ�� �˻��ϱ�
		boolean u=false;
		for(int i=0;i<book.size();i++){
			if(book.get(i).categoryCode==code){
				result.add(book.get(i));
				u=true;
			}
		}
		
		int x=1;
		System.out.println("no.    å����         ����          ���ǻ�               ī�װ��ڵ� ");
		for(int j=0;j<result.size();j++){
			
			System.out.println(x+".       "+result.get(j).bookName+"         "+result.get(j).bookAuthor+"         "+result.get(j).publisher+"             "
					+result.get(j).categoryCode);
			x=x+1;
			
		}if(u==false){
			System.out.println("��ġ�ϴ�å�� ã�� �� �����ϴ�");
		}return u;
		
	}
	void selectBook(Member m,int num){ //å�����ϱ� ���ý� �ش� Book������ copy������� ���� ���ɿ��ΰ����
		int y=1;
		num=num-1;
		boolean reserv=false;
		if(result.get(num).bookKind==true){
			System.out.println("no.    å����         å�ڵ�         ���Ⱑ�ɿ���");
			for(int i=0;i<result.get(num).list.size();i++){
				System.out.println(y+".     "+result.get(num).list.get(i).bookName+"         "+result.get(num).list.get(i).bookCode+
						"         "+result.get(num).list.get(i).rentState);
				y++;
				
			
			}
			for(int t=0;t<result.get(num).list.size();t++){
			 if(result.get(num).list.get(t).rentState==true){
				 reserv=true;
				 break;
			 }
			}
			
			if(reserv==false){// å�� ��� ������¶�� ����޼����� ��� 
				System.out.println("�����Ͻðڽ��ϱ�? yes or no");
				String r=sc.nextLine();
				
				if(r.equals("yes")){
					System.out.println("å�� �������ּ���");
					int k=sc.nextInt();
					Reservation rr=new Reservation(m,result.get(num).list.get(k-1));//���ఴü�� �����ȴ� 
					
					m.reservation.add(rr);
					
				}
			}
			
		}
		
		else if(result.get(num).bookKind==false){//�������̸� ���Ⱑ�� ���ο����� ������ ���������ʴ´�
			System.out.println("no.    å����         å�ڵ� ");
			for(int i=0;i<result.get(num).list2.size();i++){
				System.out.println(y+".         "+result.get(num).list2.get(i).bookName+"             "+result.get(num).list2.get(i).bookCode);
		}
	}
		result.removeAll(result);		
	}
}


