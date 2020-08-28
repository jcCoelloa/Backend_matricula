package com.matricula;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.matricula.handler.CursoHandler;
import com.matricula.handler.EstudianteHandler;
import com.matricula.handler.MatriculaHandler;

@Configuration
public class RouterConfig {
	
	@Bean
	public RouterFunction<ServerResponse> rutasEstudiantes(EstudianteHandler handler){
		return route(POST("/estudiante"), handler::registrar)
				.andRoute(GET("/estudiante"), handler::listar)
				.andRoute(PUT("/estudiante/{id}"), handler::modificar)
				.andRoute(GET("/estudiante/{id}"), handler::listarPorId)
				.andRoute(DELETE("estudiante/{id}"), handler::eliminar)
				.andRoute(GET("/estudianteOrderByEdad"), handler::listarByEdad);
	}
	
	@Bean
	public RouterFunction<ServerResponse> rutasCursos(CursoHandler handler){
		return route(POST("/curso"),handler::registrar)
				.andRoute(GET("/curso"), handler::listar)
				.andRoute(PUT("/curso/{id}"), handler::modificar)
				.andRoute(GET("/curso/{id}"), handler::listarPorId)
				.andRoute(DELETE("/curso/{id}"), handler::eliminar);
	}
	
	@Bean
	public RouterFunction<ServerResponse> rutasMatriculas(MatriculaHandler handler){
		return route(POST("/matricula"), handler::registrar)
				.andRoute(GET("/matricula"), handler::listar)
				.andRoute(PUT("/matricula/{id}"), handler::modificar)
				.andRoute(GET("/matricula/{id}"), handler::listarPorId)
				.andRoute(DELETE("/matricula/{id}"), handler::eliminar);
	}
	

}
