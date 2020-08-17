package  com.wuzx.boot.crud.desgin.mode.composite;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.dependency.desgin.mode.composite
 * @ClassName: DBConnection
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-25 17:42
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description: 合成复用原则
 */
public abstract class DBConnection {
    public abstract String getConnection();
}
