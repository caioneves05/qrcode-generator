package com.caioneves05.qrcode_generator.infraestructure.adapters;

import com.caioneves05.qrcode_generator.ports.StoragePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;


@Component
public class S3StorageAdapter implements StoragePort {

    private final S3Client s3Client;
    private final String s3BucketName;
    private final String region;

    public S3StorageAdapter(@Value("${aws.s3.bucket-name}") String s3BucketName,
                            @Value("${aws.region}") String region) {
        this.s3BucketName = s3BucketName;
        this.region = region;
        this.s3Client = S3Client.builder()
                .region(Region.of(region))
                .build();
    }

    @Override
    public String uploadFile(byte[] file, String fileName, String contentType) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(s3BucketName)
                .key(fileName)
                .contentType(contentType)
                .build();
        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(file));
        return String.format("https://%s.s3.%s.amazonaws.com/%s", s3BucketName, region, fileName);
    }
}
