package org.adra.app.bi;

import java.util.Date;
import java.util.List;

import org.adra.app.bi.entity.Alternativa;
import org.adra.app.bi.entity.Pedido_Oracion;
import org.adra.app.bi.entity.Persona;
import org.adra.app.bi.entity.Pregunta;
import org.adra.app.bi.repository.AfiliacionRepository;
import org.adra.app.bi.repository.AlternativaRepository;
import org.adra.app.bi.repository.Banco_ComunalRepository;
import org.adra.app.bi.repository.CapacitacionRepository;
import org.adra.app.bi.repository.Control_VistaRepository;
import org.adra.app.bi.repository.Pedido_OracionRepository;
import org.adra.app.bi.repository.PersonaRepository;
import org.adra.app.bi.repository.PreguntaRepository;
import org.adra.app.bi.repository.PrivilegioRepository;
import org.adra.app.bi.repository.RecursoRepository;
import org.adra.app.bi.repository.RolRepository;
import org.adra.app.bi.repository.Rol_privilegioRepository;
import org.adra.app.bi.repository.SesionRepository;
import org.adra.app.bi.repository.Sesion_socioRepository;
import org.adra.app.bi.repository.SocioRepository;
import org.adra.app.bi.repository.Tipo_CapacitacionRepository;
import org.adra.app.bi.repository.Tipo_RecursoRepository;
import org.adra.app.bi.repository.UsuarioRepository;
import org.adra.app.bi.repository.Usuario_rolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	
	@Autowired
	private AfiliacionRepository afiliacionRepository;
	
	@Autowired
	private AlternativaRepository alternativaRepository;
	
	@Autowired
	private Banco_ComunalRepository banco_comunalRepository;
	
	@Autowired
	private CapacitacionRepository capacitacionRepository;
	
	@Autowired
	private Control_VistaRepository control_vistaRepository;
	
	@Autowired
	private Pedido_OracionRepository pedido_oracionRepository;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private PreguntaRepository preguntaRepository;
	
	@Autowired
	private PrivilegioRepository privilegioRepository;
	
	@Autowired
	private RecursoRepository recursoRepository;
	
	@Autowired
	private Rol_privilegioRepository rol_privilegioRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private Sesion_socioRepository sesion_socioRepository;
	
	@Autowired
	private SesionRepository sesionRepository;
	
	@Autowired
	private SocioRepository socioRepository;
	
	@Autowired
	private Tipo_CapacitacionRepository tipo_capacitacionRepository;
	
	@Autowired
	private Tipo_RecursoRepository tipo_recursoRepository;
	
	@Autowired
	private Usuario_rolRepository usuario_rolRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Listar Persona
	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {
		
		
		
		// Listar Pregunta
		
		
		/*
		List<Pregunta> preguntas = preguntaRepository.listaPreguntas();
		for(int i=0;i<preguntas.size(); i++) {
			System.out.println(preguntas.get(i).getDe_pregunta() + "\t" + preguntas.get(i).getRecurso().getNo_recurso());
		}
		
		*/
		
		
		// Buscar Pregunta
		
		/*
		 
		Pregunta preg = preguntaRepository.buscarPregunta(5).get();
		System.out.println("Pregunta:" + preg.getDe_pregunta() + "\t" + preg.getRecurso().getNo_recurso());
		
		*/

		
		
		// Insertar Pregunta
		
		/*
		 
		preguntaRepository.insertarPregunta("¿Cuál es el objetivo de Instagram", 7);

		*/
		
		
		// Eliminar Pregunta
		
		 /*
			preguntaRepository.eliminarPregunta(5);
		 
		*/
		
		// Actualizar Pregunta
		
		 /*
		  * 
     	  preguntaRepository.actualizarPregunta("¿Cuál es el objetivo de Messenger", 7, 7);

		 */
		 
		
		
	}

}
