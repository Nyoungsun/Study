package board.bean;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO  {
	private int seq;
	private String id;
	private String name;
	private String email;
	private String subject;
	private String content;
	private String ref;
	private String lev;
	private String step;
	private String pseq;
	private String reply;
	private String hit;
	private Date logtime;
}
