package com.sprucelearner.mediaplayer;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MediaUtil extends Activity {    	 
	public void onCreate(){
	VideoView mvd=new VideoView(null);
     mvd.setVideoURI(Uri.parse("/sdcard/love.mp4"));
	//定义MediaController对象  
	MediaController mediaController = new MediaController(this);  
	//把MediaController对象绑定到VideoView上  
	mediaController.setAnchorView(mvd);  
	//设置VideoView的控制器是mediaController  
	mvd.setMediaController(mediaController);  
	  mvd.requestFocus();
	  mvd.start();
	  mvd.pause();
	}
}
 
