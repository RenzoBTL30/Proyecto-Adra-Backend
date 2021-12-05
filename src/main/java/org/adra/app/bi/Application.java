package org.adra.app.bi;

import java.util.Date;
import java.util.List;

import org.adra.app.bi.entity.Alternativa;
import org.adra.app.bi.entity.Pedido_Oracion;
import org.adra.app.bi.entity.Persona;
import org.adra.app.bi.entity.Pregunta;
import org.adra.app.bi.entity.Recurso;
import org.adra.app.bi.entity.Tipo_Recurso;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("101010").toString());
		
		// ---- TBL_PEDIDO_ORACION ----
		
		// Listar pedido_oracion
		
		/*
		List<Pedido_Oracion> pedido_oraciones = pedido_oracionRepository.listaPedido();
		System.out.println(); 
		for(int i=0;i<pedido_oraciones.size(); i++) {
			System.out.println(pedido_oraciones.get(i).getDe_pedido_oracion() + "\t" + pedido_oraciones.get(i).getFe_creacion() + "\t" + pedido_oraciones.get(i).getSocio().getPersona().getNo_persona());
		}
		System.out.println();
		*/
		
		// Buscar pedido_oracion
		
		
		 /*
		Pedido_Oracion pedido = pedido_oracionRepository.buscarPedido(4).get();
		System.out.println("Pedido:" + pedido.getDe_pedido_oracion() + "\t" + pedido.getFe_creacion() + "\t");
		*/

		
		// Insertar pedido_oracion
		
		/*
		pedido_oracionRepository.insertarPedido("Orar por Tacna", 1);
		*/
		
		
		// Eliminar pedido_oracion
		
		/*
 		  pedido_oracionRepository.eliminarPedido(5);
		*/
		
		
		// Actualizar pedido_oracion
		
		 /*
     	  pedido_oracionRepository.actualizarPedido("Orar por todoss", 1, 8);
		 */
		 
		
		
		
		// ---- TBL_TIPO_RECURSO ----
		
		// Listar tipo_recurso
		
		
		/*
		List<Tipo_Recurso> tipo_recursos = tipo_recursoRepository.listaTipoRecursos();
		System.out.println(); 
		for(int i=0;i<tipo_recursos.size(); i++) {
			System.out.println(tipo_recursos.get(i).getNo_tipo_recurso());
		}
		System.out.println(); 
		*/
		
		
				
		// Buscar tipo_recurso
				
		
		/*		 
		Tipo_Recurso tipo_recurso = tipo_recursoRepository.buscarTipoRecurso(5).get();
		System.out.println("Tipo Recurso: " + tipo_recurso.getNo_tipo_recurso());
		*/	
		
		
				
		// Insertar tipo_recurso
				
		/*
		   tipo_recursoRepository.insertarTipoRecurso("Evaluacion");
		*/
				
		// Eliminar tipo_recurso
				
		/*
		   tipo_recursoRepository.eliminarTipoRecurso(7);
		*/
		    
				
				
		// Actualizar tipo_recurso
		
			
		/*
		   tipo_recursoRepository.actualizarTipoRecurso("Documento", 4);
				 
		*/
		   
		   
	   // ---- TBL_RECURSO ----

		// Listar recurso
			
			
			/*
			List<Recurso> recursos = recursoRepository.listaRecursos();
			System.out.println();
			for(int i=0;i<recursos.size(); i++) {
				System.out.println(recursos.get(i).getNo_recurso() + "\t\t"+ recursos.get(i).getNu_orden() + "\t\t"+
						recursos.get(i).getDi_url() + "\t\t"+  recursos.get(i).getEs_recurso()  + "\t\t"+ recursos.get(i).getSesion().getDe_tema() + "\t\t"+ recursos.get(i).getTipo_recurso().getNo_tipo_recurso());
			}
			System.out.println();
			*/
			
					
			// Buscar recurso
					
			
			/*		 
			Recurso recurso = recursoRepository.buscarRecurso(10).get();
			System.out.println("\nRecurso: " + recurso.getNo_recurso() + "\t\t" + recurso.getNu_orden() + "\t\t" + 
					recurso.getDi_url()+ "\t\t"+  recurso.getEs_recurso() + "\t\t" + recurso.getSesion().getDe_tema() + "\t\t" + recurso.getTipo_recurso().getNo_tipo_recurso() + "\n");
					
			*/

					
			// Insertar recurso
					
			  /*
			   recursoRepository.insertarRecurso("Video 10",5,"www.youtube.com",'1',2,3);
				
				*/	
					
			// Eliminar recurso
					
			  /*
			   recursoRepository.eliminarRecurso(12);
				*/ 
			  
					
			// Actualizar recurso
			
			   /*
			   recursoRepository.actualizarRecurso("Lectura 12",5,"www.monologos.com",'1',2,3,11);
			  */
			   
			   
	}

}
