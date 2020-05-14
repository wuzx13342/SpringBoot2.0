package com.wuzx.boot.crud.service.impl;

import com.wuzx.boot.crud.entity.GoodsStore;
import com.wuzx.boot.crud.mapper.GoodStoreMapper;
import com.wuzx.boot.crud.service.GoodsStoreService;
import com.wuzx.boot.crud.utils.RedisNoWaitLock;
import com.wuzx.boot.crud.utils.RedissonLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsStoreServiceImpl0 implements GoodsStoreService {

    private static final long TIMEOUT = 5 ;

    private GoodStoreMapper goodStoreMapper;

    /**RedisTemplate实现*/
    @Autowired
    private RedisNoWaitLock redisNoWaitLock;

    /**Redission实现*/
    @Autowired
    private RedissonLock redissonLock;
    /**
     * 构造注入
     *  - 强依赖的情况使用
     * @param goodStoreMapper
     */
    @Autowired
    public GoodsStoreServiceImpl0 (GoodStoreMapper goodStoreMapper) {
        this.goodStoreMapper = goodStoreMapper;
    }

    /**
     * 保存 GoodsStore
     *
     * @param goodsStore
     */
    @Override
    public void saveGoodsStore(GoodsStore goodsStore) {
        goodStoreMapper.save(goodsStore);
    }

    /**
     * 更新 GoodsStore
     *
     * @param goodsStore
     */
    @Override
    public void updateGoodsStore(GoodsStore goodsStore) {
        goodStoreMapper.update(goodsStore);
    }
//    /**
//     * 根据产品编号更新库存（啥控制也不加）
//     *
//     * @param code
//     * @return
//     */
//    @Override
//    public String updateGoodsStore(String code, int count) {
//        synchronized(this){
//            GoodsStore goodsStore = queryGoodsStore(code);
//            if (goodsStore != null) {
//                if (goodsStore.getStore() <= 0) {
//                    return "对不起，卖完了，库存为：" + goodsStore.getStore();
//                }
//                if (goodsStore.getStore() < count) {
//                    return "对不起，库存不足，库存为：" + goodsStore.getStore() + " 您的购买数量为：" + count;
//                }
//                System.out.println("剩余库存：" + goodsStore.getStore());
//                System.out.println("扣除库存：" + count);
//                goodsStore.setStore(goodsStore.getStore() - count);
//                updateGoodsStore(goodsStore);
//                try {
//                    //为了更好的测试多线程同时进行库存扣减，在进行数据更新之后先等1秒，让多个线程同时竞争资源
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return "恭喜您，购买成功！";
//            } else {
//                return "获取库存失败。";
//            }
//        }
//
//    }
//    /**
//     * 根据产品编号更新库存(RedisTemplate实现加锁)
//     * @param code
//     * @return
//     */
//    @Override
//    public String updateGoodsStore(String code,int count) {
//        //上锁
//        long time = System.currentTimeMillis();
//        if(!redisNoWaitLock.lock(code, String.valueOf(time))){
//            System.out.println("当前排队人数过多，请稍后再试！:"+Thread.currentThread().getName());
//            return "当前排队人数过多，请稍后再试！";
//        }
//        System.out.println("获得锁的时间戳："+String.valueOf(time));
//        try {
//            GoodsStore goodsStore = queryGoodsStore(code);
//            if(goodsStore != null){
//                if(goodsStore.getStore() <= 0){
//                    return "对不起，卖完了，库存为："+goodsStore.getStore();
//                }
//                if(goodsStore.getStore() < count){
//                    return "对不起，库存不足，库存为："+goodsStore.getStore()+" 您的购买数量为："+count;
//                }
//                System.out.println("剩余库存："+goodsStore.getStore());
//                System.out.println("扣除库存："+count);
//                goodsStore.setStore(goodsStore.getStore() - count);
//                updateGoodsStore(goodsStore);
//                try{
//                    //为了更好的测试多线程同时进行库存扣减，在进行数据更新之后先等1秒，让多个线程同时竞争资源
//                    Thread.sleep(10000);
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//                return "恭喜您，购买成功！";
//            }else{
//                return "获取库存失败。";
//            }
//        } finally {
//            //释放锁
//            redisNoWaitLock.release(code);
//            System.out.println("释放锁的时间戳："+String.valueOf(time));
//        }
//    }


    /**
     * 根据产品编号更新库存(Redission实现加锁)
     * @param code
     * @return
     */
    @Override
    public String updateGoodsStore(String code,int count) {
        //上锁
        long time = System.currentTimeMillis() + TIMEOUT;
        boolean result = redissonLock.lock(code);
        if (result) {
            System.out.println("获得锁的时间戳：" + String.valueOf(time));
            System.out.println("没有线程在操作" + Thread.currentThread().getName() + "正常执行");
            GoodsStore goodsStore = queryGoodsStore(code);
            if (goodsStore != null) {
                if (goodsStore.getStore() <= 0) {
                    return "对不起，卖完了，库存为：" + goodsStore.getStore();
                }
                if (goodsStore.getStore() < count) {
                    return "对不起，库存不足，库存为：" + goodsStore.getStore() + " 您的购买数量为：" + count;
                }
                System.out.println("剩余库存：" + goodsStore.getStore());
                System.out.println("扣除库存：" + count);
                goodsStore.setStore(goodsStore.getStore() - count);
                updateGoodsStore(goodsStore);
                try {
                    //为了更好的测试多线程同时进行库存扣减，在进行数据更新之后先等1秒，让多个线程同时竞争资源
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                redissonLock.release(code);
                return "恭喜您，购买成功！";
            } else {
                redissonLock.release(code);
                return "获取库存失败。";
            }
        } else {
            return "排队人数太多，请稍后再试.";
        }
    }
    /**
     * 删除 GoodsStore
     *
     * @param id
     */
    @Override
    public void deleteGoodsStore(String id) {
        goodStoreMapper.delete(id);
    }

    /**
     * 查询 GoodsStore
     *
     * @param id
     * @return
     */
    @Override
    public GoodsStore queryGoodsStore(String id) {
        return goodStoreMapper.query(id);
    }

    /**
     * 查询 GoodsStore 列表
     *
     * @return
     */
    @Override
    public List<GoodsStore> queryGoodsStores() {
        return goodStoreMapper.queryForList();
    }
}
