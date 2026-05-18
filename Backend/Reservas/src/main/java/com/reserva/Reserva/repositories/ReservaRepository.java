package com.reserva.Reserva.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.reserva.Reserva.Model.entities.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

}
