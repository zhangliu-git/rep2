package com.ssm.mapper;


import com.ssm.beans.BookCustom;

import com.ssm.beans.BookQueryVo;

import java.util.List;


public interface BookMapperCustom {
   
	//商品查询列表
	List<BookCustom> findBookList(BookQueryVo bookQueryVo) throws Exception;
}