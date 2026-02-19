package com.yuricosta.listingservice.listing.api.dtos;

import com.yuricosta.listingservice.listing.domain.enums.MusicalGenre;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link com.yuricosta.listingservice.listing.domain.entities.Listing}
 */
public record ListingDetailsDto(UUID id, Instant createdAt, Instant updatedAt, String title, String description,
                                MusicalGenre genre, List<SessionDto> sessions, DocumentDto document) implements Serializable {
    /**
     * DTO for {@link com.yuricosta.listingservice.session.domain.Session}
     */
    public record SessionDto(UUID id, Instant createdAt, Instant updatedAt, String title, LocalDateTime occurDate,
                             String occurLocation) implements Serializable {
    }

    /**
     * DTO for {@link com.yuricosta.listingservice.listing.domain.entities.Document}
     */
    public record DocumentDto(UUID id, String url) implements Serializable {
    }
}