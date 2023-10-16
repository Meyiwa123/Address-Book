//package com.SYSC4806.AddressBook;
//
//import com.SYSC4806.AddressBook.controller.thymleaf.AddressBookController;
//import com.SYSC4806.AddressBook.model.AddressBook;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class AddressBookApplicationTests {
//
//	private MockMvc mockMvc;
//
//	@Mock
//	private AddressBookService addressBookService;
//
//	@InjectMocks
//	private AddressBookController addressBookController;
//
//
//	@BeforeEach
//	void setUp() {
//		MockitoAnnotations.openMocks(this);
//		mockMvc = MockMvcBuilders.standaloneSetup(addressBookController).build();
//	}
//
//	@Test
//	void createAddressBook() throws Exception {
//		AddressBook addressBook = AddressBook.builder()
//				.name("Address Book 1")
//				.build();
//
//		when(addressBookService.createAddressBook(any(AddressBook.class))).thenReturn(addressBook);
//
//		mockMvc.perform(post("/api/address-book")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content("{ \"name\": \"My Address Book\" }"))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.id").value(1L))
//				.andExpect(jsonPath("$.name").value("My Address Book"));
//
//		verify(addressBookService, times(1)).createAddressBook(any(AddressBook.class));
//	}
//}
