package de.sirvierl0ffel.viswiz.controllers;

import de.sirvierl0ffel.viswiz.models.Algorithm;
import de.sirvierl0ffel.viswiz.respositories.AlgorithmRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AlgorithmController {


    private final AlgorithmRepository repo;

    public AlgorithmController(AlgorithmRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/algorithm/all")
    public List<Algorithm> all() {
        return repo.findAll();
    }

    @PostMapping("/algorithm/new")
    public long post(@RequestBody Algorithm algorithm) {
        Algorithm result = repo.save(algorithm);
        return result.id;
    }

    @DeleteMapping("/algorithms/delete/{id}")
    public String delete(@PathVariable long id) {
        repo.deleteById(id);
        return "Success";
    }

}
