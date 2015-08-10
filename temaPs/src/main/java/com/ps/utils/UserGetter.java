package com.ps.utils;
//package com.sdms.utils;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//
//import com.sdms.entity.Admin;
//import com.sdms.entity.Professor;
//import com.sdms.entity.Student;
//import com.sdms.repository.AdminRepository;
//import com.sdms.repository.ProfessorRepository;
//import com.sdms.repository.StudentRepository;
//
//@Component
//public class UserGetter {
//
//	@Autowired
//	private AdminRepository adminRepository;
//
//	@Autowired
//	private ProfessorRepository professorRepository;
//
//	@Autowired
//	private StudentRepository studentRepository;
//
//	public String getLoggedUser(String email) {
//		/*
//		 * String email = SecurityContextHolder.getContext().getAuthentication()
//		 * .getName();
//		 */
//
//		Admin a = adminRepository.getAdminByEmail(email);
//		if (a != null) {
//			return a.getFirstName();
//		}
//
//		Professor p = professorRepository.findProfessorByEmail(email);
//		if (p != null) {
//			return p.getFirstName();
//		}
//
//		Student s = studentRepository.findOneByEmail(email);
//		if (s != null) {
//			return s.getFirstName();
//		}
//
//		return "Unknown User";
//	}
//}
