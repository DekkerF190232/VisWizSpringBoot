package de.sirvierl0ffel.viswiz.controllers;

import de.sirvierl0ffel.viswiz.models.Algorithm;
import de.sirvierl0ffel.viswiz.models.Post;
import de.sirvierl0ffel.viswiz.respositories.AlgorithmRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class AlgorithmController {


    private final AlgorithmRepository repo;

    public AlgorithmController(AlgorithmRepository repo) {
        this.repo = repo;
    }

    @GetMapping("all")
    public List<Algorithm> all() {
        return repo.findAll();
    }

}
