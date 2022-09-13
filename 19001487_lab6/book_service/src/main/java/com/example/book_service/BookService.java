package com.example.book_service;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/books")
public class BookService {
	List<Book> books;
	public BookService() {
		books = Books.getBooks();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBooks() {
		return books;
	}
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBook(@PathParam("id") int id) {
		  for(Book b : books) {
			  if ( b.getId() == id)
				   return b;
		  }
		  // book with the given id is not found, so throw 404 error
		  throw new NotFoundException(); 
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postBook(Book book) {
		books.add(book);
	}

	@Path("{id}")
	@DELETE
	public Book deleteBook(@PathParam("id") int id) {
		for(Book b : books) {
			if ( b.getId() == id){
				books.remove(b);
			}
		}
		// book with the given id is not found, so throw 404 error
		throw new NotFoundException();
	}
}