# QR Code Generator with Spring Boot

This project is a Java application based on the Spring Boot framework that generates QR Codes and stores them in an Amazon S3 bucket.

---

## 🚀 Technologies Used
- Java 17
- Spring Boot 3.x
- Maven
- AWS SDK for Java
- Docker

---

## ⚙️ Environment Configuration
1.  Set the following environment variables:
    - `AWS_REGION`
    - `AWS_S3_BUCKET`
    - `AWS_ACCESS_KEY_ID`
    - `AWS_SECRET_ACCESS_KEY`
2.  Ensure you have Maven installed on your system.

---

## ▶️ How to Run

### Locally
To run the application directly on your machine, use the Maven command:
```sh
mvn spring-boot:run
```

---

## 🐳 Using Docker

First, build the Docker image:

```bash
docker build -t qrcode-generator .
```

Then, run the container, passing your AWS credentials as environment variables:

```bash
docker run \
  -e AWS_REGION=us-east-1 \
  -e AWS_S3_BUCKET=your-bucket \
  -e AWS_ACCESS_KEY_ID=your-key \
  -e AWS_SECRET_ACCESS_KEY=your-secret \
  qrcode-generator
```

---

## 🤝 Contribution
Feel free to open issues or submit pull requests. All contributions are welcome!

---

## 📜 License
This project is licensed under the MIT License.
