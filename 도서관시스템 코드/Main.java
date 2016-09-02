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
   	 Book book1=new Book ("��ó��","�����","�ó���",1,true);
   	 Book book2=new Book ("���α׷���","�����","�޺�",2,false);
   	 Book book3=new Book("��������","������","�İ��",3,true);
	
	
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
   		 
   		   System.out.println("�� 2�� �������� ���Ű��� ȯ���մϴ� ");
   		   System.out.println("�α����� ���ּ���");
   		   System.out.print("ID: ");
   		   String idscan=scan.next();
   		System.out.print("Password: ");
		   String pwscan=scan.next();
		   member.id=idscan;
		   member.pw=pwscan;
		   l.logIn(member);
		   if(member.loginState==false){
			   System.out.println("�ٽ� �α������ּ���");
			   continue;
		   }
		   
		   else if(member.loginState==true){
			   System.out.println(member.id+"�� ȯ���մϴ�");
			   if(member.Authority==true){
				   Administer ad=new Administer();
				   while(true){
					System.out.println("å����ϱ� ������");
				   
					System.out.print("å�̸�:");
					String name=scan.next();
					System.out.print("å����: ");
					String author =scan.next();
					System.out.print("���ǻ�: ");
					String publisher= scan.next();
					System.out.print("ī�װ� �ڵ�: ");
					int category= scan.nextInt();
					System.out.print("å����: ");
					boolean kind=scan.nextBoolean();
					System.out.print("å�ڵ�: ");
					int code=scan.nextInt();
					ad.registerBook(name, author, publisher, category, code, kind,l);
					System.out.println("�����Ͻð� ���ϱ�? yes, no");
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
				   System.out.println("�޴������ϱ�");
				   System.out.println("1.�˻��ϱ�   2.�����ϱ�  3.�ݳ��ϱ�  4.�α׾ƿ� 5.�����ϱ�");
				   menu =scan.nextInt();
				   switch (menu){
				   case 1:
					   System.out.println("1. å �������� �˻�   2. ���ڰ˻�  3. ���ǻ�˻�  4. ī�װ��ڵ� �˻�");
					   int search=scan.nextInt();
					   
					   switch (search){
					   
					   case 1:
						   System.out.print("å����: ");
						   String str=scan.next();
						   y=l.searchByTitle(str);
						   if(y==true){
						   System.out.println("������ å ��ȣ�� �Է��ϼ���");
						   int num=scan.nextInt();
						   l.selectBook( m,num);
						   }
					
						   break;
					   case 2:
						   System.out.print("����: ");
						   String str1=scan.next();
						   y=l.searchByAuthor(str1);
						   if(y==true){
						   System.out.println("������ å ��ȣ�� �Է��ϼ���");
						   int num2=scan.nextInt();
						  l.selectBook( m,num2);
						   }
						   break;
					   case 3:
						   System.out.print("���ǻ�: ");
						   String str2=scan.next();
						  y= l.searchByPublisher(str2);
						  if(y==true){
						   System.out.println("������ å ��ȣ�� �Է��ϼ���");
						   int num3=scan.nextInt();
						   l.selectBook( m,num3);
						  }
						  
						   break;
					   case 4:
						   System.out.print("ī�װ��ڵ�: ");
						   int code=scan.nextInt();
						  y= l.searchByCategoryCode(code);
						  if(y==true){
						   System.out.println("������ å ��ȣ�� �Է��ϼ���");
						   int num5=scan.nextInt();
						   l.selectBook(m,num5);
						  }
						   break;
					   }
					   break;
				   
				   case 2:
					   System.out.println("������ å�� ī�װ��ڵ带  �Է��� �ּ���");
					   int ccode=scan.nextInt();
					   System.out.println("������å�� �ڵ带 �Է��Ͻÿ�");
					   int code=scan.nextInt();
					   l.searchBookByCode(m,ccode, code);
					  break;
				   case 3:
					
					   System.out.println("�ݳ��� å�� �ڵ带 �Է��� �ּ���");
					   int rcode=scan.nextInt();
					   l.returnBook(m,rcode);
					  
					   break;
					 case 4:
					   System.out.println("�α׾ƿ��Ǿ����ϴ�");   
					   break;
				   }
				  
				   if(menu==4||menu==5){
					   break;
				   }
			   }
		   } 
		   }
		   if(menu==5){
			 System.out.println("����Ǿ����ϴ�");
			 break;
		   }
			   
   	   }
		

	}
}
