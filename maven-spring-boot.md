maven编译启动

```bash
./mvnw package -DskipTests=true
java -jar target/spring-boot-config-0.0.1-SNAPSHOT.jar --server.ip=192.168.12.1
```
