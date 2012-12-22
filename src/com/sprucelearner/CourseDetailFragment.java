package com.sprucelearner;

import com.sprucelearner.content.Lessons;
import com.sprucelearner.content.Lessons.LessonItem;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class CourseDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private VideoView mvd;
    
    Lessons.LessonItem mItem;

    public CourseDetailFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_course_detail, container, false);
        if (mItem != null) {
            VideoView mvd = (VideoView)rootView.findViewById(R.id.vplay);
            mvd.setVideoURI(Uri.parse("/sdcard/course1.mp4"));             
          MediaController mediaController = new MediaController(this.getActivity());  
          mediaController.setAnchorView(mvd);  
          mediaController.setPadding(0,0,0,0);          
          mvd.setMediaController(mediaController);  
          mvd.requestFocus();
          mvd.start();  
        }
          return rootView;
    }
}
