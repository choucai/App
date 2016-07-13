package com.dream.model.entity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Serializable.
 *
 * @author 李君波
 * @version v1.0.0 2016-07-13 下午9:04.
 */
public class BookSerializable implements Serializable {

    private static final long serialVersionUID = 1L;

    private int bookId;

    private String bookName;

    public BookSerializable(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 序列化过程
        BookSerializable bookSerializable = new BookSerializable(110, "百年孤独");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("book.txt"));
        out.writeObject(bookSerializable);
        out.close();

        // 反序列化过程
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("book.txt"));
        BookSerializable newBookSerializable = (BookSerializable) in.readObject();
        in.close();
    }

}
