package com.example.liu.test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private DrawerLayout drawerLayout;
    private List<Data> datas=new ArrayList<Data>();
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        initView();
        initData();
    }

    public void initView(){
        navigationView=findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        drawerLayout=findViewById(R.id.drawerlayout);
        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        recyclerView=findViewById(R.id.love_show);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
//       recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
    }

    public void initData(){
                datas= (List<Data>) getIntent().getSerializableExtra("data");
        recyclerView.setAdapter(new MyAdapter(datas));
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        List<Data> datas;
        public MyAdapter(List<Data> datas){
            this.datas=datas;
        }
        @NonNull
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zq_item,viewGroup,false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int i) {
            ImageView imageView=viewHolder.imageView;
            TextView textView=viewHolder.textView;
            TextView textView1=viewHolder.textView2;
            imageView.setBackgroundResource(datas.get(i).getImageId());
            textView.setText(datas.get(i).getValue1());
            textView1.setText(datas.get(i).getValue2());
            Log.d(TAG, "onBindViewHolder: i="+i);
            Log.d(TAG, "onBindViewHolder: datasize"+datas.size());

            while(i==datas.size()-1){
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    float x1 = 0;
                    float x2 = 0;
                    float y1 = 0;
                    float y2 = 0;
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if(event.getAction() == MotionEvent.ACTION_DOWN) {
                            //当手指按下的时候
                            x1 = event.getX();
                            y1 = event.getY();
                        }
                        if(event.getAction() == MotionEvent.ACTION_UP) {
                            //当手指离开的时候
                            x2 = event.getX();
                            y2 = event.getY();
                        }
                        if(x1-x2>50){
                            Intent intent=new Intent(SecondActivity.this,ThridActivity.class);
                            startActivity(intent);
                        }
                        return false;
                    }
                });
                break;
            }
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            private ImageView imageView;
            private TextView textView;
            private TextView textView2;
            public ViewHolder(View itemView) {
                super(itemView);
                imageView=itemView.findViewById(R.id.image_show);
                textView=itemView.findViewById(R.id.text1_show);
                textView2=itemView.findViewById(R.id.text2_show);            }
        }

    }
}