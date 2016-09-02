
public class Reservation {
     Member m=new Member();
     GeneralCopy g=new GeneralCopy();
     
     Reservation(){
    	 
     }
     Reservation(Member m, GeneralCopy g){//예약객체 생성
    	 this.m=m;
    	 this.g=g;
    	 g.reservationState=true;
    	 System.out.println("책 "+ g.bookName+"에 대한 예약이 완료되었습니다");
     }
}
