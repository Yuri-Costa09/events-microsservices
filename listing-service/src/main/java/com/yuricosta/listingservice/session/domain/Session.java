package com.yuricosta.listingservice.session.domain;

import com.yuricosta.listingservice.listing.domain.entities.Listing;
import com.yuricosta.listingservice.shared.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Session extends BaseEntity {
    @Column(nullable = false, length = 70)
    private String title;

    @Column(nullable = false)
    private LocalDateTime occurDate;

    @Column(nullable = false)
    private String occurLocation; // will be plain text for now - e.g. "Allianz Park"

    @ManyToOne
    private Listing listing;

    public Session(String title, LocalDateTime occurDate, String occurLocation, Listing listing) {
        this.title = title;
        this.occurDate = occurDate;
        this.occurLocation = occurLocation;
        this.listing = listing;
    }
}
