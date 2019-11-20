package models.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.HibernateUtils;
import hibernate.SessionManager;
import models.Book;

public class BookDao {
	protected SessionFactory sessionFactory;

	public BookDao() {
		sessionFactory = SessionManager.getInstance().getSessionFactory();
	}
	
	public Book save(Book book) {
		boolean success = true;
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			
			// Se não existir um id, cria-se um novo registro, se existir atualiza o registro correspondente
			if (book.getId() == 0L)
				session.save(book);
			else
				session.update(book);

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			success = false;
		}
		session.close();
		
		return success ? book : null;
	}

	public Book find(long id) {
		Session session = sessionFactory.openSession();

		Book book = session.get(Book.class, id);

		session.close();
		return book;
	}
	
	public List<Book> findAll() {
		Session session = sessionFactory.openSession();
		List<Book> books = HibernateUtils.findAll(Book.class, session);
		session.close();
		return books;
	}
	
	public List<Book> moreExpensiveThan(float price) {
		Session session = sessionFactory.openSession();
		List<Book> books = HibernateUtils.greaterFloatThan(Book.class, session, "price", price);
		session.close();
		return books;
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
