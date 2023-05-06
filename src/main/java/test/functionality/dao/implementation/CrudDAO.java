package test.functionality.dao.implementation;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import test.util.ReflectionUtil;

public abstract class CrudDAO<T> {

	protected EntityManager em;
		
	public CrudDAO(EntityManager em) {
		this.em = em;
	}

	public  T create(T t) {
		em.persist(t);
		em.flush();
		return t;
	}

	public  T findById(Object id) {
		Class<T> type = retrieveEntityType();
		return em.find(type, id);
	}

	public void deleteById(Object id) {
		Class<T> type = retrieveEntityType();
		Object ref = em.getReference(type, id);	
		if (ref != null) {
			em.remove(ref);
		}
		
	}

	public  T update(T t) {
		t = em.merge(t);
		em.flush();
		return t;
	}

	protected List<T> findWithNamedQuery(String namedQueryName){
		Class<T> type = retrieveEntityType();
		return em.createNamedQuery(namedQueryName,type).getResultList();
	}

	protected List<T> findWithNamedQuery(String namedQueryName, Map<String,? super Object> parameters){
		return findWithNamedQuery(namedQueryName, parameters, 0);
	}

	protected List<T> findWithNamedQuery(String queryName, int resultLimit) {
		Class<T> type = retrieveEntityType();
		return em.createNamedQuery(queryName,type)
				.setMaxResults(resultLimit)
				.getResultList();    
	}

	/**
	 * 
	 * @param namedQueryName
	 * @param parameters
	 * @param resultLimit
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findWithNamedQuery(String namedQueryName, Map<String,? super Object> parameters, int resultLimit){
		Class<T> type = retrieveEntityType();
		Query query = em.createNamedQuery(namedQueryName,type);
		if(resultLimit > 0)
			query.setMaxResults(resultLimit);
		for (Entry<String,? super Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		return query.getResultList();
	}


	/**
	 * 
	 * @param namedQueryName
	 * @param parameters
	 */
	@SuppressWarnings("unchecked")
	protected T findWithNamedAndParamsQuery(String namedQueryName, Map<String,? super Object> parameters) throws NoResultException{
		Class<T> type = retrieveEntityType();
		Query query = em.createNamedQuery(namedQueryName,type);
		for (Entry<String,? super Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}

		return (T) query.getSingleResult();		
	}
	
	private Class<T> retrieveEntityType(){
		Class< ?> cls = getClass();
		Class<T> entityBeanType = ReflectionUtil.retrieveParameterizedType(cls);
		return entityBeanType;
	}
}