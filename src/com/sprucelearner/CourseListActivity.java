package com.sprucelearner;
/** 
 * @author qiumin
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class CourseListActivity extends FragmentActivity
        implements CourseListFragment.Callbacks, CourseL2ListFragment.Callbacks {

    private boolean mTwoPane;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        if (findViewById(R.id.course_l2list) != null) {
            mTwoPane = true;
            ((CourseListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.course_list))
                    .setActivateOnItemClick(true);
        }
    }

    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putString(CourseL2ListFragment.ARG_ITEM_ID, id);
            CourseL2ListFragment fragment = new CourseL2ListFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
          .replace(R.id.course_l2list, fragment)
          .commit();

        } else {
            Intent l2listIntent = new Intent(this, CourseL2ListActivity.class);
            l2listIntent.putExtra(CourseL2ListFragment.ARG_ITEM_ID, id);
            startActivity(l2listIntent);
        }
    }
}
