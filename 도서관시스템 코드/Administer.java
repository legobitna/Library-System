
public class Administer extends User {
 
	Administer(){
		
	}
	Administer(User user){
		this.id=user.id;
		this.pw=user.pw;
		this.Authority=user.Authority;
		this.loginState=user.loginState;
	}
	void registerBook(String bookName, String bookAuthor, String publisher, //å����ϱ��̺�Ʈ
			int categoryCode,int bookCode, boolean kind,Library l){
		Book b=new Book (bookName,bookAuthor,publisher,categoryCode,kind);
		l.addBook(b,bookCode);
		System.out.println("å����� �Ǿ����ϴ� ");
	
	}
	
}
