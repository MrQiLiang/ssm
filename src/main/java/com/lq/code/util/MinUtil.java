package com.lq.code.util;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * minio 客户端
 * @author qi
 */
@Component
public class MinUtil {

    /**
     * minio服务地址
     */
    @Value("minio.server.url")
    private String serverUrl;

    /**
     * 存储桶名称
     */
    @Value("minio.bucket.name")
    private String bucketName;

    /**
     * minio账号
     */
    @Value("minio.accesskey")
    private String accessKey;

    /**
     * minio密码
     */
    @Value("minio.secretkey")
    private String secretKey;

    /**
     * 上传图片
     * @param inputStream
     * @return
     */
    public String uploadFile(InputStream inputStream){
        String fileName = "timg.jpeg";
        //初始化客户端
        MinioClient minioClient = MinioClient.builder()
                                   .endpoint(serverUrl)
                                   .credentials(accessKey,secretKey)
                                   .build();

        try {
            int size = inputStream.available();
            BucketExistsArgs bucketExistsArgs = BucketExistsArgs.builder().bucket(bucketName).build();
            //判断桶是否存在
            boolean isExist = minioClient.bucketExists(bucketExistsArgs);
            if (!isExist){
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
            PutObjectArgs putObjectArgs = PutObjectArgs.builder().bucket(bucketName).object(fileName).stream(inputStream,size,-1).build();
            minioClient.putObject(putObjectArgs);
        } catch (ErrorResponseException e) {
            e.printStackTrace();
        } catch (InsufficientDataException e) {
            e.printStackTrace();
        } catch (InternalException e) {
            e.printStackTrace();
        } catch (InvalidBucketNameException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidResponseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (XmlParserException e) {
            e.printStackTrace();
        } catch (RegionConflictException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public static void main(String[] args) {
        String fileName = "timg.jpeg";
        //初始化客户端
        MinioClient minioClient = MinioClient.builder()
                .endpoint("http://192.168.31.19:9000")
                .credentials("minioadmin","minioadmin")
                .build();

        try {
            File file = new File("/Users/liangqi/Downloads/timg.jpeg");
            InputStream inputStream = new FileInputStream(file);
            if (file.exists()){
                System.out.println("========文件存在=======");
            }

            BucketExistsArgs bucketExistsArgs = BucketExistsArgs.builder().bucket("ssm").build();
            //判断桶是否存在
            boolean isExist = minioClient.bucketExists(bucketExistsArgs);
            if (!isExist){
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("ssm").build());
            }

            PutObjectArgs putObjectArgs = PutObjectArgs.builder().bucket("ssm").object(fileName).stream(inputStream,inputStream.available(),-1).build();
            minioClient.putObject(putObjectArgs);
        } catch (ErrorResponseException e) {
            e.printStackTrace();
        } catch (InsufficientDataException e) {
            e.printStackTrace();
        } catch (InternalException e) {
            e.printStackTrace();
        } catch (InvalidBucketNameException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidResponseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (XmlParserException e) {
            e.printStackTrace();
        } catch (RegionConflictException e) {
            e.printStackTrace();
        }
        System.out.println("===============文件上传成功!!");
    }
}
