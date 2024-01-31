package com.core.banca.controllers;

import com.core.banca.entities.MovimientoCC;
import com.core.banca.services.MovimientoCCServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/movimientos")
public class MovimientoCCController extends BaseControllerImpl<MovimientoCC, MovimientoCCServiceImpl> {
}
