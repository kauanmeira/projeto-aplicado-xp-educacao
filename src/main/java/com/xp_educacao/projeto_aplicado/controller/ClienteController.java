package com.xp_educacao.projeto_aplicado.controller;

import com.xp_educacao.projeto_aplicado.component.ClienteComponent;
import com.xp_educacao.projeto_aplicado.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteComponent clienteComponent;

    @Autowired
    public ClienteController(ClienteComponent clienteComponent) {
        this.clienteComponent = clienteComponent;
    }


    @PostMapping
    public ClienteDto inserir(@RequestBody ClienteDto clienteDto) {
        return clienteComponent.inserir(clienteDto);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable("id") Long id, @RequestBody ClienteDto clienteDto) {
        clienteComponent.atualizar(id, clienteDto);
    }

    @GetMapping("/{id}")
    public ClienteDto buscarPorId(@PathVariable("id") Long id) {
        return clienteComponent.buscarPorId(id);
    }

    @GetMapping("/buscar-por-nome")
    public List<ClienteDto> buscarPorNome(@RequestParam("nome") String nome) {
        return clienteComponent.buscarPorNome(nome);
    }

    @GetMapping
    public List<ClienteDto> buscarTodos() {
        return clienteComponent.listarTodos();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        clienteComponent.excluir(id);
    }

    @GetMapping("/quantidade")
    public Long buscarQuantidadeClientes(){
        return clienteComponent.buscarQuantidadeClientes();
    }
}