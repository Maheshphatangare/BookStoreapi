package com.bs.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bs.entity.Book;
import com.bs.entity.MyBookList;
import com.bs.service.BookService;
import com.bs.service.MyBookListService;

import jakarta.validation.Valid;

import java.util.*;

@Controller
public class BookController {
	
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;
	// gating home page
	@GetMapping("/")
	public String home() {
		return "home";
	}
	//register
	@GetMapping("/book_register")
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String bookRegister( Book book) {
		//m.addAttribute("book",new Book());
		return "bookRegister";
	}
	//view books
	@GetMapping("/available_books")
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	public ModelAndView getAllBook() {
		List<Book>list=service.getAllBooks();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		
		return new ModelAndView("bookList","book",list);
	}
	//save book in db and return to @GetMapping ("/available_book")
	@PostMapping("/save")
	public String addPerson(@Valid @ModelAttribute Book book, BindingResult result, Model model) {
		  if (result.hasErrors()) {
		    return "bookRegister";
		  }
		  service.save(book);
		  return "redirect:/available_books";
		}
	// is not working
//	public String addBook(@Valid @ModelAttribute Book book,BindingResult br,Model m) {
//		boolean thereAreErrors=br.hasErrors();
//		if(thereAreErrors) {
//			m.addAttribute("book",book);
//		}
//		service.save(book);
//		return "redirect:/available_books";
//	}
	//is use to see my book that wehave  add to read
	@GetMapping("/my_books")
	public String getMyBooks(Model model)
	{
		List<MyBookList>list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}
	//select id will be save in another object  book to my booklist
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	
	//edit book and also prev data
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
	//delete
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
	
}