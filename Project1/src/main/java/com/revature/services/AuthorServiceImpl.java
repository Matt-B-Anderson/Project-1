package com.revature.services;

import com.revature.daos.AuthorDAO;
import com.revature.models.Author;

public class AuthorServiceImpl implements AuthorService {
	private AuthorDAO adao = new AuthorDAO();

	@Override
	public Author updateAuthor(Author a) {
		adao.uptate(a);
		return adao.getById(a.getId());
	}

	@Override
	public Author getAuthorById(Integer id) {
		return adao.getById(id);
	}

	@Override
	public Author getAuthor(String username, String password) {
		return adao.getByUsernamePassword(username, password);
	}

}
