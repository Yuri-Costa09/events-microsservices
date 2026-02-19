package com.yuricosta.listingservice.listing.domain.entities;

import com.yuricosta.listingservice.shared.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Document extends BaseEntity {
    @Column(nullable = false)
    private String url;

    @OneToOne
    private Listing listing;
}
