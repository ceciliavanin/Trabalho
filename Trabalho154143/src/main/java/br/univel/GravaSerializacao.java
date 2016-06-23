package br.univel;

import java.io.File;

public interface GravaSerializacao<T>{
	
	public void gravar(T t, File file);
	
	public T ler(File file);

}
