package ru.ezhov.persistence.two.assotiation.many.to.many;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by rrnezh on 29.10.2017.
 */
public class ArtistTest {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerTest.class.getName());

    @Test
    public void selectAll() throws Exception {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ru.ezhov");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            List<Artist> list = entityManager.createQuery(
                    "select n FROM Artist n",
                    Artist.class
            ).getResultList();


            for (Artist artist : list) {
                LOG.info("------------->");
                LOG.info(artist.toString());
                LOG.info(artist.getCdList().toString());

                List<CD> cds = artist.getCdList();

                for (CD cd : cds) {
                    LOG.info(cd.toString());
                    LOG.info(cd.getArtistList().toString());
                }
                LOG.info("<-------------");
            }
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}