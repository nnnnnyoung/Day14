package BookList;

import java.util.Scanner;

public class Book {
	Scanner in=new Scanner(System.in);
	
	int no;
	String name;
	int year;
	String writer;
	
	public void book(int no, String name, int year, String writer) {
		this.no=no;
		this.name=name;
		this.year=year;
		this.writer=writer;
	}
	
	public void prt() {
		System.out.println("������ȣ"+this.no);
		System.out.println("å �̸�"+this.name);
		System.out.println("����"+this.year);
		System.out.println("�ۼ���"+this.writer);
	}
	

	
	
}
