package com.example.saltqasimdirectory.repository;

import com.example.saltqasimdirectory.model.AddressBook;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class AddressBookRepo {
    List<AddressBook> addresses = new ArrayList<>();

    public AddressBookRepo() {
        addresses.add(new AddressBook(
                UUID.randomUUID().toString(),
                "Qasim Ali",
                "Bergkallavagen 48, 19278"
        ));
    }

    public List<AddressBook> findAll() {
        return addresses;
    }

    public AddressBook findById(String id) {
        return addresses.stream().filter(v -> v.id().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException("Address not found!"));
    }

    public void create(AddressBook address) {
        addresses.add(address);
    }

    public void update(AddressBook address, String id) {
        AddressBook existing = addresses.stream().filter(v -> v.id().equals(id)).findFirst().orElseThrow(() -> new IllegalArgumentException("Address not found!"));
        int i = addresses.indexOf(existing);
        addresses.set(i, address);
    }

    public boolean delete (String id) {
        boolean b = addresses.removeIf(v -> v.id().equals(id));
        return b;
    }

}
