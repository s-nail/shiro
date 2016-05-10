package com.hengtiansoft.shiro.chapter3;

import org.junit.Test;

/*
 * 规则：“用户名=密码，角色1，角色2” “角色=权限1，权限2”，即首先根据用户名找到角色，然后根据角色再找到权限；即角色是权限集合；
 * Shiro 同样不进行权限的维护，需要我们通过Realm返回相应的权限信息
 */

public class PermissionTest extends BaseTest{
	
	//基于权限的访问控制
	@Test
	public void testIsPermitted(){
		login("classpath:shiro-permission.ini", "wang", "123");
		//判断拥有权限:user:create
		System.out.println("user:create = "+subject().isPermitted("user:delete"));
		//判断拥有权限:user:create and user:delete
		System.out.println("user:create and user:delete = "+subject().isPermittedAll("user:update","user:delete"));
		
	}
	
	

}
