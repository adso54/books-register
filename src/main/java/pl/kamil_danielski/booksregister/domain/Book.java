package pl.kamil_danielski.booksregister.domain;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    private Author author;
}
