package com.yuricosta.listingservice.listing.infra.blog_storage;

import com.yuricosta.listingservice.listing.domain.entities.Document;

public interface BlobStorage {
    Document upload(byte[] data, String contentType);
    void deleteObject(Document document);
}
