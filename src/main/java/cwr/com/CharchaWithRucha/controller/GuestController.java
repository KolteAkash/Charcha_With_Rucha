package cwr.com.CharchaWithRucha.controller;

import cwr.com.CharchaWithRucha.model.Categories;
import cwr.com.CharchaWithRucha.model.Guest;
import cwr.com.CharchaWithRucha.service.CategoriesService;
import cwr.com.CharchaWithRucha.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest")
@CrossOrigin
public class GuestController {
    @Autowired
    private GuestService guestService;

    @GetMapping
    public ResponseEntity<List<?>> getAllGuest() {

        return guestService.getAllGuest();
    }


    @PostMapping("/add-guest")
    public ResponseEntity<Guest> addGuest(@RequestBody Guest guest) {
        return guestService.addGuest(guest);
    }
}
