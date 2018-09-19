package com.maple.ui;

import android.app.NotificationManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.maple.ui.GithubView.GithubViewActivity;
import com.maple.ui.anim.MainActivity;
import com.maple.ui.circleImage.CircleImageActivity;
import com.maple.ui.overlapping.OverlappingActivity;
import com.maple.ui.sizeAdapter.CustomDensity;
import com.maple.ui.sizeAdapter.SizeAdapterActivity;
import com.maple.ui.timeSelector.TimeSelectorActivity;
import com.maple.wangfeng.blackutil.BlackUtil;
import com.maple.wangfeng.markview.MarkView;

import java.util.ArrayList;

public class MainListActivity extends AppCompatActivity {
    public ArrayList<ActivityItem> mItems;
    private ActivityAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        RecyclerView rv = findViewById(R.id.list);
        mItems = getItems();
        mAdapter = new ActivityAdapter(mItems);
        mAdapter.setListener(new OnClickListener<ActivityItem>() {
            @Override
            public void onClick(ActivityItem item) {
                startActivity(new Intent(MainListActivity.this, item.activity));
            }
        });
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(mAdapter);
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.bjt)
                .setContentTitle("ssss")
                .setContentText("ss")
                .setProgress(100,33,false);
        manager.notify(1,builder.build());
        //测试防卸载
        BlackUtil.activation(this);
    }

    public ArrayList<ActivityItem> getItems() {
        mItems = new ArrayList<>();
        mItems.add(new ActivityItem(SizeAdapterActivity.class));
        mItems.add(new ActivityItem(GithubViewActivity.class));
        mItems.add(new ActivityItem(CircleImageActivity.class));
        mItems.add(new ActivityItem(TimeSelectorActivity.class));
        mItems.add(new ActivityItem(OverlappingActivity.class));
        mItems.add(new ActivityItem(MarkActivity.class));
        return mItems;

    }
}
