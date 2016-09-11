/**
 * Created by Kapmat on 2016-09-11.
 */
package kapmat.service;

import org.springframework.stereotype.Service;

@Service
public class InfoService implements IInfoService {

	@Override
	public String getMsg() {
		return "Hello ";
	}
}
