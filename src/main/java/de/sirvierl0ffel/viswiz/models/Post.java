package de.sirvierl0ffel.viswiz.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User user;
    private LocalDateTime dateTime;

}
