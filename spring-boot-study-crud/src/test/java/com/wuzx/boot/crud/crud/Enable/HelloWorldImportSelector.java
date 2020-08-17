package com.wuzx.boot.crud.crud.Enable;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.util.MultiValueMap;

import java.lang.reflect.AnnotatedElement;
import java.util.function.Predicate;

/**
 * @PackgeName: com.wuzx.boot.crud.Enable
 * @ClassName: HelloWorldImporterSelector
 * @author: wuzhixiang.ithz@gmail.com
 * @Date: 2020-06-13 12:39
 * @project: spring-boot-study-crud
 * @Version: 0.0.1
 * @Description:
 */
@Slf4j
public class HelloWorldImportSelector implements ImportSelector {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        AnnotatedElement element = null;

        if(importingClassMetadata instanceof StandardAnnotationMetadata){
            element = ((StandardAnnotationMetadata) importingClassMetadata).getIntrospectedClass();
            MultiValueMap<String,Object> allAnnotationAttributes = AnnotatedElementUtils.getAllAnnotationAttributes(element,EnableHelloWorld.class.getName());
            allAnnotationAttributes.forEach((key,value)->{
                logger.info("name={},value={}",key,value);

            });

        }

        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}
