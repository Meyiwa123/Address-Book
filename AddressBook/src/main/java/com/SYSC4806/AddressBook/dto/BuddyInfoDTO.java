package com.SYSC4806.AddressBook.dto;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuddyInfoDTO {
    private Long id;
    private String buddyName;
    private String address;
    private int number;
}
