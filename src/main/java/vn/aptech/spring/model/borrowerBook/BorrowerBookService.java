package vn.aptech.spring.model.borrowerBook;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BorrowerBookService {
    private final BorrowerBookRepository borrowerBookRepository;

    public Page<BorrowerBook> findAll(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by("borrow_date").descending());
        return borrowerBookRepository.findAll(pageRequest);
    }

    public void save(BorrowerBook borrowerBook) {
        borrowerBookRepository.save(borrowerBook);
    }
}
