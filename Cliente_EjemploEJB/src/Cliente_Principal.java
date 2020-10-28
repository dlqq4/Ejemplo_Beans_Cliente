import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Departamento;
import com.exception.ServiciosException;
import com.servicios.CarrerasBeanRemote;
import com.servicios.DepartamentosBeanRemote;
import com.servicios.MateriasBeanRemote;

public class Cliente_Principal {

	public static void main(String[] args) throws NamingException {
		
//*************************************************DEPARTAMENTOS***********************************************************	
		Departamento departamento1 = new Departamento();
		Departamento departamento2 = new Departamento();
		Departamento departamento3 = new Departamento();
		
				
		departamento1.setNombre("San José");
		departamento2.setNombre("Soriano");
		departamento3.setNombre("Durazno");
		
		
		DepartamentosBeanRemote departServicios = (DepartamentosBeanRemote) 
				InitialContext.doLookup("EjemploEJB/DepartamentosBean!com.servicios.DepartamentosBeanRemote"); 
				
		try {
			                           
		
			departServicios.crear(departamento1);
			departServicios.crear(departamento2);
			departServicios.crear(departamento3);
			
			System.out.println("Se creó exitosamente el departamento");
			
		
		} catch (ServiciosException e) {
			
			System.out.println("Algo salió mal! ");
			
			e.printStackTrace();
		
		} 
		
		
		System.out.println("Obtengo todos los departamentos");
		List<Departamento> todos = departServicios.obtenertodos();
				
		for (Departamento depto : todos){
			System.out.println(depto.getNombre());
		}
		

//****************************************************MATERIAS*************************************************************
		
		MateriasBeanRemote materiasBean = (MateriasBeanRemote)
				InitialContext.doLookup("EjemploEJB/MateriasBean!com.servicios.MateriasBeanRemote"); 
		
//****************************************************CARRERAS*************************************************************
		
		CarrerasBeanRemote carrerasBean = (CarrerasBeanRemote)
				InitialContext.doLookup("EjemploEJB/CarrerasBean!com.servicios.CarrerasBeanRemote");
		
//*************************************************************************************************************************		
	}

}
