package com.core.banca.repositories;

import com.core.banca.entities.Cuenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends BaseRepository<Cuenta, Long> {
    @Query(
        value = "SELECT * FROM cuenta as c WHERE c.cliente_id=:clienteId",
        nativeQuery = true
    )
    List<Cuenta> findCuentasByClienteId(@Param("clienteId") Long clienteId);
}
