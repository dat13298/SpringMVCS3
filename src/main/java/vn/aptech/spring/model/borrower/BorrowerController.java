package vn.aptech.spring.model.borrower;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class BorrowerController {
    private final BorrowerService borrowerService;

    @GetMapping("/borrowers")
    public String borrowers(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Borrower> borrowers = borrowerService.findBorrowers(pageable);
        model.addAttribute("borrowers", borrowers);
        model.addAttribute("current", page);
        model.addAttribute("totalPages", borrowers.getTotalPages());
        return "borrowers";
    }

    @GetMapping("/borrowers/formAdd")
    public String formAdd(Model model) {
        model.addAttribute("borrower", new Borrower());
        return "borrowerFormAdd";
    }
}
