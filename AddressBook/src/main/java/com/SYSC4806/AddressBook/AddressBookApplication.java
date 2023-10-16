package com.SYSC4806.AddressBook;

import com.SYSC4806.AddressBook.model.AddressBook;
import com.SYSC4806.AddressBook.model.BuddyInfo;
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
			AddressBook addressBook = AddressBook.builder()
					.name("Address Book 1")
					.build();
			AddressBook addressBook2 = AddressBook.builder()
					.name("Address Book 2")
					.build();
			addressBookService.createAddressBook(addressBook);
			addressBookService.createAddressBook(addressBook2);

			BuddyInfo buddyInfo = BuddyInfo.builder()
					.name("John")
					.address("Carleton")
					.number(1234567890)
					.build();
			BuddyInfo buddyInfo2 = BuddyInfo.builder()
					.name("Jane")
					.address("Carleton")
					.number(24680)
					.build();
			BuddyInfo buddyInfo3 = BuddyInfo.builder()
					.name("Baba")
					.address("South-Keys")
					.number(13579)
					.build();
			buddyInfoService.createBuddyInfo(1L, buddyInfo);
			buddyInfoService.createBuddyInfo(1L, buddyInfo2);
			buddyInfoService.createBuddyInfo(2L, buddyInfo3);
		};
	}
}
