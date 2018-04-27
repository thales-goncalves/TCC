package com.ia.web.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.ia.web.models.User;

@Repository
public class UserRepository implements UserDetailsService {

	private static Log LOGGER;

	@PersistenceContext
	private EntityManager entityManager;

	public List<User> findAllUsers() {

		return entityManager.createQuery("select user from User user", User.class).getResultList();
	}

	public User find(String login) {
		List<User> users = entityManager.createQuery("SELECT u FROM USER u WHERE u:login = :login", User.class)
				.setParameter("login", login).getResultList();

		if (users.isEmpty()) {
			throw new RuntimeException("Usuario nao encontrado");
		}

		return users.get(0);

	}

	public void saveUser(User user) {

		entityManager.merge(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException{

		final CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		final Root<User> groupRoot = criteriaQuery.from(User.class);

		criteriaQuery.select(groupRoot);
		criteriaQuery.where(builder.equal(groupRoot.get("login"), login));

		final TypedQuery<User> query = entityManager.createQuery(criteriaQuery);

		User user = null;

		try {
			user = query.getSingleResult();
		}

		catch (UsernameNotFoundException e) {

			LOGGER.error(e.getMessage(), e);
			throw new UsernameNotFoundException(login);
			// Ignore this because as per your logic this is ok!
		}

		return user;
	}

	
}
