package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooksData() {

        List<Book> books = jdbcTemplate.query("SELECT b.id, b.bookId, b.title, b.priceOld, b.price, a.author as author  FROM books b " +
                "LEFT JOIN authors a ON a.bookId = b.bookId", (ResultSet rs, int rownum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setBookId(rs.getInt("bookId"));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getDouble("priceOld"));
            book.setPrice(rs.getDouble("price"));
            book.setAuthor(rs.getString("author"));
            return book;
        });
        return new ArrayList<>(books);
    }

    public List<Author> getAuthorsData() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int rownum) -> {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setAuthor(rs.getString("author"));
            return author;
        });
        List<Author> result = new ArrayList<>(authors);
        result.sort(Comparator.comparing(Author::getAuthor));
        return result;
    }

}
