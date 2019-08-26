package com.ssm.service;

import java.util.List;

import com.ssm.beans.BookCustom;
import com.ssm.beans.BookQueryVo;

/**
 * 商品的service
 * @author Administrator
 *
 */
public interface BookService {

	//商品查询列表
	List<BookCustom> findBookList(BookQueryVo bookQueryVo) throws Exception;
	
	//根据id查询商品信息
	BookCustom findBookById(String bid) throws Exception;
	
	//修改商品信息
	/**
	 * 
	 * @param bid 要修改的商品id
	 * @param bookCustom 修改的商品信息
	 * @throws Exception
	 */
	void updateBook(String bid, BookCustom bookCustom) throws Exception;
}
