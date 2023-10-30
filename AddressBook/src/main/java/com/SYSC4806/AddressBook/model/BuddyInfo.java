package com.SYSC4806.AddressBook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuddyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String buddyName;
    private String address;
    private int number;

    @ManyToOne
    @JsonIgnore
    private AddressBook addressBook;
}
