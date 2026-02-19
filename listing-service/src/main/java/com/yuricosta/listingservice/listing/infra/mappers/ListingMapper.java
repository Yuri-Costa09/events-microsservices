package com.yuricosta.listingservice.listing.infra.mappers;

import com.yuricosta.listingservice.listing.api.dtos.WriteListingDto;
import com.yuricosta.listingservice.listing.api.dtos.ListingDto;
import com.yuricosta.listingservice.listing.api.dtos.ListingDetailsDto;
import com.yuricosta.listingservice.listing.domain.entities.Document;
import com.yuricosta.listingservice.listing.domain.entities.Listing;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ListingMapper {
    Listing toEntity(ListingDto listingDto);

    @AfterMapping
    default void linkDocument(@MappingTarget Listing listing) {
        Document document = listing.getDocument();
        if (document != null) {
            document.setListing(listing);
        }
    }

    ListingDto toDto(Listing listing);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Listing partialUpdate(ListingDto listingDto, @MappingTarget Listing listing);

    Listing toEntity(ListingDetailsDto listingDetailsDto);

    @AfterMapping
    default void linkSessions(@MappingTarget Listing listing) {
        listing.getSessions().forEach(session -> session.setListing(listing));
    }

    ListingDetailsDto toDetails(Listing listing);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Listing partialUpdate(ListingDetailsDto listingDetailsDto, @MappingTarget Listing listing);

    Listing toEntity(WriteListingDto writeListingDto);

    WriteListingDto toCreateListing(Listing listing);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Listing partialUpdate(WriteListingDto writeListingDto, @MappingTarget Listing listing);
}