package com.yuricosta.listingservice.listing.api.dtos;

import com.yuricosta.listingservice.listing.domain.enums.MusicalGenre;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

/**
 * DTO for {@link com.yuricosta.listingservice.listing.domain.entities.Listing}
 */
public record ListingDto(UUID id, Instant createdAt, Instant updatedAt, String title, String description,
                         MusicalGenre genre, DocumentDto document) implements Serializable {
    /**
     * DTO for {@link com.yuricosta.listingservice.listing.domain.entities.Document}
     */
    public record DocumentDto(UUID id, String url) implements Serializable {
    }
}