package com.dream.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Parcelable.
 *
 * @author 李君波
 * @version v1.0.0 2016-07-13 下午9:04.
 */
public class BookParcelable implements Parcelable {

    private int bookId;

    private String bookName;

    public BookParcelable(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    protected BookParcelable(Parcel in) {
        bookId = in.readInt();
        bookName = in.readString();
    }


    public static final Creator<BookParcelable> CREATOR = new Creator<BookParcelable>() {
        @Override
        public BookParcelable createFromParcel(Parcel in) {
            return new BookParcelable(in);
        }

        @Override
        public BookParcelable[] newArray(int size) {
            return new BookParcelable[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookId);
        dest.writeString(bookName);
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

    @Override
    public String toString() {
        return "BookParcelable{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
