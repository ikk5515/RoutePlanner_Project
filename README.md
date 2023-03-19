![이거완전명함같네](https://user-images.githubusercontent.com/97776614/213250845-57971d6f-ae72-4cf0-ba8b-e647611573ed.png)

<br>
<hr>
<h3 tesxt align="center">코드 리팩토링 진행중</h3>
<hr>
<br>
<h1>개요</h1>
<p>지속되던 코로나-19 바이러스로 인한 일상의 제약이 점차 완화되는 추세 속에서 이전에 영위하지 못하던 개개인의 여가생활을 지원하기 위해 개발하였다. 제약이 완화되면서 많은 사람들이 국내 여행 의사가 점차 증가된다고 분석되며 동시에 우리의 일상 속에는 인간이 직접 의사결정을 하는 부분들이 많이 줄어들었습니다. <br>
공공데이터를 이용한 자동화된 경로 추천 시스템을 통해 사용자들은 의사결정의 단계 없이 제공되는 경로를 지도 API를 통해 시각적으로 이용하며 나들이 준비 과정을 간소화 시킬 것입니다.</p>

<br>

# WBS (작업분할구조도)
![작업분할구조도](https://user-images.githubusercontent.com/97776614/213252254-3b99826e-b894-4042-9b8d-2bdfabae0a16.png)

<br>

# 아키텍처 (Architecture)
Tomcat서버를 기반으로 HTML을 이용한 마크업과 JAVA Spring Framework를 이용한 Web Back-End를 개발하였으며 네이버 지도 API를 사용했습니다.<br><br>
![최종아키1](https://user-images.githubusercontent.com/97776614/213255149-9e99c644-341c-490c-97b1-4e281074b378.png)


<br>

# 데이터 흐름도
데이터의 수집부터 처리까지의 과정과 요소들을 도식화 <br><br>
![데구도](https://user-images.githubusercontent.com/97776614/213256478-b6ab2946-a702-4eef-81e8-b0d36a10c6d2.JPG)

<br>

# Flow Chart (기능 흐름도)
시스템의 전체적인 흐름을 Flow Chart를 이용하여 표현하였으며 시스템 처리를 거쳐 사용자에게 도달하는 주요 기능의 흐름을 확인할 수 있습니다.<br><br>
![기능 흐름도 2logo2 png](https://user-images.githubusercontent.com/97776614/213254716-5bb88517-2e4f-4768-9560-1b42c8a58098.png)

<br>

# API Uilization
<h3>좌표 값 변환</h3>
NAVER Map API를 이용하여 Application을 등록해 네이버 지도를 연동하였습니다.<br>
Map API를 이용하여 장소 데이터를 시각화하기 위해서는 장소의 경도, 위도 값이 반드시 필요하여 API라이브러리 함수를 이용해 추출된 데이터의 경도, 위도 값을 반환합니다(searchAddressToCoodinate 함수). <br>
searchAddressToCoodinate콜백 함수는 전체적인 결과의 반환을 기다려주지 않는 비동기식으로 작동하는 함수로서 소스코드 내에서 값에 접근하기 위해 Javascript 함수인 setTimeout()를 이용하여 일정 시간 뒤에 함수를 실행시켜 임의로 실행 결과를 기다리도록 설정합니다.
<br><br>
<h3>path 생성</h3>
위 과정을 거쳐 추출된 경도, 위도 값을 갖는 배열들을 통해 Polyline을 생성하기 위해서는 중간 지점의 path값이 필요합니다. <br>
현재 경도, 위도 배열은 Javascript 소스코드 내에 존재하기 때문에 이를 path값을 생성해 주는 알고리즘이 포함된 Java Class 파일로 전달하기 위해서 Ajax(비동기식 데이터 교환 기법)를 이용합니다.

<br><br><br>

# 시연 예시
<h3>사용자에게 제공되는 설문조사 페이지</h3>
키워드를 산출하기 위한 과정 (총 3개의 질문)<br><br>

![아오오오오오오](https://user-images.githubusercontent.com/97776614/213258264-c9a83348-3f87-4b37-b256-12f34be13c63.JPG)

<br>

<h3>처리된 경로 제공 페이지</h3>
산출된 결과를 지도상의 경로로 사용자에게 시각화 (데이터의 순서를 Marker로 표현)<br><br>

![경로제고고고공](https://user-images.githubusercontent.com/97776614/213258837-7f8504bd-383e-4543-a6d5-40adbf4239e3.JPG)

<br>
<hr>
<br>

![이거완전명함같네](https://user-images.githubusercontent.com/97776614/213250845-57971d6f-ae72-4cf0-ba8b-e647611573ed.png)
