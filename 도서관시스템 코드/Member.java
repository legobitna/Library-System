import java.util.*;
public class Member extends User {
       int count=0;
       ArrayList<Rent> rent=new ArrayList<Rent>();//���⸮��Ʈ 
       ArrayList<Reservation> reservation=new ArrayList<Reservation>();//���ฮ��Ʈ
	Member(){
		
	}
	Member(User use){
		this.id=use.id;
		this.pw=use.pw;
		this.loginState=use.loginState;
		this.Authority=use.Authority;
	}
}
