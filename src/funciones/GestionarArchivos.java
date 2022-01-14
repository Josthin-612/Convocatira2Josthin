package funciones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.Archivos;
import dol.Informacion;
import interfaces.IGestiones;

public class GestionarArchivos implements IGestiones<Informacion>{

	List<Informacion> info = new ArrayList<Informacion>();
	
	public GestionarArchivos() {
		try {
			info = Archivos.readFile();
		} catch (ClassNotFoundException | IOException e) {
			
			e.getMessage();
		}
	}
	@Override
	public void guardar(Informacion obj) {
		obj.setId(info.size()+1);
		info.add(obj);
	}
	@Override
	public void editar(int id, Informacion obj) {
		
		Informacion pr = mostrarPorId(id);
				
		pr.setNombre(obj.getNombre());
		pr.setApellido(obj.getApellido());
		pr.setDireccion(obj.getDireccion());
		pr.setSalario(obj.getSalario());
		
	}
	@Override
	public void eliminar(int id) {
		Informacion pr = mostrarPorId(id);
		info.remove(pr);
	}
	@Override
	public List<Informacion> mostrarTodo() {
		// TODO Auto-generated method stub
		return info;
	}
	@Override
	public Informacion mostrarPorId(int id) {
		Informacion info3 = null;
		for(Informacion p : info)
			if(p.getId()==id){
				info3 = p;
				break;
			}
		return info3;
	}
	
}
