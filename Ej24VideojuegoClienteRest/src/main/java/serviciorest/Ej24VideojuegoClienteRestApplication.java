package serviciorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import serviciorest.cliente.entidad.Videojuego;
import serviciorest.cliente.servicio.ServicioProxyVideojuego;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class Ej24VideojuegoClienteRestApplication implements CommandLineRunner{
	
	@Autowired
	private ServicioProxyVideojuego spv;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(Ej24VideojuegoClienteRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("***Listado videojuegos***");
		/*Videojuego vAux = spv.obtener(2);
		System.out.println(vAux);*/
		List<Videojuego> lista = spv.listar(null, null);
		lista.forEach((v)->System.out.println(v));
	}

}
