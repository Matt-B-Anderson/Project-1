package com.revature.daos;

import java.util.List;

public interface GenericDAO<T> {

	public T add(T t);

	public T getById(Integer id);

	public List<T> getall();

	public void uptate(T t);

	public boolean delete(T t);

	public T add(T t, Integer id);

}
