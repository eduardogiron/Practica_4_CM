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
public class Video {
    private Player mPlayer = null;
    private VideoControl mVidc;
    private Item mVideoItem;

    public  Video(){
        try{
            InputStream in = getClass().getResourceAsStream("/video.mpg");
            mPlayer = Manager.createPlayer(in, "video/mpeg");
            mPlayer.realize();
            if ((mVidc = (VideoControl)mPlayer.getControl("VideoControl")) != null) {
                mVideoItem = (Item)mVidc.initDisplayMode(VideoControl.USE_GUI_PRIMITIVE, null); 
                }
        }catch(IOException ioe){
            System.out.println(ioe);
        }catch(MediaException me){

        }
        
    }
    public Item pantalla_video(){
        return mVideoItem;
    }
    public void start_video(){
        try {
            mPlayer.start();
        } catch (MediaException me) {
            System.out.println(me);
        }

    }
    public void stop_video(){
        try {
            mPlayer.stop();
        } catch (MediaException me) {
            System.out.println(me);
        }

    }

}
