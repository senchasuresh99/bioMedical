package com.spring.bioMedical.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bioMedical.entity.Admin;
import com.spring.bioMedical.repository.AdminRepository;

/**
 * 
 * @author Suresh Sencha
 *
 */
@Service
public class AdminServiceImplementation implements AdminService {

	private AdminRepository adminRepository;

	// inject employee dao
	@Autowired // Adding bean id @Qualifier
	public AdminServiceImplementation(AdminRepository obj) {
		adminRepository = obj;
	}

	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll();
	}

	@Override
	public void save(Admin admin) {
		// SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date now = new Date();
		String log = now.toString();
		admin.setLastseen(log);
		adminRepository.save(admin);
	}

	@Override
	public Admin findByEmail(String user) {
		// TODO Auto-generated method stub

		return adminRepository.findByEmail(user);

	}

	@Override
	public List<Admin> findByRole(String user) {

		return adminRepository.findByRole(user);
	}

}
