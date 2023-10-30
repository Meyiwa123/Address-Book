package com.SYSC4806.AddressBook.controller;

import com.SYSC4806.AddressBook.dto.BuddyInfoDTO;
import com.SYSC4806.AddressBook.service.BuddyInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/buddy-info")
public class BuddyInfoController {

    private final BuddyInfoService buddyInfoService;

    @PostMapping("/{addressBookId}")
    public ResponseEntity<String> createBuddyInfo(@PathVariable Long addressBookId, @RequestBody BuddyInfoDTO buddyInfoDTO) {
        buddyInfoService.createBuddyInfo(addressBookId, buddyInfoDTO);
        return ResponseEntity.ok("Created buddy info " + buddyInfoDTO.getBuddyName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuddyInfoDTO> getBuddyInfoById(@PathVariable Long id) {
        return ResponseEntity.ok(buddyInfoService.getBuddyInfoById(id));
    }

    @GetMapping
    public ResponseEntity<List<BuddyInfoDTO>> getAllBuddyInfos() {
        return ResponseEntity.ok(buddyInfoService.getAllBuddyInfos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBuddyInfoById(@PathVariable Long id, @RequestBody BuddyInfoDTO buddyInfoDTO) {
        buddyInfoService.updateBuddyInfoById(id, buddyInfoDTO);
        return ResponseEntity.ok("Updated buddy info " + buddyInfoDTO.getBuddyName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuddyInfoById(@PathVariable Long id) {
        buddyInfoService.deleteBuddyInfoById(id);
        return ResponseEntity.noContent().build();
    }
}
