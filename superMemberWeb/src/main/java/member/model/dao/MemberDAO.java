package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.model.vo.Member;

public class MemberDAO {
	
	public Member selectLoginCheck(Connection conn, Member member) {
		String query = "SELECT * FROM MEMBER_TBL "
				+ "WHERE MEMBER_ID = ? AND MEMBER_PWD = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rset = null;
			Member mOne = null;
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				mOne = this.rsetToMember(rset);
			}
			rset.close();
			pstmt.close();
			return mOne;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	public int insertMember(Connection conn, Member member) throws SQLException {
		String query = "INSERT INTO MEMBER_TBL VALUES (?,?,?,?,?,?,?,?,?,SYSDATE)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPwd());
		pstmt.setString(3, member.getMemberName());
		pstmt.setString(4, member.getGender());
		pstmt.setInt(5, member.getAge());
		pstmt.setString(6, member.getEmail());
		pstmt.setString(7, member.getPhone());
		pstmt.setString(8, member.getAddress());
		pstmt.setString(9, member.getHobby());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		
		return result;
	}



	public Member selectOneById(Connection conn, String memberId) throws SQLException {
		String query = "SELECT * FROM MEMBER_TBL "
				+ "WHERE MEMBER_ID = ?";
		PreparedStatement pstmt;
		Member mOne = null;
		pstmt = conn.prepareStatement(query);
		ResultSet rset = null;			
		pstmt.setString(1, memberId);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			mOne = this.rsetToMember(rset);
		}
		rset.close();
		pstmt.close();
		return mOne;
	}

	public int updateMember(Connection conn, Member member) throws SQLException {
		String query = "UPDATE MEMBER_TBL SET MEMBER_PWD=?,EMAIL=?,PHONE=?,ADDRESS=?"
				+ ",HOBBY = ? WHERE MEMBER_ID=?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberPwd());
		pstmt.setString(2, member.getEmail());
		pstmt.setString(3, member.getPhone());
		pstmt.setString(4, member.getAddress());
		pstmt.setString(5, member.getHobby());
		pstmt.setString(6, member.getMemberId());
		result = pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}
	
	public int deleteMember(Connection conn, String memberId) throws SQLException {
		String query = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		result = pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}

	private Member rsetToMember(ResultSet rset) throws SQLException {
		Member mOne = new Member();
		mOne.setMemberId(rset.getString("MEMBER_ID"));
		mOne.setMemberPwd(rset.getString("MEMBER_PWD"));
		mOne.setMemberName(rset.getString("MEMBER_NAME"));
		mOne.setGender(rset.getString("GENDER"));
		mOne.setAge(rset.getInt("AGE"));
		mOne.setEmail(rset.getString("EMAIL"));
		mOne.setPhone(rset.getString("PHONE"));
		mOne.setAddress(rset.getString("ADDRESS"));
		mOne.setHobby(rset.getString("HOBBY"));
		mOne.setEnrollDate(rset.getDate("ENROLL_DATE"));
		
		return mOne;
	}
}
