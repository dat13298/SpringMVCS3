package vn.aptech.spring.model.borrowerBook;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.aptech.spring.model.borrower.Borrower;

@Controller
@RequiredArgsConstructor
public class BorrowerBookController {
    private final BorrowerBookService borrowerBookService;

    @GetMapping("/borrowerBooks")
    public String borrowerBooks(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BorrowerBook> borrowerBooks = borrowerBookService.findAll(pageable);
        model.addAttribute("borrowerBooks", borrowerBooks);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", borrowerBooks.getTotalPages());
        return "borrowerBooks";

    }
}
