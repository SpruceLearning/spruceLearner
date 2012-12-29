package com.sprucelearner;
/** 
 * @author qiumin
 */



import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;
import android.widget.Toast;

public class CourseListActivity extends FragmentActivity
        implements CourseListFragment.Callbacks, CourseL2ListFragment.Callbacks, OnQueryTextListener {

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
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actions, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }


	@Override
	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean onQueryTextSubmit(String query) {
		// TODO Auto-generated method stub
		return false;
	}
}
