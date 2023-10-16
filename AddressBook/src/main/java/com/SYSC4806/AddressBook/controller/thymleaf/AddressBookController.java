package com.SYSC4806.AddressBook.controller.thymleaf;

import com.SYSC4806.AddressBook.model.AddressBook;
import com.SYSC4806.AddressBook.service.AddressBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequiredArgsConstructor
public class AddressBookController {

    private final AddressBookService addressBookService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<AddressBook> addressBooks = addressBookService.getAllAddressBooks();
        model.addAttribute("addressBooks", addressBooks);
        return "home";
    }

    @PostMapping("/address-book")
    public String createAddressBook(@RequestBody AddressBook addressBook) {
        addressBookService.createAddressBook(addressBook);
        return "redirect:/";
    }

    @DeleteMapping("/address-book/{id}")
    public String deleteAddressBookById(@PathVariable Long id) {
        addressBookService.deleteAddressBookById(id);
        return "redirect:/";
    }
}
