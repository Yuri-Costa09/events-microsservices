package com.yuricosta.listingservice.listing.infra.repositories;

import com.yuricosta.listingservice.listing.domain.entities.Listing;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.UUID;

@Repository
public interface ListingRepository extends JpaRepository<Listing, UUID> {
    Page<Listing> findAll(Pageable pageable);

    Listing update(Listing listing);
}