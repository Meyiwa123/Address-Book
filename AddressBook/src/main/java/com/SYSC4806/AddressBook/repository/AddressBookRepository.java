package com.SYSC4806.AddressBook.repository;

import com.SYSC4806.AddressBook.model.AddressBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
}
