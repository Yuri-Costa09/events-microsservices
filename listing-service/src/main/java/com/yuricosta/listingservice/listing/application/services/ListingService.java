package com.yuricosta.listingservice.listing.application.services;

import com.yuricosta.listingservice.listing.infra.repositories.ListingRepository;
import org.springframework.stereotype.Service;

@Service
public class ListingService {

    private final ListingRepository listingRepository;

    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }



}
