# GreenDaoDemo
GreenDao3.2的使用，仿购物车Demo

##效果图
!()[https://github.com/AndroidHensen/GreenDaoDemo/blob/master/app/src/main/res/drawable/preview.png]

##主要API

```
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
```

##原文地址

CSDN博客：http://blog.csdn.net/qq_30379689/article/details/54410838
