package com.sprucelearner;

/**
 * @author qiumin
 */
import java.util.List;

import com.sprucelearner.content.Disciplines;
import com.sprucelearner.content.Lessons;
import com.sprucelearner.content.Lessons.LessonItem;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CourseL2ListFragment extends ListFragment {

    private static final String STATE_ACTIVATED_POSITION = "activated_position";
    public static final String ARG_ITEM_ID = "item_id";

    private Callbacks nCallbacks = sLessonCallbacks;
    private int mActivatedPosition = ListView.INVALID_POSITION;

    private Disciplines.DisciplineItem dItem;
    private List<LessonItem> lessonList;
    public interface Callbacks {

        public void onItemSelected(String id);
    }

    private static Callbacks sLessonCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(String id) {
        }
    };

    public CourseL2ListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            dItem = Disciplines.DISP_ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
        int id = Integer.parseInt(dItem.id);
        switch(id){
        	case 0: lessonList = Lessons.LESSON_ITEMS_0; break;
        	case 1: lessonList = Lessons.LESSON_ITEMS_1; break;
        	case 2: lessonList = Lessons.LESSON_ITEMS_2; break;
        	default: lessonList = Lessons.LESSON_ITEMS_0;
        }
        
        setListAdapter(new ArrayAdapter<Lessons.LessonItem>(getActivity(),
                R.layout.simple_list_item_activated_1,    // Layout to be changed here
                R.id.text1,
                lessonList));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null && savedInstanceState
                .containsKey(STATE_ACTIVATED_POSITION)) {
            setActivatedPosition(savedInstanceState.getInt(STATE_ACTIVATED_POSITION));
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        nCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        nCallbacks = sLessonCallbacks;
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);
        switch(Integer.parseInt(dItem.id)){
        	case 0:  break;
        	case 1: position = position + 3; break;
        	case 2: position = position + 4; break;
        	default: 
        }
        Intent detailIntent = new Intent(this.getActivity(), CourseDetailActivity.class);
        detailIntent.putExtra(CourseDetailFragment.ARG_ITEM_ID, Integer.toString(position));
        startActivity(detailIntent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mActivatedPosition != ListView.INVALID_POSITION) {
            outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
        }
    }

    public void setActivateOnItemClick(boolean activateOnItemClick) {
        getListView().setChoiceMode(activateOnItemClick
                ? ListView.CHOICE_MODE_SINGLE
                : ListView.CHOICE_MODE_NONE);
    }

    public void setActivatedPosition(int position) {
        if (position == ListView.INVALID_POSITION) {
            getListView().setItemChecked(mActivatedPosition, false);
        } else {
            getListView().setItemChecked(position, true);
        }

        mActivatedPosition = position;
    }
}

