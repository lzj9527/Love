package com.example.liu.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     private  FrameLayout frameLayout;
     private List<Data> datas=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                intent.putExtra("data", (Serializable) datas);
                startActivity(intent);
            }
        });
    }
    public void initView(){
        frameLayout=findViewById(R.id.bj);
    }
    public void initData(){
        Data data=new Data(R.drawable.photo1,"我有个超级可爱的女朋友\n她叫张琦\n她特别粘人","我向左她就绝不向右。\n我靠在沙发打游戏，她靠着我看书。我在书房工作，她在我背后刷微博。\n就连上厕所，她都跟在我后面。\n无论什么时候，都要和我在一起。\n但我从来不觉得厌烦，因为我知道：\n太喜欢才会想一直赖着对方。");
        datas.add(data);
        Data data1=new Data(R.drawable.photo2,"她应该是世界上最爱吃的女孩了","一起去逛超市， 她嘴里念叨着我要减肥不能吃肉,还叮嘱我看好她。\n但一看到肉，她就眼睛放光挪不动腿\n最后我也只能假装说\n买吧买吧,     我想吃。\n还能怎么办呢？\n自己的女朋友，只能宠着呗。");
        datas.add(data1);
        Data data2=new Data(R.drawable.photo3,"她总说想在家里养个小宠物","一遇到可爱的小狗\n她就会蹲下来摸着人家不撒手\n嘴里一直念叨着：\n“好可爱啊，我们偷回家吧”\n这个傻家伙\n家里分明已经养了她这个小宝贝了。");
        datas.add(data2);
        Data data3=new Data(R.drawable.photo4,"她总是很贴心想帮我分担。","每次逛超市\n她都要帮我拎东西、\n但我知道不超过三秒\n东西又会回到我手里");
        datas.add(data3);
        Data data4=new Data(R.drawable.photo6,"有时她会特别不给我面子","拍了我很多丑照");
        datas.add(data4);
        Data data5=new Data(R.drawable.photo7,"她会让我认清自己","在我装钢铁侠装得兴致勃勃时\n瞬间把我打回现实：\n“别玩了，你还没有钢铁侠一半帅呢”");
        datas.add(data5);
        Data data6=new Data(R.drawable.photo8,"但我也不甘落后。","在她穿着美美的衣服让我看时\n我也会很直男的说：\n你好像泡菜呀\n真的搞不懂，这有什么好问的 \n她无论穿什么都很漂亮呀");
        datas.add(data6);
        Data data7=new Data(R.drawable.photo9,"和她在一起我变得像个小孩子","我会在商场和她玩捉迷藏\n尽管最后是我被吓一大跳.....");
        datas.add(data7);
        Data data8=new Data(R.drawable.photo10,"她会特别调皮","她会在大冬天把手伸到我衣服里\n冷得我嗷嗷叫\n我们总会做些很蠢的事情。\n可能互相喜欢的两个人\n真的会变成智商不足的小屁孩吧");
        datas.add(data8);
        Data data9=new Data(R.drawable.photo11,"我们偶尔也会吵架","相爱的两个人\n躲得过风雨\n但免不了争吵\n可是看她委屈的样子\n我总忍不住把她抱在怀里\n先和解的人不是因为怕输\n而是因为珍惜");
        datas.add(data9);
        Data data10=new Data(R.drawable.photo12,"我喜欢和她在一起","喜欢加班回家后\n睡眼惺忪的她跑到客厅说：\n“你回来了”\n然后扑在我怀里\n又沉沉地睡过去");
        datas.add(data10);
        Data data11=new Data(R.drawable.photo13,"她会让我放下手机","喜欢在我玩手机时\n她调皮的钻到我怀里说：\n“手机哪有我好玩呀”");
        datas.add(data11);
        Data data12=new Data(R.drawable.photo14,"她会把我当成她的一部分","喜欢一起吃饭时\n她自然而然的帮我去掉嘴角的饭粒\n再自然而然的放到自己嘴里\n是有多亲近，才会变得这样自然而然");
        datas.add(data12);
        Data data13=new Data(R.drawable.photo15,"我不知道未来会是怎么样\n但我想永远陪着她","站在她身后保护她");
        datas.add(data13);
        Data data14=new Data(R.drawable.photo16,"","一起和她看很多很多风景\n如果有一天\n我明白了什么是爱情\n那一定是因为你");
        datas.add(data14);
    }
}
