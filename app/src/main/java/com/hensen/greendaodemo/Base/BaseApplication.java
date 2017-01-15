package com.hensen.greendaodemo.Base;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.hensen.greendaodemo.DaoMaster;
import com.hensen.greendaodemo.DaoSession;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2017/1/15.
 */
public class BaseApplication extends Application{

    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        //配置数据库
        setupDatabase();
    }

    /**
     * 配置数据库
     */
    private void setupDatabase() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "shop.db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }
}
