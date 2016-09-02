
public class User {
	 String id;
     String pw;
     boolean Authority;
     boolean loginState;
 User(){
    	 
     }
 User(String id, String pw, boolean Authority,boolean loginState){
	 this.id=id;
	 this.pw=pw;
	 this.Authority=Authority;
	 this.loginState=loginState;
 }
}
