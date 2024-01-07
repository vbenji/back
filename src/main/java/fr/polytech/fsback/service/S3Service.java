package fr.polytech.fsback.service;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.http.Method;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class S3Service {

    private final MinioClient client;

    private final Environment environment;

    public S3Service(Environment environment) {
        this.environment = environment;
        this.client = MinioClient
                .builder()
                .endpoint(Objects.requireNonNull(environment.getProperty("s3.hostname")))
                .credentials(
                        Objects.requireNonNull(environment.getProperty("s3.access_key")),
                        Objects.requireNonNull(environment.getProperty("s3.secret_key"))
                )
                .build();
    }

    public String getPhotosDownloadUrl(final int objectId) {
        return this.getDownloadUrl(String.valueOf(objectId), environment.getProperty("s3.buckets.photos"));
    }

    public String putPhotosDownloadUrl(final int objectId) {
        return this.putDownloadUrl(String.valueOf(objectId), environment.getProperty("s3.buckets.photos"));
    }

    public String getIllustrationsDownloadUrl(final int objectId) {
        return this.getDownloadUrl(String.valueOf(objectId), environment.getProperty("s3.buckets.illustrations"));
    }

    public String putIllustrationsDownloadUrl(final int objectId) {
        return this.putDownloadUrl(String.valueOf(objectId), environment.getProperty("s3.buckets.illustrations"));
    }

    private String getDownloadUrl(final String objectId, final String bucket) {
        try {
            return this.client.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs
                            .builder()
                            .method(Method.GET)
                            .object(objectId)
                            .bucket(bucket)
                            .build()
            );
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
                 InvalidResponseException | IOException | NoSuchAlgorithmException | XmlParserException |
                 ServerException e) {
            throw new RuntimeException(e);
        }
    }

    private String putDownloadUrl(final String objectId, final String bucket) {
        try {
            return this.client.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs
                            .builder()
                            .method(Method.PUT)
                            .object(objectId)
                            .bucket(bucket)
                            .build()
            );
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidKeyException |
                 InvalidResponseException | IOException | NoSuchAlgorithmException | XmlParserException |
                 ServerException e) {
            throw new RuntimeException(e);
        }
    }

}
