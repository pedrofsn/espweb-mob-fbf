package br.ufg.empresa.domain;

import java.util.List;

public interface Integravel<T> {

	T create(T t) throws Exception;

	List<T> readAll() throws Exception;

	T read(int i) throws Exception;

	T update(T t) throws Exception;

	boolean delete(int i) throws Exception;

}
