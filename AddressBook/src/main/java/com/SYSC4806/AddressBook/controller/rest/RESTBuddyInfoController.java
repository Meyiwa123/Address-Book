package com.SYSC4806.AddressBook.controller.rest;

import com.SYSC4806.AddressBook.model.BuddyInfo;
import com.SYSC4806.AddressBook.service.BuddyInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/buddy-info")
public class RESTBuddyInfoController {

    private final BuddyInfoService buddyInfoService;

    @PostMapping("/{addressBookId}")
    public ResponseEntity<String> createBuddyInfo(@PathVariable Long addressBookId, @RequestBody BuddyInfo buddyInfo) {
        buddyInfoService.createBuddyInfo(addressBookId, buddyInfo);
        return ResponseEntity.ok("Created buddy info " + buddyInfo.getName());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuddyInfo> getBuddyInfoById(@PathVariable Long id) {
        return ResponseEntity.ok(buddyInfoService.getBuddyInfoById(id));
    }

    @GetMapping
    public ResponseEntity<List<BuddyInfo>> getAllBuddyInfos() {
        return ResponseEntity.ok(buddyInfoService.getAllBuddyInfos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBuddyInfoById(@PathVariable Long id, @RequestBody BuddyInfo buddyInfo) {
        buddyInfoService.updateBuddyInfoById(id, buddyInfo);
        return ResponseEntity.ok("Updated buddy info " + buddyInfo.getName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuddyInfoById(@PathVariable Long id) {
        buddyInfoService.deleteBuddyInfoById(id);
        return ResponseEntity.noContent().build();
    }
}
