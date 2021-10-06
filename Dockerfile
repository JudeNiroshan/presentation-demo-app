FROM registry.access.redhat.com/ubi8/openjdk-11-runtime:1.10-1

WORKDIR /usr/app

COPY ./target/company-catalog-1.0.0-spring-boot.jar .

RUN mkdir uploaded_files

COPY ./uploaded_files/* uploaded_files

CMD ["java","-jar","company-catalog-1.0.0-spring-boot.jar"]

EXPOSE 8080