package com.spring.bioMedical.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bioMedical.entity.Admin;
import com.spring.bioMedical.entity.Appointment;
import com.spring.bioMedical.repository.AppointmentRepository;

/**
 * 
 * @author Suresh Sencha
 *
 */
@Service
public class AppointmentServiceImplementation  {

	private AppointmentRepository appointmentRepository;

	//inject employee dao
	@Autowired   //Adding bean id @Qualifier
	public AppointmentServiceImplementation( AppointmentRepository obj)
	{
		appointmentRepository=obj;
	}
	
	
	public void save(Appointment app)
	{
		
		  LocalDateTime regTime=LocalDateTime.now();
		  String time=String.valueOf(regTime); 
		  app.setRegtime(time);
		 
		
		/*
		 * LocalDateTime regTime=LocalDateTime.now(); String log = regTime.toString();
		 * app.setRegtime(log);
		 */
		 
		appointmentRepository.save(app);
	}
	
	
	public List<Appointment> findAll() {
		return appointmentRepository.findAll();
	}
}
