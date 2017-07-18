package kdb.bohem.model.dto;

public class UserDto {
	private int userindex;
	private String userid;
	private String userpwd;
	private String username;
	private String usernum;
	private String useremail;

	public UserDto(){}

	public UserDto(int userindex, String userid, String userpwd, String username, String usernum, String useremail) {
		super();
		this.userindex = userindex;
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.usernum = usernum;
		this.useremail = useremail;
	}

	public int getUserindex() {
		return userindex;
	}

	public void setUserindex(int userindex) {
		this.userindex = userindex;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsernum() {
		return usernum;
	}

	public void setUsernum(String usernum) {
		this.usernum = usernum;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	
}
