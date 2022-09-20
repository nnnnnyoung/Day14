package BookList;

import java.util.Scanner;


public class BookManager {
	
	
	Scanner in=new Scanner (System.in);
	Book [] Booklist=new Book[10];
	String [] badWord={"바보", "멍청이", "똥개", "말미잘"};
	
	BookManager(){
		for(;;) {
			menu();
			int selmenu=in.nextInt();
			in.nextLine();
			if(selmenu==1) {
				BookInput();
			}else if(selmenu==2) {
				Bookmodi();
			}else if(selmenu==3) {
				BookDel();
			}else if(selmenu==4) {
				BookList();
			}else if(selmenu==5) {
				searchBook();
			}
			
		}
	}





	private void menu() {
		// TODO Auto-generated method stub
		System.out.println("1. 책 등록");
		System.out.println("2. 책 수정");
		System.out.println("3. 책 삭제");
		System.out.println("4. 책 목록보기");		
		System.out.println("5. 책 검색하기");
		System.out.println("해당메뉴의 숫자를 입력해주세요");	
	}


	
	private void Bookmodi() {
		// TODO Auto-generated method stub
		// 이름으로 수정
		System.out.println("<수정> 이름을 입력하세요");
		String modName=in.nextLine();
		boolean flag=true;
		for(int i=0; i<Booklist.length; i++) {
			if(Booklist[i]!=null) {
				if(Booklist[i].name.equals(modName)) {
					System.out.println("수정할 이름을 입력하세요");
					String newName=in.nextLine();
					Booklist[i].name=newName;
					flag=false;
					break;
				}
			}
		}
		if(flag) {
			System.out.println("이름이 없습니다.");
		}
		
	}
	
	private void BookDel() {
		System.out.println("삭제할 책의 고유번호를 입력하세요");
		int no=in.nextInt();
		in.nextLine();
		for(int i=0; i<Booklist.length; i++){
			if(Booklist[i]!=null) {
				if(Booklist[i].no==(no)) {
					Booklist[i]=null;
					System.out.println("삭제완료");
					break;
				}
			}
		}

	}


	private void BookList() {
		// TODO Auto-generated method stub
		for(int i=0; i<Booklist.length; i++) {
			if(Booklist[i]!=null) {
				System.out.println(i+"번 정보---");
				Booklist[i].prt();
			}
		}
	}


	private void BookInput() {
		// TODO Auto-generated method stub
		Book newbooks= new Book();
		System.out.println("책 고유번호를 입력하세요");
		int no=in.nextInt();
		in.nextLine();
		System.out.println("책 이름을 입력하세요");
		
		String name=in.nextLine();
		for(int i=0; i<badWord.length; i++) {
			if(name.contains(badWord[i])) {
				System.out.println("욕설은 입력할 수 없습니다.");
				break;
			}
		}
		System.out.println("발행년도를 입력하세요");
		int year=in.nextInt();
		in.nextLine();
		System.out.println("저자 이름을 입력하세요");
		String writer=in.nextLine();
		
		newbooks.book(no, name, year, writer);
		for(int j=0; j<Booklist.length; j++) {
			if(Booklist[j]==null) {
				Booklist[j]=newbooks;
				break;
			}
		}


	}

	private void searchBook() {
		// TODO Auto-generated method stub
		//이름으로 검색한다. 단 이름은 유니크하다
		// 수준1. 이름이 완전히 일치하면->문자열 객체에서 어떤 메서드를 활용할까?
		//수준2. 검색이름이 실제 이름에 포함되면->문자열 객체에서 어떤 메서드를 활용할까?
		System.out.println("검색할 이름을 입력하세요");
		String shname=in.nextLine();

		for(int i=0; i<Booklist.length; i++) {
			if(Booklist[i]!=null) {
				if(Booklist[i].name.contains(shname)) {
					Booklist[i].prt();
					System.out.println("----------");				
				}
			}
		}

		
		
	}
	
	

	
	
}
