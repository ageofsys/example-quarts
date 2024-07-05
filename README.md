# 소개

```shell
docker run --detach --name mariadb -p 3306:3306 --env MARIADB_USER=devman --env MARIADB_PASSWORD=secret --env MARIADB_DATABASE=example-quartz --env MARIADB_ROOT_PASSWORD=secret  mariadb:latest
```

# 예시

## Quarts 단독 구성
Module Name: quarts-single-basis

## Quarts 스프링 조합 구성

# 참조 문서
[Quartz 2.3.0 Document](https://www.quartz-scheduler.org/documentation/quartz-2.3.0/)

# 메모
1. mvrepo 에서 quarts를 찾을 수 없다.
2. 2.3.0 배포판에는 docs/dbTables 폴더가 없다.
