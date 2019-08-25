package com.bcaf.project.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.bcaf.project.repository.KabupatenKotaRepo;
//import com.bcaf.project.repository.KecamatanRepo;
//import com.bcaf.project.repository.KelurahanRepo;
//import com.bcaf.project.repository.ProvinsiRepo;
import com.bcaf.project.repository.RoleRepo;
import com.bcaf.project.repository.UserRepo;
import com.bcaf.project.repository.UserRoleRepo;

@Service
public class DbInit implements CommandLineRunner {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private UserRoleRepo userRoleRepo;

//	@Autowired
//	private ProvinsiRepo provinsiRepo;
//
//	@Autowired
//	private KabupatenKotaRepo kabupatenKotaRepo;
//
//	@Autowired
//	private KecamatanRepo kecamatanRepo;
//
//	@Autowired
//	private KelurahanRepo kelurahanRepo;

	@Override
	public void run(String... args) throws Exception {
		// insert user
		if (this.userRepo.findAll().size() == 0) {// ini size nya 0 itu buat liat apakah dia udah ada di DB ato belum
			// kalo dia 0 artinya belum ada di DB tapi kalo udah ada maka dia selain satu.
			// jadi lewat aja
			List<User> listUser = new ArrayList<User>();
			listUser.add(new User("user", passwordEncoder.encode("user123"), "user@bcaf.co.id"));
			listUser.add(new User("staff", passwordEncoder.encode("user123"), "user2@bcaf.co.id"));
			listUser.add(new User("admin", passwordEncoder.encode("admin123"), "admin@bcaf.co.id"));
			listUser.add(new User("manager", passwordEncoder.encode("manager123"), "manager@bcaf.co.id"));
			listUser.add(new User("20071299", passwordEncoder.encode("head123"), "bpkbadminhead@bcaf.co.id"));
			listUser.add(new User("20131103", passwordEncoder.encode("teamleader123"), "bpkbadminteamleader@bcaf.co.id"));
			listUser.add(new User("20020112", passwordEncoder.encode("bpkbadminstaff123"), "bpkbadminstaff@bcaf.co.id"));

			// simpan ke database
			this.userRepo.saveAll(listUser);
		}

		// insert role
		if (this.roleRepo.findAll().size() == 0) {
			List<Role> listRole = new ArrayList<Role>();
			//ini dari constructor
			listRole.add(new Role("ROLE_ADMIN", "Role Admin"));
			listRole.add(new Role("ROLE_USER", "Role User"));
			listRole.add(new Role("ROLE_STAFF", "Role Staff"));
			listRole.add(new Role("ROLE_MANAGER", "Role Manager"));
			listRole.add(new Role("ROLE_HEAD", "Role Head"));
			listRole.add(new Role("ROLE_TEAMLEADER", "Role Team Leader"));

			// simpan role ke database
			this.roleRepo.saveAll(listRole);
		}
		if(this.userRoleRepo.findAll().size()==0) {
			List<UserRole> listUserRole = new ArrayList<UserRole>();
			// mencari user dulu
			User user1 = this.userRepo.findByUsername("user");
			Role role1 = this.roleRepo.findByCode("ROLE_USER");
			listUserRole.add(new UserRole(user1.getId(), role1.getId()));
			
			User user2 = this.userRepo.findByUsername("staff");
			Role role2 = this.roleRepo.findByCode("ROLE_STAFF");
			listUserRole.add(new UserRole(user2.getId(), role2.getId()));
			
			User user3 = this.userRepo.findByUsername("manager");
			Role role3 = this.roleRepo.findByCode("ROLE_MANAGER");
			listUserRole.add(new UserRole(user3.getId(), role3.getId()));
			
			User user4 = this.userRepo.findByUsername("admin");
			Role role4 = this.roleRepo.findByCode("ROLE_ADMIN");
			listUserRole.add(new UserRole(user4.getId(), role4.getId()));
			
			User user5 = this.userRepo.findByUsername("20071299");
			Role role5 = this.roleRepo.findByCode("ROLE_HEAD");
			listUserRole.add(new UserRole(user5.getId(), role5.getId()));
			
			User user6 = this.userRepo.findByUsername("20131103");
			Role role6 = this.roleRepo.findByCode("ROLE_TEAMLEADER");
			listUserRole.add(new UserRole(user6.getId(), role6.getId()));
			
			User user7= this.userRepo.findByUsername("20020112");
			Role role7 = this.roleRepo.findByCode("ROLE_STAFF");
			listUserRole.add(new UserRole(user7.getId(), role7.getId()));
			
			this.userRoleRepo.saveAll(listUserRole);
			
		}

	}

}
