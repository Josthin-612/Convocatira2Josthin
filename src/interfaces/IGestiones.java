package interfaces;

import java.util.List;

public interface IGestiones<t> {
	public void guardar(t obj);
	public void editar(int id, t obj);
	public void eliminar(int id);
	public List<t> mostrarTodo();
	public t mostrarPorId(int id);
}