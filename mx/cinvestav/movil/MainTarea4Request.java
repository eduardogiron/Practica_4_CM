package mx.cinvestav.movil;

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class MainTarea4Request extends MIDlet {

	protected void destroyApp(boolean unconditional) {
		notifyDestroyed ();
	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		new RequstController(this);
	}

}
