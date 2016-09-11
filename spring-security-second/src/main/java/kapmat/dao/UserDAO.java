/**
 * Created by Kapmat on 2016-09-11.
 */

package kapmat.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import kapmat.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public UserInfo getUserInfo(String username){
		String sql = "SELECT u.username name, u.password pass, a.authority role FROM "+
				"users u INNER JOIN authorities a on u.username=a.username WHERE "+
				"u.enabled=1 and u.username = ?";
		UserInfo userInfo = (UserInfo)jdbcTemplate.queryForObject(sql, new Object[]{username}, new UserInfoRowMapper());
		return userInfo;
	}

	private class UserInfoRowMapper implements RowMapper<UserInfo> {

		@Override
		public UserInfo mapRow(ResultSet resultSet, int rowNumb) throws SQLException {
			UserInfo user = new UserInfo();
			user.setUsername(resultSet.getString("name"));
			user.setPassword(resultSet.getString("pass"));
			user.setRole(resultSet.getString("role"));
			return user;
		}
	}
}
