package tech.timely

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import java.util.*


@SpringBootApplication
@EnableAsync
class SpringBootMvcApplication

@Bean
@Autowired
fun corsFilter(): CorsFilter {
    val corsConfiguration = CorsConfiguration()
    corsConfiguration.allowCredentials = true
    corsConfiguration.allowedOrigins = Arrays.asList("http://localhost:4200")
    corsConfiguration.allowedHeaders = Arrays.asList(
        "Origin", "Access-Control-Allow-Origin", "Content-Type",
        "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
        "Access-Control-Request-Method", "Access-Control-Request-Headers"
    )
    corsConfiguration.exposedHeaders = Arrays.asList(
        "Origin", "Content-Type", "Accept", "Authorization",
        "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"
    )
    corsConfiguration.allowedMethods = Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")
    val urlBasedCorsConfigurationSource = UrlBasedCorsConfigurationSource()
    urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration)
    return CorsFilter(urlBasedCorsConfigurationSource)
}

fun main(args: Array<String>) {
    runApplication<SpringBootMvcApplication>(*args)
}
