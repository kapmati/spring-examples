/**
 * Created by Kapmat on 2016-09-11.
 */
package kapmat.service;

import org.springframework.security.access.prepost.PreAuthorize;

public interface IInfoService {

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public String getMsg();
}
