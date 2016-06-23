package br.univel;


	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.Serializable;
	import java.lang.reflect.ParameterizedType;

	public class SerIMP<T> implements GravaSerializacao{
		
		public void gravar(Object t, File file){
							
			try(FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(t);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
			
		

		@SuppressWarnings("unchecked")
		@Override
		public T ler(File file) {
			try(FileInputStream fis = new FileInputStream(file);
					ObjectInputStream ois = new ObjectInputStream(fis)){
				
				Object object = ois.readObject();
				
				Class<?> clGenType = (Class<?>)((ParameterizedType) getClass()
						.getGenericSuperclass())
						.getActualTypeArguments()[0];
				
				if(!object.getClass().equals(clGenType)){
					System.out.println("tá fueda man");
				}
				
				return (T) object;
				
				}catch(Exception e){
					System.out.println("Chame o batman! HOHOHO");;
			}
			return null;
		}
		

	}



