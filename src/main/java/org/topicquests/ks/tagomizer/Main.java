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
package org.topicquests.ks.tagomizer;

import static io.javalin.apibuilder.ApiBuilder.before;
import static io.javalin.apibuilder.ApiBuilder.get;

import org.topicquests.ks.backside.javalin.Server;
import org.topicquests.ks.tagomizer.hypothesis.HypViewerEnvironment;
import org.topicquests.ks.tagomizer.hypothesis.HypothesisController;
import org.topicquests.ks.tagomizer.util.Path;
import org.topicquests.ks.tagomizer.util.ViewUtil;

import io.javalin.Javalin;

/**
 * @author jackpark
 *
 */
public class Main extends Server {
	private HypViewerEnvironment environment;
	private HypothesisController hypController;
	/**
	 * 
	 */
	public Main() {
		environment = new HypViewerEnvironment();
		hypController = environment.getController();
		app.error(404, ViewUtil.notFound);
		setRoutes(app);
	}

	/* (non-Javadoc)
	 * @see org.topicquests.ks.backside.javalin.Server#setRoutes(io.javalin.Javalin)
	 */
	@Override
	public void setRoutes(Javalin app) {
        app.routes(() -> {
            //before(Filters.handleLocaleChange);
            get(Path.Web.HYP, hypController.handleGetAll);
            get(Path.Web.HYP_ONE_R, hypController.handleGetOneResource);
            get(Path.Web.HYP_ONE_T, hypController.handleGetOneTag);
            get(Path.Web.HYP_ONE_U, hypController.handleGetOneUser);
            get(Path.Web.HYP_TEXT, hypController.handleGetText);
            get(Path.Web.HYP_RESOURCES, hypController.handleGetResources);
            get(Path.Web.HYP_USERS, hypController.handleGetUsers);
            get(Path.Web.HYP_TAGS, hypController.handleGetTags);
            get(Path.Web.HYP_GROUPS, hypController.handleGetGroups);
            get(Path.Web.HYP_TRIPLES, hypController.handleGetTriples);
            get(Path.Web.HYP_TAG_PIV, hypController.handleGetTagPivot);
            get(Path.Web.HYP_USR_PIV, hypController.handleGetUserPivot);
            get(Path.Web.HYP_RES_PIV, hypController.handleGetResourcePivot);
            get(Path.Web.HYP_GRP_PIV, hypController.handleGetGroupPivot);
            get(Path.Web.HYP_RES_BY_USR, hypController.handleGetResourcesByUser);
            get(Path.Web.HYP_RES_BY_TAG, hypController.handleGetResourcesByTag);
            get(Path.Web.HYP_RES_BY_GRP, hypController.handleGetResourcesByGroup);
            get(Path.Web.HYP_TAG_BY_USR, hypController.handleGetTagsByUser);
            get(Path.Web.HYP_TAG_BY_RES, hypController.handleGetTagsByResource);
            get(Path.Web.HYP_TAG_BY_GRP, hypController.handleGetTagsByGroup);
            get(Path.Web.HYP_GRP_BY_USR, hypController.handleGetGroupsByUser);
            get(Path.Web.HYP_GRP_BY_TAG, hypController.handleGetGroupsByTag);
            get(Path.Web.HYP_GRP_BY_RES, hypController.handleGetGroupsByResource);
            get(Path.Web.HYP_USR_BY_RES, hypController.handleGetUsersByResource);
            get(Path.Web.HYP_USR_BY_TAG, hypController.handleGetUsersByTag);
            get(Path.Web.HYP_USR_BY_GRP, hypController.handleGetUsersByGroup);

            //get(Path.Web.HYP_PIV_2, hypController.handleGetPivot2);
        });
    	app.error(404, ViewUtil.notFound);
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();
	}

}
