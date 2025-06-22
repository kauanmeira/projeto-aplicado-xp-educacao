package com.xp_educacao.projeto_aplicado.service.cliente;

import com.xp_educacao.projeto_aplicado.model.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> listarTodos();

    Cliente buscarPorId(Long id);

    List<Cliente> buscarPorNome(String nome);

    Cliente salvar(Cliente cliente);

    Cliente atualizar(Cliente cliente);

    void excluir(Long id);

    Long buscarTotalDeRegistros();

    Cliente buscarPorDocumento(String documento);

    Cliente buscarPorEmail(String email);
}
