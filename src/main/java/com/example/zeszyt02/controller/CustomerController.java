package com.example.zeszyt02.controller;

import com.example.zeszyt02.entity.Customers;
import com.example.zeszyt02.service.CustomersService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // 1. Zmiana na RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    @Autowired
    private CustomersService customersService;

    @GetMapping("/list")
    public List<Customers> getListOfCustomers() {
        // Zwraca bezpośrednio listę - Spring zamieni ją na JSON Array []
        return customersService.getCustomers();
    }

    // W API zazwyczaj nie ma metody /add typu GET (formularze są po stronie frontendu)
    // Zostawiam ją tylko jeśli naprawdę jej potrzebujesz jako "szablon" obiektu
//    @GetMapping("/init")
//    public Customers initAddCustomer() {
//        return new Customers();
//    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Customers addCustomer(@Valid @RequestBody Customers customers) {
        // @RequestBody jest kluczowe dla odbierania JSONa
        customersService.addCustomer(customers);
        return customers;
    }

    @GetMapping("/{id}") // Uproszczony mapping dla pobierania pojedynczego klienta
    public Customers getCustomer(@PathVariable long id) {
        return customersService.getCustomer(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
    }

    @PutMapping("/update/{id}") // W REST do aktualizacji używamy PUT
    public Customers updateCustomer(@PathVariable long id, @Valid @RequestBody Customers customers) {
        // Ustawiamy ID z ścieżki, aby upewnić się, że aktualizujemy właściwy rekord
        customers.setId(id);
        customersService.updateCustomer(customers);
        return customers;
    }

    @DeleteMapping("/delete/{id}") // W REST używamy DELETE zamiast GET/POST
    public Map<String, String> deleteCustomer(@PathVariable long id) {
        customersService.deleteCustomer(id);
        // Zwracamy prosty komunikat w formacie JSON
        return Map.of("status", "deleted", "id", String.valueOf(id));
    }
}