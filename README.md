# 🛤 *Parkpal*
**반가워요!🙋‍♀️ 당신의 즐거운 산책 메이트 *Parkpal*이에요🍀🍃**
<br/>
<br/>

## 🤸‍♀️Contributor

| ![박지혜](https://avatars.githubusercontent.com/u/153366521?v=4) | ![박진현](https://avatars.githubusercontent.com/u/193213283?s=400&u=a2ff434fa5c27a5567884503751aafc69e9167fe&v=4) | ![서소원](https://avatars.githubusercontent.com/u/79669001?v=4)| ![석혜진](https://avatars.githubusercontent.com/u/127267532?v=4) |
|:--------------------:|:--------------------:|:--------------------:|:--------------------:|
| [박지혜](https://github.com/parkjhhh) | [박진현](https://github.com/jinhyunpark929) | [서소원](https://github.com/PleaseErwin) | [석혜진](https://github.com/HyeJinSeok) |
<br/>

## 📢Project Overview
JDBC와 MySQL을 활용하여 서울시 공원 정보를 효율적으로 검색할 수 있는 데이터베이스 시스템을 구현했습니다.  
사용자들이 손쉽게 원하는 공원 정보를 찾을 수 있도록 **특정 키워드를 활용한 공원 이름 검색 기능**을 제공합니다.
<br/>
<br/>

## 📑Reference

+ **서울시 주요 공원현황** <https://data.seoul.go.kr/dataList/OA-394/S/1/datasetView.do>
  
  + 2023년 11월 서울특별시시의회의 자료 기준, 총 **2,959개**의 공원이 존재
  + 이 중 서울시 직영 공원과 자치구별 주요 공원 총 **130개**를 선정한 **서울열린데이터 광장**의 **'서울시 주요 공원현황'** 을 선정
  + 전처리 과정 중 주요 식물 관련 정보가 존재하지 않는 공원 데이터를 삭제하여 총 **88개의 공원 데이터 활용**	
<br/>

## 🗂Project Structure

```
📦 Parkpal
├─ src
│  ├─ Controller
│  │  └─ parkController
│  ├─ Park.Model
│  │  └─ parkModelDAO
│  ├─ Park.Model.DTO
│  │  └─ parkModelDTO
│  ├─ Park.Model.Util
│  │  └─ parkDbutil
│  └─ Park.View
│     ├─ parkStartview
│     └─ parkEndview
└─ README.md
```
<br/>

## 🛠Skill Stack

<div>
<img src="https://img.shields.io/badge/java-FF0000?style=for-the-badge&logo=java&logoColor=white">
<img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
<img src="https://img.shields.io/badge/linux-FCC624?style=for-the-badge&logo=linux&logoColor=black">
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
<img src="https://img.shields.io/badge/dbeaver-382923?style=for-the-badge&logo=dbeaver&logoColor=white">
</div>
<br/>
<br/>


## 🔍Main Features

![Parkpal_MainFeature_Final](https://github.com/user-attachments/assets/c0c769da-13db-484f-be10-92b9babe9fd6)

---

**1. 전체 공원 정보 검색**  
```c
public static void getparkInfo() {
		try {
			EndView.parkView(ParkDAO.getAllparkInfo());
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("모든 공원 정보 검색 오류");
		}
	}
```
<details>
<summary>Result</summary>
    
![Parkpal1](https://github.com/user-attachments/assets/1993c690-0dab-4537-b075-ab4cff87c833)  
</details>
<br/>

**2. 특정 키워드가 포함된 공원 검색**  
```c
public static void getparkInfo(String keyword) {
		try {
			EndView.allParkView(ParkDAO.getparkInfo(keyword));
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("공원 정보 검색 오류");
		}
	}
```
<details>
<summary>Result</summary>
    
![Parkpal2](https://github.com/user-attachments/assets/ab1bce79-395a-452c-86d1-6ba95891eaf1)
</details>
<br/>

**3. 리스트 내 신규 공원 추가**  
```c
public static boolean addPark(int num, String parkName, String openingDate, String principalSpecies,
			String directions, String location, String officeNumber, String keyFacilities) {
		boolean result = false;

		try {
			result = ParkDAO.addParkInfo(num, parkName, openingDate, principalSpecies, directions, location, officeNumber, keyFacilities);
			System.out.println("추가 완료");
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("공원 정보 추가 오류");
		}
		return result;
	}
```
<details>
<summary>Result</summary>
    
![Parkpal3_1](https://github.com/user-attachments/assets/917d2889-ab63-412a-b101-99a1c6b614da)

**정상적으로 추가 완료**
![Parkpal3_2](https://github.com/user-attachments/assets/a8812e8b-e662-4668-a734-75cbf8338860)
</details>
<br/>

**4. 특정 지역의 주요 식물 분포 변경**
```c
public static boolean updatePark(String principalSpecies, String location) {
		boolean result = false;
		try {
			result = ParkDAO.updateParkinfo(principalSpecies, location);
			System.out.println("업데이트 완료");
		} catch (SQLException s) {
			s.printStackTrace();
			EndView.showError("공원 정보 수정 오류");
		}
		return result;
	}
```
<details>
<summary>Result</summary>
    
![Parkpal4](https://github.com/user-attachments/assets/7c0a1482-d8b4-40a3-b063-68db760405a7)
</details>
<br/>
  
**5. 공원명 내 특정 키워드를 포함한 공원 정보 삭제**
```c
public static boolean deletePark(String parkName) {
		boolean result = false;
		try {
			result = ParkDAO.deleteParkInfo(parkName);
			System.out.println("삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
			EndView.showError("공원 정보 삭제 오류");

		}
		return result;
	}
}
```
<details>
<summary>Result</summary>
    
![Parkpal5_1](https://github.com/user-attachments/assets/f22f0b42-dfb3-44a7-a24d-f13af3af6e26)

**정상적으로 삭제 완료**
![Parkpal5_2](https://github.com/user-attachments/assets/bdd2bc4e-33ca-4158-a9a5-440092d1c68c)
</details>
<br/>

## 🚩Troubleshooting
<br/>

### Issue 1. CSV 형식 데이터의 DBeaver 테이블 변환 실패

```
error code: Can't init data transfer, Can't create or update target table
```
#### Solution : CSV 파일 스키마의 불필요한 공백 제거로 DBeaver 테이블 변환 성공
<br/>

---
<br/>

### Issue 2. 데이터베이스 연결 중 Connection reset 예외 발생

```
java.sql.SQLRecoverableException: IO 오류: Connection reset, connect lapse 1 ms., Authentication lapse 0 ms.
    at oracle.jdbc.driver.T4CConnection.logon(T4CConnection.java:794)
    at oracle.jdbc.driver.PhysicalConnection.connect(PhysicalConnection.java:688)
    at oracle.jdbc.driver.T4CDriverExtension.getConnection(T4CDriverExtension.java:39)
```

 #### Solution : db 이관으로 인한 db 설정 정보 변경

<img width="365" alt="cap1" src="https://github.com/user-attachments/assets/c9d1ac36-d4f8-47a1-bd80-d1d1e41942cb" />

<br/>

---
<br/>

### Issue 3. 코드와 DB 간의 연결 오류 발생 원인을 위한 콘솔 출력문 입력

```
# DBUtil.java

    static {
        try {
            // dbinfo.properties 파일 로드
            p.load(new FileInputStream("dbinfo.properties"));
            System.out.println("dbinfo.properties 파일 로드 완료");

            // 파일 내용을 출력하여 확인
            System.out.println("jdbc.driver: " + p.getProperty("jdbc.driver"));
            System.out.println("jdbc.url: " + p.getProperty("jdbc.url"));
            System.out.println("jdbc.username: " + p.getProperty("jdbc.username"));
            System.out.println("jdbc.password: " + p.getProperty("jdbc.password"));

            // JDBC 드라이버 로드
            Class.forName(p.getProperty("jdbc.driverClassName"));
            System.out.println("JDBC 드라이버가 정상적으로 로드되었습니다.");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 실패: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("DB 설정 파일 로드 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
```

```
# 발생한 오류
System.out.println("DB 설정 파일 로드 중 오류 발생: " + e.getMessage());
```


#### Solution : JDBC 드라이버가 정상적으로 로드되지 않으므로, Class.forName(p.getProperty("jdbc.driverClassName")); 대신 Class.forName(p.getProperty("jdbc.driver"));로 수정함


```
# dbinfo.properties

jdbc.driverClassName=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://127.0.0.1:3306/fisa
jdbc.username=user01
jdbc.password=user01

# 추가된 부분 
jdbc.driver=com.mysql.cj.jdbc.Driver
```

<br/>

---

<br/>

### Issue 4. 로컬 파일을 브랜치에 푸시한 후, main과 병합하고 main을 풀(pull)하는 과정에서 오류 발생

![cap2](https://github.com/user-attachments/assets/d27c8779-8090-437a-bfb9-c81c4fd1e628)

#### Solution : 충돌 파일들을 수동으로 수정하여 강제로 병합함

```
git add src/controller/Controller.java
git add src/park/view/StartView.java
```

<br/>

 ---

<br/>

### Issue 5. MySQL과의 연결 문제로 Communication link failure 오류 발생

![cap3](https://github.com/user-attachments/assets/aacb6750-13a2-412b-8d85-b1a71699271f)

#### Solution : Oracle VirtualBox 서버 실행 및 MobaXterm 로그인을 통해 mysql에 접속함


![cap4](https://github.com/user-attachments/assets/029b1b3e-051d-4423-bb6c-9d49ff3356fa)

<br/>

## ✒Retrospective

* 박지혜 : 내용을 완전히 이해했다고 생각하기 전에 프로젝트를 시작한 거라서 처음에는 막막했지만, 코드를 하나하나 작성해 나가고 수업 시간에 배운 내용들을 되짚어보면서 프로그램을 만들어 나가다 보니 자연스럽게 몰랐던 내용이 이해되었다. 프로젝트를 하면서 생각처럼 코드가 돌아가지 않아 속상하기도 하고, 계속 예상치 못했던 오류가 발생하여 마음이 급해지기도 했지만, 차근차근 트러블 슈팅을 해가면서 새로운 내용을 많이 배운 것 같다. 나중에는 완성도가 높아져 가면서 새로운 기능을 추가하고 싶다는 생각이 들기도 했다. 조금 아쉬웠던 점은 자바 문법에 대한 이해와 공부가 부족했다는 점이었다. 다음 프로젝트를 할 때는 자바 문법에 대해 더 많이 공부하여 추가 기능을 만들어 깔끔하고 완성도 높은 프로그램을 완성 시키고 싶다.


* 박진현 : 난생처음 코드를 작성해 봤다. 생성자가 무엇인지 몰라 눈물을 흘렸던 이 주 전을 생각하면 이제 코드의 흐름을 이해할 수 있고, JDBC의 기능을 이해하기 시작했다는 점에서 의미가 있는 프로젝트였다. 하지만 여전히 Java 문법이 어색하기 때문에 좀 더 깊이 공부하려고 한다. 또한 GitHub 내 READ ME를 작성하며 실무자가 글을 읽었을 때 채용하고 싶다는 생각이 드는 글을 써야겠다고 생각하며, 다음에 계속해서 수정해야 할 것 같다.


* 서소원 : MVC 패턴을 구현하는 건 처음이라 구조가 헷갈렸는데, 역시 클래스별 메소드 호출을 따라가며  반복해서 읽고 직접 부딪혀보는 것이 이해하는 데 제일 효과적이었다. 팀원들과 프로젝트를 진행할 때 브랜치도 생성하고 PR도 하면서 git에 훨씬 능숙해진 것 같다. 또한 자바와 mysql, JDBC를 같이 사용하면서 다양한 오류 메시지를 마주했는데 이 오류가 어디서 발생했는지 찾아내며 트러블 슈팅에 대한 안목을 기를 수 있었다.


* 석혜진 : 데이터베이스와 애플리케이션을 설치하고 연결하는 작업을 통해, 서버와의 네트워크 통신 및 데이터 전송과 관련된 기술적인 부분을 학습할 수 있었다. 주제 선정부터 최종 기록까지 팀원들과 역할을 나누어 프로젝트를 진행하면서, Java와 Git Bash 활용에 있어 부족한 부분을 배우고 보완할 수 있었다. 팀 프로젝트의 전반적인 흐름을 통찰할 수 있는 역량을 더 키워야겠다는 다짐이 들었다.
<br/>

## 📌Git Commit Rules
* feat	: 새로운 기능에 대한 커밋
* fix	: 버그 수정에 대한 커밋
* build : 빌드 관련 파일 수정에 대한 커밋
* docs	: 문서 수정에 대한 커밋
* perf	: 성능 개선에 대한 커밋
