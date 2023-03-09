package board.bean;

import lombok.Data;

@Data
public class BoardPaging {
	private int currentPage;// 현재페이지
	private int pageBlock;// [이전][1][2][3][다음]
	private int pageSize;// 1페이지당 5개씩
	private int totalArticle;// 총글수
	private StringBuffer pagingHTML;

	public void makePaging() {
		pagingHTML = new StringBuffer(); // 생성

		int totalPage = (totalArticle + pageSize - 1) / pageSize;// 총 페이지수

		int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		if (startPage != 1) {
			pagingHTML.append("<span id='paging' onclick='boardPaging(" + (startPage - 1) + ")'>이전</span>");
		}
		for (int i = startPage; i <= endPage; i++) {
			if (i == currentPage) {
				pagingHTML.append("<span id='currentPaging' onclick='boardPaging(" + i + ")'>" + i + "</span>");
			} else {
				pagingHTML.append("<span id='paging' onclick='boardPaging(" + i + ")'>" + i + "</span>");
			}
		}
		if (endPage < totalPage) {
			pagingHTML.append("<span id='paging' onclick='boardPaging(" + (endPage + 1) + ")'>다음</span>");
		}
	}
}
