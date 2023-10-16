package com.SYSC4806.AddressBook.controller.rest;

import com.SYSC4806.AddressBook.model.AddressBook;
import com.SYSC4806.AddressBook.service.AddressBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/address-book")
public class RESTAddressBookController {
    private final AddressBookService addressBookService;

    @PostMapping
    public ResponseEntity<String> createAddressBook(@RequestBody AddressBook addressBook) {
        addressBookService.createAddressBook(addressBook);
        return ResponseEntity.ok("Created address book " + addressBook.getName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getAddressBookById(@PathVariable Long id) {
        return ResponseEntity.ok(addressBookService.getAddressBookById(id));
    }

    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllAddressBooks() {
        return ResponseEntity.ok(addressBookService.getAllAddressBooks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddressBookById(@PathVariable Long id, @RequestBody AddressBook addressBook) {
    	addressBookService.updateAddressBookById(id, addressBook);
        return ResponseEntity.ok("Updated address book " + addressBook.getName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddressBookById(@PathVariable Long id) {
    	addressBookService.deleteAddressBookById(id);
        return ResponseEntity.noContent().build();
    }
}
