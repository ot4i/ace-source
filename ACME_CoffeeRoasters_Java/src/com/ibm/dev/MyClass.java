package com.ibm.dev;

import java.net.InetAddress;
import java.net.UnknownHostException;

class MyClass {

public static String myHostnameMethod() { 
	String hostname = "";
	try {
		hostname = InetAddress.getLocalHost().getHostName();
	} catch (UnknownHostException e) {
		e.printStackTrace();
	}
	return hostname;
	}
}