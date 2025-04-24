# nhn-academy-spring-boot-jpa

## 설정 파일 정리

- [application.yml](src/main/resources/application.yml)
    - 모든 환경에 공통으로 적용할 설정
- [application-prod.yml](src/main/resources/application-prod.yml)
    - 운영 환경에서 실행할 때 사용할 설정
- [application-dev.yml](src/main/resources/application-dev.yml)
    - 개발 환경에서 실행할 때 사용할 설정
- [application-local.yml](src/main/resources/application-local.yml)
    - 로컬 환경에서 실행할 때 사용할 설정
- [snippet-jpa-logging.yml](src/main/resources/snippet-jpa-logging.yml)
    - JPA 로깅 설정
    - JPA 로깅이 필요한 환경의 설정에 import 해서 사용한다.
- [snippet-mysql-prod.yml](src/main/resources/snippet-mysql-prod.yml)
    - 운영 환경의 MySQL 접속 정보
    - 이 설정은 application-prod.yml 에서만 사용할거라면 굳이 분리할 필요는 없다. 예시를 위해 분리하였다.
- [snippet-mysql-dev.yml](src/main/resources/snippet-mysql-dev.yml)
    - 개발 환경의 MySQL 접속 정보
    - 개발 환경과 로컬 환경에서 개발 환경 DB 에 붙어서 실행할 때 사용하기 위해 별로 파일로 분리했다.
- [snippet-mysql-local.yml](src/main/resources/snippet-mysql-local.yml)
    - 로컬 환경의 MySQL 접속 정보
    - 개발 진행하면서 스키마 변경하고 테스트 해봐야 할 때, 모두가 같이 사용하는 개발 환경이 아니라 로컬 DB 에 붙여서 개발하고 싶을 때 사용하면 좋다.
    - 개인마다 설정 값이 다를 것이기 때문에 .gitignore 에 추가해서 git 에 올라가지 않도록 하는 것이 좋다.

## 테스트 관련 설정

- [application-test.yml](src/test/resources/application-test.yml)
  - 테스트를 실행할 때 사용할 설정
  - DB 설정이나 외부 API 호출에 관련된 설정들을 외부 환경에 의존하지 않도록 테스트 전용 환경 설정이 필요하다.
  - 테스트에서는 DB 를 h2 를 사용하도록 하거나, testcontainer 를 사용하여야 한다.
  - 테스트에서는 외부 API 호출도 mock up 환경으로 호출하도록 해야한다. -> 난이도 있음
    - 참고 자료: https://www.baeldung.com/spring-boot-wiremock
- `@ActiveProfiles("test")`
  - `@SpringBootTest` 나 `@DataJpaTest` 와 같이 환경 설정을 로드해서 동작하는 테스트에서 application-test.yml 설정을 사용하도록 강제한다.
  - 예시 파일
    - [UserRepositoryTest.java](src/test/java/com/nhnacademy/springbootjpa/repository/UserRepositoryTest.java)
    - [ApplicationTests.java](src/test/java/com/nhnacademy/springbootjpa/ApplicationTests.java)
