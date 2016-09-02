import java.util.*;
public class Library {
	ArrayList <User> user=new ArrayList<User>();//사용자 리스트
	ArrayList <Book> book=new ArrayList <Book>();//책리스트
	 ArrayList<Book> result=new ArrayList<Book>();//검색된 책에대한 리스트
	GeneralCopy gc=new GeneralCopy();
	Scanner sc=new Scanner(System.in);
	Library(){
		
	}
	void logIn(User u){//로그인이벤트
		Iterator<User> it = user.iterator();
		while(it.hasNext()){
			User t=it.next();
			if((t.id).equals(u.id)&& (t.pw).equals(u.pw)){
				u.loginState=true;
				u.Authority=t.Authority;
			}
		}
		
	}
	void addBook(Book b, int code){//책등록이벤트  Book 과 Copy가 생김 
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
	void searchBookByCode(Member m,int ccode, int code){//대출이벤트 
		boolean bl=false;
		for(int i=0;i<book.size();i++){
			
				if((book.get(i).categoryCode)==(ccode)){
				     if(book.get(i).bookKind==false){
					System.out.println("참고도서라 대출이 불가능 합니다");
					bl=true;
				     }
				else if(book.get(i).bookKind==true){
					book.get(i).searchGeneralBook(m,code);//copy에 대한 검색은 book객체에 가서 검색한다
					bl=true;
				    }
				}
				
			
		}
		if(bl==false)
			System.out.println("일치하는 책을 찾을 수 없습니다");
	}
	void returnBook(Member m, int code){//반납이벤트
		boolean r=false;
		for(int i=0;i<m.rent.size();i++){
			if(m.rent.get(i).copy.bookCode==code){
				m.rent.get(i).copy.rentState=true;
				m.count--;
				m.rent.remove(i);
				r=true;
				System.out.println("반납이 완료되었습니다");
			}
		}
		if(r==false)
			System.out.println("일치하는 책을 찾을 수 없습니다");
		
	}
	boolean searchByTitle(String title){ //책 제목으로 검색하기 
		boolean u=false;
		for(int i=0;i<book.size();i++){
			if(book.get(i).bookName.equals(title)){
				
				result.add(book.get(i));
				u=true;
			}
		}
		
		int x=1;
		System.out.println("no.    책제목         저자          출판사               카테고리코드 ");
		for(int j=0;j<result.size();j++){
			
			System.out.println(x+".     "+result.get(j).bookName+"     "+result.get(j).bookAuthor+"     "+result.get(j).publisher+"         "
					+result.get(j).categoryCode);
			x++;
			
		}
		if(u==false){
			System.out.println("일치하는책을 찾을 수 없습니다");
		}
		return u;
	}
	boolean searchByAuthor(String title){// 저자로 검색하기 
		boolean u=false;
		for(int i=0;i<book.size();i++){
			if(book.get(i).bookAuthor.equals(title)){
				result.add(book.get(i));
				u=true;
			}
			
		}
		
		int x=1;
		System.out.println("no.    책제목         저자          출판사               카테고리코드 ");
		for(int j=0;j<result.size();j++){
			
			System.out.println(x+".       "+result.get(j).bookName+"     "+result.get(j).bookAuthor+"     "+result.get(j).publisher+"         "
					+result.get(j).categoryCode);
			x++;
			
		}
		if(u==false){
			System.out.println("일치하는책을 찾을 수 없습니다");
			
		}
		return u;
		
	}	
	boolean searchByPublisher(String title){ //출판사로 검색하기 
		boolean u=false;
		for(int i=0;i<book.size();i++){
			if(book.get(i).publisher.equals(title)){
				result.add(book.get(i));
				u=true;
			}
		}
		
		int x=1;
		System.out.println("no.    책제목         저자          출판사               카테고리코드 ");
		for(int j=0;j<result.size();j++){
			
			System.out.println(x+".     "+result.get(j).bookName+"     "+result.get(j).bookAuthor+"     "+result.get(j).publisher+"         "
					+result.get(j).categoryCode);
			x++;
			
		}if(u==false){
			System.out.println("일치하는책을 찾을 수 없습니다");
		}
		return u;
	}
	boolean searchByCategoryCode(int code){ //카테고리코드로 검색하기
		boolean u=false;
		for(int i=0;i<book.size();i++){
			if(book.get(i).categoryCode==code){
				result.add(book.get(i));
				u=true;
			}
		}
		
		int x=1;
		System.out.println("no.    책제목         저자          출판사               카테고리코드 ");
		for(int j=0;j<result.size();j++){
			
			System.out.println(x+".       "+result.get(j).bookName+"         "+result.get(j).bookAuthor+"         "+result.get(j).publisher+"             "
					+result.get(j).categoryCode);
			x=x+1;
			
		}if(u==false){
			System.out.println("일치하는책을 찾을 수 없습니다");
		}return u;
		
	}
	void selectBook(Member m,int num){ //책선택하기 선택시 해당 Book에대한 copy정보들과 대출 가능여부가뜬다
		int y=1;
		num=num-1;
		boolean reserv=false;
		if(result.get(num).bookKind==true){
			System.out.println("no.    책제목         책코드         대출가능여부");
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
			
			if(reserv==false){// 책이 모두 대출상태라면 예약메세지가 뜬다 
				System.out.println("예약하시겠습니까? yes or no");
				String r=sc.nextLine();
				
				if(r.equals("yes")){
					System.out.println("책을 선택해주세요");
					int k=sc.nextInt();
					Reservation rr=new Reservation(m,result.get(num).list.get(k-1));//예약객체가 생성된다 
					
					m.reservation.add(rr);
					
				}
			}
			
		}
		
		else if(result.get(num).bookKind==false){//참고도서이면 대출가능 여부에대한 정보는 보여지지않는다
			System.out.println("no.    책제목         책코드 ");
			for(int i=0;i<result.get(num).list2.size();i++){
				System.out.println(y+".         "+result.get(num).list2.get(i).bookName+"             "+result.get(num).list2.get(i).bookCode);
		}
	}
		result.removeAll(result);		
	}
}


