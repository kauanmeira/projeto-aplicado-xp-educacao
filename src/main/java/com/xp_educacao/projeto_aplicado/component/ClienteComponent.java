package com.xp_educacao.projeto_aplicado.component;

import com.xp_educacao.projeto_aplicado.dto.ClienteDto;
import com.xp_educacao.projeto_aplicado.mapper.ClienteMapper;
import com.xp_educacao.projeto_aplicado.service.cliente.ClienteService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteComponent {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;


    public ClienteComponent(ClienteService clienteService, ClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    public ClienteDto inserir(ClienteDto clienteDto) {
        return clienteMapper.toClienteDto(clienteService.salvar(clienteMapper.toClienteEntity(clienteDto)));
    }

    public void atualizar(Long clienteId, ClienteDto clienteDto) {
        clienteService.salvar(clienteMapper.updateClienteFromDto(clienteService.buscarPorId(clienteId), clienteDto));
    }

    public ClienteDto buscarPorId(Long clienteId) {
        return clienteMapper.toClienteDto(clienteService.buscarPorId(clienteId));
    }

    public List<ClienteDto> buscarPorNome(String nome) {
        return clienteService.buscarPorNome(nome).stream().map(clienteMapper::toClienteDto).toList();
    }

    public List<ClienteDto> listarTodos() {
        return clienteService.listarTodos().stream().map(clienteMapper::toClienteDto).toList();
    }

    public Long buscarQuantidadeClientes() {
        return clienteService.buscarTotalDeRegistros();
    }
}