/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.cinvestav.movil.media;
import javax.microedition.media.*;
import javax.microedition.media.control.*;
import javax.microedition.lcdui.*;
import java.io.*;
/**
 *
 * @author eduardogiron
 */
public class Captura_imagen {
    private Player mPlayer = null;
    private VideoControl mVideoControl;
    private Item mFotoItem;

    public Captura_imagen(){

        try {
            mPlayer = Manager.createPlayer("capture://video");
            mPlayer.realize();
            if ((mVideoControl = (VideoControl)mPlayer.getControl("VideoControl")) != null) {
                mFotoItem = (Item)mVideoControl.initDisplayMode(VideoControl.USE_GUI_PRIMITIVE, null);
                }
        }catch(IOException ioe){
            System.out.println(ioe);
        }catch(MediaException me){
            System.out.println(me);
        }
        
    }
    public Item pantalla(){
        return mFotoItem;
    }
    public void iniciar_captura(){
        try {
            mPlayer.start();
        } catch (MediaException me) {
            System.out.println(me);
        }
    }
    
    public Image tomar_imagen(){
        Image image= null;
        try {
      // Get the image.
            byte[] raw = mVideoControl.getSnapshot(null);
            image = Image.createImage(raw, 0, raw.length);

        // Shut down the player.
             mPlayer.close();
             mPlayer = null;
             mVideoControl = null;
        }
        catch (MediaException me) {
            System.out.println(me);
        }
        return image;
    }
     
}
