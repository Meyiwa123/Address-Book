package com.SYSC4806.AddressBook;

import com.SYSC4806.AddressBook.dto.AddressBookDTO;
import com.SYSC4806.AddressBook.dto.BuddyInfoDTO;
import com.SYSC4806.AddressBook.service.AddressBookService;
import com.SYSC4806.AddressBook.service.BuddyInfoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AddressBookService addressBookService, BuddyInfoService buddyInfoService) {
		return (args) -> {
			AddressBookDTO addressBook = AddressBookDTO.builder()
					.name("Address Book 1")
					.build();
			AddressBookDTO addressBook2 = AddressBookDTO.builder()
					.name("Address Book 2")
					.build();
			addressBookService.createAddressBook(addressBook);
			addressBookService.createAddressBook(addressBook2);

			BuddyInfoDTO buddyInfo = BuddyInfoDTO.builder()
					.buddyName("Buddy 1")
					.address("Address 1")
					.number(123456789)
					.build();
			BuddyInfoDTO buddyInfo2 = BuddyInfoDTO.builder()
					.buddyName("Buddy 2")
					.address("Address 2")
					.number(24680)
					.build();
			BuddyInfoDTO buddyInfo3 = BuddyInfoDTO.builder()
					.buddyName("Buddy 3")
					.address("Address 3")
					.number(13579)
					.build();
			buddyInfoService.createBuddyInfo(1L, buddyInfo);
			buddyInfoService.createBuddyInfo(1L, buddyInfo2);
			buddyInfoService.createBuddyInfo(2L, buddyInfo3);
		};
	}
}
