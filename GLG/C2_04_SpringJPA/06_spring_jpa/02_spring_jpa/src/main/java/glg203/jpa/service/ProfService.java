package glg203.jpa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import glg203.jpa.model.Prof;
import glg203.jpa.repositories.ProfRepository;

/**
 * ProfService
 */
@Service
public class ProfService {

    private final ProfRepository repository;

    public ProfService(ProfRepository repository) {
        this.repository = repository;
    }

    public Long creerProf(String nom, String prenom) {
        Prof p = new Prof(nom, prenom);
        repository.save(p);
        return p.getProfId();
    }

    public Optional<Prof> find(Long id) {
        return repository.findById(id);    
    }

    public List<Prof> findAll() {
        // La méthode de repository renvoie un Iterable.
        return StreamSupport.stream(
            repository.findAll().spliterator(), false)
            .collect(Collectors.toList())
            ;
    }

}