package com.wuzx.boot.crud.service;

import com.wuzx.boot.crud.entity.GoodsStore;

import java.util.List;

/**
 * GoodsStore 业务接口 {@link GoodsStoreService}
 *
 * @author wuzhixiang
 * @wx: 36567126
 */
public interface GoodsStoreService {

    /**
     * 保存 GoodsStore
     * @param goodsStore
     */
    public void saveGoodsStore (GoodsStore goodsStore);

    /**
     * 更新 GoodsStore
     * @param goodsStore
     */
    public void updateGoodsStore (GoodsStore goodsStore);

    /**
     * 更新库存
     * @param code
     * @param count
     * @return
     */
    public String updateGoodsStore(String code, int count);
    /**
     * 删除 GoodsStore
     * @param id
     */
    public void deleteGoodsStore (String id);

    /**
     * 查询 GoodsStore
     * @param id
     * @return
     */
    public GoodsStore queryGoodsStore (String id);

    /**
     * 查询 GoodsStore 列表
     * @return
     */
    public List<GoodsStore> queryGoodsStores ();
}
