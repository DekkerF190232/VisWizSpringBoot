package de.sirvierl0ffel.viswiz.controllers;

import de.sirvierl0ffel.viswiz.dtos.AlgorithmDto;
import de.sirvierl0ffel.viswiz.dtos.InputDto;
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

    private AlgorithmDto algorithmToDto(Algorithm algorithm) {
        AlgorithmDto algorithmDto = new AlgorithmDto();
        algorithmDto.setId(algorithm.getId());
        algorithmDto.setName(algorithm.getName());
        algorithmDto.setDefaultInput(new InputDto(algorithm.getDefaultInput()));
        algorithmDto.setDescription(algorithm.getDescription());
        algorithmDto.setPseudoCode(algorithm.getPseudoCode().split("\n"));
        algorithmDto.setImageLocation(algorithm.getImageLocation());
        algorithmDto.setCode(algorithm.getCode());
        return algorithmDto;
    }

    private Algorithm toAlgorithm(AlgorithmDto algorithmDto) {
        Algorithm algorithm = new Algorithm();
        algorithm.setName(algorithmDto.getName());
        algorithm.setDescription(algorithmDto.getDescription());
        algorithm.setImageLocation(algorithmDto.getImageLocation());
        algorithm.setDefaultInput(algorithmDto.getDefaultInput().getInput());
        algorithm.setPseudoCode(String.join("\n", algorithmDto.getPseudoCode()));
        algorithm.setCode(algorithmDto.getCode());
        return algorithm;
    }

    @GetMapping("/algorithm/all")
    public List<AlgorithmDto> all() {
        return repo.findAll().stream().map(this::algorithmToDto).toList();
    }

    @PostMapping("/algorithm/new")
    public long post(@RequestBody AlgorithmDto algorithm) {
        if (algorithm.getName() == null
                || algorithm.getDescription() == null
                || algorithm.getDefaultInput() == null
                || algorithm.getDefaultInput().getInput() == null
                || algorithm.getCode() == null
                || algorithm.getPseudoCode() == null
                || algorithm.getImageLocation() == null) {
            throw new BadRequestException();
        }
        Algorithm result = repo.save(toAlgorithm(algorithm));
        return result.id;
    }

    @DeleteMapping("/algorithm/delete/{id}")
    public String delete(@PathVariable long id) {
        Algorithm algorithm = repo.findById(id).orElse(null);
        if (algorithm == null) throw new NotFoundException();
        repo.delete(algorithm);
        return algorithm.getName();
    }

}
