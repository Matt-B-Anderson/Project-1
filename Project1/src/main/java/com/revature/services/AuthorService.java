package com.revature.services;

import com.revature.models.Author;

public interface AuthorService {

	public Author getAuthorById(Integer id);

	public Author getAuthor(String username, String password);

	public Author updateAuthor(Author a);

}
