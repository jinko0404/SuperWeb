package memberddo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import memberddo.model.vo.MemberDdo;

public class MemberDdoDao {
	
	public int updateMemberDdo(Connection conn, MemberDdo member) throws SQLException {
		String query = "UPDATE MEMBER_TBL SET MEMBER_PW = ?, MEMBER_EMAIL = ?"
				+ ", MEMBER_PHONE = ?, MEMBER_ADDRESS = ?, MEMBER_HOBBY = ?"
				+ ", UPDATE_DATE = SYSTIMESTAMP WHERE MEMBER_ID = ?";
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
	
	public int deleteMemberDdo(Connection conn, String memberId) throws SQLException {
		String query = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		result = pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}
	
	public MemberDdo selectOneById(Connection conn, String memberId) throws SQLException {
		MemberDdo member = null;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		rset = pstmt.executeQuery();
		if(rset.next()) {
			member = this.rsetToMember(rset);
		}
		rset.close();
		pstmt.close();
		
		return member;
	}
	
	public int insertMemberDdo(Connection conn, MemberDdo member) throws SQLException {
		String query = "INSERT INTO MEMBER_TBL VALUES (?,?,?,?,?,?,?,?,?,SYSDATE, SYSTIMESTAMP, 'Y')";
		PreparedStatement pstmt = null;
		int result = 0;
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPwd());
		pstmt.setString(3, member.getMemberName());
		pstmt.setString(4, String.valueOf(member.getGender()));
		pstmt.setInt(5, member.getAge());
		pstmt.setString(6, member.getEmail());
		pstmt.setString(7, member.getPhone());
		pstmt.setString(8, member.getAddress());
		pstmt.setString(9, member.getHobby());
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		
		return result;
	}
	
	public MemberDdo selectLoginCheck(Connection conn, MemberDdo member) {
		String query = "SELECT * FROM MEMBER_TBL "
				+ "WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rset = null;
			MemberDdo mOne = null;
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
	
	private MemberDdo rsetToMember(ResultSet rset) throws SQLException {
		MemberDdo mOne = new MemberDdo();
		mOne.setMemberId(rset.getString("MEMBER_ID"));
		mOne.setMemberPwd(rset.getString("MEMBER_PW"));
		mOne.setMemberName(rset.getString("MEMBER_NAME"));
		mOne.setGender(rset.getString("MEMBER_GENDER").charAt(0));
		mOne.setAge(rset.getInt("MEMBER_AGE"));
		mOne.setEmail(rset.getString("MEMBER_EMAIL"));
		mOne.setPhone(rset.getString("MEMBER_PHONE"));
		mOne.setAddress(rset.getString("MEMBER_ADDRESS"));
		mOne.setHobby(rset.getString("MEMBER_HOBBY"));
		mOne.setEnrollDate(rset.getDate("MEMBER_DATE"));
		mOne.setUpdateDate(rset.getDate("UPDATE_DATE"));
		mOne.setMemberYn(rset.getString("MEMBER_YN").charAt(0));
		
		return mOne;
	}
}
