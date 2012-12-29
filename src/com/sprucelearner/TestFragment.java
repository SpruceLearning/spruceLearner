package com.sprucelearner;
/**
 * @author qiumin
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.sprucelearner.content.Lessons;
import com.sprucelearner.content.Lessons.LessonItem;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class TestFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private VideoView mvd;
    private String path;
    
    Lessons.LessonItem mItem;

    public TestFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = Lessons.LESSON_ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_test, container, false);
        if (mItem != null) {
            ImageView img = (ImageView)rootView.findViewById(R.id.iview);
       //     path = "android.resource://" + this.getActivity().getPackageName() +"/"+"R.raw.course"+mItem.id+".mp3";
            path = "/sdcard/course"+mItem.id+".jpg";
            
            Bitmap bitmap = getLoacalBitmap(path); 
            img.setImageBitmap(bitmap); 
            
        }
          return rootView;
    }
    
    public  Bitmap getLoacalBitmap(String url) {
        try {
             FileInputStream fis = new FileInputStream(url);
             return BitmapFactory.decodeStream(fis);         

          } catch (Exception e) {
             e.printStackTrace();
             return null;
        }
    }
}
