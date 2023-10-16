package com.SYSC4806.AddressBook.service;

import com.SYSC4806.AddressBook.model.AddressBook;
import com.SYSC4806.AddressBook.model.BuddyInfo;
import com.SYSC4806.AddressBook.repository.BuddyInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@RequestMapping("/buddy-info")
public class BuddyInfoService {

    private final BuddyInfoRepository buddyInfoRepository;
    private final AddressBookService addressBookService;

    public void createBuddyInfo(Long addressBookId, BuddyInfo buddyInfo) {
        AddressBook addressBook = addressBookService.getAddressBookById(addressBookId);
        buddyInfo.setAddressBook(addressBook);
        buddyInfoRepository.save(buddyInfo);
    }

    public BuddyInfo getBuddyInfoById(Long id) {
        return buddyInfoRepository.findById(id).orElseThrow();
    }

    public List<BuddyInfo> getAllBuddyInfos() {
        return (List<BuddyInfo>) buddyInfoRepository.findAll();
    }

    public void updateBuddyInfoById(Long id, BuddyInfo buddyInfo) {
        BuddyInfo buddyInfoToUpdate = buddyInfoRepository.findById(id)
                .orElseThrow();
        Optional.ofNullable(buddyInfo.getName()).ifPresent(buddyInfoToUpdate::setName);
        Optional.of(buddyInfo.getNumber()).ifPresent(buddyInfoToUpdate::setNumber);
        Optional.ofNullable(buddyInfo.getAddress()).ifPresent(buddyInfoToUpdate::setAddress);
        buddyInfoRepository.save(buddyInfoToUpdate);
    }

    public void deleteBuddyInfoById(Long id) {
        buddyInfoRepository.deleteById(id);
    }
}
