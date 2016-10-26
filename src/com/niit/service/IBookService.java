package com.niit.service;

import java.util.List;

import com.niit.po.Book;
import com.niit.po.BookExample;

/**
 *图书管理的service 
 * @author Allen
 *
 */
public interface IBookService {
	//图书列表
	public List<Book> findBooksList(BookExample bookExample)throws Exception;
	//图书查询列表
	public List<Book> findBooksListByName(String bookName)throws Exception;
	//图书查询(根据id)
	public Book selectByPrimaryKey(Integer id)throws Exception;
	//图书删除
	public int deleteByPrimaryKey(Integer id)throws Exception;
	//图书插入
	public int insertSelective(Book record)throws Exception;
	//图书更新
	public int updateByPrimaryKeySelective(Book record)throws Exception;
}
