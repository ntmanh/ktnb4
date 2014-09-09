package cmc.com.ktnb.util;

import javax.servlet.http.HttpServletRequest;

public class Context {
	private static ThreadLocal instance = new ThreadLocal();
    private HttpServletRequest request;

    private Context(HttpServletRequest request) {
        this.request = request;
    }

    public static Context getCurrentInstance() {
        return (Context)instance.get();
    }

    public static Context newInstance(HttpServletRequest request) {
        Context context = new Context(request);
        instance.set(context);        
        return context;
    }
    public void release() {
        instance.set(null);
    }
    public HttpServletRequest getRequest() {
        return request;
    }
}
