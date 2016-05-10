package com.hengtiansoft.shiro.chapter3;

import java.util.Arrays;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

public class RoleTest extends BaseTest {

	/*
	 * Shiro 提供了hasRole/hasRole 用于判断用户是否拥有某个角色/某些权限；
	 * 但是没有提供如hashAnyRole用于判断是否有某些权限中的某一个。
	 */
	@Test
	public void testHasRole() {
		login("classpath:shiro-role.ini", "zhang", "123");

		// 判断拥有角色:role1
		Assert.assertTrue(subject().hasRole("role1"));
		System.out.println("判断拥有角色role1:" + subject().hasRole("role1"));

		// 判断拥有角色:role1 and role2
		Assert.assertTrue(subject()
				.hasAllRoles(Arrays.asList("role1", "role2")));
		System.out.println("判断拥有角色role1 and role2:"
				+ subject().hasAllRoles(Arrays.asList("role1", "role2")));

		// 判断拥有角色 : role1 and role2 and !role3
		boolean[] result = subject().hasRoles(
				Arrays.asList("role1", "role2", "role3"));
		Assert.assertEquals(true, result[0]);
		Assert.assertEquals(true, result[1]);
		Assert.assertEquals(false, result[2]);
		System.out.println("result[0]:" + result[0]);
		System.out.println("result[1]:" + result[1]);
		System.out.println("result[2]:" + result[2]);
	}

	/*
	 * Shiro 提供的checkRole/checkRoles 和hasRole/hasAllRoles
	 * 不同的地方是它在判断为假的情况下会抛出UnauthorizedException异常。
	 */
	@Test(expected = UnauthorizedException.class)
	public void testCheckRole() {
		login("classpath:shiro-role.ini", "zhang", "123");
		// 断言拥有角色：role1
		subject().checkRoles("role1");
		// 断言拥有角色：role1 and role3 失败抛出异常
		subject().checkRoles("role1", "role3");
	}

}
