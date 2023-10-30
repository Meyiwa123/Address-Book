package com.SYSC4806.AddressBook;


import com.SYSC4806.AddressBook.dto.AddressBookDTO;
import com.SYSC4806.AddressBook.dto.BuddyInfoDTO;
import com.SYSC4806.AddressBook.service.AddressBookService;
import com.SYSC4806.AddressBook.service.BuddyInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AddressBookApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private AddressBookService addressBookService;
    @MockBean
    private BuddyInfoService buddyInfoService;
    private final String addressBookURI ="/api/v1/address-book";
    private final String buddyInfoURI ="/api/v1/buddy-info";

    @BeforeEach
    public void setUp() {
        AddressBookDTO addressBook = AddressBookDTO.builder()
                .name("Address Book 1")
                .build();
        BuddyInfoDTO buddyInfo = BuddyInfoDTO.builder()
                .buddyName("John")
                .address("Carleton")
                .number(1234567890)
                .build();
        addressBookService.createAddressBook(addressBook);
        buddyInfoService.createBuddyInfo(1L, buddyInfo);
    }

    @Test
    public void shouldCreateAddressBook() throws Exception {
        AddressBookDTO addressBookDTO = AddressBookDTO.builder()
                .name("Address Book 1")
                .build();

        String requestBody = objectMapper.writeValueAsString(addressBookDTO);

        mockMvc.perform(post(addressBookURI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAddressBookById() throws Exception {
        mockMvc.perform(get(addressBookURI + "/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateAddressBookById() throws Exception {
        AddressBookDTO addressBookDTO = AddressBookDTO.builder()
                .name("Updated Address Book 1")
                .build();

        String requestBody = objectMapper.writeValueAsString(addressBookDTO);

        mockMvc.perform(put(addressBookURI + "/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteAddressBookById() throws Exception {
        mockMvc.perform(delete(addressBookURI + "/{id}", 1))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldCreateBuddyInfo() throws Exception {
        BuddyInfoDTO buddyInfoDTO = BuddyInfoDTO.builder()
                .buddyName("Buddy 1")
                .number(987654321)
                .build();

        String requestBody = objectMapper.writeValueAsString(buddyInfoDTO);

        mockMvc.perform(post(buddyInfoURI + "/{addressBookId}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetBuddyInfoById() throws Exception {
        mockMvc.perform(get(buddyInfoURI + "/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateBuddyInfoById() throws Exception {
        BuddyInfoDTO buddyInfoDTO = BuddyInfoDTO.builder()
                .buddyName("Updated Buddy 1")
                .number(987654321)
                .build();

        String requestBody = objectMapper.writeValueAsString(buddyInfoDTO);

        mockMvc.perform(put(buddyInfoURI + "/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteBuddyInfoById() throws Exception {
        mockMvc.perform(delete(buddyInfoURI + "/{id}", 1))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
