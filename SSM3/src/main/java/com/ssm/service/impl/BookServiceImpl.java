package com.ssm.service.impl;

import java.util.List;

import com.ssm.exception.CustomException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.mapper.BookMapper;
import com.ssm.mapper.BookMapperCustom;
import com.ssm.beans.Book;
import com.ssm.beans.BookCustom;
import com.ssm.beans.BookQueryVo;
import com.ssm.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookMapperCustom bookMapperCustom;
	
	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public List<BookCustom> findBookList(BookQueryVo bookQueryVo)
			throws Exception {
		
		
		return bookMapperCustom.findBookList(bookQueryVo);
	}

	@Override
	public BookCustom findBookById(String bid) throws Exception {
		
		Book book = bookMapper.selectByPrimaryKey(bid);
		if(book ==null){
		    throw new CustomException("修改的商品不存在！");
        }
		//中间对商品信息进行业务处理
		BookCustom bookCustom = null;
		//将book里的属性拷贝到bookCustom
		if(book!=null){
			bookCustom = new BookCustom();
			BeanUtils.copyProperties(book, bookCustom);
		}
		//最终获取扩展类BookCustom
		return bookCustom;
	}

	@Override
	public void updateBook(String bid, BookCustom bookCustom) throws Exception {
		//添加业务校验，通常在service接口对关键参数进行校验
		//若id为空抛出异常

		//更新商品信息
		//updateByPrimaryKey要求必须传入id
		bookCustom.setBid(bid);
		bookMapper.updateByPrimaryKey(bookCustom);
	}

	
}
