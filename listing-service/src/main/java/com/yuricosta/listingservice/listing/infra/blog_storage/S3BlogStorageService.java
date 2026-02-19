package com.yuricosta.listingservice.listing.infra.blog_storage;

import com.yuricosta.listingservice.listing.domain.entities.Document;
import org.springframework.stereotype.Service;

/*
 * Implementation of BlogStorage Interface using Amazon S3.
 */
@Service
public class S3BlogStorageService implements BlobStorage{

    /*
     * Uploads a file to an Amazon S3 bucket, and returns the URL of the uploaded Object.
     * @param data The byte array representing the file to be uploaded.
     * @param contentType The MIME type of the file being uploaded.
     * @return The URL of the uploaded file in the S3 bucket.
     */
    @Override
    public Document upload(byte[] data, String contentType) {
        // TODO: Implement
    }

    /*
    * Deletes a file from an Amazon S3 bucket based on the provided URL.
    * @param url The URL of the file to be deleted from the S3 bucket.
    */
    @Override
    public void deleteObject(Document document) {
        // TODO: Implement
    }
}
