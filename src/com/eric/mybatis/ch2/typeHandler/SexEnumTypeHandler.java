package com.eric.mybatis.ch2.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import com.eric.mybatis.ch2.po.Sex;

public class SexEnumTypeHandler implements TypeHandler<Sex> {
	
	private Logger log = Logger.getLogger(SexEnumTypeHandler.class);

	@Override
	public void setParameter(PreparedStatement ps, int index, Sex sex, JdbcType jdbcType) throws SQLException {
		log.info("使用我的TypeHandler");
		ps.setInt(index, sex.getId());
		
	}

	@Override
	public Sex getResult(ResultSet rs, String columnName) throws SQLException {
		log.info("使用我的TypeHandler, ResutlSet列名获取字符串");
		int id = rs.getInt(columnName);
		return Sex.getSex(id);
	}

	@Override
	public Sex getResult(ResultSet rs, int columnIndex) throws SQLException {
		log.info("使用我的TypeHandler, ResutlSet下标获取字符串");
		int id = rs.getInt(columnIndex);
		return Sex.getSex(id);
	}

	@Override
	public Sex getResult(CallableStatement cs, int columnIndex) throws SQLException {
		log.info("使用我的TypeHandler, CallableStatement下标获取字符串");
		int id = cs.getInt(columnIndex);
		return Sex.getSex(id);
	}


	
}
