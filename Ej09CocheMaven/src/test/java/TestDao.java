import static org.junit.Assert.*;
import org.junit.*;
import modelo.entidad.Coche;
import modelo.persistencia.CocheDaoMySql;

public class TestDao {
	
	CocheDaoMySql cd = new CocheDaoMySql();
	Coche coche = new Coche("9919FML", "Kia", "Picanto",45000);
	
	@Test
	public void testAlta() {
		cd.alta(coche);
		Coche cocheRespuesta = cd.obtener(coche.getMatricula());
		assertEquals(coche,cocheRespuesta);	
	}

	@Test
	public void testBaja() {
		cd.baja(coche.getMatricula());
		Coche cocheRespuesta = cd.obtener(coche.getMatricula());
		assertNull(cocheRespuesta);
	}
	
}
