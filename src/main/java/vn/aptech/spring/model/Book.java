package vn.aptech.spring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, length = 100)
    private String author;
    @Column(name = "published_year", nullable = false)
    @Min(value = 1500, message = "Published year must be at least 1500")
    private Integer publishedYear;
    @Column(name = "copies_avaiable", nullable = false)
    @Min(value = 1, message = "Copies available must be more than 0")
    private Integer copiesAvailable;

}
