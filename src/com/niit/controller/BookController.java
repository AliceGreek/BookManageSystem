package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.po.Book;
import com.niit.po.User;
import com.niit.service.IBookService;

/**
 * 图书的Controller
 * 
 * @author Allen
 *
 */
@RequestMapping(value = "/book")
@Controller
public class BookController extends BaseController {

	@Autowired
	private IBookService bookService;
	// @Autowired
	// private BookExample bookExample;

	// 图书列表
	@RequestMapping(value = "/bookList")
	public ModelAndView listBook() throws Exception {
		ModelAndView modelAndView = this.getModelAndView();
		User user = this.getUser();
		if (null == user) {
			modelAndView.addObject("from",getRequest().getHeader("Referer"));
			modelAndView.setViewName("redirect:/login/login.html");
			return modelAndView;
		}
		List<Book> bookList = bookService.findBooksList(null);
		modelAndView.addObject("bookList", bookList);
		modelAndView.setViewName("book/bookList");
		return modelAndView;
	}

	// 图书查询
	@RequestMapping(value = "/bookQuery")
	public ModelAndView queryBook(String bookName) throws Exception {
		ModelAndView modelAndView = this.getModelAndView();
		User user = this.getUser();
		if (null == user) {
			modelAndView.addObject("from",getRequest().getHeader("Referer"));
			modelAndView.setViewName("redirect:/login/login.html");
			return modelAndView;
		}
		List<Book> findBooksListByName = bookService.findBooksListByName(bookName);
		modelAndView.addObject("searchContent", bookName);
		modelAndView.addObject("bookList", findBooksListByName);
		modelAndView.setViewName("book/bookList");
		return modelAndView;
	}

	// 新增图书页面
	@RequestMapping(value = "/goAdd")
	public ModelAndView goAdd() throws Exception {
		ModelAndView modelAndView = this.getModelAndView();
		User user = this.getUser();
		if (null == user) {
			modelAndView.addObject("from",getRequest().getHeader("Referer"));
			modelAndView.setViewName("redirect:/login/login.html");
			return modelAndView;
		}
		modelAndView.addObject("formTitle", "添加");
		modelAndView.setViewName("book/bookEdit");
		return modelAndView;
	}

	// 修改图书页面
	@RequestMapping(value = "/bookEdit-{id}")

	public ModelAndView editBook(@PathVariable Integer id) throws Exception {
		ModelAndView modelAndView = this.getModelAndView();
		User user = this.getUser();
		if (null == user) {
			modelAndView.addObject("from",getRequest().getHeader("Referer"));
			modelAndView.setViewName("redirect:/login/login.html");
			return modelAndView;
		}
		Book selectByPrimaryKey = bookService.selectByPrimaryKey(id);
		modelAndView.addObject("selectByPrimaryKey", selectByPrimaryKey);
		modelAndView.addObject("formTitle", "修改");
		modelAndView.setViewName("book/bookEdit");
		return modelAndView;
	}

	// 插入图书
	@RequestMapping(value = "/bookAdd")
	public ModelAndView addBook(Book book) throws Exception {
		ModelAndView modelAndView = this.getModelAndView();
		User user = this.getUser();
		if (null == user) {
			modelAndView.addObject("from",getRequest().getHeader("Referer"));
			modelAndView.setViewName("redirect:/login/login.html");
			return modelAndView;
		}
		if (null != book) {
			if (null == book.getId()) {
				bookService.insertSelective(book);
			} else {
				bookService.updateByPrimaryKeySelective(book);
			}
		}else{
			modelAndView.setViewName("redirect:/login/login.html");
			return modelAndView;
		}

		modelAndView.setViewName("redirect:bookList.action");
		return modelAndView;
	}

	// 删除图书
	@RequestMapping(value = "/bookDelete-{id}")
	public ModelAndView deleteBook(@PathVariable Integer id) throws Exception {
		ModelAndView modelAndView = this.getModelAndView();
		User user = this.getUser();
		if (null == user) {
			modelAndView.addObject("from",getRequest().getHeader("Referer"));
			modelAndView.setViewName("redirect:/login/login.html");
			return modelAndView;
		}
		bookService.deleteByPrimaryKey(id);
		modelAndView.setViewName("redirect:bookList.action");
		return modelAndView;
	}
}
