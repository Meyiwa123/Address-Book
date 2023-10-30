package com.SYSC4806.AddressBook.controller;

import com.SYSC4806.AddressBook.dto.AddressBookDTO;
import com.SYSC4806.AddressBook.service.AddressBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address-book")
public class AddressBookController {
    private final AddressBookService addressBookService;

    @PostMapping
    public ResponseEntity<String> createAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
        addressBookService.createAddressBook(addressBookDTO);
        return ResponseEntity.ok("Created address book " + addressBookDTO.getName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBookDTO> getAddressBookById(@PathVariable Long id) {
        return ResponseEntity.ok(addressBookService.getAddressBookById(id));
    }

    @GetMapping
    public ResponseEntity<List<AddressBookDTO>> getAllAddressBooks() {
        return ResponseEntity.ok(addressBookService.getAllAddressBooks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddressBookById(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
    	addressBookService.updateAddressBookById(id, addressBookDTO);
        return ResponseEntity.ok("Updated address book " + addressBookDTO.getName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddressBookById(@PathVariable Long id) {
    	addressBookService.deleteAddressBookById(id);
        return ResponseEntity.noContent().build();
    }
}
