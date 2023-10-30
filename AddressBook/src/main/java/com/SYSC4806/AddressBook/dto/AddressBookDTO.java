package com.SYSC4806.AddressBook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    private Long id;
    private String name;
    private List<BuddyInfoDTO> buddyList;
}
