package com.example.liu.test;

import android.animation.Animator;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private NbButton button;
    private RelativeLayout relativeLayout;
    private List<Data> datas=new ArrayList<Data>();
    private Handler handler;
    private Animator animator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        relativeLayout.getBackground().setAlpha(0);
        handler=new Handler();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(HelpUtil.isFastDoubleClick()){
                    return;
                }
                button.startAnim();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gotoNew();
                    }
                },3000);

            }
        });
    }
    public void initView(){
        button=findViewById(R.id.bt_nb);
        relativeLayout=findViewById(R.id.rl_content);

    }
    private void gotoNew() {
        button.gotoNew();

        final Intent intent=new Intent(this,SecondActivity.class);
        datas= (List<Data>) getIntent().getSerializableExtra("data");
        intent.putExtra("data", (Serializable) datas);
        int xc=(button.getLeft()+button.getRight())/2;
        int yc=(button.getTop()+button.getBottom())/2;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            animator= ViewAnimationUtils.createCircularReveal(relativeLayout,xc,yc,0,1111);
        }

        animator.setDuration(300);
        animator.addListener(new Animator.AnimatorListener() {
            LinearLayout ll1=findViewById(R.id.ll_1);
            LinearLayout ll2=findViewById(R.id.ll_2);
            @Override
            public void onAnimationStart(Animator animation) {

                ll1.setVisibility(View.GONE);
                ll2.setVisibility(View.GONE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(intent);
                        overridePendingTransition(R.anim.in,R.anim.out);

                    }
                },200);
            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
       relativeLayout.getBackground().setAlpha(255);
    }
    @Override
    protected void onStop() {
        super.onStop();
        animator.cancel();
        relativeLayout.getBackground().setAlpha(0);
        button.regainBackground();
    }
}
