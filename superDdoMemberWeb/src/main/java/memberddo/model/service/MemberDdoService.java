package memberddo.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import memberddo.common.JDBCTemplate;
import memberddo.model.dao.MemberDdoDao;
import memberddo.model.vo.MemberDdo;

public class MemberDdoService {
	private JDBCTemplate jdbcTemplate;
	private MemberDdoDao mdDao;
	
	public MemberDdoService(){
		jdbcTemplate = JDBCTemplate.getInstance();
		mdDao = new MemberDdoDao();
	}
	
	public int updateMemberDdo(MemberDdo member) {
		int result = 0;
		try {
			Connection conn = jdbcTemplate.getConnection();
			result = mdDao.updateMemberDdo(conn, member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteMemberDdo(String memberId) {
		int result = 0;
		try {
			Connection conn = jdbcTemplate.getConnection();
			result = mdDao.deleteMemberDdo(conn, memberId);
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
	
	public MemberDdo selectOneById(String memberId){
		MemberDdo member = null;
		
		try {
			Connection conn = jdbcTemplate.getConnection();
			member = mdDao.selectOneById(conn, memberId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}
	
	public MemberDdo selectLoginCheck(MemberDdo member) throws SQLException {
		MemberDdo mOne = null;
		
		Connection conn = jdbcTemplate.getConnection();
		mOne = mdDao.selectLoginCheck(conn, member);
		
		return mOne;
	}
	
	public int insertMemberDdo(MemberDdo member) throws SQLException {
		Connection conn = jdbcTemplate.getConnection();
		int result = 0;
		try {
			result = mdDao.insertMemberDdo(conn, member);
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
