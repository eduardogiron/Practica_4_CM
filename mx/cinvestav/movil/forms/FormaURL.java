package mx.cinvestav.movil.forms;

import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;

public class FormaURL extends FormaPadre {
	private TextField direccion;
	private int nuevoTag;
	private int idDireccion;
	
	public FormaURL(CommandListener c) {
		super(c, "Capruta de URL");
		
		String defaulDire = "computacion.cs.cinvestav.mx/~saucedo/movil/prueba.txt";
		StringItem titu = new StringItem("Introdusca la url", null);
		append(titu);
		direccion = new TextField("http://", defaulDire, 100, TextField.URL);
		idDireccion = append(direccion);
	}

	public void setDescargando() {
		StringItem descargando = new StringItem("Descargando: " + direccion.getString() + "...", null);
		nuevoTag = append(descargando);
		
		this.delete(idDireccion);
	}

	public String getDire()
	{
		return direccion.getString();
	}
}
