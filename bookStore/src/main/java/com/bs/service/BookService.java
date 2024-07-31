//package com.bs.service;
//
//
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.bs.entity.Book;
//import com.bs.repository.BookRepository;
//
//@Service
//public class BookService {
//	
//	@Autowired
//	private BookRepository bRepo;
//	
//	public void save(Book b) {
//		bRepo.save(b);
//	}
//	
//	public List<Book> getAllBook(){
//		return bRepo.findAll();
//	}
//	
//	public Book getBookById(int id) {
//		return bRepo.findById(id).get();
//	}
//	public void deleteById(int id) {
//		bRepo.deleteById(id);
//	}
//}
package com.bs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.entity.Book;
import com.bs.repository.BookRepository;

@Service
public class BookService implements BookServiceinterface {
    
    @Autowired
    private BookRepository bRepo;
    
    @Override
    public void save(Book b) {
        bRepo.save(b);
    }
    
    @Override
    public List<Book> getAllBooks() {
        return bRepo.findAll();
    }
    
    @Override
    public Book getBookById(int id) {
        return bRepo.findById(id).orElse(null);
    }
    
    @Override
    public void deleteById(int id) {
        bRepo.deleteById(id);
    }
}
