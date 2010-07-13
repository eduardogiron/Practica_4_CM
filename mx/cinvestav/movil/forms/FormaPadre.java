package mx.cinvestav.movil.forms;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

public class FormaPadre extends Form implements CommandListener {

	private CommandListener comm;

	public FormaPadre(CommandListener c, String title) {
		super(title);

		comm = c;

		this.setCommandListener(this);
	}

	public void commandAction(Command c, Displayable d) {
		comm.commandAction(c, d);
	}

}
