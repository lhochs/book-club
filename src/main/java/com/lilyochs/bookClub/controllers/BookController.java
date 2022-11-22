package com.lilyochs.bookClub.controllers;

//import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lilyochs.bookClub.models.Book;
import com.lilyochs.bookClub.models.LoginUser;
import com.lilyochs.bookClub.models.User;
import com.lilyochs.bookClub.services.BookService;
import com.lilyochs.bookClub.services.UserService;

@Controller
public class BookController {

	@Autowired
	private UserService userService;
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
			User user = userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/books";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
			User user = userService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/books";
	}
	
	@GetMapping("/books")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
		model.addAttribute("books", bookService.allBooks());
		return "dashboard.jsp";
	}
	
	@GetMapping("/books/new")
	public String add(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		User user = userService.findById((Long)session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "add.jsp";
	}
	
	@PostMapping("/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result){
		if (result.hasErrors()) {
			return "add.jsp";
		}
			bookService.createBook(book);
			return "redirect:/books";
	}
	
	@GetMapping("/books/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }
	
	
	@PutMapping("/books/{id}")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
			bookService.updateBook(book);
			return "redirect:/books";
	}
	
	
	@DeleteMapping("/books/{id}")
	public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
	}
	
	@GetMapping("/books/{id}")
    public String show(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
        return "show.jsp";
    }
	
	
	@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.setAttribute("userId", null);
		return "redirect:/";
		}
}
