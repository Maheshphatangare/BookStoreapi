package com.bs.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bs.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>  {

}
