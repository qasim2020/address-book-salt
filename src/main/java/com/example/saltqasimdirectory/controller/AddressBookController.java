package com.example.saltqasimdirectory.controller;

import com.example.saltqasimdirectory.model.AddressBook;
import com.example.saltqasimdirectory.repository.AddressBookRepo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RestController()
@RequestMapping("")
public class AddressBookController {

    private final AddressBookRepo repo;

    public AddressBookController(AddressBookRepo repo) {
        this.repo = repo;
    };

    @GetMapping("/getNewId")
    public String getId() {
        return UUID.randomUUID().toString();
    }

    @GetMapping("/findAll")
    public List<AddressBook> findAll() {
        return repo.findAll();
    }

    @GetMapping("/findOne/{id}")
    public AddressBook findOne(@PathVariable String id) {
        return repo.findById(id);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createOne")
    public void createOne(@RequestBody AddressBook address) {
        repo.create(address);
    }

    @DeleteMapping("/deleteOne/{id}")
    public boolean deleteOne(@PathVariable String id) {
        return repo.delete(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/updateOne/{id}")
    public void updateOne(@RequestBody AddressBook address, @PathVariable String id) {
        repo.update(address, id);
    }

}
