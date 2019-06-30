package com.example.jike;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

//张九红  1811a
public class MainActivity extends AppCompatActivity {
    /**
     * 日报
     */
    private TextView title;
    private Toolbar tool;
    private RelativeLayout vp;
    private NavigationView nav;
    private DrawerLayout dr;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        title = (TextView) findViewById(R.id.title);
        tool = (Toolbar) findViewById(R.id.tool);
        vp = (RelativeLayout) findViewById(R.id.vp);
        nav = (NavigationView) findViewById(R.id.nav);
        dr = (DrawerLayout) findViewById(R.id.dr);

        tool.setTitle("");
        setSupportActionBar(tool);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dr, tool, R.string.app_name, R.string.app_name);
        toggle.syncState();
        dr.addDrawerListener(toggle);

        fragmentManage();
    }

    private void fragmentManage() {

        final ZhiHuFragment zhiHuFragment = new ZhiHuFragment();
        final WeiXinFragment weiXinFragment = new WeiXinFragment();

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.vp,zhiHuFragment);
        //transaction.add(R.id.vp,weiXinFragment);
        transaction.commit();


        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.zhihu:
                        title.setText("知乎日报");
                        FragmentTransaction transaction1 = manager.beginTransaction();
                        transaction1.show(zhiHuFragment);
                        transaction1.hide(weiXinFragment);
                        transaction1.commit();
                        dr.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.weixin:
                        title.setText("微信精选");
                        FragmentTransaction transaction2 = manager.beginTransaction();
                        transaction2.add(R.id.vp,weiXinFragment);
                        transaction2.hide(zhiHuFragment);
                        transaction2.commit();
                        dr.closeDrawer(Gravity.LEFT);
                        break;
                }
                return false;
            }
        });

    }
}
