package in.kce.book.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import in.kce.book.bean.BookBean;
import in.kce.book.service.Administrator;

@WebServlet("/viewBook")
public class ViewServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String isbn = request.getParameter("isbn");
        Administrator admin = new Administrator();
        BookBean book = admin.viewbook(isbn);

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        if (book == null) {
            out.print("<h2>No Book Found</h2>");
            return;
        }

        out.print("<h2>Book Details</h2>");
        out.print("Book Title: " + book.getBookName() + "<br>");
        out.print("Author: " + book.getAuthor().getAuthorName() + "<br>");
        out.print("Contact: " + book.getAuthor().getContactNo() + "<br>");
        out.print("Cost: " + book.getCost());
    }
}