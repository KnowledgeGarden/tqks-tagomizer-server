/**
 * 
 */
package org.topicquests.ks.hypothesis;

import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.support.RootEnvironment;

/**
 * @author jackpark
 *
 */
public class HypViewerEnvironment extends RootEnvironment {
	private HypothesisController controller;
	private HypothesisDao dao = null;
	private PostgresConnectionFactory pgProvider;

	/**
	 * 
	 */
	public HypViewerEnvironment() {
		super("config-props.xml", "logger.properties");
		String dbname = getStringProperty("DatabaseName");
		String schema = getStringProperty("DatabaseSchema");
		pgProvider = new PostgresConnectionFactory(dbname, schema);

		dao = new HypothesisDao(this);
		controller = new HypothesisController(this);
	}

	public PostgresConnectionFactory getProvider() {
		return pgProvider;
	}
	
	public HypothesisController getController() {
		return controller;
	}
	public HypothesisDao getHypothesisDao() {
		return dao;
	}
	/* (non-Javadoc)
	 * @see org.topicquests.support.RootEnvironment#shutDown()
	 */
	@Override
	public void shutDown() {
		// TODO Auto-generated method stub

	}

}
