package com.min.edu.model.form;

import java.util.List;

import com.min.edu.vo.form.Form;
import com.min.edu.vo.form.FormClassification;
import com.min.edu.vo.paging.PagingDto;

public interface IFormDao {

	public List<FormClassification> selectFormcList();
	public List<Form> selectFormList();
	public Form selectFormDetail(int form_no);
	public int insertForm(Form form);
	public List<Form> searchFormList(String formtitle);
	public String selectTemplate(int form_no);
	public List<Form> selectForm();
	public List<Form> selectPaging(PagingDto paging);
	public int selectTotalPaging(); 
}
