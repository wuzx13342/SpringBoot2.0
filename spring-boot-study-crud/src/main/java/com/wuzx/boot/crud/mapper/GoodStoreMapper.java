package com.wuzx.boot.crud.mapper;

import com.wuzx.boot.crud.entity.GoodsStore;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * GoodStore 数据访问接口 {@link GoodStoreMapper}
 */
@Repository
public interface GoodStoreMapper {


    /**
     * 保存 GoodsStore
     * @param goodsStore
     */
    public void save (GoodsStore goodsStore);

    /**
     * 更新 GoodsStore
     * @param goodsStore
     */
    public void update (GoodsStore goodsStore);

    /**
     * 删除 GoodsStore
     * @param id
     */
    public void delete (String id);

    /**
     * 查询 GoodsStore
     * @param id
     * @return
     */
    public GoodsStore query (String id);

    /**
     * 查询 GoodsStore 列表
     * @return
     */
    public List<GoodsStore> queryForList ();
}
