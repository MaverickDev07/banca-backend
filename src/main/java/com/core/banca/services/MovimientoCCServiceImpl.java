package com.core.banca.services;

import com.core.banca.entities.Cuenta;
import com.core.banca.entities.MovimientoCC;
import com.core.banca.repositories.BaseRepository;
import com.core.banca.repositories.CuentaRepository;
import com.core.banca.repositories.MovimientoCCRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovimientoCCServiceImpl extends BaseServiceImpl<MovimientoCC, Long> implements MovimientoCCService {
    @Autowired
    private MovimientoCCRepository movimientoCCRepository;
    @Autowired
    private CuentaRepository cuentaRepository;

    private static final Logger logger = LoggerFactory.getLogger(MovimientoCCServiceImpl.class);

    public MovimientoCCServiceImpl(BaseRepository<MovimientoCC, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    @Transactional
    public MovimientoCC save(MovimientoCC movimientoCC) throws Exception {
        try {
            logger.info("Ohh Siii: " + String.valueOf(movimientoCC.getCuenta().getId()));
            Optional<Cuenta> optionalCuenta = cuentaRepository.findById(movimientoCC.getCuenta().getId());
            if (optionalCuenta.isPresent()) {
                Cuenta cuenta = optionalCuenta.get();
                double base_monto = cuenta.getMonto();
                if (movimientoCC.getTipo_transaccion().equalsIgnoreCase("deposito")) {
                    double monto = base_monto + movimientoCC.getMonto();
                    cuenta.setMonto(monto);
                } else {
                    if (base_monto < movimientoCC.getMonto()) {
                        throw new RuntimeException("No existe ese monto en la cuenta, intente nuevamente gracias.");
                    } else {
                        double monto = base_monto - movimientoCC.getMonto();
                        cuenta.setMonto(monto);
                    }
                }

                cuentaRepository.save(cuenta);
            }
            movimientoCC = movimientoCCRepository.save(movimientoCC);
            return movimientoCC;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*
    *
    * @Override
    @Transactional
    public E save(E entity) throws Exception {
        try {
            entity = baseRepository.save(entity);
            return entity;
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }*/
}
