/*
 * Copyright 2019 TopicQuests
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.topicquests.ks.tagomizer.hypothesis;

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
		super("config-props.xml");
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
