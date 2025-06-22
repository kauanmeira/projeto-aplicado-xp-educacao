package com.xp_educacao.projeto_aplicado.service.cliente;

import com.xp_educacao.projeto_aplicado.dto.TipoDocumento;
import com.xp_educacao.projeto_aplicado.exception.XpException;
import com.xp_educacao.projeto_aplicado.model.Cliente;
import com.xp_educacao.projeto_aplicado.repository.ClienteRepository;
import com.xp_educacao.projeto_aplicado.utils.DocumentoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new XpException(HttpStatus.BAD_REQUEST, "Cliente não encontrado: " + id));
    }

    @Override
    public List<Cliente> buscarPorNome(String nome) {
        return clienteRepository.findByNomeStartsWith(nome);
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        validarDocumento(cliente);
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        validarDocumento(cliente);
        return salvar(cliente);
    }

    @Override
    public Cliente buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    @Override
    public Cliente buscarPorDocumento(String documento) {
        return clienteRepository.findByDocumento(documento.trim().replaceAll("\\D", ""));
    }

    @Override
    public void excluir(Long id) {
        if (isNull(this.buscarPorId(id)))
            throw new XpException(HttpStatus.BAD_REQUEST, "Cliente não encontrado para o id: " + id);
        clienteRepository.deleteById(id);
    }

    @Override
    public Long buscarTotalDeRegistros() {
        return clienteRepository.countClientes();
    }

    public void validarDocumento(Cliente cliente) {
        String documento = cliente.getDocumento();
        TipoDocumento tipoDocumento = cliente.getTipoDocumento();

        if (nonNull(documento) && nonNull(tipoDocumento)) {
            documento = documento.trim().replaceAll("\\D", "");

            if (documento.length() != tipoDocumento.getTamanho()) {
                throw new XpException(HttpStatus.BAD_REQUEST,
                        String.format("Documento inválido para o tipo %s. Esperado %d dígitos, recebido %d: %s",
                                tipoDocumento.name(), tipoDocumento.getTamanho(), documento.length(), documento));
            }

            if (!DocumentoValidator.isValid(documento)) {
                throw new XpException(HttpStatus.BAD_REQUEST,
                        String.format("%s inválido: %s", tipoDocumento.name(), documento));
            }

            cliente.setDocumento(documento);
            return;
        }

        throw new XpException(HttpStatus.BAD_REQUEST, "Documento ou tipoDocumento não informados.");
    }
}