package com.hengtiansoft.shiro.chapter2.test;

import junit.framework.Assert;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/*测试的几个问题:
 
 * 1、用户名/密码硬编码在ini配置文件(shiro.ini)，以后需要改成如数据库存储，且密码需要加密存储；
 * 2、用户身份Token 可能不仅仅是用户名/密码，也可能还有其他的，如登录时允许用户名/邮箱/手机号同时登录。
 */

public class LoginLogoutTest {

	@Test
	public void testHelloworld() {
		// 1. 获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro.ini");

		// 2. 得到SecurityManager实例 并绑定给SecurityUtils
		org.apache.shiro.mgt.SecurityManager securityManager = factory
				.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		// 3. 得到Subject及创建用户名/密码身份验证Token(即用户身份/凭证)
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

		try {
			// 4. 登录，即身份验证
			subject.login(token);
			System.out.println("身份验证成功");
		} catch (AuthenticationException e) {
			// 5. 身份验证失败
			System.out.println("身份验证失败");
		}
		Assert.assertEquals(true, subject.isAuthenticated());// 断言用户已经登录

		// 退出
		subject.logout();
	}

	@Test
	public void testCustomRealm() {
		// 1. 获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro-realm.ini");

		// 2. 得到SecurityManager实例 并绑定给SecurityUtils
		org.apache.shiro.mgt.SecurityManager securityManager = factory
				.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		// 3. 得到Subject及创建用户名/密码身份验证Token(即用户身份/凭证)
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

		try {
			// 4. 登录，即身份验证
			subject.login(token);
			System.out.println("身份验证成功");
		} catch (AuthenticationException e) {
			// 5. 身份验证失败
			System.out.println("身份验证失败");
		}
		Assert.assertEquals(true, subject.isAuthenticated());// 断言用户已经登录

		// 退出
		subject.logout();
	}

	@Test
	public void testCustomMultiRealm() {
		// 1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro-multi-realm.ini");

		// 2、得到SecurityManager实例 并绑定给SecurityUtils
		org.apache.shiro.mgt.SecurityManager securityManager = factory
				.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		// 3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("wang", "123");

		try {
			// 4、登录，即身份验证
			subject.login(token);
			System.out.println("身份验证成功");
		} catch (AuthenticationException e) {
			// 5、身份验证失败
			e.printStackTrace();
			System.out.println("身份验证失败");
		}

		Assert.assertEquals(true, subject.isAuthenticated()); // 断言用户已经登录

		// 6、退出
		subject.logout();
	}
	
	
	@Test
    public void testJDBCRealm() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("HAHA", 12);
        
        System.out.println("subject.getSession: "+subject.getSession().getAttribute("HAHA"));
        UsernamePasswordToken token = new UsernamePasswordToken("Lee", "123");

        try {
            //4、登录，即身份验证
            subject.login(token);
            System.out.println("身份验证成功");
        } catch (AuthenticationException e) {
            //5、身份验证失败
            e.printStackTrace();
            System.out.println("身份验证失败");
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6、退出
        subject.logout();
    }

}
