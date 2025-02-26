package vn.aptech.spring.model.borrower;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "borrowers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Borrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
}
