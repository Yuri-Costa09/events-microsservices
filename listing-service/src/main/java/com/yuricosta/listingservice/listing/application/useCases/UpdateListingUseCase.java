package com.yuricosta.listingservice.listing.application.useCases;

import com.yuricosta.listingservice.listing.api.dtos.ListingDto;
import com.yuricosta.listingservice.listing.infra.mappers.ListingMapper;
import com.yuricosta.listingservice.listing.infra.repositories.ListingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
public class UpdateListingUseCase {

    private final ListingRepository listingRepository;
    private final ListingMapper listingMapper;

    public UpdateListingUseCase(ListingRepository listingRepository, ListingMapper listingMapper) {
        this.listingRepository = listingRepository;
        this.listingMapper = listingMapper;
    }

    @Transactional
    public ListingDto execute(UUID id, ListingDto dto) {
        log.debug("Executing UpdateListingUseCase for ID: {}", id);
        var listing = listingMapper.toEntity(dto);
        listing = listingRepository.update(listing);
        log.info("Listing with ID: {} updated successfully", id);
        listingRepository.save(listing);

        return listingMapper.toDto(listing);
    }
}
