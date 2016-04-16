package co.edu.poli.cnt.simulador.repositorio;

import co.edu.poli.cnt.simulador.modelo.PreguntaEntity;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Antonio Paternina <acpaternina@poli.edu.co>
 */
public class PreguntaRepositorioImpl implements PreguntaRepositorio {

    private static final Logger logger = Logger.getLogger(PreguntaRepositorioImpl.class.getName());

    private static PreguntaRepositorioImpl instancia;

    private final EntityManager em;

    private PreguntaRepositorioImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("co.edu.poli.cnt_SimuladorCertificacion");
        this.em = emf.createEntityManager();
    }

    public static PreguntaRepositorioImpl getInstancia() {
        if (instancia == null) {
            instancia = new PreguntaRepositorioImpl();
        }
        return instancia;
    }

    @Override
    public List<PreguntaEntity> getAllPreguntaEntity() {
        logger.fine("getAllPreguntaEntity - start");
        return em.createQuery("select p from PreguntaEntity p order by p.orden").getResultList();
    }

}
