package com.hoteles.reservas.repository;

import com.hoteles.reservas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Listo, hereda automáticamente métodos como save(), findAll() y deleteById()
}