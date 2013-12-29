package com.tl.myspring;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tl.myspring.model.Book;
import com.tl.myspring.model.BookRepository;

@Controller
@RequestMapping("/book")
public class BookController {
	
	protected static final int DEFAULT_PAGE_NUM = 0;
    protected static final int DEFAULT_PAGE_SIZE = 5;
    
    protected static final Logger LOGGER = LoggerFactory
            .getLogger(BookController.class);
	
	@Autowired
	BookRepository bookRepository;

	@RequestMapping(value = "/list")
    public String list(
            @RequestParam(value = "page", required = false) Integer page,
            Model model) {
        int pageNum = page != null ? page : DEFAULT_PAGE_NUM;
        Page<Book> paging = bookRepository.findAll(new PageRequest(pageNum, DEFAULT_PAGE_SIZE));
        model.addAttribute("page", paging);
        return "/book/list";
    }
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
    public @ModelAttribute
    Book create(Model model) {
		Book book = new Book();
		return book;
	}
	
	 @RequestMapping(value = "/form", method = RequestMethod.POST)
	    public String createOnSubmit(@Valid Book book,
	            BindingResult bindingResult, Model model) {
	        LOGGER.debug("create book={}", book);
	        if (bindingResult.hasErrors()) {
	            LOGGER.warn("validation error={}", bindingResult.getModel());
	            model.addAllAttributes(bindingResult.getModel());
	            return "/book/form";
	        }
	        bookRepository.save(book);
	        return "redirect:/book/list";
	    }

	    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Book book = bookRepository.findOne(id);
	        model.addAttribute(book);
	        return "/book/form";
	    }

	    @RequestMapping(value = "/edit", method = RequestMethod.POST)
	    public String editOnSubmit(@Valid Book book,
	            BindingResult bindingResult, Model model) {
	        LOGGER.debug("edit book={}", book);
	        if (bindingResult.hasErrors()) {
	            LOGGER.warn("validation error={}", bindingResult.getModel());
	            model.addAllAttributes(bindingResult.getModel());
	            return "/book/form";
	        }
	        bookRepository.save(book);
	        return "redirect:/book/list";
	    }

	    @RequestMapping(value = "/delete/{id}")
	    public String delete(
	            @RequestParam(value = "page", required = false) Integer page,
	            @PathVariable("id") Long id) {
	        LOGGER.debug("delete id={}", id);
	        bookRepository.delete(id);
	        return "redirect:/book/list";
	    }
}
