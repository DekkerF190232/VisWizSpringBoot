package de.sirvierl0ffel.viswiz.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="TableUser")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
