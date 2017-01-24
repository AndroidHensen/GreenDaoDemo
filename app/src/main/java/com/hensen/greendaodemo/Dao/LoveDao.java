package com.hensen.greendaodemo.Dao;

import com.hensen.greendaodemo.Base.BaseApplication;
import com.hensen.greendaodemo.Bean.Shop;
import com.hensen.greendaodemo.ShopDao;

import java.util.List;

/**
 * Created by handsome on 2016/4/19.
 */
public class LoveDao {

    /**
     * 添加数据
     *
     * @param shop
     */
    public static void insertLove(Shop shop) {
        BaseApplication.getDaoInstant().getShopDao().insert(shop);
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public static void deleteLove(long id) {
        BaseApplication.getDaoInstant().getShopDao().deleteByKey(id);
    }

    /**
     * 更新数据
     *
     * @param shop
     */
    public static void updateLove(Shop shop) {
        BaseApplication.getDaoInstant().getShopDao().update(shop);
    }

    /**
     * 查询条件为Type=TYPE_LOVE的数据
     *
     * @return
     */
    public static List<Shop> queryLove() {
        return BaseApplication.getDaoInstant().getShopDao().queryBuilder().where(ShopDao.Properties.Type.eq(Shop.TYPE_LOVE)).list();
    }
}
