package in.kce.book.servlets;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import in.kce.book.bean.AuthorBean;
import in.kce.book.bean.BookBean;
import in.kce.book.service.Administrator;

@WebServlet("/addBook")
public class MainServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        BookBean bookBean = new BookBean();
        AuthorBean authorBean = new AuthorBean();

        bookBean.setIsbn(request.getParameter("isbn"));
        bookBean.setBookName(request.getParameter("bookName"));
        bookBean.setBookType(request.getParameter("bookType").charAt(0));
        bookBean.setCost(Float.parseFloat(request.getParameter("cost")));

        authorBean.setAuthorName(request.getParameter("author"));
        bookBean.setAuthor(authorBean);

        Administrator admin = new Administrator();
        String result = admin.addBook(bookBean);

        if (result.equals("Success")) {
            response.sendRedirect("NewFile.html");
        } else if (result.equals("Invalid")) {
            response.sendRedirect("invalid.html");
        } else {
            response.sendRedirect("failure.html");
        }
    }
}