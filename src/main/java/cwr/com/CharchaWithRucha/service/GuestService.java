package cwr.com.CharchaWithRucha.service;


import cwr.com.CharchaWithRucha.model.Guest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GuestService {
    ResponseEntity<List<?>> getAllGuest();
    ResponseEntity<Guest> addGuest(Guest guest);
}
