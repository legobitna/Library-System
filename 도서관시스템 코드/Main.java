import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Library l=new Library(); 
		User member=new User();
		 Member m=new Member(member);
		 User user1=new User("tallshe","tallshe",false,false);
		
   	    User user2=new User("administer","administer",true,false);
   	    l.user.add(user1);
   	    l.user.add(user2);
   	 Book book1=new Book ("정처기","김빛나","시나공",1,true);
   	 Book book2=new Book ("프로그래밍","김빛나","햇빛",2,false);
   	 Book book3=new Book("글자전쟁","김진명","파고다",3,true);
	
	
   	// GeneralCopy gc=new GeneralCopy(book1,11,true);
   	    l.addBook(book1, 11);
   	    l.addBook(book2, 21);
   	    l.addBook(book3,31 );
   	    l.addBook(book1, 12);
   	 l.addBook(book1, 13);
   	l.addBook(book1, 14);
	
   	int menu = 0;
   	    Scanner scan=new Scanner(System.in);
   	  
   	   while(true){
   		 
   		   System.out.println("팀 2의 도서관에 오신것을 환영합니다 ");
   		   System.out.println("로그인을 해주세요");
   		   System.out.print("ID: ");
   		   String idscan=scan.next();
   		System.out.print("Password: ");
		   String pwscan=scan.next();
		   member.id=idscan;
		   member.pw=pwscan;
		   l.logIn(member);
		   if(member.loginState==false){
			   System.out.println("다시 로그인해주세요");
			   continue;
		   }
		   
		   else if(member.loginState==true){
			   System.out.println(member.id+"님 환영합니다");
			   if(member.Authority==true){
				   Administer ad=new Administer();
				   while(true){
					System.out.println("책등록하기 페이지");
				   
					System.out.print("책이름:");
					String name=scan.next();
					System.out.print("책저자: ");
					String author =scan.next();
					System.out.print("출판사: ");
					String publisher= scan.next();
					System.out.print("카테고리 코드: ");
					int category= scan.nextInt();
					System.out.print("책종류: ");
					boolean kind=scan.nextBoolean();
					System.out.print("책코드: ");
					int code=scan.nextInt();
					ad.registerBook(name, author, publisher, category, code, kind,l);
					System.out.println("종료하시겠 습니까? yes, no");
					String ans=scan.next();
					if(ans.equals("no")){
						continue;
					}
					else if(ans.equals("yes")){
						break;
					}
					
				   }
				 
					
			   }
			   else if(member.Authority==false){
				 while(true){
					 System.out.println("                      ");
					 boolean y=false;
				   System.out.println("메뉴선택하기");
				   System.out.println("1.검색하기   2.대출하기  3.반납하기  4.로그아웃 5.종료하기");
				   menu =scan.nextInt();
				   switch (menu){
				   case 1:
					   System.out.println("1. 책 제목으로 검색   2. 저자검색  3. 출판사검색  4. 카테고리코드 검색");
					   int search=scan.nextInt();
					   
					   switch (search){
					   
					   case 1:
						   System.out.print("책제목: ");
						   String str=scan.next();
						   y=l.searchByTitle(str);
						   if(y==true){
						   System.out.println("선택할 책 번호를 입력하세요");
						   int num=scan.nextInt();
						   l.selectBook( m,num);
						   }
					
						   break;
					   case 2:
						   System.out.print("저자: ");
						   String str1=scan.next();
						   y=l.searchByAuthor(str1);
						   if(y==true){
						   System.out.println("선택할 책 번호를 입력하세요");
						   int num2=scan.nextInt();
						  l.selectBook( m,num2);
						   }
						   break;
					   case 3:
						   System.out.print("출판사: ");
						   String str2=scan.next();
						  y= l.searchByPublisher(str2);
						  if(y==true){
						   System.out.println("선택할 책 번호를 입력하세요");
						   int num3=scan.nextInt();
						   l.selectBook( m,num3);
						  }
						  
						   break;
					   case 4:
						   System.out.print("카테고리코드: ");
						   int code=scan.nextInt();
						  y= l.searchByCategoryCode(code);
						  if(y==true){
						   System.out.println("선택할 책 번호를 입력하세요");
						   int num5=scan.nextInt();
						   l.selectBook(m,num5);
						  }
						   break;
					   }
					   break;
				   
				   case 2:
					   System.out.println("대출할 책의 카테고리코드를  입력해 주세요");
					   int ccode=scan.nextInt();
					   System.out.println("대출할책의 코드를 입력하시오");
					   int code=scan.nextInt();
					   l.searchBookByCode(m,ccode, code);
					  break;
				   case 3:
					
					   System.out.println("반납할 책의 코드를 입력해 주세요");
					   int rcode=scan.nextInt();
					   l.returnBook(m,rcode);
					  
					   break;
					 case 4:
					   System.out.println("로그아웃되었습니다");   
					   break;
				   }
				  
				   if(menu==4||menu==5){
					   break;
				   }
			   }
		   } 
		   }
		   if(menu==5){
			 System.out.println("종료되었습니다");
			 break;
		   }
			   
   	   }
		

	}
}
