# 설문조사 기반 데이터 공유 플랫폼

### 0\. Index
1. [프로젝트 소개](#1)<br>
2. [팀원 소개](#2)<br>
3. [기능 소개](#3)<br>
4. [유스케이스 다이어그램](#4)<br>
5. [기술 스택](#5)<br>
6. [구현](#6)<br>
   6-1. [DB](#6-1)<br>
   6-2. [MSA](#6-2)<br>
   6-3. [System Architecture](#6-3)<br>
   6-4. [CI/CD](#6-4)<br>
7. [프로젝트 관리](#7)<br>
8. [UI](#8)<br>


<a name="1"></a>
### 1\. 프로젝트 소개

<img src="https://user-images.githubusercontent.com/114554407/226843540-7dcfdf0c-f803-41b4-a333-59759af79583.png" width="600"/>

-   설문조사 플랫폼 : 설문 제작 기능 및 답변에 따른 통계 데이터 제공
-   설문 데이터 허브: 공개 범위에 따른 설문 조사 결과 열람 및 엑셀 다운로드 기능 제공

<a name="2"></a>
### 2\. 팀원 소개
| **고솔비** | **서유리** | **신예나** | **오영주** |
| --- | --- | --- | --- |
| PM,<br>설문조사, 질문, 답변 관리,<br>사용자 인증 및 권한 관리 | 그룹 관리 | 공통 코드 관리,<br>답변 관리 | 설문 결과 통계 조회,<br>비속어 자연어 처리 개발 |
| [https://github.com/solbiko](https://github.com/solbiko) | [https://github.com/uRibbon](https://github.com/uRibbon) | [https://github.com/shinyena](https://github.com/shinyena) | [https://github.com/OYJ-hansung](https://github.com/OYJ-hansung) |

<a name="3"></a>
### 3\. 기능 소개
0.  사용자 인증 및 권한 (로그인, 회원가입, 회원정보수정, 회원탈퇴)
1.  설문 조사 생성, 수정, 삭제
2.  설문조사 답변 등록, 수정, 삭제
3.  설문, 답변 조회 및 전체 답변에 대한 엑셀 다운로드
4.  설문 결과 및 분석 및 통계 조회
5.  그룹 생성, 수정, 삭제를 통한 설문 대상자 지정 가능
6.  어드민 권한 기능(플랫폼 사용자 통계 조회 및 비속어 설문 삭제 처리)

<a name="4"></a>
### 4\. 유스케이스 다이어그램
<img src="https://user-images.githubusercontent.com/114554407/226844339-7a32cf61-935b-42d3-b977-55d08504051f.png" width="600"/>

<a name="5"></a>
### 5\. 기술 스택

-   Frontend:
![](https://img.shields.io/badge/React-61DAFB?style=flat-square&logo=React&logoColor=black)
![](https://img.shields.io/badge/NGINX-009639?style=flat-square&logo=NGINX&logoColor=white)

-   Backend:
![](https://img.shields.io/badge/Java-007396?style=flat-square&logo=Conda-Forge&logoColor=white)
![](https://img.shields.io/badge/SpringBoot-6DB33F?style=flat-square&logo=SpringBoot&logoColor=white)
![](https://img.shields.io/badge/ApacheKafka-231F20?style=flat-square&logo=ApacheKafka&logoColor=white)

-   Database:
![](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white)

-   CI/CD: 
![](https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=docker&logoColor=white)
![](https://img.shields.io/badge/Jenkins-D24939?style=flat-square&logo=jenkins&logoColor=white)
![](https://img.shields.io/badge/Argo-EF7B4D?style=flat-square&logo=argo&logoColor=white)
![](https://img.shields.io/badge/Kubernetes-326CE5?style=flat-square&logo=kubernetes&logoColor=white)

-  Infra: 
![](https://img.shields.io/badge/KakaoiCloud-FFCD00?style=flat-square&logo=iCloud&logoColor=black)

<a name="6"></a>
### 6\. 구현

<a name="6-1"></a>
#### 1) DB
-   survey\_db : 설문, 질문 및 답변 정보 저장
<img src="https://user-images.githubusercontent.com/114554407/226845467-6878fad2-6d2e-4827-9be3-bf5a91de1d5d.png" width="600"/>

-   user\_db : 사용자, 그룹 정보 저장
<img src="https://user-images.githubusercontent.com/114554407/226845501-01d93c87-f230-4452-b670-292004d4f46a.png" width="600"/>

-   common\_db : 플랫폼 공통 코드 저장
<img src="https://user-images.githubusercontent.com/114554407/226845623-851a16b4-41ee-44ee-9ad3-974b2589285c.png" width="600"/>

-   point\_db : 사용자 포인트 정보 저장
<img src="https://user-images.githubusercontent.com/114554407/226845655-64ad3bc8-3b30-4aaa-80ea-041b359bafea.png" width="600"/>

-   analysis\_db : 플랫폼,  설문 분석 정보 저장
<img src="https://user-images.githubusercontent.com/114554407/226845755-6c35e932-4cad-4f17-99a9-68943f489347.png" width="600"/>

<a name="6-2"></a>
#### 2) MSA
<img src="https://user-images.githubusercontent.com/114554407/226848437-41425dc2-c170-4a5c-94d1-50872b5160d4.png" width="600"/>

<a name="6-3"></a>
#### 3) System Architecture
<img src="https://user-images.githubusercontent.com/114554407/226848262-b7d0aff8-1a60-4009-8d39-76057ed4ffa8.png" width="600"/>

<a name="6-4"></a>
#### 4)CI/CD
<img src="https://user-images.githubusercontent.com/114554407/226849091-43b3d098-02ac-4a30-b185-708e6160fda5.png" width="600"/>

<a name="7"></a>
### 7\. 프로젝트 관리
<img src="https://user-images.githubusercontent.com/114554407/226921532-3f7c4563-af6e-4241-834f-0ad26a8aac6e.png" width="600"/>
<img src="https://user-images.githubusercontent.com/114554407/226920931-2d7eac1e-fc63-4a11-9a46-31f4914b89b6.png" width="600"/>
<img src="https://user-images.githubusercontent.com/114554407/226920944-5255f670-44bc-4a1b-819c-04471b4d7643.png" width="600"/>

<a name="8"></a>
### 8\. UI

#### 1) 로그인 화면
![R1280x0-11](https://user-images.githubusercontent.com/114554407/226846369-3d094067-f519-4e2d-abc4-575785ecaeb1.png)

#### 2) 회원가입
![R1280x0-12](https://user-images.githubusercontent.com/114554407/226846711-b4ccad72-cb27-454e-b021-93d5b693e477.png)

#### 3) 메인화면
![R1280x0-13](https://user-images.githubusercontent.com/114554407/226846730-7fa09438-927d-4547-bbff-8a65bc71752e.png)

#### 4) 설문조사 리스트
![R1280x0-14](https://user-images.githubusercontent.com/114554407/226846743-05de802f-2fa3-4a92-ad3a-c4e2e13e6d62.png)

#### 5) 설문조사 생성
![R1280x0-15](https://user-images.githubusercontent.com/114554407/226846770-6711eaa0-6dec-48aa-9983-b0127de3be1d.png)
![R1280x0-16](https://user-images.githubusercontent.com/114554407/226846857-6c56e8fb-3048-49c4-a932-7134851d6d70.png)

#### 6) 설문 상세 페이지
![R1280x0-17](https://user-images.githubusercontent.com/114554407/226847015-3a9f6809-6a17-407f-adef-c0c599a60acb.png)
![R1280x0-18](https://user-images.githubusercontent.com/114554407/226847022-ca4c466d-15dc-4bef-b245-2e8867dee3eb.png)

#### 7) 생성, 참여 설문 리스트
![R1280x0-19](https://user-images.githubusercontent.com/114554407/226847047-55e8fade-0493-49af-80a7-d16009e1dde4.png)
![R1280x0-20](https://user-images.githubusercontent.com/114554407/226903231-b2961593-b046-4a41-b044-17aa3654d0f5.png)

#### 8) 그룹 리스트
![R1280x0-24](https://user-images.githubusercontent.com/114554407/226847410-f729af41-221b-48ae-86da-372f8db35ace.png)

#### 9) 설문 조사 카테고리 관리(ADMIN)
![R1280x0-21](https://user-images.githubusercontent.com/114554407/226847173-d6c030f7-33ed-4906-b50e-080db798ed89.png)

#### 10) 설문 조사 비속어 목록
![R1280x0-22](https://user-images.githubusercontent.com/114554407/226847155-896ef8a1-b909-4d84-b969-0dad32c9e4bf.png)

#### 11) 플랫폼 이용자 및 설문조사 분석
![R1280x0-23](https://user-images.githubusercontent.com/114554407/226847082-b9f77c10-9edc-4b20-b490-899dd4543eb1.png)

