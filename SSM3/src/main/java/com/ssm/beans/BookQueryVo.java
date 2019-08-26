package com.ssm.beans;

import java.util.List;

/**
 * 商品的包装对象
 * @author Administrator
 *
 */
public class BookQueryVo{

	//商品信息
	private Book book;
	//为了系统可扩展性，对原始生成的po进行扩展
	private BookCustom bookCustom;
	//
	private List<BookCustom> bookCustomList;

	public Book getBook() {
		return book;
	}

	public BookCustom getBookCustom() {
		return bookCustom;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setBookCustom(BookCustom bookCustom) {
		this.bookCustom = bookCustom;
	}

	public List<BookCustom> getBookCustomList() {
		return bookCustomList;
	}

	public void setBookCustomList(List<BookCustom> bookCustomList) {
		this.bookCustomList = bookCustomList;
	}
}
