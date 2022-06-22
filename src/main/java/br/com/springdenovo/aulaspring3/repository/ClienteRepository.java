package br.com.springdenovo.aulaspring3.repository;

import br.com.springdenovo.aulaspring3.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer> {

    public Iterable<Cliente> findByNomeContaining(String nomeParte);
}
