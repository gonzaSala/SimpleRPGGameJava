package MiniRPG;

public interface IAtacable {
	public void atacar(IAtacable enemigo);
	
	public void recibirHerida(int cantidad);
}
