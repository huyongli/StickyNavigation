package cn.ittiger.stickynavigation;

import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout mTabLayout;
    ViewPager mViewPager;
    BottomNavigationView mBottomNavigationView;
    AppBarLayout mAppBarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);


        /**
         * 如果不想使用Behavior实现BottomNavigationView进行隐藏显示的画，也可用采用下面的监听实现此效果
         * */
        /*mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                Log.d("MainActivity", verticalOffset + "");
                mBottomNavigationView.setTranslationY(-verticalOffset);
            }
        });*/

        initViewData();
    }

    private void initViewData() {

        List<ContentFragment> fragments = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            fragments.add(ContentFragment.newInstance(i));
        }
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

        ContentFragmentAdapter adapter = new ContentFragmentAdapter(fragments, getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
