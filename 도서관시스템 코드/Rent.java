
public class Rent {
        Library l=new Library();
        Member member=new Member();
        GeneralCopy copy=new GeneralCopy();
	  Rent(){
		  
	  }
	  Rent(Member member, GeneralCopy g){//���ⰴü ���� 
		  if(g.rentState==true){
		  member.count++;
		  g.rentState=false;
		  this.member=member;
		  this.copy=g;
		  System.out.println("å "+copy.bookName+"�� ���� ������ �Ϸ�Ǿ����ϴ� ");
		  }
		  else if(g.rentState==false){
			  System.out.println("�̹� ����� å�Դϴ�");
		  }
	  }
}
