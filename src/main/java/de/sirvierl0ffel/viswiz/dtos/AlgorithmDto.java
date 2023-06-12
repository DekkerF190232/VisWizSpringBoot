package de.sirvierl0ffel.viswiz.dtos;

import de.sirvierl0ffel.viswiz.models.Post;
import lombok.Data;

@Data
public class AlgorithmDto {
    
    private long id;
    private String name;
    private String description;
    private String imageLocation;
    private String code;
    private String[] pseudoCode;
    private InputDto defaultInput;
    private Post post;

}
