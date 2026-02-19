package com.yuricosta.listingservice.listing.api.dtos;

import com.yuricosta.listingservice.listing.domain.enums.MusicalGenre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.yuricosta.listingservice.listing.domain.entities.Listing}
 */
public record WriteListingDto(
        @Size(message = "Enter a valid size", min = 2, max = 50) @NotBlank(message = "Title should not be null.") String title,
        @NotBlank(message = "Description should not be null.") String description,
        @NotNull(message = "Genre should not be null.") MusicalGenre genre) implements Serializable {
}