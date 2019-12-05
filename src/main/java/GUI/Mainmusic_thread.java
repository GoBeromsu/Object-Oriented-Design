package GUI;

import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Mainmusic_thread extends Thread {
    static public Mainmusic_thread thread;
    static private Player player;
    static private boolean isLoop;
    static private BufferedInputStream bis;

    public Mainmusic_thread(InputStream file_stream, boolean isLoop){
        try {

            bis = new BufferedInputStream(file_stream);
            player = new Player(bis);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        thread = this;
    }

    @Override
    public void run(){
        try{
            do{
                player.play();
                player = new Player(bis);
            }while(isLoop);
        }catch(Exception e){}
    }

    public void close(){
        isLoop = false;
        player.close();
        this.interrupt();
    }
}
