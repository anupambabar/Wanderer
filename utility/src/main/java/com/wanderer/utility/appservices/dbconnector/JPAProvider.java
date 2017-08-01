package com.wanderer.utility.appservices.dbconnector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.wanderer.utility.constants.AppConstants;
import com.wanderer.utility.utils.PropertyReaderUtil;

/**
 * 
 * @author anupam.babar
 */
public class JPAProvider {

	private static final EntityManagerFactory coreEntityManagerFactory;

	private JPAProvider() {
	}

	static {
		coreEntityManagerFactory = Persistence
				.createEntityManagerFactory(PropertyReaderUtil.getInstance().getValue(AppConstants.CORE_PERSISTENCE_UNIT));
	}

	public synchronized static EntityManager getCoreEntityManager() {
		return coreEntityManagerFactory.createEntityManager();
	}

	/**
	 * used to close the factory
	 */
	public static void close() {
		coreEntityManagerFactory.close();
	}
}
