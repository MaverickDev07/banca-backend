package com.core.banca.services;

import com.core.banca.entities.Cliente;
import com.core.banca.entities.Cuenta;
import com.core.banca.repositories.BaseRepository;
import com.core.banca.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServiceImpl extends BaseServiceImpl<Cuenta, Long> implements CuentaService {
    @Autowired
    private CuentaRepository cuentaRepository;

    public CuentaServiceImpl(BaseRepository<Cuenta, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Cuenta> findCuentasByClienteId(Long clienteId) throws Exception {
        try {
            List<Cuenta> cuentas = cuentaRepository.findCuentasByClienteId(clienteId);
            return cuentas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
