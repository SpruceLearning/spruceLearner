package com.sprucelearner;
/**
 * @author qiumin
 */


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

public class CourseDetailActivity extends FragmentActivity {

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(CourseDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(CourseDetailFragment.ARG_ITEM_ID));
            CourseDetailFragment fragment = new CourseDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.course_detail_container, fragment)
                    .commit();
        }
        VideoView mvd =(VideoView)this.findViewById(R.id.vplay);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, CourseListActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
