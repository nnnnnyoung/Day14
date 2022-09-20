package BookList;

import java.util.Scanner;


public class BookManager {
	
	
	Scanner in=new Scanner (System.in);
	Book [] Booklist=new Book[10];
	String [] badWord={"�ٺ�", "��û��", "�˰�", "������"};
	
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
		System.out.println("1. å ���");
		System.out.println("2. å ����");
		System.out.println("3. å ����");
		System.out.println("4. å ��Ϻ���");		
		System.out.println("5. å �˻��ϱ�");
		System.out.println("�ش�޴��� ���ڸ� �Է����ּ���");	
	}


	
	private void Bookmodi() {
		// TODO Auto-generated method stub
		// �̸����� ����
		System.out.println("<����> �̸��� �Է��ϼ���");
		String modName=in.nextLine();
		boolean flag=true;
		for(int i=0; i<Booklist.length; i++) {
			if(Booklist[i]!=null) {
				if(Booklist[i].name.equals(modName)) {
					System.out.println("������ �̸��� �Է��ϼ���");
					String newName=in.nextLine();
					Booklist[i].name=newName;
					flag=false;
					break;
				}
			}
		}
		if(flag) {
			System.out.println("�̸��� �����ϴ�.");
		}
		
	}
	
	private void BookDel() {
		System.out.println("������ å�� ������ȣ�� �Է��ϼ���");
		int no=in.nextInt();
		in.nextLine();
		for(int i=0; i<Booklist.length; i++){
			if(Booklist[i]!=null) {
				if(Booklist[i].no==(no)) {
					Booklist[i]=null;
					System.out.println("�����Ϸ�");
					break;
				}
			}
		}

	}


	private void BookList() {
		// TODO Auto-generated method stub
		for(int i=0; i<Booklist.length; i++) {
			if(Booklist[i]!=null) {
				System.out.println(i+"�� ����---");
				Booklist[i].prt();
			}
		}
	}


	private void BookInput() {
		// TODO Auto-generated method stub
		Book newbooks= new Book();
		System.out.println("å ������ȣ�� �Է��ϼ���");
		int no=in.nextInt();
		in.nextLine();
		System.out.println("å �̸��� �Է��ϼ���");
		
		String name=in.nextLine();
		for(int i=0; i<badWord.length; i++) {
			if(name.contains(badWord[i])) {
				System.out.println("�弳�� �Է��� �� �����ϴ�.");
				break;
			}
		}
		System.out.println("����⵵�� �Է��ϼ���");
		int year=in.nextInt();
		in.nextLine();
		System.out.println("���� �̸��� �Է��ϼ���");
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
		//�̸����� �˻��Ѵ�. �� �̸��� ����ũ�ϴ�
		// ����1. �̸��� ������ ��ġ�ϸ�->���ڿ� ��ü���� � �޼��带 Ȱ���ұ�?
		//����2. �˻��̸��� ���� �̸��� ���ԵǸ�->���ڿ� ��ü���� � �޼��带 Ȱ���ұ�?
		System.out.println("�˻��� �̸��� �Է��ϼ���");
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
