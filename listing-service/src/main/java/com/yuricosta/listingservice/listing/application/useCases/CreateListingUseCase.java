package com.yuricosta.listingservice.listing.application.useCases;

import com.yuricosta.listingservice.listing.api.dtos.WriteListingDto;
import com.yuricosta.listingservice.listing.api.dtos.ListingDto;
import com.yuricosta.listingservice.listing.infra.mappers.ListingMapper;
import com.yuricosta.listingservice.listing.infra.repositories.ListingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class CreateListingUseCase {
    private final ListingRepository listingRepository;
    private final ListingMapper mapper;

    public CreateListingUseCase(ListingRepository listingRepository, ListingMapper mapper) {
        this.listingRepository = listingRepository;
        this.mapper = mapper;
    }

    @Transactional
    public ListingDto execute(WriteListingDto dto) {
        log.debug("Executing CreateListingUseCase with data: {}", dto);
        var listing = mapper.toEntity(dto);
        var savedListing = listingRepository.save(listing);
        log.info("Listing created with ID: {}", savedListing.getId());
        return mapper.toDto(savedListing);
    }
}
