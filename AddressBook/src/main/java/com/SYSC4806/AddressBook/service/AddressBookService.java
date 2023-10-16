package com.SYSC4806.AddressBook.service;

import com.SYSC4806.AddressBook.model.AddressBook;
import com.SYSC4806.AddressBook.repository.AddressBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressBookService {
    private final AddressBookRepository addressBookRepository;

    public void createAddressBook(AddressBook addressBook) {
        addressBookRepository.save(addressBook);
    }

    public AddressBook getAddressBookById(Long id) {
        return addressBookRepository.findById(id)
                .orElseThrow();
    }

    public List<AddressBook> getAllAddressBooks() {
        return (List<AddressBook>) addressBookRepository.findAll();
    }

    public void updateAddressBookById(Long id, AddressBook addressBook) {
        AddressBook addressBookToUpdate = addressBookRepository.findById(id)
                .orElseThrow();
        Optional.ofNullable(addressBook.getName()).ifPresent(addressBookToUpdate::setName);
        addressBookRepository.save(addressBookToUpdate);
    }

    public void deleteAddressBookById(Long id) {
        addressBookRepository.deleteById(id);
    }
}
