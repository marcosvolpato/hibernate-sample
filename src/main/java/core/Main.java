package core;

import hibernate.SessionManager;
import models.dao.BookDao;

public class Main {

	public static void main(String[] args) {
		BookDao bookDao = new BookDao();
		bookDao.create();
		SessionManager.getInstance().exit();
	}

}
