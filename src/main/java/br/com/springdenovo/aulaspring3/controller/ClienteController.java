package br.com.springdenovo.aulaspring3.controller;

import br.com.springdenovo.aulaspring3.models.Cliente;
import br.com.springdenovo.aulaspring3.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository cr;

    @PostMapping
    public Cliente RetornarCliente(Cliente cliente) {


        cr.save(cliente);
        return cliente;
    }
    @GetMapping
    public Iterable<Cliente> ObterClientes(){

        return cr.findAll();    }

    @GetMapping(path = "/{id}")
    public Optional<Cliente> ObterClientePorID(@PathVariable int id){
        return cr.findById(id);
    }
    @PutMapping
    public Cliente AlterarCliente(Cliente cliente){
        cr.save(cliente);
        return cliente;
    }
    @DeleteMapping(path = "/{id}")
    public void ExcluirCliente(@PathVariable int id) {
        cr.deleteById(id);
    }
    @GetMapping(path = "/nome/{nomeParte}")
    public Iterable<Cliente> ObterClientePorNome(@PathVariable String nomeParte){
        return cr.findByNomeContaining(nomeParte);
    }
    @GetMapping(path = "/pagina/{numeroPagina}/{qtdPagina}")
    public Iterable<Cliente> ObterClientePorPagina(

            @PathVariable int numeroPagina,
            @PathVariable int qtdPagina
    ){
        Pageable paginas = PageRequest.of(numeroPagina, qtdPagina);
        return cr.findAll(paginas);
    }
}

