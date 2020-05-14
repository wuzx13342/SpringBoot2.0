package com.wuzx.boot.crud.controller;


import com.wuzx.boot.crud.entity.GoodsStore;
import com.wuzx.boot.crud.service.GoodsStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@RestController
@RequestMapping("/storage")
public class GoodStoreController{

    private GoodsStoreService goodsStoreService;

    private static final int corePoolSize = 20;

    private static final int maxPoolSize = 20;

    private static final int capacity = 512;

    private static final RejectedExecutionHandler defaultHandler = new ThreadPoolExecutor.DiscardPolicy();

    private static ExecutorService threadPool = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(capacity), defaultHandler);

    /**
     * 构造器注入
     * @param goodsStoreService
     */
    @Autowired
    public GoodStoreController(GoodsStoreService goodsStoreService){this.goodsStoreService=goodsStoreService;}

    /**
     * 进入测试页面
     * @param model
     * @return
     */
    @GetMapping("test")
    public ModelAndView stepOne(Model model){
        return new ModelAndView("test", "model", model);
    }

    /**
     * 秒杀提交
     * @param code
     * @param num
     * @return
     */
    @PostMapping("secKill")
    @ResponseBody
    public String secKill(@RequestParam(value="code",required=true) String code,@RequestParam(value="num",required=true) Integer num){

        List<String> list =new ArrayList<>();
        for (int i = 0; i <=5 ; i++) {
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    String reString = goodsStoreService.updateGoodsStore(code, num);
                    list.add(reString);
                }
            });
        }

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String reString = goodsStoreService.updateGoodsStore(code, num);
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String reString = goodsStoreService.updateGoodsStore(code, num);
//            }
//        });
//
//        Thread t3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String reString = goodsStoreService.updateGoodsStore(code, num);
//            }
//        });
//        t1.start();
//        t2.start();
//        t3.start();
        return list.toString();
    }
    /**
     * 查询所有库存信息
     */
    @GetMapping("")
    public List<GoodsStore> queryAllGoodsStores(){
        return goodsStoreService.queryGoodsStores();
    }
    /**
     * 根据id查询库存
     */
    @GetMapping("/{id}")
    public GoodsStore queryGoodeStoreByCode(@PathVariable String id){
        return goodsStoreService.queryGoodsStore(id);
    }
}


