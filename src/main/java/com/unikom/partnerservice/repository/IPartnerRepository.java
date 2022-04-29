package com.unikom.partnerservice.repository;

import com.unikom.partnerservice.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPartnerRepository extends JpaRepository<Partner, Long> {

//    @Query("select p from PartnerEntity p where p.code like %:code% and p.name like %:name%")
//    List<PartnerEntity> searchPartner(String code, String name);

//    @Query(value = "select * " +
//            "from Partner as p " +
//            "where 1=1 " +
//            "and p.code like %:code% " +
//            "and p.name like %:name% " +
//            "and p.founded_year = :foundedYear " +
//            "and p.quantity_of_employee = :quantityOfEmployee ", nativeQuery = true)
//    Page<Partner> searchPageable(String code, String name, int foundedYear, int quantityOfEmployee, Pageable pageable);

    Optional<Partner> findByIdAndIsDeletedIsFalse(Long id);

}
