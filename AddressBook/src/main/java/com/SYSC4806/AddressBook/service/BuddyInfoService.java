package com.SYSC4806.AddressBook.service;

import com.SYSC4806.AddressBook.dto.AddressBookDTO;
import com.SYSC4806.AddressBook.dto.BuddyInfoDTO;
import com.SYSC4806.AddressBook.model.AddressBook;
import com.SYSC4806.AddressBook.model.BuddyInfo;
import com.SYSC4806.AddressBook.repository.BuddyInfoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BuddyInfoService {

    private final ModelMapper modelMapper;
    private final BuddyInfoRepository buddyInfoRepository;
    private final AddressBookService addressBookService;

    public void createBuddyInfo(Long addressBookId, BuddyInfoDTO buddyInfoDTO) {
        AddressBookDTO addressBookDTO = addressBookService.getAddressBookById(addressBookId);
        AddressBook addressBook = modelMapper.map(addressBookDTO, AddressBook.class);

        BuddyInfo buddyInfo = modelMapper.map(buddyInfoDTO, BuddyInfo.class);
        buddyInfo.setAddressBook(addressBook);
        buddyInfoRepository.save(buddyInfo);
    }

    public BuddyInfoDTO getBuddyInfoById(Long id) {
        BuddyInfo buddyInfo = buddyInfoRepository.findById(id).orElseThrow();
        return modelMapper.map(buddyInfo, BuddyInfoDTO.class);
    }

    public List<BuddyInfoDTO> getAllBuddyInfos() {
        List<BuddyInfo> buddyInfos = (List<BuddyInfo>) buddyInfoRepository.findAll();
        return buddyInfos.stream()
                .map(buddyInfo -> modelMapper.map(buddyInfo, BuddyInfoDTO.class))
                .collect(Collectors.toList());
    }

    public void updateBuddyInfoById(Long id, BuddyInfoDTO buddyInfoDTO) {
        BuddyInfo buddyInfoToUpdate = buddyInfoRepository.findById(id)
                .orElseThrow();
        Optional.ofNullable(buddyInfoDTO.getBuddyName()).ifPresent(buddyInfoToUpdate::setBuddyName);
        Optional.of(buddyInfoDTO.getNumber()).ifPresent(buddyInfoToUpdate::setNumber);
        Optional.ofNullable(buddyInfoDTO.getAddress()).ifPresent(buddyInfoToUpdate::setAddress);
        buddyInfoRepository.save(buddyInfoToUpdate);
    }

    public void deleteBuddyInfoById(Long id) {
        buddyInfoRepository.deleteById(id);
    }
}
