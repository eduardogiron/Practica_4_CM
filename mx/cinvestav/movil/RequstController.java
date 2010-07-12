package mx.cinvestav.movil;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;

import mx.cinvestav.movil.forms.FormaURL;

public class RequstController implements CommandListener{
	Display display;
	private MainTarea4Request applic;
	private Command exit;
	private Command request;
	private FormaURL fURL;

	public RequstController(MainTarea4Request mainTarea4Request) {
		applic = mainTarea4Request;
		display = Display.getDisplay(mainTarea4Request);
		
		fURL = new FormaURL(this);
		exit = new Command("Salir", Command.EXIT, 1);
		request = new Command("Pedir", Command.OK, 1);

		fURL.addCommand(exit);
		fURL.addCommand(request);

		display.setCurrent(fURL);
	}
	
	public void commandAction(Command c, Displayable d) {
		if (c == exit)
			applic.destroyApp(true);
		else
			cambioFroma(c);
	}

	private void cambioFroma(Command c) {
		if (c == request)
		{
			String uri = fURL.getDire();
			fURL.setDescargando();
			(new Thread(new HiloRequest(uri, this))).start();
		}
	}

	public void muestraDoc(String doc) {
		TextBox t = new TextBox("Contenido", doc, 1024, 0);
		
		t.addCommand(exit);
		t.setCommandListener(this);
		display.setCurrent(t);
	}
}
