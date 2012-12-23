package com.sprucelearner;
/**
 * @author qiumin
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class CourseL2ListActivity extends FragmentActivity
        implements  CourseL2ListFragment.Callbacks {

    private boolean mTwoPane;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_l2list);
        
        if (findViewById(R.id.course_list) != null) {
            mTwoPane = true;
            ((CourseL2ListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.course_l2list))
                    .setActivateOnItemClick(true);
        }
    }

    @Override
    public void onItemSelected(String id) {
            Intent detailIntent = new Intent(this, CourseDetailActivity.class);
            detailIntent.putExtra(CourseDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
    }
}
