package com.quiz.dao;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.mapping.MappedClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testDBContext.xml")
public abstract class BaseDAOTest {
	
	private static final Logger logger = Logger.getLogger(BaseDAOTest.class);

	@Autowired
	private Morphia morphia;
	
	@Autowired
	private Datastore dataStore;
	
	@Before
	public void dropDB() {
		for (final MappedClass mc : this.morphia.getMapper().getMappedClasses()) {
			logger.debug("Collection name: " + mc.getCollectionName());
			this.dataStore.getCollection(mc.getClazz()).drop();
		}
		logger.info("All collections dropped...");
	}

}
