# Legend Of Delivery

이 프로젝트는 배달 주문 사이트를 개발하는 프로젝트입니다.
</br>
사용자들이 가게를 선택해 주문을 완료하고, 주문 후 리뷰를 남길 수 있는 기능을 포함합니다.

## 👥 Team

<details>
<summary>팀장 : 함승완</summary>
<div markdown="1">
<br>
    
- 관리자(가게) 페이지
</div>
</details>

<details>
<summary>팀원 : 김지수</summary>
<div markdown="1">
<br>
    
- 리뷰 CRUD
</div>
</details>

<details>
<summary>팀원 : 유균한</summary>
<div markdown="1">
<br>  
    
- 사용자 인증, 프로필 관리
</div>
</details>

<details>
<summary>팀원 : 정효진</summary>
<div markdown="1">
<br>
    
- 좋아요, 찜 기능
</div>
</details>

<details>
<summary>팀원 : 최연한</summary>
<div markdown="1">
<br>    
    
- 주문 CRUD
</div>
</details>

## 🛠️ Tech Stack
- 언어 : Java 17
- 프레임워크 : Spring Boot 3.3.0
- 데이터베이스 : MySQL 8.0.28
- Spring Security
- JWT
- JPA
- GitHub

## 🔖 Features
- 사용자 인증
  - Spring Security와 JWT를 사용하여 인증,인가 필터를 구현합니다.
  - Access Token, Refresh Token을 구현합니다.
  - Access Token 만료 시, 유효한 Refresh Token을 통해 새로운 Token을 발급합니다.
  - Refresh Token 만료 시, 재로그인을 통해 새로운 Token을 발급합니다.
  - 조건에 맞는 username, password를 사용해 회원을 생성합니다.
  - 회원의 username, password를 사용해 로그인할 수 있습니다.
  - 현재 로그인되어 있는 사용자의 계정을 로그아웃할 수 있습니다.
  - 현재 로그인되어 있는 사용자의 계정의 상태를 LEAVE로 바꿔 회원 탈퇴 기능을 구현합니다.
- 프로필 관리
  - 프로필의 이름, 이메일을 수정할 수 있습니다.
  - 비밀번호를 수정할 수 있습니다. 단, 최근 사용한 3개의 비밀번호와는 다르게 설정해야 합니다.
- 가게 CRUD
  - 모든 가게를 조회할 수 있습니다. 
  - 밑의 기능들은 ADIMN 권한을 가진 사용자만 사용할 수 있습니다.
  - 가게를 생성, 수정, 삭제할 수 있습니다.
  - 현재 가게의 상태를 오픈, 마감으로 변경할 수 있습니다.
- 주문 CRUD
  - 주문을 생성, 수정, 삭제할 수 있습니다.
  - 주문 상태를 ACCEPTANCE, COMPLETE로 변경할 수 있습니다.
  - 로그인한 사용자가 주문한 모든 목록을 조회할 수 있습니다. 
- 리뷰 CRUD
  - 주문을 한 이력이 있는 가게의 리뷰를 생성, 수정, 삭제할 수 있습니다.
  - 로그인한 사용자가 작성한 모든 리뷰 목록을 조회할 수 있습니다.
  - 로그인한 사용자가 작성한 모든 리뷰 목록 중 특정 가게에 대한 리뷰만을 조회할 수 있습니다. 
- 좋아요
  - 다른 사용자가 작성한 리뷰에 좋아요를 등록할 수 있습니다.
  - 리뷰에 등록한 좋아요를 취소할 수 있습니다.
- 찜
  - 가게를 찜할 수 있습니다.
  - 찜한 가게를 취소할 수 있습니다.
  - 로그인한 사용자가 찜한 모든 가게 목록을 조회할 수 있습니다.

## 📕 기획 명세서
<details>
<summary>ERD Diagram</summary>
<div markdown="1">
<br>
    
![image](https://github.com/ryurbsgks5114/LegendOfDelivery/assets/64136923/f367c2c0-7999-4b3e-8e32-b6f4f893c0fe)
</div>
</details>

<details>
<summary>API 명세서</summary>
<div markdown="1">
<br>
사용자 인증 기능
    
![사용자인증](https://github.com/ryurbsgks5114/LegendOfDelivery/assets/64136923/8246c969-1758-46df-953d-21166923e7ec)
<br>
프로필 관리 기능

![프로필](https://github.com/ryurbsgks5114/LegendOfDelivery/assets/64136923/521b2a1a-6a2f-42d3-988c-3c064a4d471f)
<br>
주문 기능

![주문](https://github.com/ryurbsgks5114/LegendOfDelivery/assets/64136923/b14e5662-2977-4e2e-8902-1c2253c28683)
<br>
리뷰 기능

![리뷰](https://github.com/ryurbsgks5114/LegendOfDelivery/assets/64136923/cd611358-a8e3-4bd2-8b33-7c6f8ae512dd)
<br>
좋아요 & 찜 기능

![좋아요찜](https://github.com/ryurbsgks5114/LegendOfDelivery/assets/64136923/fb47fc47-f943-46bd-9efb-735b6962f840)
<br>
관리자(가게) 기능

![관리자1](https://github.com/ryurbsgks5114/LegendOfDelivery/assets/64136923/8640108a-73fc-4e28-adc2-cd7d3856c960)
![관리자2](https://github.com/ryurbsgks5114/LegendOfDelivery/assets/64136923/671d7298-8ae2-473f-865d-588c36ba030e)
![관리자3](https://github.com/ryurbsgks5114/LegendOfDelivery/assets/64136923/6635ad4b-62c5-4dd0-b3b9-c7372ecebb81)

</div>
</details>

## 🐱 Rules

<details>
<summary>Code Convention</summary>
<div markdown="1">

#### 1️⃣ 도메인형 패키지 구조
이번 프로젝트의 패키지 구조는 도메인형 패키지 구조를 사용합니다.
도메인형 구조는 패키지를 도메인으로 구분하는 방식입니다.
이 구조는 각 도메인이 자신의 책임을 명확히 하고 독립적으로 관리될 수 있도록 돕습니다.
(추가로 이러한 도메인형 패키지 구조 방식은 MSA(마이크로서비스 아키텍처) 방식에 적합한 설계 방식으로 MSA 방식이 궁금하시다면 검색해서 간단하게 확인하거나 스탠다드 실습반 05. MSA와 API 통신 강의를 확인해주세요!)
<br>
##### 도메인형 패키지 구조의 주요 특징
1. domain 패키지
  각 도메인은 domain 패키지 아래에 독립적인 패키지로 구성됩니다.
  예를 들어, domain 패키지는 user, post, comment 등과 같은 패키지로 구성됩니다.
2. domain 패키지 계층 구조
  domain 패키지 내부의 패키지는 필요에 따라 계층형 구조로 나눌 수 있습니다.
  예를 들어, domain.user 패키지는 controller, service, repository, dto, entity 등과 같은 패키지로 구성됩니다.
3. global 패키지
  프로젝트 전반에서 공통으로 사용되는 기능이나 설정 등을 담당하는 패키지입니다.
  예를 들어, global 패키지는 jwt, security, exception, config 등과 같은 패키지로 구성됩니다.
##### 도메인형 패키지 구조 예시
```
src/
├── domain/
│   ├── user/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── dto/
│   │   ├── entity/
│   ├── post/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── dto/
│   │   ├── entity/
├── global/
│   ├── jwt/
│   ├── security/
│   ├── config/
│   ├── exception/
```
#### 2️⃣ 프로젝트 네이밍 컨벤션
- **변수 및 함수 명명 규칙**:
    - **Camel Case**를 사용: 모든 변수와 함수 이름은 소문자로 시작하고, 이후 단어의 첫 글자는 대문자로 작성합니다.
        - 예: `createBoard`, `userName`, `orderDetails`
    - 함수 이름은 **동사+명사** 형태로 작성하여 기능을 명확히 표현합니다.
        - 예: `createUser`, `getOrderDetails`, `updateBoard`
- **데이터베이스 컬럼명**:
    - **Snake Case**를 사용: 모든 컬럼명은 소문자로 작성하고, 단어는 밑줄(`_`)로 구분합니다.
        - 예: `user_id`, `created_at`, `order_total`
- **DTO (Data Transfer Object)**:
    - **Camel Case**를 사용하고, 명확히 역할을 드러내는 이름을 사용합니다.
        - 예: `UserRequestDto`, `OrderResponseDto`, `ProductUpdateDto`
- **엔티티 클래스 명명**:
    - **Pascal Case**를 사용: 모든 클래스 이름은 각 단어의 첫 글자가 대문자인 형태로 작성합니다.
        - 예: `User`, `Order`, `Product`
    - 엔티티 클래스에는 주로 데이터베이스 테이블과 매핑되는 데이터를 포함합니다.
- **기능 및 엔티티 이름 규칙**:
    - 함수 이름에는 기능 후에 엔티티 이름을 붙여서 작성합니다.
        - 예: `createUser`, `updateOrder`, `deleteProduct`
- **기타 규칙**:
    - **상수**: 상수는 모두 대문자로 작성하고, 단어는 밑줄(`_`)로 구분합니다.
        - 예: `MAX_USERS`, `DEFAULT_TIMEOUT`
    - **주석**: 필요한 경우 명확하고 간결하게 작성합니다. 중요한 로직이나 복잡한 부분에 대한 설명을 추가합니다.
        - 예: `// 사용자 정보를 생성하는 함수`

#### 3️⃣ 환경 변수 설정
환경 변수를 설정하는 이유는 프로젝트에서 데이터베이스 비밀번호, API key, JWT Secret key와 같은 민감한 정보를 노출하지 않기 위해서입니다.

환경 변수를 설정하는 방법은 application-secrets.properties, Intellij 환경 변수 설정, dotenv 라이브러리 & .env 파일 등 여러 가지가 있습니다.

이번 프로젝트에서는 application-secrets.properties를 이용해서 환경 변수를 설정합니다.
그 이유는 다음과 같습니다.

현재 프로젝트 과정에서는 Intellij 환경 변수 설정으로도 충분히 가능하지만, 나중에 AWS EC2 배포와 같은 상황에서는 Intellij를 사용할 수 없어서 미리 연습 겸 application-secrets.properties를 사용합니다.

build.gradle 파일에 dotenv 라이브러리 의존성을 추가하고 .env 파일을 만들어서 환경 변수를 설정할 수도 있지만, 동일하게 환경 변수 파일을 만들어서 관리해야 한다면 Spring Boot 2.4 이후 버전부터 `spring.config.import`를 사용하여 다른 파일을 가져올 수 있는 점을 활용하여 application-secrets.properties 파일을 이용해서 환경 변수를 관리하는 것이 더 낫다고 판단하였습니다.

##### 설정 과정

1. Git 추적 제외
    
    Git 추적을 제외하기 위해서 `.gitignore` 파일에 `application-secrets.properties` 파일을 등록합니다.
    
    ```java
    application-secrets.properties
    ```
    
2. 파일 생성
    
    `resources` 디렉토리 아래에 `application-secrets.properties` 파일을 만듭니다.
    
3. key-value 저장
    
    application-secrets.properties 파일에 key=value 형태로 저장합니다.
    
    ```java
    DB_URL=jdbc:mysql://localhost:3306/yourDatabase
    DB_USERNAME=yourUserName
    DB_PASSWORD=yourPassword
    ```
    
4. application.properties 설정
    
    application.properties 파일에서 application-secrets.properties를 가져오도록 설정합니다.
    
    ```java
    spring.config.import=optional:classpath:application-secrets.properties
    ```
    
5. 환경 변수 사용
    
    이제 application.properties에서 환경 변수를 사용합니다.
    
    ```java
    spring.config.import=optional:classpath:application-secrets.properties
    
    spring.datasource.url=${DB_URL}
    spring.datasource.username=${DB_USERNAME}
    spring.datasource.password=${DB_PASSWORD}
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    ```
    
6. 팀원과 공유
    
    application-secrets.properties 파일이 **업데이트**되면 해당 내용을 **Slack**을 통해 팀원들과 공유합니다.
    
</div>
</details>

<details>
<summary>Github Rules</summary>
<div markdown="1">

#### 1️⃣ commit 규칙

|작업 타입| 작업 내용  |
|-------|--------|
|setting|환경 설정|
| add|새로운 파일 추가|
|update|새로운 기능 추가|
|fix|코드 수정|
|refactor|코드 리팩토링|
|del|기능/파일 삭제|

#### 2️⃣ PR 규칙

- Git Fork
- Git Issues 단위로 PR
- PR전에 팀 슬랙 에다가 PR 하겠다 전달.
- PR하기 전 본인이 만든 기능 모두 테스트하고 PR

#### 3️⃣ 코드 리뷰 규칙
‘PR’ 후 ‘merge’ 전에 코드 리뷰를 받고 ‘merge’를 진행합니다.

코드 리뷰 요청은 젭 자리의 시계방향으로 요청합니다.

ex) 승완님 → 연환님 → 균한님 → 효진님 → 지수님 → 승완님 

만약, 코드 리뷰어가  코드 리뷰를 진행하기 어려운 상황이라면, 다음 사람 또는 다른 팀원에게 코드 리뷰를 부탁하거나, 코드 작성자에게 코드 설명을 부탁합니다.

#### 4️⃣ git Issues, Project
##### Issues

‘Issues’는 프로젝트에서 발생하는 모든 것을 추적하고 관리하는 데 사용됩니다.(버그 보고서, 기능 요청, 작업 항목 등)

이번 프로젝트에서는 작업 항목(Task card)이 주 목적이며, 버그 발생 시 ‘Bug Report’ 정도만 작성 예정입니다.

‘Issues’의 ‘Task card’ 단위는 기능 구현을 맡은 본인이 정해서 작성합니다.

‘Task card’는 기능별로 작성하며 해당 기능을 구현하기 위한 세부 내용은 ‘Task card’ 내부에 작성합니다.(이러한 작업은 기능 구현을 위해 어떤 작업을 해야 할지 글로 작성하고 코드를 작성하는 연습을 도와줍니다. 그리고 한 번에 완벽하게 작성할 필요는 없습니다. 큰 틀만 작성하고, 기능 구현을 하면서 추가되는 부분이 있다면 나중에 ‘Task card’에 추가해도 됩니다.)

ex) [Task] 회원가입 기능 구현

- [ ]  회원가입에 필요한 패키지 및 클래스 작성(dto, entity, controller, service, repository)
- [ ]  request dto 유효성 검사
- [ ]  회원가입 유효성 검사(중복 아이디, 탈퇴한 아이디 등)
- [ ]  비밀번호 암호화

##### Milestones

‘Milestones’은 프로젝트의 단계나 목표를 설정할 때 사용됩니다.

보통 마감일을 설정하여 특정한 작업이나 기능 개발 등을 완료하는 것을 목표로 합니다.

‘Milestones’은 ‘Issues’와 결합하여 해당 마일스톤에 관련된 작업을 추적하고 진척 상황을 확인할 수 있습니다.

‘Milestones’ 작성은 마감일을 생각하면서 주제를 묶어서 작성해주세요.(마감일보다 기능 구현 완료가 오래 걸릴 수 있습니다. 마감일은 생각했던 것보다 조금 더 길게 잡으세요.)

ex) 회원가입 및 로그인 기능 구현

ex) JWT 기능 구현

ex) Spring Security 적용

##### Projects

‘Projects’는 ‘Issues’와 ‘Milestones’을 조직화하고 시각화하는 데 사용됩니다.

이번 프로젝트에서는 칸반 보드 형식으로 ‘Projects’를 만들어서 진행할 예정입니다.
</div>
</details>
