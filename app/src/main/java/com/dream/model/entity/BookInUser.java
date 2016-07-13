package com.dream.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Parcelable.
 *
 * @author 李君波
 * @version v1.0.0 2016-07-13 下午9:47.
 */
public class BookInUser implements Parcelable {

    private int userId;

    private String userName;

    private BookParcelable book;

    public BookInUser(int userId, String userName, BookParcelable book) {
        this.userId = userId;
        this.userName = userName;
        this.book = book;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public BookParcelable getBook() {
        return book;
    }

    public void setBook(BookParcelable book) {
        this.book = book;
    }

    protected BookInUser(Parcel in) {
        userId = in.readInt();
        userName = in.readString();
        book = in.readParcelable(BookParcelable.class.getClassLoader());
    }

    public static final Creator<BookInUser> CREATOR = new Creator<BookInUser>() {
        @Override
        public BookInUser createFromParcel(Parcel in) {
            return new BookInUser(in);
        }

        @Override
        public BookInUser[] newArray(int size) {
            return new BookInUser[size];
        }
    };

    /**
     * Describe the kinds of special objects contained in this Parcelable's
     * marshalled representation.
     *
     * @return a bitmask indicating the set of special object types marshalled
     * by the Parcelable.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeString(userName);
        dest.writeParcelable(book, flags);
    }

    @Override
    public String toString() {
        return "BookInUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", book=" + book +
                '}';
    }
}
