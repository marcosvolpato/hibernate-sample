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
	
	public Book create(Book book) {
		boolean success = true;
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			session.save(book);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			success = false;
		}
		session.close();
		
		return success ? book : null;
	}

	public Book read(long id) {
		Session session = sessionFactory.openSession();

		Book book = session.get(Book.class, id);

		session.close();
		return book;
	}

	public Book update(Book book) {
		
		boolean success = true;

		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();

			session.update(book);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			success = false;
		}
		session.close();
		
		return success ? book : null;
	}

	public boolean delete(long id) {
		Book book = new Book();
		book.setId(id);

		Session session = sessionFactory.openSession();
		boolean success = true;
		
		try {
			session.beginTransaction();

			session.delete(book);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			success = false;
		}
		session.close();
		return success;
	}
}
