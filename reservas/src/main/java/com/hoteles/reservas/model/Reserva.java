package com.hoteles.reservas.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotel;
    private String nombreCliente;
    private String correoCliente;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;

    // Constructor vacío (Obligatorio para JPA)
    public Reserva() {}

    // Constructor con parámetros
    public Reserva(String hotel, String nombreCliente, String correoCliente, LocalDate fechaIngreso, LocalDate fechaSalida) {
        this.hotel = hotel;
        this.nombreCliente = nombreCliente;
        this.correoCliente = correoCliente;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }

    // Getters y Setters (Para que Spring pueda leer y escribir los datos)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getHotel() { return hotel; }
    public void setHotel(String hotel) { this.hotel = hotel; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public String getCorreoCliente() { return correoCliente; }
    public void setCorreoCliente(String correoCliente) { this.correoCliente = correoCliente; }

    public LocalDate getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(LocalDate fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public LocalDate getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDate fechaSalida) { this.fechaSalida = fechaSalida; }
}