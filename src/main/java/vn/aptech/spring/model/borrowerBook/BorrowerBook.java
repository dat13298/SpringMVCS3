package vn.aptech.spring.model.borrowerBook;

import jakarta.persistence.*;
import lombok.*;
import vn.aptech.spring.model.book.Book;
import vn.aptech.spring.model.borrower.Borrower;

import java.util.Date;

@Entity
@Table(name = "borrowed_books")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BorrowerBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "borrow_date", nullable = false)
    private Date borrowedDate;

    @Column(name = "return_date", nullable = true)
    private Date returnDate;
}
