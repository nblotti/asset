package ch.nblotti.asset.index.respository;

import ch.nblotti.asset.common.ReadOnlyRepository;
import ch.nblotti.asset.firm.to.FirmTopMoversTO;
import ch.nblotti.asset.index.to.SP500MoversTO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "sp500topmovers")
public interface SP500MoversRepository extends ReadOnlyRepository<SP500MoversTO, Integer> {

  @Cacheable("findFSPirst10TopLoosers")
  @Query("select sp from SP500MoversTO sp where sp.viewType =1")
  Iterable<SP500MoversTO> findFSPirst10TopLoosers();

  @Cacheable("findFSPirst10TopWiners")
  @Query("select sp from SP500MoversTO sp where sp.viewType =2")
  Iterable<SP500MoversTO> findFSPirst10TopWiners();

  @Cacheable("findFSPirst10TopMovers")
  @Query("select sp from SP500MoversTO sp where sp.viewType =3")
  Iterable<SP500MoversTO> findFSPirst10TopMovers();


}