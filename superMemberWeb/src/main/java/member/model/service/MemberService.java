package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import member.common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {
	private JDBCTemplate jdbcTemplate;
	private MemberDAO mDao;
	
	public MemberService() {
		jdbcTemplate = JDBCTemplate.getInstance();
		mDao = new MemberDAO();
	}
	
	public Member selectLoginCheck(Member member) {
		Member mOne = null;
		
		Connection conn = jdbcTemplate.getConnection();
		mOne = mDao.selectLoginCheck(conn, member);
		
		return mOne;
	}
	
	public Member selectOneById(String memberId) {
		Member mOne = null;
		try {
			Connection conn = jdbcTemplate.getConnection();
			mOne = mDao.selectOneById(conn, memberId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mOne;
	}
	
	public int insertMember(Member member){
		Connection conn = jdbcTemplate.getConnection();
		int result = 0;
		try {
			result = mDao.insertMember(conn, member);
			if(result > 0) {
				conn.commit();
			}
			else {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateMember(Member member){
		Connection conn = jdbcTemplate.getConnection();
		int result = 0;
		try {
			result = mDao.updateMember(conn, member);
			if(result > 0) {
				conn.commit();
			}
			else {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteMember(String memberId){
		Connection conn = jdbcTemplate.getConnection();
		int result = 0;
		try {
			result = mDao.deleteMember(conn, memberId);
			if(result > 0) {
				conn.commit();
			}
			else {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
