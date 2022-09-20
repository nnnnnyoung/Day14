package Market;

import java.util.Scanner;

public class GoodsManager {
	
	Goods[] gList=new Goods[10];
	Scanner in=new Scanner(System.in);
	
	GoodsManager(){
		//물건을 관리하는 객체: 물건등록, 수정, 삭제, 물건 1개가를 관리
		for(;;) {
			menu();
			int selMenu=in.nextInt();
			in.nextLine();
			if(selMenu==1) {
				addGoods();
			}else if(selMenu==3) {
				listGoods();
			}else if(selMenu==2) {
				modGoods();
			}else if(selMenu==4) {
				delGoods();
			}else if(selMenu==5) {
				searchGoods();
			}
		}
	}

	private void searchGoods() {
		// TODO Auto-generated method stub
		//이름으로 검색한다. 단 이름은 유니크하다
		// 수준1. 이름이 완전히 일치하면->문자열 객체에서 어떤 메서드를 활용할까? equals
		//수준2. 검색이름이 실제 이름에 포함되면->문자열 객체에서 어떤 메서드를 활용할까? contain
		System.out.println("검색할 이름을 입력하세요");
		String shname=in.nextLine();
		boolean flag=true;
		for(int i=0; i<gList.length; i++) {
			if(gList[i]!=null) {
//				수준1. 이름이 유니크하고 일치하니 더이상 순회할 이유가 없다
				if(gList[i].name.equals(shname)) {
					gList[i].prt();
					System.out.println("----------");
					flag=false;		
					break;
				}//수준2. 이름이 포함되니 더 순회해야한다.
				if(gList[i].name.contains(shname)) {
					gList[i].prt();
					System.out.println("----------");
					flag=false;				
				}
				
			}
		}
		if(flag) {
			System.out.println("결과가 없습니다.");
		}
		
		
	}

	private void delGoods() {
		// TODO Auto-generated method stub
		System.out.println("<삭제> 이름을 입력하세요");
		String delName=in.nextLine();
		for(int i=0; i<gList.length; i++) {
			if(gList[i]!=null) {
				if(gList[i].name.equals(delName)) {
					gList[i]=null;
					System.out.println(delName+" 삭제완료!");
					break;
				}
			}
		}
	}

	private void addGoods() {
		// TODO Auto-generated method stub
		Goods newGoods= new Goods();
		System.out.println("이름 입력");
		String name=in.nextLine();
		System.out.println("아이디 입력");
		String id=in.nextLine();
		System.out.println("수량 입력");
		int cnt=in.nextInt();
		in.nextLine();
		System.out.println("가격 입력");
		int price=in.nextInt();
		in.nextLine();
		newGoods.setting(name, id, cnt, price);
		
		for(int i=0; i<gList.length; i++) {
			if(gList[i]==null) {
				gList[i]=newGoods;
				break;
			}
		}
	}

	
	private void listGoods() {
		boolean flag=true;
		for(int i=0; i<gList.length; i++) {
			if(gList[i]!=null) {
				System.out.println(i+"번 정보----");
				gList[i].prt();
				System.out.println("---------");
				flag=false;
			}

		}
		if(flag) {
			System.out.println("등록된 책이 없습니다.");
		}


		
	}


	public void menu() {
		System.out.println("1. 물건등록");
		System.out.println("2. 물건수정");
		System.out.println("3. 전체보기");
		System.out.println("4. 물건삭제");
		System.out.println("5. 물건검색");
		System.out.println(">>>><메뉴선택");

		
	}
	
	   private void modGoods() {
		      // 이름으로 수정하시오.. 이름으로 수정하는데 수량하고 가격만 수정이 가능하다.. 
		      System.out.println("<수정> 이름을 입력하세요");
		      String modName = in.nextLine();
		      boolean flag = true;
		      for(int i=0; i < gList.length; i++) {
		         if(gList[i]!=null) {
		            if(gList[i].name.equals(modName)) {
		               System.out.println("수량을 입력하세요");
		               int newInt = in.nextInt();
		               in.nextLine();
		               gList[i].cnt=newInt;
		               
		               System.out.println("가격을 입력하세요");
		               newInt = in.nextInt();
		               in.nextLine();
		               gList[i].price=newInt;
		               flag=false;
		               break;
		            }
		         }
		      }
		      if(flag) {
		         System.out.println("이름이 없습니다. ");
		      }
		      
		   }

}
