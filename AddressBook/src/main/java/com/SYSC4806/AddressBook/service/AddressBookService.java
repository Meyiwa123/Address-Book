package com.SYSC4806.AddressBook.service;

import com.SYSC4806.AddressBook.dto.AddressBookDTO;
import com.SYSC4806.AddressBook.model.AddressBook;
import com.SYSC4806.AddressBook.repository.AddressBookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AddressBookService {
    private final ModelMapper modelMapper;
    private final AddressBookRepository addressBookRepository;

    public void createAddressBook(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = modelMapper.map(addressBookDTO, AddressBook.class);
        addressBookRepository.save(addressBook);
    }

    public AddressBookDTO getAddressBookById(Long id) {
        AddressBook addressBook = addressBookRepository.findById(id)
                .orElseThrow();
        return modelMapper.map(addressBook, AddressBookDTO.class);
    }

    public List<AddressBookDTO> getAllAddressBooks() {
        List<AddressBook> addressBooks = (List<AddressBook>) addressBookRepository.findAll();
        return addressBooks.stream()
                .map(addressBook -> modelMapper.map(addressBook, AddressBookDTO.class))
                .toList();
    }

    public void updateAddressBookById(Long id, AddressBookDTO addressBookDTO) {
        AddressBook addressBookToUpdate = addressBookRepository.findById(id)
                .orElseThrow();
        Optional.ofNullable(addressBookDTO.getName()).ifPresent(addressBookToUpdate::setName);
        addressBookRepository.save(addressBookToUpdate);
    }

    public void deleteAddressBookById(Long id) {
        addressBookRepository.deleteById(id);
    }
}
