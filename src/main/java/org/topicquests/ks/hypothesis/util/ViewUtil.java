/**
 * 
 */
package org.topicquests.ks.hypothesis.util;


import java.util.HashMap;
import java.util.Map;


import io.javalin.http.Context;
import io.javalin.http.ErrorHandler;

/**
 * @author jackpark
 *
 */
public class ViewUtil {

    public static Map<String, Object> baseModel(Context ctx) {
        Map<String, Object> model = new HashMap<>();
        model.put("msg", new MessageBundle(RequestUtil.getSessionLocale(ctx)));
        model.put("currentUser", RequestUtil.getSessionCurrentUser(ctx));
        return model;
    }

    public static ErrorHandler notFound = ctx -> {
        ctx.render(Path.Template.NOT_FOUND, baseModel(ctx));
    };

}
