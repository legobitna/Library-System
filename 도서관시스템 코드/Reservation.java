
public class Reservation {
     Member m=new Member();
     GeneralCopy g=new GeneralCopy();
     
     Reservation(){
    	 
     }
     Reservation(Member m, GeneralCopy g){//���ఴü ����
    	 this.m=m;
    	 this.g=g;
    	 g.reservationState=true;
    	 System.out.println("å "+ g.bookName+"�� ���� ������ �Ϸ�Ǿ����ϴ�");
     }
}
