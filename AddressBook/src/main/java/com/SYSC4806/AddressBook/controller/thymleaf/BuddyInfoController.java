package com.SYSC4806.AddressBook.controller.thymleaf;

import com.SYSC4806.AddressBook.model.BuddyInfo;
import com.SYSC4806.AddressBook.service.BuddyInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/buddy-info")
public class BuddyInfoController {

    private final BuddyInfoService buddyInfoService;

    @PostMapping
    public String createBuddyInfo(@RequestBody Long addressBookId, @RequestBody BuddyInfo buddyInfo) {
        buddyInfoService.createBuddyInfo(addressBookId, buddyInfo);
        return "redirect:/";
    }

    @DeleteMapping
    public String deleteBuddyInfoById(@RequestBody Long id) {
        buddyInfoService.deleteBuddyInfoById(id);
        return "redirect:/";
    }
}
