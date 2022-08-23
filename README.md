# hospital-api

### 개발 환경

- Kotlin
- Spring Boot 2.7.3
- JPA
- Querydsl
- Gradle
- H2 (http://localhost:8080/h2-console/)
---

방문 도메인은 환자 도메인(aggregate root)을 통해서 추가, 수정, 삭제를 진행 한다고 가정하고
해당 API는 구성하지 않았습니다.

### API 명세

1. 병원 생성


| Method | URL       |
|--------|-----------|
| POST   | /hospital |

body
```json
{
  "name": "jpumpkin병원",
  "institutionNumber": "01",
  "directorName": "jpumpkin"
}
```


2. 환자 생성



| Method | URL       |
|--------|-----------|
| POST   | /patients |

body
```json
{
  "name": "박정호",
  "genderCode": "M",
  "dateOfBirth": "220824",
  "mobileNumber": "010-0000-0000",
  "hospitalId": 1
}
```


3. 환자 수정



| Method | URL             |
|--------|-----------------|
| POST   | /patients/{id}  |

body
```json
{
  "name": "박정호",
  "genderCode": "M",
  "dateOfBirth": "220824",
  "mobileNumber": "010-0000-0000"
}
```

4. 환자 ID를 통해 조회



| Method | URL             |
|--------|-----------------|
| GET    | /patients/{id}  |

response
```json
{
  "id": 1,
  "createdAt": "2022-08-24T01:27:35.676277",
  "name": "박정호",
  "registerNumber": "1_220824_박정호",
  "genderCode": "M",
  "dateOfBirth": "220824",
  "mobileNumber": "010-0000-0000",
  "hospitalId": 1,
  "visitList": [
    {
      "createdAt": "2022-08-24T02:20:41.926424",
      "statusCode": "방문중"
    }
  ]
}
```

5. 환자 목록 조회



| Method | URL        |
|--------|------------|
| GET    | /patients  |

params
```json
{
  "name": "박정호",
  "registerNumber": "1_220824_박정호",
  "dateOfBirth": "220824",
  "size": 30,
  "page": 0
}
```
- name, registerNumber, dateOfBirth (nullable) -> 동적 검색을 위한 param으로 필요하지 않을 시 안보내면 됩니다.
- size(페이지 사이즈), page(페이지 번호 0부터 시작) -> 페이징을 위한 param

response (Spring에서 제공하는 pageable 사용)
```json
{
  "content": [
    {
      "name": "박정호",
      "registerNumber": "1_931214_박정호",
      "genderCode": "M",
      "dateOfBirth": "931214",
      "mobileNumber": "010-2383-7361",
      "lastVisitDate": "2022-08-24T02:20:41.926424"
    }
  ],
  "pageable": {
    "sort": {
      "sorted": false,
      "empty": true,
      "unsorted": true
    },
    "pageSize": 30,
    "pageNumber": 0,
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "last": true,
  "totalElements": 1,
  "totalPages": 1,
  "numberOfElements": 1,
  "first": true,
  "sort": {
    "sorted": false,
    "empty": true,
    "unsorted": true
  },
  "number": 0,
  "size": 30,
  "empty": false
}
```

6. 환자 방문



| Method | URL                  |
|--------|----------------------|
| POST   | /patients/{id}/visit |

body
```json
{
  "statusCode": "방문중"
}
```