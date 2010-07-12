/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.cinvestav.movil.media;
import javax.microedition.media.*;
import java.io.*;
/**
 *
 * @author eduardogiron
 */
public class Audio {
    Player player;
    
    public Audio(){
        //InputStream in = getClass().getResourceAsStream("/relax.wav");
        try{
            InputStream in = getClass().getResourceAsStream("/DGrayM.mp3");
            player = Manager.createPlayer(in,"audio/mpeg");
            player.prefetch();
            player.setLoopCount(-1);
            

        }catch(IOException ioe){
            System.out.println(ioe);
        }catch(MediaException me){

        }
                
    }
    public void start_song(){
        try {
            player.start();
        } catch (MediaException me) {
            System.out.println(me);
        }

    }
    public void stop_song(){
        try {
            player.stop();
        } catch (MediaException me) {
            System.out.println(me);
        }

    }
}
