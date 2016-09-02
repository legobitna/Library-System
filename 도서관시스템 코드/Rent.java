
public class Rent {
        Library l=new Library();
        Member member=new Member();
        GeneralCopy copy=new GeneralCopy();
	  Rent(){
		  
	  }
	  Rent(Member member, GeneralCopy g){//대출객체 생성 
		  if(g.rentState==true){
		  member.count++;
		  g.rentState=false;
		  this.member=member;
		  this.copy=g;
		  System.out.println("책 "+copy.bookName+"에 대한 대출이 완료되었습니다 ");
		  }
		  else if(g.rentState==false){
			  System.out.println("이미 대출된 책입니다");
		  }
	  }
}
