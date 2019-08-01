package eventos;

	import java.io.IOException;

	public interface ICommand {

	public void Execute(Evento evento) throws IOException ;
	}

