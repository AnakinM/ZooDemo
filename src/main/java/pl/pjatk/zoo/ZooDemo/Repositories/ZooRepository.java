package pl.pjatk.zoo.ZooDemo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.pjatk.zoo.ZooDemo.Models.Zoo;


public interface ZooRepository extends JpaRepository<Zoo, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Zoo z SET z.name = :name, z.isClosed = :isClosed WHERE z.id = :id")
    long updateZoo(Integer id, String name, boolean isClosed);

    @Query("SELECT z FROM Zoo z WHERE z.id > 5")
    long findZooByIdGreaterThanFive();

//    Querrymethod
//    List<Zoo> findAllByIsClosedIsTrue();
}
