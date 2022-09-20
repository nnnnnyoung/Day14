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
		System.out.println("고유번호"+this.no);
		System.out.println("책 이름"+this.name);
		System.out.println("연도"+this.year);
		System.out.println("작성자"+this.writer);
	}
	

	
	
}
