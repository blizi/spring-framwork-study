package com.spring.study;



import com.spring.study.pojo.People;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class SpringStudyApplication {


	public static void main(String[] args) {
		//资源加载
		Resource resource = new ClassPathResource("spring-config.xml");
		//创建工厂
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		//创建读取器
		BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		//资源挂载到读取器--工厂
		beanDefinitionReader.loadBeanDefinitions(resource);

		People bean = defaultListableBeanFactory.getBean(People.class);
		System.out.println(bean.toString());

		BeanDefinition people = defaultListableBeanFactory.getBeanDefinition("people");
		System.out.println(people.getBeanClassName());
		System.out.println("spring----------");
	}
}
