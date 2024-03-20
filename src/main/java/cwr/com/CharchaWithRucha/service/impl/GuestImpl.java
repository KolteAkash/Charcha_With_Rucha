package cwr.com.CharchaWithRucha.service.impl;

import cwr.com.CharchaWithRucha.model.Guest;
import cwr.com.CharchaWithRucha.repository.GuestRepository;
import cwr.com.CharchaWithRucha.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestImpl implements GuestService {
    @Autowired
    private GuestRepository guestRepository;


    @Override
    public ResponseEntity<List<?>> getAllGuest(){
        List<Guest> guest = guestRepository.findAll();
        return new ResponseEntity<>(guest, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<Guest> addGuest(Guest guest){
        try {
            Guest saved_guest = guestRepository.save(guest);
            return new ResponseEntity<>(saved_guest, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(guest);
        }
    }
}
