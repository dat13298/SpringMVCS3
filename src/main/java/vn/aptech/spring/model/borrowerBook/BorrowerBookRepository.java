package vn.aptech.spring.model.borrowerBook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerBookRepository extends JpaRepository<BorrowerBook, Integer> {

}
