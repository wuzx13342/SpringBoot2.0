package com.wuzx.boot.crud.crud.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @PackgeName: com.wuzx.boot.crud.sentinel
 * @ClassName: SentinelDemo
 * @author: <a href="mailto:wuzhixiang.ithz@gmail.com">wuzhixiang</a>
 * @Date: 2020-08-17 20:52
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: Sentinel 限流
 */
public class SentinelDemo {

    public static void doSomething(){
        try {
            Entry entry = SphU.entry("doSomething");
            System.out.println("开始请求");
            System.out.println("hello world"+System.currentTimeMillis());
        } catch (BlockException e) {
            e.printStackTrace();
        }
    }
    //Sentinel实现限流
    public static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setRefResource("doSomething");//定义资源 ②定义限流规则

        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);//基于QPS
        rule.setCount(20);
        rule.setGrade(RuleConstant.FLOW_GRADE_THREAD);//基于线程数

        rule.setLimitApp("default");
        rule.setStrategy(RuleConstant.STRATEGY_CHAIN);
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);
        rules.add(rule);
        //加入我们的限流管理
        FlowRuleManager.loadRules(rules);
    }
    //Sentinel实现服务熔断
    public static void initDegradeRule(){
        List<DegradeRule> rules = new ArrayList<>();

        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource("KEY");
        degradeRule.setCount(10);
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_RT);//熔断策略
        degradeRule.setTimeWindow(10);//熔断降级的时间窗口
        rules.add(degradeRule);
    }


    public static void main(String[] args) {
        //initFlowRules();
        initDegradeRule();
        while(true){
            doSomething();
        }
    }
}
