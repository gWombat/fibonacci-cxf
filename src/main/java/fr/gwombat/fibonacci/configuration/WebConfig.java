package fr.gwombat.fibonacci.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by guillaume.
 *
 * @since 16/08/2018
 */
@Configuration
@EnableWebMvc
@ComponentScan("fr.gwombat.fibonacci.controllers")
public class WebConfig implements WebMvcConfigurer {
}
