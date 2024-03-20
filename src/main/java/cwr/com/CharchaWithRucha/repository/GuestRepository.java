package cwr.com.CharchaWithRucha.repository;

import cwr.com.CharchaWithRucha.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {
}
