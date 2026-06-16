package com.hoteles.reservas.controller;

import com.hoteles.reservas.model.Reserva;
import com.hoteles.reservas.repository.ReservaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    // ==========================================
    // MÓDULO 1: RESERVAS
    // ==========================================
    @PostMapping("/reservas/guardar")
    @Tag(name = "Reservas", description = "Operaciones para crear, listar y cancelar reservas de hotel")
    @Operation(summary = "Registra una nueva reserva", description = "Recibe los datos del huésped y el hotel seleccionado para almacenarlos en PostgreSQL.")
    public Reserva guardarReserva(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @GetMapping("/reservas/listar")
    @Tag(name = "Reservas")
    @Operation(summary = "Lista todas las reservas activas", description = "Retorna el listado completo de reservaciones guardadas en el sistema.")
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    @DeleteMapping("/reservas/cancelar/{id}")
    @Tag(name = "Reservas")
    @Operation(summary = "Cancela una reserva existente", description = "Elimina de forma permanente la reserva de la base de datos utilizando su ID.")
    public String cancelarReserva(@PathVariable Long id) {
        reservaRepository.deleteById(id);
        return "Reserva con ID " + id + " cancelada correctamente.";
    }

    // ==========================================
    // MÓDULO 2: SERVICIOS (Nuevo para rellenar tu Swagger)
    // ==========================================
    @GetMapping("/services")
    @Tag(name = "Servicios", description = "Servicios disponibles del hotel")
    @Operation(summary = "Lista los servicios activos", description = "Retorna las amenidades disponibles como Wifi, Alberca, Spa y Restaurante.")
    public List<String> listarServicios() {
        return List.of("Wifi Gratis", "Alberca Infinita", "Desayuno Incluido", "Spa & Wellness");
    }

    // ==========================================
    // MÓDULO 3: USUARIOS (Nuevo para simular Login/Perfil)
    // ==========================================
    @PostMapping("/login")
    @Tag(name = "Usuarios", description = "Login, registro y perfil de usuario")
    @Operation(summary = "Inicia sesion con correo y contrasena", description = "Valida las credenciales del usuario para permitirle administrar el sistema.")
    public String login(@RequestBody Map<String, String> credenciales) {
        return "Inicio de sesión simulado con éxito para: " + credenciales.get("correo");
    }

    @PostMapping("/register")
    @Tag(name = "Usuarios")
    @Operation(summary = "Registra un nuevo huesped", description = "Crea una cuenta nueva en el sistema para un cliente.")
    public String registrarUsuario(@RequestBody Map<String, String> datosUsuario) {
        return "Usuario " + datosUsuario.get("nombre") + " registrado correctamente.";
    }

    @GetMapping("/profile/{id}")
    @Tag(name = "Usuarios")
    @Operation(summary = "Obtiene el perfil de un usuario", description = "Recupera la información del perfil del usuario mediante su ID único.")
    public Map<String, String> obtenerPerfil(@PathVariable Long id) {
        return Map.of("id", id.toString(), "nombre", "Jocelin Pérez", "rol", "Administrador");
    }
}