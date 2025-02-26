package vn.aptech.spring.model.book;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/books")
    public String products(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books = bookService.findAll(pageable);
        model.addAttribute("books", books);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", books.getTotalPages());
        return "books";
    }

    @GetMapping("/books/add-new")
    public String addNewForm(Model model) {
        model.addAttribute("book", new Book());
        return "addNewBook";
    }

    @GetMapping("/books/editBook/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("book", bookService.findOne(id));
        return "editBook";
    }

    @PostMapping("/books/add")
    public String addNew(@ModelAttribute Book book) {
        bookService.addNew(book);
        return "redirect:/books";
    }

    @PostMapping("/books/update")
    public String update(@ModelAttribute Book book) {
        Book existingBook = bookService.findOne(book.getId());

        if (existingBook == null) {
            return "redirect:/books?error=notFound";
        }

        bookService.update(book);
        return "redirect:/books";
    }
}
