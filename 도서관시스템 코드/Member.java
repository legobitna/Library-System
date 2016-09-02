import java.util.*;
public class Member extends User {
       int count=0;
       ArrayList<Rent> rent=new ArrayList<Rent>();//대출리스트 
       ArrayList<Reservation> reservation=new ArrayList<Reservation>();//예약리스트
	Member(){
		
	}
	Member(User use){
		this.id=use.id;
		this.pw=use.pw;
		this.loginState=use.loginState;
		this.Authority=use.Authority;
	}
}
