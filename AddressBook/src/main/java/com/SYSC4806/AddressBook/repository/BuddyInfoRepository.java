package com.SYSC4806.AddressBook.repository;

import com.SYSC4806.AddressBook.model.BuddyInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
}
