/**
 * Created by Kapmat on 2016-09-11.
 */
package kapmat.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("kapmat")
@EnableWebMvc
@Import({SecurityConfiguration.class})
public class AppConfiguration {
}
