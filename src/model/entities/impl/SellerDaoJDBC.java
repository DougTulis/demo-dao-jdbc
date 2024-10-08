package model.entities.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDAO {

	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn
					.prepareStatement(
			"SELECT seller.*,department.Name as DepName " 
			+ "FROM seller INNER JOIN department "
			+ "ON seller.DepartmentId = department.Id "
			+ "WHERE seller.Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				Department dep = InstantiateDep(rs);
                Seller sl = InstantiateDep(dep,rs);
                return sl;
     			}
			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Seller InstantiateDep(Department dep, ResultSet rs) throws SQLException {
		Seller sl = new Seller();
		 sl.setId(rs.getInt("Id"));
         sl.setName(rs.getString("Name"));
         sl.setEmail(rs.getString("Email"));
         sl.setBaseSalary(rs.getDouble("BaseSalary"));
         sl.setBirthDate(rs.getDate("BirthDate"));
         sl.setDepartment(dep);
		return sl;
	}

	private Department InstantiateDep(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));		
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
