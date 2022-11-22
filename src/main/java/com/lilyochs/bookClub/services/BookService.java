package com.lilyochs.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lilyochs.bookClub.models.Book;
import com.lilyochs.bookClub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
//	public BookService(BookRepository bookRepository) {
//		this.bookRepository = bookRepository;
	
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book findBook(Long id){
		Optional<Book> optionalBook = bookRepository.findById(id);
			if(optionalBook.isPresent()) {
				return optionalBook.get();
			}else {
				return null;
		}
	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	
	}
	
	public Book deleteBook(Long id){
		Optional<Book> optionalBook = bookRepository.findById(id);
			if(optionalBook.isPresent()) {
				bookRepository.deleteById(id);
			}
			return null;
	}
}

