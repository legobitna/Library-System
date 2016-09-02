
public class Administer extends User {
 
	Administer(){
		
	}
	Administer(User user){
		this.id=user.id;
		this.pw=user.pw;
		this.Authority=user.Authority;
		this.loginState=user.loginState;
	}
	void registerBook(String bookName, String bookAuthor, String publisher, //책등록하기이벤트
			int categoryCode,int bookCode, boolean kind,Library l){
		Book b=new Book (bookName,bookAuthor,publisher,categoryCode,kind);
		l.addBook(b,bookCode);
		System.out.println("책등록이 되었습니다 ");
	
	}
	
}
