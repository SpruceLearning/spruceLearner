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
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class TestActivity extends FragmentActivity {

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_test);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(TestFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(TestFragment.ARG_ITEM_ID));
            TestFragment fragment = new TestFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.course_test_container, fragment)
                    .commit();
        }
       ImageView img =(ImageView)this.findViewById(R.id.iview);
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
