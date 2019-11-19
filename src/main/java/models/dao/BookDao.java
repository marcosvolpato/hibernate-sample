package models.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.SessionManager;
import models.Book;

public class BookDao {
	protected SessionFactory sessionFactory;
	
	public BookDao() {
		sessionFactory = SessionManager.getInstance().getSessionFactory();
	}
	public void create() {
    	
    	Book book = new Book();
        book.setTitle("Java amateurs vol2");
        book.setAuthor("Marcos Vinicius Volpato");
        book.setPrice(32.59f);
        
    	Session session = sessionFactory.openSession();
    	session.beginTransaction();
    	
    	session.save(book);
    	
    	session.getTransaction().commit();
    	session.close();
    }
 
    public void read() {
    	Session session = sessionFactory.openSession();
    	 
        long bookId = 1;
        Book book = session.get(Book.class, bookId);
     
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Price: " + book.getPrice());
     
        session.close();
    }
 
    public void update() {
    	Book book = new Book();
        book.setId(1);
        book.setTitle("Ultimate Java Programming");
        book.setAuthor("Nam Ha Minh");
        book.setPrice(19.99f);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.update(book);
     
        session.getTransaction().commit();
        session.close();
    }
 
    public void delete() {
    	Book book = new Book();
        book.setId(1);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.delete(book);
     
        session.getTransaction().commit();
        session.close();
    }
}
