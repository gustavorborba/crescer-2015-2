package br.com.cwi.crescer.dao;

public interface IDao<T> {
	T findById(long id);
}
