package com.rookie.www.materialdesigntest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private Toolbar tbMain;
    private DrawerLayout dlMain;
    private NavigationView nvMain;
    private FloatingActionButton fabMain;
    private RecyclerView rvMain;

    private List<ShuihuCard> shuihuCardList = new ArrayList<ShuihuCard>();
    private ShuihuCardAdapter adapter;

    private String[] shuihuCardNames = {
            "呼保义宋江", "玉麒麟卢俊义", "智多星吴用", "入云龙公孙胜", "大刀关胜", "豹子头林冲",
            "霹雳火秦明", "双鞭呼延灼", "小李广花荣", "小旋风柴进", "扑天雕李应", "美髯公朱仝",
            "花和尚鲁智深", "行者武松", "双枪将董平", "没羽箭张清", "青面兽杨志", "金枪手徐宁",
            "急先锋索超", "神行太保戴宗", "赤发鬼刘唐", "黑旋风李逵", "九纹龙史进", "没遮拦穆弘",
            "插翅虎雷横", "混江龙李俊", "立地太岁阮小二", "船火儿张横", "短命二郎阮小五", "浪里白条张顺",
            "活阎罗阮小七", "病关索杨雄", "拚命三郎石秀", "两头蛇解珍", "双尾蝎解宝", "浪子燕青",
            "神机军师朱武", "镇三山黄信", "病尉迟孙立", "丑郡马宣赞", "井木犴郝思文", "百胜将韩滔",
            "天目将彭玘", "圣水将单廷珪", "神火将魏定国", "圣手书生萧让", "铁面孔目裴宣", "摩云金翅欧鹏",
            "火眼狻猊邓飞", "锦毛虎燕顺", "锦豹子杨林", "轰天雷凌振", "神算子蒋敬", "小温侯吕方",
            "赛仁贵郭盛", "神医安道全", "紫髯伯皇甫端", "矮脚虎王英", "一丈青扈三娘", "丧门神鲍旭",
            "混世魔王樊瑞", "毛头星孔明", "独火星孔亮", "八臂哪吒项充", "飞天大圣李衮", "玉臂匠金大坚",
            "铁笛仙马麟", "出洞蛟童威", "翻江蜃童猛", "玉幡竿孟康", "通臂猿侯健", "跳涧虎陈达",
            "白花蛇杨春", "白面郎君郑天寿", "九尾龟陶宗旺", "铁扇子宋清", "铁叫子乐和", "花项虎龚旺",
            "中箭虎丁得孙", "小遮拦穆春", "操刀鬼曹正", "云里金刚宋万", "摸着天杜迁", "病大虫薛永",
            "金眼彪施恩", "打虎将李忠", "小霸王周通", "金钱豹子汤隆", "鬼脸儿杜兴", "出林龙邹渊",
            "独角龙邹润", "旱地忽律朱贵", "笑面虎朱富", "铁臂膊蔡福", "一枝花蔡庆", "催命判官李立",
            "青眼虎李云", "没面目焦挺", "石将军石勇", "小尉迟孙新", "母大虫顾大嫂", "菜园子张青",
            "母夜叉孙二娘", "活闪婆王定六", "险道神郁保四", "白日鼠白胜", "鼓上蚤时迁", "金毛犬段景住"
    };

    private int[] shuihuCardIds = {
            R.drawable.sh001
            , R.drawable.sh002
            , R.drawable.sh003
            , R.drawable.sh004
            , R.drawable.sh005
            , R.drawable.sh006
            , R.drawable.sh007
            , R.drawable.sh008
            , R.drawable.sh009
            , R.drawable.sh010
            , R.drawable.sh011
            , R.drawable.sh012
            , R.drawable.sh013
            , R.drawable.sh014
            , R.drawable.sh015
            , R.drawable.sh016
            , R.drawable.sh017
            , R.drawable.sh018
            , R.drawable.sh019
            , R.drawable.sh020
            , R.drawable.sh021
            , R.drawable.sh022
            , R.drawable.sh023
            , R.drawable.sh024
            , R.drawable.sh025
            , R.drawable.sh026
            , R.drawable.sh027
            , R.drawable.sh028
            , R.drawable.sh029
            , R.drawable.sh030
            , R.drawable.sh031
            , R.drawable.sh032
            , R.drawable.sh033
            , R.drawable.sh034
            , R.drawable.sh035
            , R.drawable.sh036
            , R.drawable.sh037
            , R.drawable.sh038
            , R.drawable.sh039
            , R.drawable.sh040
            , R.drawable.sh041
            , R.drawable.sh042
            , R.drawable.sh043
            , R.drawable.sh044
            , R.drawable.sh045
            , R.drawable.sh046
            , R.drawable.sh047
            , R.drawable.sh048
            , R.drawable.sh049
            , R.drawable.sh050
            , R.drawable.sh051
            , R.drawable.sh052
            , R.drawable.sh053
            , R.drawable.sh054
            , R.drawable.sh055
            , R.drawable.sh056
            , R.drawable.sh057
            , R.drawable.sh058
            , R.drawable.sh059
            , R.drawable.sh060
            , R.drawable.sh061
            , R.drawable.sh062
            , R.drawable.sh063
            , R.drawable.sh064
            , R.drawable.sh065
            , R.drawable.sh066
            , R.drawable.sh067
            , R.drawable.sh068
            , R.drawable.sh069
            , R.drawable.sh070
            , R.drawable.sh071
            , R.drawable.sh072
            , R.drawable.sh073
            , R.drawable.sh074
            , R.drawable.sh075
            , R.drawable.sh076
            , R.drawable.sh077
            , R.drawable.sh078
            , R.drawable.sh079
            , R.drawable.sh080
            , R.drawable.sh081
            , R.drawable.sh082
            , R.drawable.sh083
            , R.drawable.sh084
            , R.drawable.sh085
            , R.drawable.sh086
            , R.drawable.sh087
            , R.drawable.sh088
            , R.drawable.sh089
            , R.drawable.sh090
            , R.drawable.sh091
            , R.drawable.sh092
            , R.drawable.sh093
            , R.drawable.sh094
            , R.drawable.sh095
            , R.drawable.sh096
            , R.drawable.sh097
            , R.drawable.sh098
            , R.drawable.sh099
            , R.drawable.sh100
            , R.drawable.sh101
            , R.drawable.sh102
            , R.drawable.sh103
            , R.drawable.sh104
            , R.drawable.sh105
            , R.drawable.sh106
            , R.drawable.sh107
            , R.drawable.sh108
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbMain = (Toolbar) findViewById(R.id.tbMain);
        setSupportActionBar(tbMain);
        dlMain = (DrawerLayout) findViewById(R.id.dlMain);
        nvMain = (NavigationView) findViewById(R.id.nvMain);
        View headerView = nvMain.inflateHeaderView(R.layout.nav_header_main);
        CircleImageView civNavHeaderMain = (CircleImageView) headerView.findViewById(R.id.civNavHeaderMain);
        civNavHeaderMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "显示图片", Toast.LENGTH_SHORT).show();
                dlMain.closeDrawers();
            }
        });
        nvMain.setItemIconTintList(null);
        nvMain.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this, "选择了" + item.getTitle(), Toast.LENGTH_SHORT).show();
                dlMain.closeDrawers();
                return false;
            }
        });
        fabMain = (FloatingActionButton) findViewById(R.id.fabMain);
        fabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "展开导航栏？", Snackbar.LENGTH_SHORT)
                        .setAction("是", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dlMain.openDrawer(GravityCompat.START);
                            }
                        }).show();
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_more);
        }
        initShuihuCards();
        rvMain = (RecyclerView) findViewById(R.id.rvMain);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        rvMain.setLayoutManager(gridLayoutManager);
        adapter = new ShuihuCardAdapter(shuihuCardList);
        rvMain.setAdapter(adapter);
    }

    private void initShuihuCards() {
        shuihuCardList.clear();
        for (int i = 0; i < 108; i++) {
            shuihuCardList.add(new ShuihuCard(shuihuCardNames[i], shuihuCardIds[i]));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        setMenuItemIconEnable(menu, true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItemAbout:
                Toast.makeText(this, "版本1.0", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItemExit:
                finish();
                break;
            case android.R.id.home:
                dlMain.openDrawer(GravityCompat.START, true);
                break;
        }
        return true;
    }

    private void setMenuItemIconEnable(Menu menu, boolean enable) {
        try {
            Class menuBuilder = Class.forName("android.support.v7.view.menu.MenuBuilder");
            Method menuBuilderSetOptionalIconsVisible = menuBuilder.getMethod("setOptionalIconsVisible", boolean.class);
            menuBuilderSetOptionalIconsVisible.invoke(menu, enable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
