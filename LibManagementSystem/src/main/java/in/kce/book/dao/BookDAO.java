package in.kce.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.kce.book.bean.AuthorBean;
import in.kce.book.bean.BookBean;
import in.kce.book.util.DBUtil;

public class BookDAO {

    public int createBook(BookBean bookBean) {
        String sql = "INSERT INTO Book_tbl (ISBN, Book_title, Book_type, Author_code, Book_cost) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection con = DBUtil.getDBConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            AuthorDAO authorDAO = new AuthorDAO();
            AuthorBean author = authorDAO.getAuthor(bookBean.getAuthor().getAuthorName());

            if (author == null) {
                return 0;
            }

            ps.setString(1, bookBean.getIsbn());
            ps.setString(2, bookBean.getBookName());
            ps.setString(3, String.valueOf(bookBean.getBookType()));
            ps.setInt(4, author.getAuthorCode());
            ps.setFloat(5, bookBean.getCost());

            ps.executeUpdate();
            con.close();
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public BookBean fetchBook(String isbn) {
        BookBean book = null;
        try {
            Connection con = DBUtil.getDBConnection();
            String sql = "SELECT * FROM Book_tbl WHERE ISBN = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, isbn);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                book = new BookBean();
                book.setIsbn(rs.getString("ISBN"));
                book.setBookName(rs.getString("Book_title"));
                book.setBookType(rs.getString("Book_type").charAt(0));
                book.setCost(rs.getFloat("Book_cost"));

                int authorCode = rs.getInt("Author_code");
                AuthorDAO authorDAO = new AuthorDAO();
                book.setAuthor(authorDAO.getAuthor(authorCode));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }
}