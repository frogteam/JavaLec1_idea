package test.attribute;

import java.util.HashMap;

class Request {
	
	HashMap<String, Object> hMap = new HashMap<>();
	
	public void setAttribute(String name, Object obj) {
		hMap.put(name, obj);
	}
	
	public Object getAttribute(String name) {
		return hMap.get(name);
	}
}

public class Main {
	public static void main(String[] args) {
		Request request = new Request();
		
		request.setAttribute("result", 10);
		
		int cnt = (Integer)request.getAttribute("result");
	}
}
