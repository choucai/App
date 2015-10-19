package com.dream.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by William Lee on 2015/10/15.
 * <p/>
 * 常用的属性有三个：
 * <p/>
 * app:tabSelectedTextColor：Tab被选中字体的颜色
 * app:tabTextColor：Tab未被选中字体的颜色
 * app:tabIndicatorColor：Tab指示器下标的颜色
 * TabLayout常用的方法如下：
 * - addTab(TabLayout.Tab tab, int position, boolean setSelected) 增加选项卡到 layout 中
 * - addTab(TabLayout.Tab tab, boolean setSelected) 同上
 * - addTab(TabLayout.Tab tab) 同上
 * - getTabAt(int index) 得到选项卡
 * - getTabCount() 得到选项卡的总个数
 * - getTabGravity() 得到 tab 的 Gravity
 * - getTabMode() 得到 tab 的模式
 * - getTabTextColors() 得到 tab 中文本的颜色
 * - newTab() 新建个 tab
 * - removeAllTabs() 移除所有的 tab
 * - removeTab(TabLayout.Tab tab) 移除指定的 tab
 * - removeTabAt(int position) 移除指定位置的 tab
 * - setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) 为每个 tab 增加选择监听器
 * - setScrollPosition(int position, float positionOffset, boolean updateSelectedText) 设置滚动位置
 * - setTabGravity(int gravity) 设置 Gravity
 * - setTabMode(int mode) 设置 Mode,有两种值：TabLayout.MODE_SCROLLABLE和TabLayout.MODE_FIXED分别表示当tab的内容超过屏幕宽度是否支持横向水平滑动，第一种支持滑动，第二种不支持，默认不支持水平滑动。
 * - setTabTextColors(ColorStateList textColor) 设置 tab 中文本的颜色
 * - setTabTextColors(int normalColor, int selectedColor) 设置 tab 中文本的颜色 默认 选中
 * - setTabsFromPagerAdapter(PagerAdapter adapter) 设置 PagerAdapter
 * - setupWithViewPager(ViewPager viewPager) 和 ViewPager 联动
 */
public class FmPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public FmPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    public FmPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Tab1Fragment tab1 = new Tab1Fragment();
                return tab1;
            case 1:
                Tab2Fragment tab2 = new Tab2Fragment();
                return tab2;
            case 2:
                Tab3Fragment tab3 = new Tab3Fragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "tab1";
            case 1:
                return "tab2";
            case 2:
                return "tab3";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
