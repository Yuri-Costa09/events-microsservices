package com.yuricosta.listingservice.listing.application.useCases;

import com.yuricosta.listingservice.listing.api.dtos.ListingDto;
import com.yuricosta.listingservice.listing.infra.mappers.ListingMapper;
import com.yuricosta.listingservice.listing.infra.repositories.ListingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@Slf4j
public class GetAllListingUseCase {


    private final ListingRepository listingRepository;
    private final ListingMapper listingMapper;

    public GetAllListingUseCase(ListingRepository listingRepository, ListingMapper listingMapper) {
        this.listingRepository = listingRepository;
        this.listingMapper = listingMapper;
    }

    public List<ListingDto> execute(Pageable pageable) {
        log.debug("Executing GetAllListingUseCase");
        var listingList = listingRepository.findAll().stream()
                .map(listingMapper::toDto)
                .toList();
        log.info("Retrieved {} listings", listingList.size());
        return listingList;
    }
}
