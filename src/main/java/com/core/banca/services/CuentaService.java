package com.core.banca.services;

import com.core.banca.entities.Cliente;
import com.core.banca.entities.Cuenta;

import java.util.List;

public interface CuentaService extends BaseService<Cuenta, Long> {
    public List<Cuenta> findCuentasByClienteId(Long clienteId) throws Exception;
}
