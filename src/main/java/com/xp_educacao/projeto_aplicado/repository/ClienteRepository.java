package com.xp_educacao.projeto_aplicado.repository;

import com.xp_educacao.projeto_aplicado.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNome(String nome);

    List<Cliente> findByNomeStartsWith(String nome);

    @Query(value = "select count(c.id) from Cliente c ")
    Long countClientes();

    Cliente findByDocumento(String documento);

    Cliente findByEmail(String email);
}