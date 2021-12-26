package com.min.edu.ctrl.department;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.min.edu.model.department.IDeptService;
import com.min.edu.vo.emp.Department;
import com.min.edu.vo.emp.Dept_Page;

@Controller
public class DeptController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Department dept;
	
	@Autowired
	private IDeptService dservice;
	
	//./deptList.do
	@GetMapping(value="/deptList.do")
	public String selectAllDept(Model model,HttpServletRequest req) {
		logger.info("DeptController selectAllDept 부서 전체 목록화면 이동");
		Dept_Page paging = new Dept_Page(
				req.getParameter("index"),
				req.getParameter("pageStartNum"),
				req.getParameter("listCnt"),
				req.getParameter("searchWord")
				);
		paging.setTotal(dservice.selectTotalDept());
		List<Department> lists = dservice.selectDeptPaging(paging);
		model.addAttribute("deptList",lists);
		model.addAttribute("paging",paging);
		
		return "dept/deptList";
	}
	
	@GetMapping(value="/updateDeptForm.do")
	public String updateDeptForm(HttpServletRequest req) {
		logger.info("DeptController 부서목록에서 상세정보페이지 이동");
		int dept_no = Integer.parseInt(req.getParameter("dept_no"));
		logger.info("DeptController 부서목록에서 받은 dept_no : {}",dept_no);
		Department dept = dservice.selectDeptByNo(dept_no);
		req.setAttribute("dept", dept);
		return "dept/updateDeptForm";
	}
	
	@PostMapping(value="/updateDept.do")
	public String updateDept(Department dept,HttpServletRequest req) {
		logger.info("DeptController updateDept 수정완료");
		int no = Integer.parseInt(req.getParameter("dept_no"));
		String nm = req.getParameter("dept_nm");
		
		dept.setDept_no(no);
		dept.setDept_nm(nm);
		
		dservice.updateDept(dept);
		
		return "redirect:/home.do";
	}
	
	@GetMapping(value="/newDeptForm.do")
	public String newDeptForm() {
		return"dept/newDeptForm.jsp";
	}
	
	@PostMapping(value="/newDept.do")
	public String newDept(HttpServletRequest req) {
		int newNo = dept.getDept_no();
		logger.info("DeptController newDept 새 부서번호 : {}",newNo);
		req.setAttribute("newDeptNo", newNo);
		
		String newNm = req.getParameter("dept_nm");
		dept.setDept_nm(newNm);
		dept.setDept_no(newNo);
		
		dservice.updateDept(dept);
		
		return "dept/deptList";
	}
	
	
	
}
