package com.niit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.mapper.BookMapper;
import com.niit.po.Book;
import com.niit.po.BookExample;
import com.niit.service.IBookService;

/**
 * 图书管理
 * 
 * @author Allen
 *
 */
public class BookServiceImpl implements IBookService {

	@Autowired
	private BookMapper BookMapper;

	@Override
	public List<Book> findBooksList(BookExample bookExample) throws Exception {
		// 通过BookMapper查询数据库
		return BookMapper.selectByExample(bookExample);
	}

	@Override
	public List<Book> findBooksListByName(String bookName) throws Exception {
		// TODO Auto-generated method stub
		if (null == bookName) {
			bookName = "";
		}
		return BookMapper.selectByBookName(bookName);
	}

	@Override
	public Book selectByPrimaryKey(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return BookMapper.selectByPrimaryKey(id);

	}

	@Override
	public int deleteByPrimaryKey(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return BookMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(Book record) throws Exception {
		// TODO Auto-generated method stub
		return BookMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Book record) throws Exception {
		// TODO Auto-generated method stub
		return BookMapper.updateByPrimaryKeySelective(record);
	}
}