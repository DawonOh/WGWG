/**
 * 
 */
//상세 페이지로 데이터 전달
function detailAjax(no, docBox) {
	var sendData = { "docno": no, "docBox": docBox }

	$("#content").load("./docdetail.do?docno=" + no + "&docBox=" + docBox);
//	$(location).attr('href',"./docdetail.do?docno=" + no + "&docBox=" + docBox);
}



//상세페이지 이동(문서 상태)
function detailMove(state){
	$('table tbody tr').click(function(){
		
		var no = $(this).find('td').eq(0).text();
		console.log(no);
		detailAjax(no,state);
		
	});
}

//문서 제목으로 검색
function search(){
	
	
		$('#index').attr('value',0);
		$('#pageStartNum').attr('value',1);
		AppPaging();
//		pageAjax();
	
}

function detail(no){
	e.preventDefault();
	$('#content').load("./detailnotice.do?notice_no="+no);
}

