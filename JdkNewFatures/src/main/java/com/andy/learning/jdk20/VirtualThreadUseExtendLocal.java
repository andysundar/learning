package com.andy.learning.jdk20;


import jdk.incubator.concurrent.ExtentLocal;


public class VirtualThreadUseExtendLocal {

	public static void main(String[] args) {
		Server server = new Server();

		String creds = "Andy";
		server.externalCall(creds);
		
		creds = "Another Value";
		server.externalCall(creds);
		
	}
}

class Server { 
	static final ExtentLocal<String> CREDENTIALS = ExtentLocal.newInstance();
	
     void externalCall(String request) {
    	 ExtentLocal.where(CREDENTIALS, request).run(() -> {
		      DBAccess.open();
		   });
	}
}
class DBAccess {
    static Boolean open() {
        var credentials = Server.CREDENTIALS.get();     
        System.out.println(String.format("Value from ExtendLocal is %s", credentials));
        return "Andy".equals(credentials);
    }
}
