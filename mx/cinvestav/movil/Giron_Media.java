/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.cinvestav.movil;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import mx.cinvestav.movil.media.*;
/**
 * @author eduardogiron
 */
public class Giron_Media extends MIDlet implements CommandListener {
    Captura_imagen imagen;
    Video video;
    Audio audio;
    Display display;
    List mainForm;
    Form video_f,audio_f, captura_f,captura;
    private Command aceptar,entrar,salir,back_v,back_a,back_c,tomar;
    public Giron_Media(){
        display = Display.getDisplay(this);        
//------------------------------------------------------------------
        
        mainForm = new List("Aplicación Media", Choice.IMPLICIT);
        mainForm.append("Audio", null);
        mainForm.append("Video", null);
        mainForm.append("Captura", null);
        salir = new Command("Salir",Command.EXIT,1);
        entrar = new Command("Aceptar",Command.OK,2);
        mainForm.addCommand(salir);
        mainForm.addCommand(entrar);
        mainForm.setCommandListener(this);
//------------------------------------------------------------------
        //Ventana Video
        video= new Video();
        video_f= new Form ("Reproducción de Video");
        back_v = new Command("Back",Command.OK,2);
        video_f.addCommand(back_v);
        video_f.setCommandListener(this);
//------------------------------------------------------------------
        //Ventana Audio
        audio= new Audio();
        audio_f= new Form("Reproducción de Audio");
        back_a = new Command("Back",Command.OK,2);
        audio_f.addCommand(back_a);
        audio_f.setCommandListener(this);
//------------------------------------------------------------------
        //Ventana Captura Imagen
        imagen = new Captura_imagen();
        captura_f= new Form("Captura de Foto");
        tomar = new Command("Capturar",Command.OK,2);
        back_c = new Command("Back",Command.OK,2);
        captura_f.addCommand(back_c);
        captura_f.addCommand(tomar);
        captura_f.setCommandListener(this);
//------------------------------------------------------------------
        captura= new Form("Imagen Capturada");
        aceptar = new Command("Aceptar",Command.OK,2);
        captura.addCommand(aceptar);
        captura.setCommandListener(this);
    }
    public void startApp() {
        display.setCurrent (mainForm);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
        //video.stop_video();

    }

    public void commandAction(Command c, Displayable d){
        if(c==salir){
            destroyApp(false);
            notifyDestroyed();
        }

        if (c== entrar){
             
             if (mainForm.isSelected(0)){
                 audio.start_song();
                 display.setCurrent(audio_f);
             }
             if (mainForm.isSelected(1)){
                 video_f.append(video.pantalla_video());
                 display.setCurrent(video_f);
                 video.start_video();
             }
             if (mainForm.isSelected(2)){
                 captura_f.append(imagen.pantalla());
                 imagen.iniciar_captura();
                 display.setCurrent(captura_f);
             }
        }
        if(c==back_v){
            video.stop_video();
            display.setCurrent(mainForm);
        }

        if(c==back_a){
            audio.stop_song();
            display.setCurrent(mainForm);
        }
        if(c==back_c){
            display.setCurrent(mainForm);
        }
        if(c==tomar){
            Image ima= imagen.tomar_imagen();
            captura.append(ima);
            display.setCurrent(captura);
        }
        if(c==aceptar){
            display.setCurrent(mainForm);
        }

    }
}
