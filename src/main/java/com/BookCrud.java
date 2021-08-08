package com;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.BookBean;

public class BookCrud {

	public static void main(String[] args) {
		int ch = -1;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = null;
		Scanner sc = new Scanner(System.in);
		String name, author;
		int bookId, price, quantity;
		Transaction tx = null;
		while (true) {
			System.out.println(
					"\n0 for Exit\n1 For AddBook\n2 For List All Books\n3 For Delete Book By Id\n4 For Get Book Detail By Id");
			System.out.println("\n5 For Update book\n6 for SearchBook By Name\nEnter Choice");
			ch = sc.nextInt();

			switch (ch) {
			case 0:
				System.exit(0);
				break;

			case 1:
				System.out.println("Enter Book Name : ");
				name = sc.next();
				System.out.println("Enter Book Author : ");
				author = sc.next();
				System.out.println("Enter Book Price : ");
				price = sc.nextInt();
				System.out.println("Enter Book Quantity : ");
				quantity = sc.nextInt();

				BookBean book = new BookBean();
				book.setName(name);
				book.setAuthor(author);
				book.setPrice(price);
				book.setQuantity(quantity);

				session = sf.openSession();
				tx = session.beginTransaction();
				try {
					session.save(book);
					tx.commit();
				} catch (Exception e) {
					// TODO: handle exception
					tx.rollback();
				} finally {
					session.close();
				}
				break;

			case 2:
				session = sf.openSession();
				List<BookBean> books = session.createQuery("from BookBean", BookBean.class).getResultList();

				for (BookBean bean : books) {
					System.out.println(bean.getBookId() + " " + bean.getName() + " " + bean.getAuthor() + " "
							+ bean.getPrice() + " " + bean.getQuantity());
				}

				session.close();
				break;

			case 3:
				System.out.println("Enter a Book ID");
				bookId = sc.nextInt();
				session = sf.openSession();
				tx = session.beginTransaction();
				book = session.get(BookBean.class, bookId);
				session.delete(book);

				tx.commit();
				session.close();
				break;

			case 4:
				System.out.println("Enter BookId :  ");
				bookId = sc.nextInt();
				session = sf.openSession();
				book = session.get(BookBean.class, bookId);
				System.out.println(book.getBookId() + " " + book.getName() + " " + book.getAuthor() + " "
						+ book.getPrice() + " " + book.getQuantity());
				break;

			case 5:
				System.out.println("which Book you want to update please enter bookid");
				bookId = sc.nextInt();
				session = sf.openSession();
				try {
					book = session.get(BookBean.class, bookId);

					if (book == null) {
						System.out.println("Invalid Book ID");
					} else {

						System.out.println("oldName :- " + book.getName());
						System.out.println("Do you want to update book name? Press 1 for Yes");
						int choice = sc.nextInt();

						if (choice == 1) {
							System.out.println("Enter new Author Name: ");
							String newAuthorName = sc.next();
							book.setAuthor(newAuthorName);
						}

						tx = session.beginTransaction();
						session.save(book);
						tx.commit();
						session.close();
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Something Went Wrong.....");
					System.out.println(e.getMessage());
					e.printStackTrace();
				}

				break;

			default:
				System.out.println("\nInvalid choice try again!!!");
				break;

			}
		}

	}

}
