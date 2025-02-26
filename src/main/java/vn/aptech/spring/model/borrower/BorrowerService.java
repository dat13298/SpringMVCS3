package vn.aptech.spring.model.borrower;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BorrowerService {
    private final BorrowerRepository borrowerRepository;

    public void addBorrower(Borrower borrower) {
        borrowerRepository.save(borrower);
    }

    public Page<Borrower> findBorrowers(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize()
        );
        return borrowerRepository.findAll(pageRequest);
    }
}
