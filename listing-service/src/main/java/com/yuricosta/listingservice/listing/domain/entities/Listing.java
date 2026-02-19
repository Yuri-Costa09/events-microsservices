package com.yuricosta.listingservice.listing.domain.entities;

import com.yuricosta.listingservice.listing.domain.enums.MusicalGenre;
import com.yuricosta.listingservice.session.domain.Session;
import com.yuricosta.listingservice.shared.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Listing extends BaseEntity {
    @Column(nullable = false, length = 120)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "Genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private MusicalGenre genre;

    @OneToMany(
            mappedBy = "listing",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @OrderBy("createdAt ASC")
    private List<Session> sessions = new ArrayList<>();

    @OneToOne(
            mappedBy = "listing",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Document document;

    public Listing(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
