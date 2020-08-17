package com.wuzx.boot.crud.crud.desgin.mode.composite;

/**
 * @PackgeName: com.wuzx.boot.crud.desgin.mode.composite
 * @ClassName: ProductDao
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-05-25 17:44
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
public class ProductDao {

    private DBConnection dbConnection;

    public void setDbConnection(DBConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    public void addProduct(){
        String conn = dbConnection.getConnection();
        System.out.println("使用"+conn+"增加产品");
    }

    public static void main(String[] args) {
        OracleConnection oracleConnection = new OracleConnection();
        ProductDao productDao =new ProductDao();
        productDao.setDbConnection(oracleConnection);
        productDao.addProduct();
    }
}
