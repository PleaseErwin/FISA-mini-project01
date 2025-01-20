package park.view;

import java.util.Scanner;

import controller.parkController;

public class StartView {

	public static void main(String[] args) {
    
		Scanner scanner = new Scanner(System.in);
		String menuInput = "";
		
		whileLoop:
		while (true) {
			System.out.println("----------------------------------");
			System.out.println("1. 모든 공원 정보 검색");
			System.out.println("2. 공원 정보 개별 검색");
			System.out.println("3. 공원 정보 추가");
			System.out.println("4. 공원 정보 업데이트");
			System.out.println("5. 공원 정보 삭제");
			System.out.println("6. 종료");
			
			System.out.print("메뉴 선택 > ");
			menuInput = scanner.nextLine();
			
			switch(menuInput) {
			case "1":
				parkController.getParkInfo();
				break;
			
			case "2":
				String searchParkName = "";
				System.out.print("공원 검색어 입력 > ");
				searchParkName = scanner.nextLine();
				parkController.getParkInfo(searchParkName);
				break;
			
			case "3":
				String updateInfo;
				
				System.out.print("추가할 공원 정보를 연번/공원명/개원일/주요식물/오시는길/지역/전화번호/주요시설 순서대로 입력 (엔터로 구분) > ");
				updateInfo = scanner.nextLine();				
				parkController.addPark(updateInfo); 
				break;
				
			case "4":
				String updatePrincipalSpecies;
				String updateLocation;
				System.out.println("정보를 수정할 주요식물/지역 순서대로 입력 (엔터로 구분) > ");
				updatePrincipalSpecies = scanner.nextLine();
				updateLocation = scanner.nextLine();
				parkController.updatePark(updatePrincipalSpecies, updateLocation);
				break;
			
			case "5":
				String deleteParkName = "";
				System.out.print("삭제할 공원 이름 입력 > ");
				deleteParkName = scanner.nextLine();
				parkController.deletePark(deleteParkName);
				break;
			
			case "6":
				scanner.close();// 사용한 입력객체 닫기
				System.out.println("프로그램 종료");
				break whileLoop;
		
			default:
				System.out.println("잘못된 값을 입력하셨습니다. 다시 입력하세요.");
				break;
				
			}
		}
		
	}

}
