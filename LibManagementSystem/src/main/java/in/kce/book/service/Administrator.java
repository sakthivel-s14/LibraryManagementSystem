package in.kce.book.service;

import in.kce.book.bean.BookBean;
import in.kce.book.dao.BookDAO;

public class Administrator {

    public String addBook(BookBean bookBean) {

        if (bookBean == null ||
            bookBean.getBookName() == null ||
            bookBean.getIsbn() == null ||
            bookBean.getAuthor() == null ||
            (bookBean.getBookType() != 'G' && bookBean.getBookType() != 'T') ||
            bookBean.getCost() <= 0) {
            return "Invalid";
        }

        BookDAO dao = new BookDAO();
        return dao.createBook(bookBean) == 1 ? "Success" : "Failure";
    }

    public BookBean viewbook(String isbn) {
        if (isbn == null || isbn.isEmpty()) return null;
        BookDAO dao = new BookDAO();
        return dao.fetchBook(isbn);
    }
}