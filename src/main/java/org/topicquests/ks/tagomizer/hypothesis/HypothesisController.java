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

import java.util.Map;

import org.topicquests.pg.api.IPostgresConnection;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

import io.javalin.http.Handler;
import java.util.*;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

/**
 * @author jackpark
 *
 */
public class HypothesisController {
	private HypViewerEnvironment environment;
	private HypothesisDao hypDao;
	/**
	 * 
	 */
	public HypothesisController(HypViewerEnvironment env) {
		environment = env;
		hypDao = environment.getHypothesisDao();
	}

	/////////////////////////
	// NOTE
	// Path Params are named in org.topicquests.ks.backside.javalin.util.Path.java
	////////////////////////
	/**
	 * get/:offset/:count
	 */
	public Handler handleGetAll = ctx -> {
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		
        List<JSONObject>hits = hypDao.getAllHits(offset, count);
        //ship JSON
        ctx.json(hits);
	};
	
	public Handler handleGetResources = ctx -> {
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		JSONArray hits = hypDao.getResources(offset, count);
        //ship JSON
        ctx.json(hits);
	};
	public Handler handleGetUsers = ctx -> {
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		environment.logDebug("GetUsers "+offset+" "+count+"\n"+hypDao);
        JSONArray hits = hypDao.getUsers(offset, count);
		environment.logDebug("GetUsers+ "+hits);
		         //ship JSON
        ctx.json(hits);
		
	};
	public Handler handleGetTags = ctx -> {
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		JSONArray hits = hypDao.getTags(offset, count);
        //ship JSON
        ctx.json(hits);
	};

	public Handler handleGetGroups = ctx -> {
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		JSONArray hits = hypDao.getGroups(offset, count);
        //ship JSON
        ctx.json(hits);
	};

	public Handler handleGetTagPivot = ctx -> {
		String id = ctx.pathParam("tag");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		JSONObject jo = hypDao.getTagPivot(id, offset, count);
		ctx.json(jo);
	};
	
	public Handler handleGetTriples = ctx -> {
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		int o = Integer.parseInt(offset);
		int c = Integer.parseInt(count);

		JSONArray jo = hypDao.getTriples(o, c);
		ctx.json(jo);
	};
	public Handler handleGetUserPivot = ctx -> {
		String id = ctx.pathParam("user");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		JSONObject jo = hypDao.getUserPivot(id, offset, count);
		ctx.json(jo);		
	};
	public Handler handleGetResourcePivot = ctx -> {
		String id = ctx.pathParam("resource");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		JSONObject jo = hypDao.getResourcePivot(id, offset, count);
		ctx.json(jo);
	};

	public Handler handleGetGroupPivot = ctx -> {
		String id = ctx.pathParam("group");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		JSONObject jo = hypDao.getGroupPivot(id, offset, count);
		ctx.json(jo);
	};

	public Handler handleGetResourcesByUser = ctx -> {
		String id = ctx.pathParam("user");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		int o = Integer.parseInt(offset);
		int c = Integer.parseInt(count);
		JSONArray hits = hypDao.getResourcesByUser(id, o, c);
		ctx.json(hits);		
	};
	
	public Handler handleGetResourcesByTag = ctx -> {
		String id = ctx.pathParam("tag");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		int o = Integer.parseInt(offset);
		int c = Integer.parseInt(count);
		JSONArray hits = hypDao.getResourcesByTag(id, o, c);
		ctx.json(hits);				
	};
	
	public Handler handleGetResourcesByGroup = ctx -> {
		String id = ctx.pathParam("group");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		int o = Integer.parseInt(offset);
		int c = Integer.parseInt(count);
		JSONArray hits = hypDao.getResourcesByGroup(id, o, c);
		ctx.json(hits);		
	};
	
	public Handler handleGetTagsByUser = ctx -> {
		String id = ctx.pathParam("user");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		int o = Integer.parseInt(offset);
		int c = Integer.parseInt(count);
		JSONArray hits = hypDao.getTagsByUser(id, o, c);
		ctx.json(hits);
	};
	
	public Handler handleGetTagsByResource = ctx -> {
		String id = ctx.pathParam("resource");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		int o = Integer.parseInt(offset);
		int c = Integer.parseInt(count);
		JSONArray hits = hypDao.getTagsByResource(id, o, c);
		ctx.json(hits);
	};
	
	public Handler handleGetTagsByGroup = ctx -> {
		String id = ctx.pathParam("group");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		int o = Integer.parseInt(offset);
		int c = Integer.parseInt(count);
		JSONArray hits = hypDao.getTagsByGroup(id, o, c);
		ctx.json(hits);						
	};
	
	public Handler handleGetUsersByTag = ctx -> {
		String id = ctx.pathParam("tag");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		int o = Integer.parseInt(offset);
		int c = Integer.parseInt(count);
		JSONArray hits = hypDao.getUsersByTag(id);
		ctx.json(hits);				
	};
	
	public Handler handleGetUsersByGroup = ctx -> {
		String id = ctx.pathParam("group");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		int o = Integer.parseInt(offset);
		int c = Integer.parseInt(count);
		JSONArray hits = hypDao.getUsersByGroup(id);
		ctx.json(hits);				
	};
	
	public Handler handleGetUsersByResource = ctx -> {
		String id = ctx.pathParam("resource");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		int o = Integer.parseInt(offset);
		int c = Integer.parseInt(count);
		JSONArray hits = hypDao.getUsersByResource(id);
		ctx.json(hits);		
	};
	
	public Handler handleGetGroupsByTag = ctx -> {
		String id = ctx.pathParam("tag");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		int o = Integer.parseInt(offset);
		int c = Integer.parseInt(count);
		JSONArray hits = hypDao.getGroupsByTag(id, o, c);
		ctx.json(hits);		
	};
	
	public Handler handleGetGroupsByUser = ctx -> {
		String id = ctx.pathParam("user");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		int o = Integer.parseInt(offset);
		int c = Integer.parseInt(count);
		JSONArray hits = hypDao.getGroupsByUser(id, o, c);
		ctx.json(hits);				
	};
	public Handler handleGetGroupsByResource = ctx -> {
		String id = ctx.pathParam("resource");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		int o = Integer.parseInt(offset);
		int c = Integer.parseInt(count);
		JSONArray hits = hypDao.getGroupsByResource(id, o, c);
		ctx.json(hits);		
	};

	
	
	
	
	/**
	 * get/:resource/:offset/:count  (for the pivots) 
	 */
	public Handler handleGetOneResource = ctx -> {
		//TODO
	};
	
	/**
	 * get/:tag:/:offset/:count  (for the pivots)
	 */
	public Handler handleGetOneTag = ctx -> {
		//TODO
	};
	
	/**
	 * get/:user/:offset/:count  (for the pivots)
	 */
	public Handler handleGetOneUser = ctx -> {
		//TODO
	};

	/**
	 * get/:text/:offset/:count
	 */
	public Handler handleGetText = ctx -> {
		String query = ctx.pathParam("text");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		
        List<JSONObject>hits = hypDao.listTextQuery(query, offset, count);
        //ship JSON
        ctx.json(hits);
		
	};

	/*
	public Handler handleGetPivot2 = ctx -> {
		String featureA = ctx.pathParam("featureA");
		String featureB = ctx.pathParam("featureB");
		String offset = ctx.pathParam("offset");
		String count = ctx.pathParam("count");
		JSONObject jo = hypDao.getPivot2(featureA, featureB , offset, count);
		ctx.json(jo);
	};
	*/

	public Handler handlePost = ctx -> {
		//DO NOTHING
	};

}
