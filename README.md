# ✨알고리즘 정리
### 알고리즘 문제사이트
- [백준](https://www.acmicpc.net/)
- [SWEA](https://swexpertacademy.com/main/main.do)
- [프로그래머스](https://programmers.co.kr/)
- [정올](http://www.jungol.co.kr/)

### 📰 주요 언어 및 공부 방법

- Java를 사용하여 알고리즘 문제풀이
- 문제를 풀면서 어떤 알고리즘이 쓰이는지 생각하면서 구현
- 공부한 내용 알고리즘 별로 정리하면서 다시 한 번 복습
- 두시간 이상 못 풀고 붙잡고 있을 때는 풀이방법 찾아보고 완벽하게 이해하기
- 걸린 시간 기록 + 줄일 수 있으면 효율성 높여보기(?)

### 🥇 정리한(할) 알고리즘
| 알고리즘  | 정리한 내용               | 정리 및 복습         |
| :------------ | :-----------: | -------------------: |
| BFS    | [너비우선탐색]          | X               |
| DFS    | [깊이우선탐색]          | X               |
| KMP    | [KMP](./알고리즘/KMP)          | O               |
| Union Find    | [유니온 파인드](./알고리즘/서로소)      | O               |
| Dijkstra     | [다익스트라](./알고리즘/서로소)  | X               |

<br><br>

# 👑알고왕 스터디
### 📅 시간

- 화 ,목 (수업 후 2시간 )

### 📰 주요 언어

- Java를 사용하여 알고리즘 해결

### ✏️ 스터디 진행 방식

⇒ 화,목 :  스터디 시간에 같이 진행

### 💥패널티

- : 보증금(3만원) → 무단 지각 시 (- 분당 백원), 과제 안풀시 (-1000원), 무단 결석 (-2000원)
- 보충수업 기간동안은 주 2회 유동적, 스터디 과제 없이 모여서 푸는 것만
### 🖥️ Chrome Study용 확장 프로그램

- 삼성 익스퍼트 아카데미 홈페이지의 input 파일, output 파일을 쉽게 복사하는 plugin
[https://chrome.google.com/webstore/detail/samsung-expert-academy-ex/fpjlgclniclpcfmmhgpfldppfailoeae](https://chrome.google.com/webstore/detail/samsung-expert-academy-ex/fpjlgclniclpcfmmhgpfldppfailoeae)
- swea, 백준에 제출시 패키지 지우고 클래스이름을 Solution또는 Main으로 변경해주는 Plugin
[https://chrome.google.com/webstore/detail/submitjava/jamfbhbmmopcmncgnapfifjiimomgpfp](https://chrome.google.com/webstore/detail/submitjava/jamfbhbmmopcmncgnapfifjiimomgpfp)
- 백준 문제 레벨을 보여주는  plugin
[https://chrome.google.com/webstore/detail/solvedac/anenheoccfogllpbpcmbbpcbjpogeehe](https://chrome.google.com/webstore/detail/solvedac/anenheoccfogllpbpcmbbpcbjpogeehe)

### 📜 github 명령어

- 작업한 내용 스테이징 & Commit & Push

```bash
$ git add .
$ git commit -m "Commit Message"
$ git push origin master
```

- push 시 -set - -upstream 에러가 발생했을 경우

```bash
$ git push -u origin "push할 branch"

# 예시
$ git push -u origin master
```

- master 브랜치에 업데이트 내용 끌어오기

```bash
$ git pull origin master
```

### 🔖 이외에 코딩 가이드가 필요할 땐?

[인프런](https://www.inflearn.com/?gclid=CjwKCAiAsOmABhAwEiwAEBR0ZkF-wpqUz31ovQhAEwvbZJjjxucTKAG0-z471qHR3ThgMGaulcFIdRoCq5YQAvD_BwE)

## 📌 Gitignore 자동 생성 주소

- git ignore는 커밋할 때 커밋에서 제외할 목록을 저장한 문서 파일입니다.
- 보통 저장소가 무거워지는 것을 방지하고자 metadata 와 bin같은 데이터들은 git ignore에 명시하여 커밋에서 제외시킵니다.

- 사용하는 IDE 나 언어, 프로젝트등을 단순이 선택만 하면 자동으로 gitignore를 생성해주는 사이트

[gitignore.io](https://www.toptal.com/developers/gitignore)

- git ignore가 제대로 먹히지 않을 경우

```bash
$ git rm -r --cached .

$ git add .

$ git commit -m "git ignore add"

$ git push
```
