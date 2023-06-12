package de.sirvierl0ffel.viswiz.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    private long id;
    private String name;

}
