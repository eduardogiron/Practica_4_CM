package mx.cinvestav.movil;

import mx.cinvestav.movil.http.HttpRequester;

public class HiloRequest implements Runnable {
	String uri = null;
	RequstController controller;

	public HiloRequest(String uri, RequstController controller)
	{
		this.uri = uri;
		this.controller = controller;
	}
	
	public void run() {
		System.out.println(uri);

		String doc = HttpRequester.RequestURI(uri);

		System.out.println(doc);
		
		controller.muestraDoc(doc);
	}

}
