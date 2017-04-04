package br.com.webfinance.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.hibernate.collection.internal.AbstractPersistentCollection;

import br.com.webfinance.models.Entidade;

public class Util {

	@SuppressWarnings("rawtypes")
	public static Object objectClone(Object object,
			HashMap<Object, Object> cache) {

		Object clone = null;

		Collection listaAux = null;
		Entidade entityAux = null;

		try {

			clone = (Object) object.getClass().newInstance();

			cache.put(object, clone);

			BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
			PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();

			if (properties != null) {
				Method rMethod = null;
				Method wMethod = null;
				Object obj = null;

				for (int i = 0; i < properties.length; i++) {
					rMethod = properties[i].getReadMethod(); //get
					wMethod = properties[i].getWriteMethod(); //set

					if (rMethod != null && wMethod != null) {
						try {
							obj = rMethod.invoke(object);

							if (obj != null) {
								if (obj instanceof AbstractPersistentCollection) {
									if (((AbstractPersistentCollection) obj)
											.wasInitialized()) {
										listaAux = Util
												.collectionClone(
														(Collection) obj, cache);
										wMethod.invoke(clone, listaAux);
									}
								} else if (obj instanceof Collection) {
									listaAux = Util.collectionClone(
											(Collection) obj, cache);
									wMethod.invoke(clone, listaAux);
								} else if (obj instanceof Entidade) {
									entityAux = (Entidade) obj;
									// se o objeto é o proprio filho(recursividade infinita)
									if (object == entityAux) {
										Entidade o = (Entidade) object
												.getClass().newInstance();
										o.setId(entityAux.getId());
										wMethod.invoke(clone, o);
									} else {
										wMethod.invoke(clone, Util
												.objectClone(entityAux, cache));
									}
								} else {
									wMethod.invoke(clone, obj);
								}
							}

						} catch (Exception e) {

						}
					}
				}
			}

		} catch (Exception e) {

		}

		return clone;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Collection collectionClone(Collection lista,
			HashMap<Object, Object> cache) {
		Collection clone = null;
		try {
			clone = new ArrayList();
		} catch (Throwable e) {
			
		}

		for (Object item : lista) {
			clone.add(objectClone(item, cache));
		}
		
		return clone;
	}

	/*
	@SuppressWarnings("unchecked")
	public static List<Object> listClone(List<Object> list) {
		
		Object obj = null;
		Map<Object, Object> map = null;
		
		@SuppressWarnings("rawtypes")
		List listaAux = new ArrayList();
		
		try {

			BeanInfo binfo = Introspector.getBeanInfo(list.get(0).getClass());
			PropertyDescriptor[] properties = binfo.getPropertyDescriptors();
			
			for(int i = 0; i < list.size(); i++){
				if(list.get(i) instanceof Entidade){
					System.out.println("class: " + 1 + " : " + list.get(i).getClass().getName());
				}
			}
			
			if (properties != null) {
				Method readMethod = null;
				Method writeMethod = null;

				for (Object objeto : list) {
					
					map = new HashMap<Object, Object>();
					
					for (int i = 0; i < properties.length; i++) {
						readMethod = properties[i].getReadMethod();
						writeMethod = properties[i].getWriteMethod();

						if (readMethod != null && writeMethod != null) {
							obj = readMethod.invoke(objeto);
							
							if (obj != null) {
								if(obj instanceof Entidade){
									System.out.println("aqui porra");
								}else{
									map.put(properties[i].getName(), obj.toString());
								}
							}
						}
					}
					
					listaAux.add(map);
				}
			}

		} catch(Exception e){
			e.printStackTrace();
		}
		
		return listaAux;
	}
	*/
}
