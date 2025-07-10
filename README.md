# 계산기 프로그램
| 차수    | 세부 사항 | 날짜       |
|-------|--|----------|
| 1차 완성 |  | 25/07/10 |
---
1. AppConfig - 모든 객체를 싱글톤 객체로 처리, DI, IOC
2. AppRunner - 실행
3. Dispatcher - Controller를 조회해서 실행 및 반복과 예외 처리
4. Handler - 현재 상태 값을 통한 Controller 반환
5. Controller - 각 작업의 단계를 실행
6. Dispatcher - 다음 작업 실행

---
### 프로그램 구동 사진
1. 메인 메뉴
![메인 메뉴](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdna%2FbTWgU3%2FbtsPetR3srx%2FAAAAAAAAAAAAAAAAAAAAADgBbD_z-0j0EHuTJTu5wtJv4ZFITvJCbw5589gLt1m6%2Fimg.png%3Fcredential%3DyqXZFxpELC7KVnFOS48ylbz2pIh7yKj8%26expires%3D1753973999%26allow_ip%3D%26allow_referer%3D%26signature%3DtLNapJYv4uqtfZ2VOSzTuAT164o%253D)
2. 계산기 메뉴
![계산기 메뉴](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdna%2Fdx7kjk%2FbtsPde2FVZd%2FAAAAAAAAAAAAAAAAAAAAAD3H6En2A8IjUnO131PLzzNBj8j-gYA0zvfpTmeL4iSb%2Fimg.png%3Fcredential%3DyqXZFxpELC7KVnFOS48ylbz2pIh7yKj8%26expires%3D1753973999%26allow_ip%3D%26allow_referer%3D%26signature%3DSoy7aJYgBYLM7HvMS0zjCnnKhUU%253D)
3. 사칙연산 진행
![사칙연산 진행](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdna%2Fcjv9ec%2FbtsPd7IsUFs%2FAAAAAAAAAAAAAAAAAAAAAIOPeEf0c-wTTUW3lVFIzTJ4IjarufN_c53kUjjMDCCk%2Fimg.png%3Fcredential%3DyqXZFxpELC7KVnFOS48ylbz2pIh7yKj8%26expires%3D1753973999%26allow_ip%3D%26allow_referer%3D%26signature%3Dy4pJ%252BDJAj%252F2yyAw7W0fYQTnRVEw%253D)
4. 원 넓이 연산 진행
![원 넓이 연산 진행](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdna%2FbfbgLT%2FbtsPc6Rnprz%2FAAAAAAAAAAAAAAAAAAAAALObqeKy6_jprn2eCeb78JOwJvRAj84O4Ynp_RESC4rm%2Fimg.png%3Fcredential%3DyqXZFxpELC7KVnFOS48ylbz2pIh7yKj8%26expires%3D1753973999%26allow_ip%3D%26allow_referer%3D%26signature%3DQ0hBTSTw7OIERrXEQuH1plGH02Y%253D)
5. 연산 추가 메뉴
![연산 추가 메뉴](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdna%2Fv8Nk9%2FbtsPc6RnhSn%2FAAAAAAAAAAAAAAAAAAAAAGkkFD76njX4TcYh-6YsyYbHpDoaR5Yxtj8wmyxk4hkZ%2Fimg.png%3Fcredential%3DyqXZFxpELC7KVnFOS48ylbz2pIh7yKj8%26expires%3D1753973999%26allow_ip%3D%26allow_referer%3D%26signature%3DZMCTolGMOoxJDmLOq22Q0fgvKZY%253D)
6. 로그 메뉴
![로그 메뉴](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdna%2FyCsEy%2FbtsPeBifM1o%2FAAAAAAAAAAAAAAAAAAAAAN3jMQc2s-hCzSEiiWl56IdlvC8X9tO9LLMr3FSqKxEU%2Fimg.png%3Fcredential%3DyqXZFxpELC7KVnFOS48ylbz2pIh7yKj8%26expires%3D1753973999%26allow_ip%3D%26allow_referer%3D%26signature%3DK9yAsGHujZ%252FBpXPMKJ9k%252FEDIJuQ%253D)
7. 로그 목록 출력
![로그 목록 출력](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdna%2FbKEtHp%2FbtsPdIPIIPV%2FAAAAAAAAAAAAAAAAAAAAAFmLQWjNTyrW4UI659XsylXTR1Sczkperu99dDSDEXfB%2Fimg.png%3Fcredential%3DyqXZFxpELC7KVnFOS48ylbz2pIh7yKj8%26expires%3D1753973999%26allow_ip%3D%26allow_referer%3D%26signature%3D1CD94%252FQh%252B4wunp70Lh8sxmiZ01E%253D)
8. 로그 목록 비우기
![로그 목록 비우기](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdna%2Fbl8cT8%2FbtsPdPBja1y%2FAAAAAAAAAAAAAAAAAAAAACW3TdcnhbdtZMkiEhL2UY-iy6veXAWT6eRZzPL6Eai4%2Fimg.png%3Fcredential%3DyqXZFxpELC7KVnFOS48ylbz2pIh7yKj8%26expires%3D1753973999%26allow_ip%3D%26allow_referer%3D%26signature%3D%252FUmu6Ru8qwR5kt8aGeYb9vQePdo%253D)
