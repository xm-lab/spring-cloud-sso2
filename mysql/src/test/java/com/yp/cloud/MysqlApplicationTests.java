package com.yp.cloud;

import com.yp.cloud.entity.Department;
import com.yp.cloud.entity.Role;
import com.yp.cloud.entity.User;
import com.yp.cloud.repository.DepartmentRepository;
import com.yp.cloud.repository.RoleRepository;
import com.yp.cloud.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
@SpringBootTest
public class MysqlApplicationTests {
	@Autowired
	UserRepository userRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	RoleRepository roleRepository;

	@Before
	public void initData() throws Exception {
		userRepository.deleteAll();
		roleRepository.deleteAll();
		departmentRepository.deleteAll();

		Department department = new Department();
		department.setName("开发部");
		department.setCreatedAt(new Date());
		departmentRepository.save(department);
		Assert.assertNotNull(department.getId());

		Role role = new Role();
		role.setName("admin");
		role.setCreatedAt(new Date());
		roleRepository.save(role);
		Assert.assertNotNull(role.getId());

		User user = new User();
		user.setName("user");
		user.setEmail("yuanpeng1341@gmail.com");
		user.setSex(1);
		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
		user.setPassword(bpe.encode("user"));
		user.setCreatedAt(new Date());
		user.setDepartment(department);
		userRepository.save(user);
		Assert.assertNotNull(user.getId());

	}

	@Test
	public void insertUserRoles() {
		User user = userRepository.findByName("user");
		Assert.assertNotNull(user);

		List<Role> roles = roleRepository.findAll();
		Assert.assertNotNull(roles);
		user.setRoles(roles);
		userRepository.save(user);
	}

}
