package com.hensen.greendaodemo.Activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.hensen.greendaodemo.Adapter.ShopListAdapter;
import com.hensen.greendaodemo.Bean.Shop;
import com.hensen.greendaodemo.Dao.LoveDao;
import com.hensen.greendaodemo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_add, bt_delete, bt_update, bt_query;
    private ListView lv_content;
    private ShopListAdapter adapter;
    private List<Shop> shops;
    private static int i = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_add = (Button) findViewById(R.id.bt_add);
        bt_delete = (Button) findViewById(R.id.bt_delete);
        bt_update = (Button) findViewById(R.id.bt_update);
        bt_query = (Button) findViewById(R.id.bt_query);
        lv_content = (ListView) findViewById(R.id.lv_content);
        bt_add.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_query.setOnClickListener(this);

        queryDate();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add:
                addDate();
                break;
            case R.id.bt_delete:
                deleteDate();
                break;
            case R.id.bt_update:
                updateDate();
                break;
            case R.id.bt_query:
                queryDate();
                break;
        }
    }

    private void deleteDate() {
        if (!shops.isEmpty()) {
            LoveDao.deleteLove(shops.get(0).getId());
            queryDate();
        }
    }

    private void queryDate() {
        shops = new ArrayList<>();
        shops = LoveDao.queryLove();
        adapter = new ShopListAdapter(this, shops);
        lv_content.setAdapter(adapter);
    }

    private void addDate() {
        Shop shop = new Shop();
        shop.setType(Shop.TYPE_LOVE);
        shop.setAddress("广东深圳");
        shop.setImage_url("https://img.alicdn.com/bao/uploaded/i2/TB1N4V2PXXXXXa.XFXXXXXXXXXX_!!0-item_pic.jpg_640x640q50.jpg");
        shop.setPrice("19.40");
        shop.setSell_num(15263);
        shop.setName("正宗梅菜扣肉 聪厨梅干菜扣肉 家宴常备方便菜虎皮红烧肉 2盒包邮" + i++);
        LoveDao.insertLove(shop);
        queryDate();
    }

    private void updateDate() {
        if (!shops.isEmpty()) {
            Shop shop = shops.get(0);
            shop.setName("我是修改的名字");
            LoveDao.updateLove(shop);
            queryDate();
        }
    }
}
