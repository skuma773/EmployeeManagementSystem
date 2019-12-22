package com.test.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findTop1ById(long id);
	
	@Query(value = "SELECT r.* FROM user u JOIN user_roles ur ON (u.id = ur.users_id) JOIN role r ON (r.id = ur.roles_id) WHERE u.username=:userName limit 1", nativeQuery = true)
	Role findRoleByUserName(@Param("userName") String userName);

}
