package com.quiz.dao.mongoImpl;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quiz.dao.UserDAO;
import com.quiz.entity.User;

@Repository("userDAO")
public class UserDAOImpl extends BasicDAO<User, ObjectId> implements UserDAO {

	@Autowired
	public UserDAOImpl(Datastore dataStore) {
		super(User.class, dataStore);
	}

	public List<User> findAll() {
		return getDatastore().find(User.class).order("id").asList();
	}

	@Override
	public boolean saveOrUpdate(User user) {
		save(user);
		return true;
	}

	public boolean deleteEntity(User user) {
		delete(user);
		return true;
	}

	@Override
	public List<User> findByName(String name) {
		Query<User> q = getDatastore().createQuery(User.class).field("name").equal(name);
		return find(q).asList();
	}

}
