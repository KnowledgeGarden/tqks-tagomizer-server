/**
 * 
 */
package org.topicquests.ks.hypothesis;

import org.topicquests.pg.PostgresConnectionFactory;
import org.topicquests.pg.api.IPostgresConnection;
import org.topicquests.support.ResultPojo;
import org.topicquests.support.api.IResult;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.sql.ResultSet;
import java.util.*;
/**
 * @author jackpark
 *
 */
public class HypothesisDao {
	private HypViewerEnvironment environment;
	private PivotSuite pivots;


	/**
	 * 
	 */
	public HypothesisDao(HypViewerEnvironment env) {
		environment = env;
		pivots = new PivotSuite(environment);
	}
	

	/**
	 * Fetch general annotation hits
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<JSONObject> getAllHits(String _offset, String _count) {
		List<JSONObject> result = null;
		IResult r = pivots.listAllResources(Integer.parseInt(_offset), Integer.parseInt(_count));
		result = (List<JSONObject>)r.getResultObject();
		return result;
    }
	
	///////////////////////////////////////////////////////
	//THESE WORK for bulk fetching
	public JSONArray getResources(String _offset, String _count) {
		JSONArray result = null;
		List<JSONObject> x = getAllHits(_offset, _count);
		result = toJA(x);
		return result;
	}

	JSONArray toJA(List<JSONObject> l) {
		JSONArray result = new JSONArray();
		if (l != null && !l.isEmpty()) {
			Iterator<JSONObject>itr = l.iterator();
			while (itr.hasNext())
				result.add(itr.next());
		}
		return result;
	}
	public JSONArray getUsers(String _offset, String _count) {
		JSONArray result = new JSONArray();
		IResult r = pivots.listAllUsers();
		List<String> l = (List<String>)r.getResultObject();
		environment.logDebug("DAO.getUsers "+l);
		if (l != null && !l.isEmpty()) {
			Iterator<String>itr = l.iterator();
			while (itr.hasNext()) {
				result.add(itr.next());
			}
		}	
		environment.logDebug("DAO.getUsers+ "+result);
		return result;
	}

	public JSONArray getGroups(String _offset, String _count) {
		JSONArray result = new JSONArray();
		IResult r = pivots.listAllGroups();
		List<JSONObject> x = (List<JSONObject>)r.getResultObject();
		result = toJA(x);	
		return result;
	}

	public JSONArray getTags(String _offset, String _count) {
		JSONArray result = null;
		IResult r = pivots.listAllTags(Integer.parseInt(_offset), Integer.parseInt(_count));
		List<JSONObject> x = (List<JSONObject>)r.getResultObject();
		result = toJA(x);
		return result;
	}
	

	//TODO -- ADD Groups and Group Pivots
	//TODO wire these utilities
	////////////////////////////////////////////////////////
	// Utilities
	//
	JSONArray getResourcesByUser(String userId, int offset, int count) {
		JSONArray result = new JSONArray();
		IResult r = pivots.listPivotsByUser(userId, offset, count);
		List<JSONObject> x = (List<JSONObject>)r.getResultObject();
		result = toJA(x);
		return result;
	}
	
	JSONArray getResourcesByTag(String tagId, int offset, int count) {
		JSONArray result = new JSONArray();
		IResult r = pivots.listResourcesByTag(tagId, offset, count);
		List<JSONObject> x = (List<JSONObject>)r.getResultObject();
		result = toJA(x);
		return result;
	}
	
	JSONArray getResourcesByGroup(String tagId, int offset, int count) {
		JSONArray result = new JSONArray();
		IResult r = pivots.listResourcesByGroup(tagId, offset, count);
		List<JSONObject> x = (List<JSONObject>)r.getResultObject();
		result = toJA(x);
		return result;
	}
	
	JSONArray getUsersByResource(String docId){
		JSONArray result = new JSONArray();
		IResult r = pivots.listUsersByResource(docId);
		List<String> l = (List<String>)r.getResultObject();
		if (l != null && !l.isEmpty()) {
			Iterator<String>itr = l.iterator();
			while (itr.hasNext())
				result.add(itr.next());
		}	

		return result;
	}
	
	JSONArray getUsersByTag(String tagId) {
		JSONArray result = new JSONArray();
		IResult r = pivots.listUsersByTag(tagId);
		List<String> l = (List<String>)r.getResultObject();
		if (l != null && !l.isEmpty()) {
			Iterator<String>itr = l.iterator();
			while (itr.hasNext())
				result.add(itr.next());
		}	
		return result;
	}
	
	JSONArray getUsersByGroup(String tagId) {
		JSONArray result = new JSONArray();
		IResult r = pivots.listUsersByGroup(tagId);
		List<String> l = (List<String>)r.getResultObject();
		if (l != null && !l.isEmpty()) {
			Iterator<String>itr = l.iterator();
			while (itr.hasNext())
				result.add(itr.next());
		}	
		return result;
	}
	JSONArray getTagsByUser(String userId, int offset, int count) throws Exception {
		JSONArray result = new JSONArray();
		IResult r = pivots.listTagsByUser(userId, offset, count);
		List<JSONObject> x = (List<JSONObject>)r.getResultObject();
		result = toJA(x);
		return result;
	}

	JSONArray getTagsByGroup(String groupId, int offset, int count) throws Exception {
		JSONArray result = new JSONArray();
		IResult r = pivots.listTagsByGroup(groupId, offset, count);
		List<JSONObject> x = (List<JSONObject>)r.getResultObject();
		result = toJA(x);
		return result;
	}

	JSONArray getTagsByResource(String docId, int offset, int count) {
		JSONArray result = new JSONArray();
		IResult r = pivots.listTagsByResource(docId, offset, count);
		List<JSONObject> x = (List<JSONObject>)r.getResultObject();
		result = toJA(x);
		return result;
	}
	
	JSONArray getGroupsByResource(String docId, int offset, int count) {
		JSONArray result = new JSONArray();
		IResult r = pivots.listGroupsByResource(docId);
		List<JSONObject> x = (List<JSONObject>)r.getResultObject();
		result = toJA(x);
		return result;
	}

	JSONArray getGroupsByUser(String userId, int offset, int count) {
		JSONArray result = new JSONArray();
		IResult r = pivots.listGroupsByUser(userId);
		List<JSONObject> x = (List<JSONObject>)r.getResultObject();
		result = toJA(x);
		return result;
	}
	
	JSONArray getGroupsByTag(String tagId, int offset, int count) {
		JSONArray result = new JSONArray();
		IResult r = pivots.listGroupsByTag(tagId);
		List<JSONObject> x = (List<JSONObject>)r.getResultObject();
		result = toJA(x);
		return result;
	}

	//
	////////////////////////////////////////////////////////

	public JSONObject getTagPivot(String tagId, String _offset, String _count) {
		IResult r = pivots.listPivotsByTag(tagId, Integer.parseInt(_offset), Integer.parseInt(_count));
		JSONObject result = (JSONObject)r.getResultObject();
		return result;
	}
	
	public JSONObject getUserPivot(String userId, String _offset, String _count) {
		IResult r = pivots.listPivotsByUser(userId, Integer.parseInt(_offset), Integer.parseInt(_count));
		JSONObject result = (JSONObject)r.getResultObject();
		return result;
	}
	
	public JSONObject getResourcePivot(String docId, String _offset, String _count) {
		IResult r = pivots.listPivotsByResource(docId, Integer.parseInt(_offset), Integer.parseInt(_count));
		JSONObject result = (JSONObject)r.getResultObject();
		return result;
	}
	
	public JSONObject getGroupPivot(String groupId, String _offset, String _count) {
		IResult r = pivots.listPivotsByGroup(groupId, Integer.parseInt(_offset), Integer.parseInt(_count));
		JSONObject result = (JSONObject)r.getResultObject();
		return result;
	}
	

	/**
	 * Fetch annotations based on a full text query
	 * @param textQuery
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<JSONObject> listTextQuery(String textQuery, String _offset, String _count) {
		List<JSONObject> result = null;
		IResult r = pivots.listTextBySearch(textQuery, Integer.parseInt(_offset), Integer.parseInt(_count));
		result = (List<JSONObject>)r.getResultObject();
		return result;
	}

}
