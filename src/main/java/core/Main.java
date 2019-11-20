package core;

import java.util.List;

import hibernate.SessionManager;
import models.Book;
import models.dao.BookDao;

public class Main {

	public static void main(String[] args) {
		
//		Book book = new Book();
//		book.setTitle("Java amateurs vol8");
//		book.setAuthor("José da Silva");
//		book.setPrice(55.45f);
//		
		BookDao bookDao = new BookDao();
//		if (bookDao.save(book) != null) {
//			System.out.println("Livro adicionado com sucesso!");
//		} else {
//			System.out.println("Erro ao adicionar livro!");
//		}
//		Book book = bookDao.find(8);
//		System.out.println(book == null);
//		System.out.println("Title: " + book.getTitle());
//		System.out.println("Author: " + book.getAuthor());
//		System.out.println("Price: " + book.getPrice());
//		
//		book.setPrice(102.85f);
//		Book bookUpdated = bookDao.save(book);
//		
//		System.out.println(bookUpdated == null);
//		System.out.println("Title: " + bookUpdated.getTitle());
//		System.out.println("Author: " + bookUpdated.getAuthor());
//		System.out.println("Price: " + bookUpdated.getPrice());
//		System.out.println("Deletado: " + bookDao.delete(6));
		
		List<Book> books = bookDao.moreExpensiveThan(40f);
		
		for (Book book : books) {
			System.out.println("Title: " + book.getTitle());
			System.out.println("Author: " + book.getAuthor());
			System.out.println("Price: " + book.getPrice());
			System.out.println("_____________________________");
		}
		
		SessionManager.getInstance().exit();
	}
}
