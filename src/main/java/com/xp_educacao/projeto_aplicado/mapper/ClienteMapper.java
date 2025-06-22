package com.xp_educacao.projeto_aplicado.mapper;

import com.xp_educacao.projeto_aplicado.dto.ClienteDto;
import com.xp_educacao.projeto_aplicado.model.Cliente;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ClienteMapper {

    public Cliente toClienteEntity(ClienteDto clienteDto) {
        return Cliente.builder()
                .email(clienteDto.getEmail())
                .tipoDocumento(clienteDto.getTipoDocumento())
                .documento(clienteDto.getDocumento())
                .nome(clienteDto.getNome())
                .build();
    }

    public ClienteDto toClienteDto(Cliente cliente) {
        return ClienteDto.builder()
                .nome(cliente.getNome())
                .tipoDocumento(cliente.getTipoDocumento())
                .documento(cliente.getDocumento())
                .email(cliente.getEmail())
                .build();
    }

    public Cliente updateClienteFromDto(Cliente cliente, ClienteDto clienteDto) {
        if (Objects.isNull(cliente)){
            cliente = new Cliente();
        }

        cliente.setNome(clienteDto.getNome());
        cliente.setDocumento(clienteDto.getDocumento());
        cliente.setTipoDocumento(clienteDto.getTipoDocumento());
        cliente.setEmail(clienteDto.getEmail());
        return cliente;
    }
}
