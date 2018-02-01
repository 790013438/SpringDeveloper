# SpringDeveloper

## install
https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-installing-spring-boot.html#getting-started-manual-cli-installation

## spring boot init
```bash
spring init -dweb,data-jpa,thymeleaf,data-mongodb --build maven spring-boot-journal --force
```
web应用，jdbc；gradle
```bash
spring init -d=web,jdbc --build=gradle
```
只想有pom.xml,或者build.gradle文件，不要wrapper
```bash
spring init -d=web,data-jpa,security --format=build --build=gradle
```
没有--build会默认生成pom.xml
```bash
spring init -d=jdbc,amqp --format=build
```
name,groupId,artifactId
```bash
spring init -d=amqp -g=com.apress.spring -a=spring-boot-rabbitmq -name=spring-boot-rabbitmq
```
指定package name
```bash
spring init -d=web,thymeleaf,data-jpa,data-rest,security -g=com.apress.spring -a=spring-boot-journal-oauth --package-name=com.apress.spring -name=spring-boot-journal-oauth
```
如果好奇
```bash
spring init --list
```

###  The shell Command
```bash
spring shell
```

### The help Command
如果你想知道init命令
```bash
spring help init
```
