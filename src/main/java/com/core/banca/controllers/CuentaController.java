package com.core.banca.controllers;

import com.core.banca.entities.Cuenta;
import com.core.banca.services.CuentaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/cuentas")
public class CuentaController extends BaseControllerImpl<Cuenta, CuentaServiceImpl> {
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<?> cuentasByClienteId(@PathVariable Long clienteId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findCuentasByClienteId(clienteId));
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}

