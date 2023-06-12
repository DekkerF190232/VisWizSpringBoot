package de.sirvierl0ffel.viswiz.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@Entity
public class Algorithm {

    @Id
    public long id;
    private String name;
    private String description;
    private String imageLocation;
    private String code;
    private String pseudoCode;
    private String defaultInput;

    @OneToOne
    private Post post;

}
