package com.xp_educacao.projeto_aplicado.component;

import com.xp_educacao.projeto_aplicado.dto.ClienteDto;
import com.xp_educacao.projeto_aplicado.exception.XpException;
import com.xp_educacao.projeto_aplicado.mapper.ClienteMapper;
import com.xp_educacao.projeto_aplicado.model.Cliente;
import com.xp_educacao.projeto_aplicado.service.cliente.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Component
public class ClienteComponent {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;


    public ClienteComponent(ClienteService clienteService, ClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    public ClienteDto inserir(ClienteDto clienteDto) {
        if (nonNull(clienteDto.getDocumento()) && nonNull(clienteService.buscarPorDocumento(clienteDto.getDocumento()))) {
            throw new XpException(HttpStatus.BAD_REQUEST, "Cliente já cadastrado para o documento: " + clienteDto.getDocumento());
        }

        if (nonNull(clienteDto.getEmail()) && nonNull(clienteService.buscarPorEmail(clienteDto.getEmail()))) {
            throw new XpException(HttpStatus.BAD_REQUEST, "Cliente já cadastrado para o email: " + clienteDto.getEmail());
        }

        return clienteMapper.toClienteDto(clienteService.salvar(clienteMapper.toClienteEntity(clienteDto)));
    }

    public void atualizar(Long clienteId, ClienteDto clienteDto) {
        Cliente cliente = clienteService.buscarPorId(clienteId);

        if (nonNull(clienteDto.getDocumento()) && !Objects.equals(clienteDto.getDocumento(), cliente.getDocumento()) &&
                nonNull(clienteService.buscarPorDocumento(clienteDto.getDocumento()))) {
            throw new XpException(HttpStatus.BAD_REQUEST, "Cliente já cadastrado para o documento: " + clienteDto.getDocumento());
        }

        if (nonNull(clienteDto.getEmail()) && !Objects.equals(clienteDto.getEmail(), cliente.getEmail()) &&
                nonNull(clienteService.buscarPorEmail(clienteDto.getEmail()))) {
            throw new XpException(HttpStatus.BAD_REQUEST, "Cliente já cadastrado para o email: " + clienteDto.getEmail());
        }


        clienteService.atualizar(clienteMapper.updateClienteFromDto(cliente, clienteDto));
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

    public void excluir(Long id) {
        clienteService.excluir(id);
    }

    public Long buscarQuantidadeClientes() {
        return clienteService.buscarTotalDeRegistros();
    }
}