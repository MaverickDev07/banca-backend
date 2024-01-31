package com.core.banca.repositories;

import com.core.banca.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {
    List<Cliente> findByNombreContainingOrAppaternoOrApmaternoContaining(String nombre, String appaterno, String apmaterno);

    Page<Cliente> findByNombreContainingOrAppaternoOrApmaternoContaining(String nombre, String appaterno, String apmaterno, Pageable pageable);

    @Query(value = "SELECT c FROM Cliente c WHERE c.nombre LIKE %:filtro% OR c.appaterno LIKE %:filtro% OR c.apmaterno LIKE %:filtro%")
    List<Cliente> search(@Param("filtro") String filtro);

    @Query(value = "SELECT c FROM Cliente c WHERE c.nombre LIKE %:filtro% OR c.appaterno LIKE %:filtro% OR c.apmaterno LIKE %:filtro%")
    Page<Cliente> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
        value = "SELECT * FROM cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.appaterno LIKE %:filtro% OR cliente.apmaterno LIKE %:filtro%",
        nativeQuery = true
    )
    List<Cliente> searchNativo(@Param("filtro") String filtro);

    @Query(
        value = "SELECT * FROM cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.appaterno LIKE %:filtro% OR cliente.apmaterno LIKE %:filtro%",
        countQuery = "SELECT count(*) FROM cliente",
        nativeQuery = true
    )
    Page<Cliente> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
