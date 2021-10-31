package com.example.SuccessCadets.repo;

import com.example.SuccessCadets.model.Cadet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadetRepository extends JpaRepository<Cadet, Long> {
}
