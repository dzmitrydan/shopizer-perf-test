# shopizer-perf-test
### Description
Home Task: *Backend performance testing - **Gatling***

#### How to deploy the application 'Shopizer' locally with Docker:

1. Run from Docker images:
From the command line:
```sh
docker run -p 8080:8080 shopizerecomm/shopizer:latest
```

2. Run the administration tool
```sh
docker run -e "APP_BASE_URL=http://localhost:8080/api" -p 82:80 shopizerecomm/shopizer-admin
```

3. Run react shop sample site
```sh
docker run -e "APP_MERCHANT=DEFAULT" -e "APP_BASE_URL=http://localhost:8080" -p 80:80 shopizerecomm/shopizer-shop-reactjs
```

4. Access site as http://localhost/

### Run test:
```sh
mvn gatling:test
```
```sh
mvn clean gatling:test
```
```sh
mvn clean gatling:test -DUsers=10
```
```sh
mvn clean gatling:test -DUsers=10 -DUsers=30
```